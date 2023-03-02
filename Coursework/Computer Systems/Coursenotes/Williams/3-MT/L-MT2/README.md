# Locking

    March 2, 2023

# Table of Contents

# Recap

- Thread is a logical flow of execution.
  - Every program has some thread in it, that executes that program and its instructions.
- Multiple threads can share an address space.
  - We want to share code and global data.
  - We don't share stacks.
  - We will explore what happens when we have more than one thread of execution inside of address space.
- User-threads can be used without the help of the kernel, but with some caveats:
  - Can't run on multiple CPUs (cores) and can't preempt.
- Kernel-supported threads allows the kernel to assist in preemption and scheduling onto different CPUs (cores).
  - POSIX threads are called `pthreads`.

# `pthread`

<p align="center" width="100%">
    <img src="img/figure-1.png">
</p>

```c
tid = pthread(fn ... args);
pthread_join(id) // Pass the 'tid' here
```

## `create/join` vs `fork/exec`

- Threads are a part of the same program while children have their own destinies and can exec without corrupting the shared data like threads would.
  - Exiting in any thread will exit from the whole program.
  - Exiting in a child will not affect the state of its parent or its siblings or its children.

# Question: How Many Theads?

- How many threads should we have in a program?
  - How many threads is natural for our CPU?
  - How many threads per CPU core?

> **Note**: CPU refers to "Physical Threads" or "Cores".

## Answer

- We would want $N$ threads for $N$ amount of CPUs, however:
  - Once we have $>N$, the Kernel has to start scheduling them which causes alot of switching with creates a lot of overhead, "diminishing returns".
    - Once we get to a certain large amount of $>N$, the threads will make such little progress that they will be doing little to no work, making no real progress.

<p align="center" width="100%">
    <img src="img/figure-1.png">
</p>

- Ideally we want number READY/RUNNING state processes to be the same as number of threads.
  - Too many idle CPUs is wasted computing power.

<p align="center" width="100%">
    <img src="img/figure-1.png">
</p>

- Command `make -j <#>` where `<#>` is number of parallelism.
  - Every object file can be built on a different CPU.
  - Command `make` may be significantly shorter than `make -j 32` on a 32-core CPU.

# Threadpool

- An abstraction to try to accomplish maximum usage out of our specific machine with $N$ number of CPUs (cores).
- Threads in the threadpool are like workers that want to process some tasks.

## Interface

<p align="center" width="100%">
    <img src="img/figure-1.png">
</p>

- Way to interact with the threadpool as a user.

### Tasks & Futures

- Send threadpool a task.
- Task returns a "future" which is an object that will allow you to see the result of the task at some point in the future when the task is complete.
  - We can continue to do other stuff in the meantime and use `future.get` to acquire the result when we need it.
    - If the result is not ready yet, then it will block.

## Example: Java FixedThreadPool

```java
```
- Note that the output is in order, but are they actually processed in order?
  - But if you see the output for the threads themselves, they are processesing them in different orders.
- The reason why the threads are different orders, it is because we have no control over scheduling as users, this is determined by the kernel.
  - This is due, in part, to preemption.
  - If some thread is not running as much, it is probably because it was not scheduled yet.

> **Important**: Thread scheduling is ***NOT*** in out control as programmers. The same way we can't trust the compiler or the C programming language with Undefined Behavior.

# Question: What Can Go Wrong?

- Given that the scheduler will schedule as it pleases and preempt at any time, what can go wrong?

## Example: `race.c`

```c
#include <pthread.h>
#include <stdio.h>

int global_shared;

static void* thread1(void* _tn) {
  for (int i = 0; i < 1000000000; i++) {
    global_shared++;
  }
  return NULL;
}

static void* thread2(void* _tn) {
  for (int i = 0; i < 1000000000; i++) {
    global_shared++;
  }
  return NULL;
}

int main() {
  int i, N = 2;
  pthread_t t[N];
  pthread_create(t + 0, NULL, thread1, NULL);
  pthread_create(t + 1, NULL, thread2, NULL);

  for (i = 0; i < N; i++) {
    pthread_join(t[i], NULL);
  }

  printf("global_shared = %d\n", global_shared);
  return 0;
}
```
```c
global_shared = !2000000 // Returns a different number every time it runs
```
## Answer

- This is happening because both are altering `global_shared`.
  - They may be accessing `global_shared` at the same time or before one function can update it before the other function accesses it.
    - The `for` loop _will_ happen 1,000,000 times.
  - Read before update.
  - The issue described before is as a result of the absence of atomicity and is referred to as a "Race Condition".

### Atomicity

- There are three instructions occuring:

```c
// Replace with image
mov ..., rg
inc rg
mov rg, ...
```

<p align="center" width="100%">
    <img src="img/figure-1.png">
</p>

- These three instructions are referred to as a "critical section" because it is "critical" that we are not interrupted during this section.
- We want these three instructions to be "Atomic" to avoid issues.

### Race Condition

- When threads are accessing the same "shared" data and read it before it is updated.

#### Question: How to Prevent Race Conditions

- How can we prevent this example's race condition?

###### Answer

- Use locks or make operation atomic.
- Simplest solution is to avoid sharing the `global_shared` counter.
  - Per CPU "ready queue".
    - Need to manage overhead.
  - Region-based `malloc` for memory allocation.

# Locking

- Locks are also called `mutex`es and stands for "**MUT**ual **EX**clusion" of some "Critical Section".

<p align="center" width="100%">
    <img src="img/figure-1.png">
</p>

- It sounds like we are locking the code or the critical section but we don't care about the code, what matters is the shared data.
  - If the code is not accessing global shared variable, then we don't care.
- Think about what data a lock is protecting, not code necessarily.
  - So if some code is using some shared data, we want to protect it with a lock.
- Locks are meant to protect ***data*** not necessaily ***code***.
- Threads can still run while there is a lock, but we have introduced some condition to be met in order to execute some instructions on shared data.
- There are colloquially two kinds of locks:
  1. Fine-Grained: More concurrency.
     - Difficult to keep track of and can cause issues where you need two locks for some operation potentially.
       - Can cause "deadlocks"
  2. Coarse-Grained: Less concurrency.
  - Start Coarse-Grained and then make it more Fine-Grained as necessary, if your Coarse-Grained lock is the bottleneck of your program for example.

## Example: `race_locked.c`

```c
#include <pthread.h>
#include <stdio.h>

int global_shared; /* Protected by my_lock */
pthread_mutex_t my_lock = PTHREAD_MUTEX_INITIALIZER; /* Protects global_shared */

static void* thread1(void* _tn) {
  for (int i = 0; i < 1000000000; i++) {
    pthread_mutex_lock(&my_lock); // Lock
    global_shared++;
    pthread_mutex_unlock(&my_lock); // Unlock
  }
  return NULL;
}

static void* thread2(void* _tn) {
  for (int i = 0; i < 1000000000; i++) {
    pthread_mutex_lock(&my_lock); // Lock
    global_shared++;
    pthread_mutex_unlock(&my_lock); // Unlock
  }
  return NULL;
}

int main() {
  int i, N = 2;
  pthread_t t[N];
  pthread_create(t + 0, NULL, thread1, NULL);
  pthread_create(t + 1, NULL, thread2, NULL);

  for (i = 0; i < N; i++) {
    pthread_join(t[i], NULL);
  }

  printf("global_shared = %d\n", global_shared);
  return 0;
}
```
```c
global_shared = 2000000 // Returns 2,000,000 every time
```

- We have ensured that once we start that three-instruction sequence, that no other thread can perform that sequence.

## Example: `race_coarse_grain_locked.c` Performace

```c
...

static void* thread1(void* _tn) {
  pthread_mutex_lock(&my_lock); // Lock
  for (int i = 0; i < 1000000000; i++) {
    global_shared++;
  }
  pthread_mutex_unlock(&my_lock); // Unlock
  return NULL;
}

...
```
```c
global_shared = 2000000 // Also returns 2,000,000 every time
```

- This also returns the correct result every time however the way the locks are placed are such that the entire `for`-loop must complete before any other thread can access the shared data.
  - Effectively we are no longer _actually_ multithreading anymore.

# Source

[Dan Williams](https://people.cs.vt.edu/djwillia/)