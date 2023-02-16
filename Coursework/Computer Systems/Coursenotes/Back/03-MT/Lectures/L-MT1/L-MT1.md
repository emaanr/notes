# Introduction to Multithreading

# Table of Contents

- [Introduction to Multithreading](#introduction-to-multithreading)
- [Table of Contents](#table-of-contents)
- [The Case for Application-Level Concurrency](#the-case-for-application-level-concurrency)
- [Threads vs Processes](#threads-vs-processes)
- [Implementing Threads](#implementing-threads)
- [Cooperative Multithreading](#cooperative-multithreading)
  - [Advantages](#advantages)
  - [Disadvantages](#disadvantages)
- [Kernel-Supported Threads](#kernel-supported-threads)
- [Hybrid Models](#hybrid-models)
- [POSIX Threads: p-threads](#posix-threads-p-threads)
- [Threads: Examples](#threads-examples)
  - [POSIX Threads](#posix-threads)
  - [Java Threads](#java-threads)
- [Concurrency Management](#concurrency-management)
- [Threadpools: Create & Join Examples](#threadpools-create--join-examples)
  - [Java's ExecutorService](#javas-executorservice)
  - [Parallel Divide-and-Conquer](#parallel-divide-and-conquer)
- [Source](#source)

# The Case for Application-Level Concurrency

- General purpose OS already provide the ability to execute processes concurrently. In many applications, we would like to pursue multiple, concurrent computations simultaneously _within_ a process.
- E.g.
  - Parallel Computing:
    - Perform multiple tasks or work on shares of data simultaneously.
  - Overlap I/O & Computation:
    - Checksum and repair while downloading in a file sharing program.
  - Serve a UI while performing background activity:
    - Spell check.
    - Contact server.
    - Backend for autosuggestions.
  - Handling multiple clients simultaneously in a network server.

> Such _application-level_ concurrency is supported by having multiple threads of execution.

# Threads vs Processes

|           | Share                                                                    | Do Not Share          |
|-----------|--------------------------------------------------------------------------|-----------------------|
| Processes | Machine resources, files on disk, inherited file descriptors, terminals. | Address Space         |
| Threads   | Address space [1], open file descriptors.                                | Stack [2] & Registers |
- [1]:
  - Heap objects.
  - All global variables.
- [2]:
  - Local variables.
  - Function arguments.
  - Thread-local variables.
- Processes provide concurrent, separate logical flows of control within a system/machine.
- Threads provide separate logical flows of control within a process.
- Think of threads as multiple programs executing concurrently within a shared process, sharing all data and resources, but maintaining separate stacks and execution state.

# Implementing Threads

<p align="center" width="100%">
    <img src="figure-1.png">
</p>

- Question:
  - Does the ability to maintain multiple flows of control require support from the underlying OS kernel?
- Or...
  - Can it be implemented purely using libraries, etc. using the non-priviledged instructions and other facilities available at user level?

# Cooperative Multithreading

- It's possible to maintain multiple control flows entirely without kernel level support.
- Exists in multiple variants in different languages, known as coroutines or user-level threads depending on variant.
- Requires a primitive that saves & restores execution state.
- Non-preemptive model:
  - Threads' access to the CPU is not preempted (taken away) unless the thread yields access to the CPU voluntarily.
- Yield may be:
  - Directed:
    - Saying which coroutine should run next
  - Undirected:
    - Run something else next.
    - E.g. uthreads example.
- In some higher-level languages, functions can "yield" temporary results as their execution state is saved and restored.
  - E.g.
    - Python.
    - ES6 yield.
- Can be combined with asynchronous I/O:
  - Yield a promise object that represents an in-progress operation: `async/await`.

## Advantages

- Requires no OS support.
- Very lightweight and fast context switching.
- Absence of certain data races.
  - E.g. `x++` is atomic.
- Can yield scalable designs when combined with asynchronous I/O.

## Disadvantages

- Cannot make use of multiple CPUs.
- Cannot preempt long-running or uncooperative threads easily.
- Blocking I/O system calls will block all threads/entire process.

# Kernel-Supported Threads

- If the OS kernel supports threads directly, the above-mentioned problems can be solved.
  - Parallelism:
    - Using multiple CPUs/cores simultaneously.
    - Is possible because OS can assign threads to different CPUs, which enables speedup.
  - When performing I/O, the OS will move only the calling thread into the BLOCKED state.
  - The OS's preemptive scheduling model can share access to a CPU even if threads do not yield the CPU by (forcefully) interrupting threads and moving them to the READY state.
- Kernel-supported Threads:
  - Dominant model today, supported by all major OS. Aka as kernel-level (as opposed to user-level) threading, but not to be confused with pure (inside the) kernel threads. Sometimes also called lightweight processes (LWP).

# Hybrid Models

<p align="center" width="100%">
    <img src="figure-2.png">
</p>

- Figure 1: $1:1$ Model
  - Pure kernel-level threading.
  - $1$ OS thread for each user thread.
- Figure 2: $1:N$ Model
  - Pure user-level threading.
  - $N$ user-level threads share $1$ OS-level thread.
- Figure 3: $M:N$ Model
  - Hybrid models try to obtain the best of user-level and kernel-supported threads.
- Examples:
  - Windows Fibers (now defunct).
  - Solaris $M:N: Model.
- Increase in complexity (and lack of payoff) led to the $M:N$ Model being largely abandoned.
- Heavy investment/optimization in reducing the costs of the $1:1$ Model.
  - E.g. Fast user-level synchronization facilities.

# POSIX Threads: p-threads

- Execution model and API de facto standard for Unix-like OS, specified in IEEE Std.1003.10-2017.
- Retrofitted into overall POSIX standard as an extension, defining interaction between traditional process-based facilities and threads.
  - E.g. Signals.
- Many languages provide direct bindings for it.
  - E.g.
    - Java threads.
    - C++ `async`.
    - Etcetera.

# Threads: Examples

## POSIX Threads

```c
struct thread_info {
    const char * msg;
};

static void * thread_function(void *_arg) {
    struct thread_info *info = _arg;
    printf("Thread 1 runs, msg was '%s'\n", info->msg);
    return (void *) 42;
}
```
```c
int main() {

    struct thread_info info = {
        .msg = "Hello, Thread"
    };
    
    pthread_t t;
    pthread_create(&t, NULL, thread_function, &info);
    
    uintptr_t status;
    pthread_join(t, (void **) &status);
    printf("Status %lu\n", status);
    return 0;
}
```

## Java Threads

```java
public class JavaThread {

    static class Example implements Runnable {
        
        String msg;
        int result;
        Example(String msg) {
            this.msg = msg;
        }

        @Override
        public void run() {
            System.out.println(msg);
            result = 42;
        }
    }
}
```
```java
public static void main(String []av) throws Exception {
    
    var ex = new Example("Hello Thread");
    Thread t = new Thread(ex);
    t.start();
    t.join();
    System.out.println(ex.result);
}

```

# Concurrency Management

- Applications rarely create separate, new threads for individual tasks, particularly if small.
- Instead, they manage the number of threads needed to perform work and distribute work to threads.
- Trade-off:
  - Too many threads:
    - Leads to increased contention for resources and resulting overhead from managing that.
  - Too few threads:
    - Risks underutilization of CPUs/cores.
- Target:
  - Number of READY + RUNNING threads around equal to number of cores.
- Solution:
  - Thread pools.

# Threadpools: Create & Join Examples

## Java's ExecutorService

```java
import java.util.concurrent.*;

public class FixedThreadPool {
    
    static final int N = 8;
    
    public static void main(String []av) throws Exception {
        
        ExecutorService ex = Executors.newFixedThreadPool(3);
        Future<?> f[] = new Future<?>[N];
        for (int i = 0; i < N; i++) {
            final int j = i;
            f[i] = ex.submit(new Callable<String>() {
                public String call() {
                    return "Future #" + j + " brought to you by " + Thread.currentThread();
                }
            });
        }
        for (int i = 0; i < N; i++) {
            System.out.println(f[i].get());
        }
        ex.shutdown();
    }
}
```

## Parallel Divide-and-Conquer

```java
Result solve(Param problem) {

    if (problem.size <= GRANULARITY_THRESHOLD) {
        return directlySolve(problem);
    } else {
        in-parallel {
            Result l = solve(lefthalf(problem));
            Result r = solve(rightHalf(problem);
        }
        return combine(l, r);
    }
}
```
- Pseudocode Source:
  - Lea:
    - A java fork/join framework.
- Challenge:
  - An execution framework must map the tasks created in in-parallel to threads.

# Source

[Godmar Back](https://people.cs.vt.edu/~gback/)