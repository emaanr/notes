# Multithreading

    February 28, 2023

# Table of Contents

- [Multithreading](#multithreading)
- [Table of Contents](#table-of-contents)
- [The Story So Far](#the-story-so-far)
- [Definition](#definition)
- [Questions](#questions)
  - [Answers](#answers)
    - [Example](#example)
- [Sharing](#sharing)
  - [Threads](#threads)
  - [Processes](#processes)
  - [Threads vs Processes](#threads-vs-processes)
- [Question: Kernel](#question-kernel)
  - [Answer](#answer)
    - [Cooperative Multithreading](#cooperative-multithreading)
      - [Higher-Level Languages](#higher-level-languages)
      - [Pros \& Cons](#pros--cons)
        - [Pros](#pros)
        - [Cons](#cons)
- [Threading Models](#threading-models)
  - [`pthread`](#pthread)
  - [1:N](#1n)
  - [1:1](#11)
  - [M:N](#mn)
- [Kernel-Supported Threads](#kernel-supported-threads)
- [Source](#source)

# The Story So Far

<p align="center" width="100%">
    <img src="img/figure-1.png">
</p>

# Definition

- "Multi-" referring to concurrency.
- "Thread" referring to a logical unit of execution.

# Questions

- What if we want concurrent execution in the same address space?
- Each process has a thread, what if we want more than one thread in a process?
- Why do we want multiple threads in an address space?

## Answers

- Use extra CPU's (cores) on modern day computers to perform multithreading.
  - Note that we can still have multiple threads on a single CPU (Core).
- The reason we _started_ to think about threads is because we wanted to parallelize computation to get work done faster on a computer with more than one CPU (core).

### Example

- Web server with multiple requests.
  - Use same data in address space to respond to requests, might be helpful to have different threads for different requests.
- Devices are slow, and sometimes we might want to do something else while those operations are happening (like reading from a disk).
  - This is called I/O overlapping.
- Operating System Kernel.
  - Historically the first concurrent program.

# Sharing

- Create tables for both and give a summary here

## Threads

- Threads share an address space.
  - Shared:
    - Code
    - Data
    - Open File Descriptors
  - Not Shared:
    - Stacks
    - Registers
    - Thread Local Storage (TLS)
- Address Space:
  - Code
    - Text section, includes libraries.
    - Shared by processes.
  - Data
    - Read only global variables.
    - Shared, working on same computation so we will share globals.
  - BSS
  - Heap
    - Program gets (dynamic) memory from the heap.
    - Shared.
  - Stack
    - Function call trace and local variables, grows opposite to the heap.
    - Not shared.
      - Thread of execution is represented by its own stack and registers.
        - Registers are current state of the process that is executing.
          - Program counter must be different for every thread since each thread is an abstaction of logical execution.
          - Stack pointers will be different.

## Processes

- Shared:
  - Shared Memory (shmem)
  - File Descriptors
    - Kernel Resources
  - Files on Disk
- Not Shared:
  - Address Space
    - Cloned at fork
  - Stack
  - Registers
- Containers can assist in isolating what processes share.
  - We may want to do this because issues start to arise when things are shared.

## Threads vs Processes

- If processes make changes to their own copies of the address space, then other processes can't _see_ those changes and may be working out outdated data or computing with incorrect values.
- The only difference between starting a process or a thread is whether or not Virtual Memory (VM), which is referring to the address space, is shared.

<p align="center" width="100%">
    <img src="img/figure-1.png">
</p>

# Question: Kernel

- Do we need the Kernel to implement threads?

## Answer

- Kernel is not necessarily needed to implement threads.

### Cooperative Multithreading

- Also called:
  - Co-Routines
  - User-Level Threads
  - Green Threads
- No preemption.
  - Stopping a process to allow another process to run.
- User threads downside is that the kernel is not involved, so it cannot "preempt" a process to intersperse them or prevent infinite looping.
- Concept of "Yield":
  - Directed:
    - Yield to some predetermined thread.
  - Undirected
    - Yielding to whoever the scheduler happens to choose.
- Switching threads requires switching stacks/registers.
  - Need to save and restore registers, see `setjmp` and `longjmp`.
  - Allocating with `malloc` a bunch of stacks on the heap (can be allocated anywhere but will be on the heap if allocated _dynamically_) of the address space.
    - One of the registers has a reference to the stack pointer so we know where to go look when changing threads.

#### Higher-Level Languages

- Yield temporary result.
- Yield promise object for asynchronous I/O.
  - `async`
  - `await`

#### Pros & Cons

- There are some pro's and con's with Cooperative Multithreading.

##### Pros

- Interleave computation with I/O.
- Can be very fast.
  - We just swap stack and registers.
  - There is overhead when using syscalls to switch into the kernel.
  - Thread switching without kernel intervention can be fast.

##### Cons

- Uses only one CPU (core).
  - Cannot utilize other cores.
- No preemption which is bad because infinite looping.
- Blocking I/O blocks everyone.

# Threading Models

- 1:1 Model is most popular.
  - Often used alongside optimizations to make it faster.
  - Use "futex"es $\rightarrow$ "Fast User Mutex".

## `pthread`

- The `pthread` is just a standard API, so whether they are slow or fast depends on the implementation of that API.
- Specifically in Linux `pthread` mutexes are implemented as futexes and are therefore fast.
- `pthread` does not `fork` and `wait` in the same way that processes do.
  - When one thread exits the process is gone because they are working on the same process rather than being independent processes themselves.

## 1:N

<p align="center" width="100%">
    <img src="img/figure-1.png">
</p>

- Lots of idle CPUs.
- User-space, user-defined cooperative multithreading.

## 1:1

<p align="center" width="100%">
    <img src="img/figure-1.png">
</p>

+ Multiple CPUs.
+ OS knows about them and can schedule them.
+ If one blocks, it's okay, the kernel just registers it as waiting in the "blocked" state of the "Blocked-Ready-Running" simplified process model.
+ Preemption possible.
- Slower than user-space 1:N model.

## M:N

<p align="center" width="100%">
    <img src="img/figure-1.png">
</p>

- Hybrid of 1:N and 1:1
- Popularized by Solaris and used by Windows Fibers.
- Tries to get the best of both worth (fast switching with some preemption).

# Kernel-Supported Threads


# Source

[Dan Williams](https://people.cs.vt.edu/djwillia/)