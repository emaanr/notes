# Process States

    January 26, 2023

# Table of Contents

- [Process States](#process-states)
- [Table of Contents](#table-of-contents)
- [Introduction](#introduction)
  - [Polling](#polling)
- [Process States](#process-states-1)
  - [Blocked](#blocked)
  - [Running](#running)
  - [Ready](#ready)
- [Process States Cycle](#process-states-cycle)
  - [Blocked $\\rightarrow$ Ready](#blocked-rightarrow-ready)
  - [Ready $\\leftrightarrow$ Running](#ready-leftrightarrow-running)
  - [Running $\\rightarrow$ Blocked](#running-rightarrow-blocked)
  - [Note](#note)
  - [Examples](#examples)
    - [Example 1](#example-1)
    - [Example 2](#example-2)
    - [Example 3](#example-3)
    - [Example 4](#example-4)
    - [Practical Example](#practical-example)
- [Busy Waiting](#busy-waiting)
  - [Busy Looping](#busy-looping)
  - [Not Busy Looping](#not-busy-looping)
- [Process States in Linux](#process-states-in-linux)
  - [Codes](#codes)
    - [States](#states)
    - [Additional Descriptors](#additional-descriptors)
      - [Berkley Software Distribution](#berkley-software-distribution)
        - [Research Unix](#research-unix)
  - [Time](#time)
    - [Example](#example)
- [Job Control](#job-control)
- [Outro](#outro)
  - [Synchronization Primitives](#synchronization-primitives)
- [Source](#source)

# Introduction

- Some processes aren't on the CPU right now.
  - Waiting for:
    - Input (I/O):
      - Keyboard.
      - Server waiting for a request.
      - Data on a pipe.
    - Exclusive Access:
      - Locks (Multithreading and Synchronization).
      - Signal coming from user to program (used in Synchronization).
      - Time, such as `sleep` command.
    - Child process to terminate.

## Polling

- Polling, or polled operation, in computer science, refers to actively sampling the status of an external device by a client program as a synchronous activity.
- Polling is most often used in terms of input/output (I/O), and is also referred to as polled I/O or software-driven I/O.

# Process States

1. Blocked
2. Running
3. Ready

## Blocked

- Waiting for something (not ready to execute).

## Running

- Currently excuting.

## Ready

- No CPU available (able to run otherwise).

# Process States Cycle

## Blocked $\rightarrow$ Ready

- Process becomes "Ready" once it has all the information it needs to execute.

## Ready $\leftrightarrow$ Running

- Context switching.
- "Ready Queue" or "Run Queue" refers to processes that are ready to run.

## Running $\rightarrow$ Blocked

- A process that is executing arrives to a point in their work where they need to become blocked to wait for some information in order to continue.

## Note

> Note: There is no arrow from:
> - "Blocked $\rightarrow$ Running"
>    - This is because a process must be READY to run before it can actually RUN.
> - "Ready \$rightarrow Blocked"
>   - Once a process is READY, until it begins RUNNING, it cannot be BLOCKED again.

## Examples

### Example 1

- $n$ CPUs + $n$ READY Processes:
  - All Processes RUNNING.

### Example 2

- $n$ CPUs + $0$ READY Processes:
  - All Processes BLOCKED.
    - `hlt`


### Example 3

- $n$ CPUs + $k < n$ READY Processes:
  - RUNNING $k$ Processes
  - BLOCKED on $n-k$ (Other) Processes.
    - `hlt`

### Example 4

- $n$ CPUs + $2n$ READY Processes:
  - Take turns RUNNING all Processes.

### Practical Example

- Typical System:
  - BLOCKED: 150 - 500
  - RUNNING: 0 - 2
- Amount of CPU Demand: Length of RUN/READY Queue.

# Busy Waiting

- Results in a greater load which results in a very strained CPU.
- You may want to utilize a syscall, like `wait` or `sleep`, to instead to save CPU power.

## Busy Looping

```
while(1) {
    condition
        break
}    
```

- Wastes CPU cycles.
- Is worthwhile if you are waiting for something you _know_ will arrive in a few cycles.
    - Such as a super high performance environment like network processing where we know total amount of packages to expect.
    - Would be more wasteful in terms of time to context switch than to just loop.

## Not Busy Looping
    
```
syscall("wait for x")
```
- Use a syscall instead of busy looping.
- Where "x" is "something".
- Not busy waiting which saves CPU cycles.

# Process States in Linux

| Linux State | Meaning               | Cycle State   |
|:-----------:|-----------------------|---------------|
|      D      | UNINTERRUPTABLE SLEEP | BLOCKED       |
|      R      | RUNNING & RUNNABLE    | READY/RUNNING |
|      S      | INTERRUPTABLE SLEEP   | BLOCKED       |
|      T      | STOPPED               | BLOCKED       |
|      t      | STOPPED (BY DEBUGGER) | BLOCKED       |
|      Z      | ZOMBIE                | BLOCKED       |

> Note: That `kworker` often refers to a kernel thread or kernel worker.

## Codes

- Utilize `man ps` command in Linux to explore different Linux States.

### States

- Here are the different values that the `s`, `stat` and `state` output specifiers (header "STAT" or "S") will display to describe the state of a process:

| Code | Description                                                         |
|:----:|---------------------------------------------------------------------|
|   D  | Uninterruptible sleep (usually IO)                                  |
|   I  | Idle kernel thread                                                  |
|   R  | Running or runnable (on run queue)                                  |
|   S  | Interruptible sleep (waiting for an event to complete)              |
|   T  | Stopped by job control signal                                       |
|   t  | Stopped by debugger during the tracing                              |
|   X  | Dead (should never be seen)                                         |
|   Z  | Defunct ("zombie") process, terminated but not reaped by its parent |

### Additional Descriptors

- For BSD (Berkeley Software Distribution) formats and when the stat keyword is used, additional characters may be displayed:

| Char | Description                                                         |
|:----:|---------------------------------------------------------------------|
|   <  | High-priority (not nice to other users)                             |
|   N  | Low-priority (nice to other users)                                  |
|   L  | Has pages locked into memory (for real-time and custom IO)          |
|   s  | Is a session leader (process groups)                                |
|   l  | Is multi-threaded (using CLONE_THREAD, like NPTL pthreads do)       |
|   +  | Is in the foreground process group                                  |

#### Berkley Software Distribution

- Berkeley Software Distribution (BSD) is a group of related open source Unix-like operating systems (OS) with origins in early versions of Research Unix at Bell Labs.

##### Research Unix

- The term "Research Unix" refers to early versions of the Unix operating system.

## Time

- Use `time` command/program and pass a process, like an executable file, as an argument to observe `real`, `user`, and `sys` time usage for it.

### Example

- `time ./sleep`

# Job Control

- Consists of:
  1. Foreground/Background:
     - `fg`
     - `bg`
  2. List of jobs.
- We don't always know what the OS will do with processes.
  - But, for example, we can explicitly use `&` to run a program in the background for more control as a user.

# Outro

- As a Programmer:
  - State transitions are not often in your control (very unpredictable).
    - User Actions
    - Scheduling
    - Block/Unblock for Locks
  - Don't assume anything about order (of process states).
    - OS might make different/unpredictable decisions.
      - Need "Synchronization Primitives".

## Synchronization Primitives

- Synchronization primitives are simple software mechanisms provided by a platform (e.g. operating system) to its users for the purposes of supporting thread or process synchronization.
- They're usually built using lower level mechanisms.
  -  E.g.
     -  Atomic Operations
     -  Memory Barriers
     -  Spinlocks
     -  Context Switches
     -  Etcetera.

# Source

[Dan Williams](https://people.cs.vt.edu/djwillia/)