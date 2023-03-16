# Spheals

    Information collected through conversations with and "schpeels" from different people. Called "Spheals" after the Pokémon.

<p align="center" width="100%">
    <img title="Tokomon from Digimon and Spheal from Pokémon" src="sphealmon.png">
</p>

# Table of Contents

- [Spheals](#spheals)
- [Table of Contents](#table-of-contents)
- [Pipes](#pipes)
- [Context Switching](#context-switching)
- [Zombies](#zombies)
  - [Example: Scenario](#example-scenario)
    - [Case 1](#case-1)
    - [Case 2](#case-2)
- [Sanity Checking](#sanity-checking)
- [Race Conditions](#race-conditions)
- [`strace`](#strace)
- [Structs](#structs)
  - [Examples](#examples)
    - [Example 1](#example-1)
    - [Example 2](#example-2)
- [`#include` Guards](#include-guards)
- [Signals](#signals)
  - [Signal Table](#signal-table)
- [Variable Shadowing](#variable-shadowing)
  - [Allows](#allows)
    - [C](#c)
    - [Python](#python)
  - [Disallows](#disallows)
    - [Java](#java)

# Pipes

A _pipe_ redirects standard input from one program to be the standard output of another program. Note that the pipe works in real time such that:
  1. The pipe can stall the redirection if it becomes full.
  2. Bottlenecking may also occur if the two streams are moving at different speeds.

# Context Switching

The idea is we have many processes running on a computer CPU that has multiple cores and each core on the CPU can run one process at any given time. In a multitasking context, _context switching_ refers to the process of storing the system state for one task, so that task can be paused and another task resumed. A context switch can also occur as the result of an _interrupt_, such as when a task needs to access disk storage, freeing up CPU time for other tasks. Some operating systems also require a context switch to move between _user mode_ and _kernel mode_ tasks.

- One common case related to _scheduling_:
  - Let's say there are 16 process running and 8 cores, we cannot run all 16 processes at a given time. Every CPU has a clock, when a process runs for too long the kernel will trigger an interrupt in order to allow another process the ability to run instead. Any given process can either conclude or trigger another interrupt, at which point another process can run. The hardware determines when interrupts occure, when an interrupt happens, a mode switch to kernel mode utilizes its scheduler to determine if another process should run instead.
- Processes can be in one of three states:
  1. _Running_
     - On a CPU core.
  2. _Ready_
     - Capable of running but unable to due to insufficient resources like not enough cores available to run the particular process.
  3. _Blocked_
     - Waiting to run, such as waiting for user input or waiting for standard input to be piped into it.
- The illusion that we are able to run so many processes at once on our computers is due to _schedulers_ that instigate interrupts and switches so quickly that it is unnoticeable to humans. However, in the context of video games, having too many processes running at once may cause notable lag due to the need for frames to refresh at a certain rate and consistently to avoid detection by the human eye.
- In Linux, there is something called a _niceness value_ which determines the priority of a program to run from `-n` to `+n` such that the negative extreme, `-n`, has the least priority and positive extreme, `+n`, has the greatest priority. This influences whether or not the kernel decides to allow a process to run longer than the clock suggests.
  - **Example:**
    - We might allow a low priority program to run once every 20 interrupts, but a very high priority program might run for 19 interrupts consecutively, etcetera.

# Zombies

On Unix and Unix-like computer operating systems, a _zombie process_ or _defunct process_ is a process that has completed execution (via the `exit` system call) but still has an entry in the process table: it is a process in the "_Terminated State_". This occurs for the child processes, where the entry is still needed to allow the parent process to read its child's exit status: once the exit status is read via the `wait` system call, the zombie's entry is removed from the process table and it is said to be "reaped".

A child process always first becomes a zombie before being removed from the resource table. In most cases, under normal system operation, zombies are immediately waited on by their parent and then reaped by the system – processes that stay zombies for a long time are generally an error and cause a resource leak, but the only resource they occupy is the process table entry – process ID.

The term zombie process derives from the common definition of zombie — an undead person. In the term's metaphor, the child process has "died" but has not yet been "reaped". Also, unlike normal processes, the `kill` command has no effect on a zombie process.

Zombie processes should not be confused with _orphan processes_: an orphan process is a process that is still executing, but whose parent has died. When the parent dies, the orphaned child process is adopted by `init` (process ID 1). When orphan processes die, they do not remain as zombie processes; instead, they are waited on by `init`. The result is that a process that is both a zombie and an orphan will be reaped.

- Let's say the parent creates a child where the program has finished running but the process hasn't been killed yet or cleaned up.
- The operating system does not immediately reclaim that memory.
- Normally if you run a `Hello World` program it would get cleaned up once the program terminates, but if a parent makes a child (a process creates another process) then we won't want to kill the child right away since it might need to return something to the parent once it finishes running.
- The parent may be waiting for the child to finish and return something to it, so the child becomes a zombie where it is in a limbo state in the case that its parent is still doing something but may need to recieve information from the child when the parent is done doing that "thing".
- This is why zombie processes exist at all. `
- Sometimes a parent is not quite ready to recieve the information returned by its child and so the child must wait for the parent to be in a state to recieve that information.
- There is a system call called `wait` in the parent where the parent is blocked until the child is finished running.
- If a parent has multiple children then it must wait for all of them to finish before killing them.
- If the parent dies the child dies as well.

## Example: Scenario

- Parent creates child.
  - So we have a process $P$ and process $C$.
- No guarantees about which process runs first.
  - If multiple cores, they may even run simultaneously.
- The `wait()` system call allows the parent to wait (be BLOCKED) until child has finished.

### Case 1

    Parent runs first

- Parent calls `wait()` and is blocked.
- Child runs.
  - Exits with return code 1.
  - Child is made a zombie.
  - If we cleaned up child now, we wouldn't be able to give the parent the return code.
- Kernel unblocks parent.
  -  Now, 1 is returned from the `wait()` call.
  -  The kernel cleans up child's data (stack, etcetera).
- Parent continues running.
- Parent exits.
- Kernel cleans up parent's data.

### Case 2

    Child runs first

- Child runs.
  - Exits with return code 1.
  - Child is made a zombie.
- Parent calls `wait()`.
  - In this case since child is already done, no need to block.
    - Kernel just gives return code 1.
    - The Kernel cleans up child's data.
- Parent continues running.
- Parent exits.
- Kernel cleans up parent's data.

# Sanity Checking

_Sanity checking_ is a lamens term for ensuring that the program is doing what it's supposed to do. That is, ensuring the integrity of the program.

# Race Conditions

_Race condition_ is a technical term for an undesirable situation that occurs when a device or system attempts to perform two or more operations at the same time, but because of the nature of the device or system, the operations must be done in the proper sequence to be done correctly.

# `strace`

- Diagnostic tool that lets you know all the system calls that are made.

# Structs

Structures (also called structs) are a way to group several related variables into one place. Each variable in the structure is known as a member of the structure. Structures can not contain functions.

## Examples

The following examples are based on `struct person`.

```c
struct person {
  int age;
  char* eye_color;
  char* name;
};
```

### Example 1

```c
int main(int argc, char* argv[]) {

  struct person ben;
  ben.age = 24;
  ben.eye_color = "Brown";
  ben.name = "Ben"

  printf("%s is %d years old and has %s eyes.\n", ben.name, ben.age, ben.eye_color);

  return 0;
}
```
```
Ben is 24 years old and has Brown eyes.
```

### Example 2

```c
int main(int argc, char* argv[]) {
  
  struct person *shiner = malloc(sizeof(struct person));
  (*shiner).age = 8;    // One way to set variable of this struct
  // shiner->age = 8;   // Another way to set variable of this struct
  shiner->eye_color = "Green";
  shiner->name = "Shiner";

  printf("%s is %d years old and has %s eyes.\n", shiner->name, shiner->name, shiner->eye_color);

  return 0;
}
```
```
Shiner is 8 years old and has Green eyes.
```

# `#include` Guards

`#ifndef` is often used to make header files idempotent by defining a token once the file has been included and checking that the token was not set at the top of that file.

```c
#ifndef <token>
/* Code */
#else
/* Code to include if the token is defined */
#endif
```
```c
#ifndef _INCL_GUARD
#define _INCL_GUARD
#endif
```

- `#ifndef` checks whether the given token has been `#defined` earlier in the file or in an included file.
- If not, it includes the code between it and the closing `#else` or, if no `#else` is present, `#endif` statement.

# Signals

A list of signals and what they mean.
  - These were all recorded from a Linux i386 system.
    - Numbers may vary between platforms.
  - Linux uses signals 34-64 for its real-time system which we are not interested in.
  - Official manual page on signals can be found at:
    1. [man7.org](https://man7.org/linux/man-pages/man7/signal.7.html)
    2. [linux.die](https://linux.die.net/man/7/signal)
  - This is a fairly exhaustive list of signals.
    - Only some of them will arrise in the context of the `make` program.

## Signal Table

| No. | Short Name | Meaning                                                                                                                                                                                                                                                                                                                                                                                  |
|----:|------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
|   1 | SIGHUP     | If a process is being run from terminal and that terminal suddenly goes away then the process receives this signal. "HUP" is short for "*h*ang *up*" and refers to hanging up the telephone in the days of telephone modems.                                                                                                                                                             |
|   2 | SIGINT     | The process was "*int*errupted". This happens when you press `Ctrl-C` on the controlling terminal.                                                                                                                                                                                                                                                                                       |
|   3 | SIGQUIT    |                                                                                                                                                                                                                                                                                                                                                                                          |
|   4 | SIGILL     | *Ill*egal instruction. The program contained some machine code the CPU can't understand.                                                                                                                                                                                                                                                                                                 |
|   5 | SIGTRAP    | This signal is used mainly from within debuggers and program tracers.                                                                                                                                                                                                                                                                                                                    |
|   6 | SIGABRT    | The program called the `abort()` function. This is an emergency stop.                                                                                                                                                                                                                                                                                                                    |
|   7 | SIGBUS     | An attempt was made to access memory incorrectly. This can be caused by alignment errors in memory access etc.                                                                                                                                                                                                                                                                           |
|   8 | SIGFPE     | A *f*loating *p*oint *e*xception happened in the program.                                                                                                                                                                                                                                                                                                                                |
|   9 | SIGKILL    | The process was explicitly killed by somebody wielding the `kill` program.                                                                                                                                                                                                                                                                                                               |
|  10 | SIGUSR1    | Left for the programmers to do whatever they want.                                                                                                                                                                                                                                                                                                                                       |
|  11 | SIGSEGV    | An attempt was made to access memory not allocated to the process. This is often caused by reading off the end of arrays etc.                                                                                                                                                                                                                                                            |
|  12 | SIGUSR2    | Left for the programmers to do whatever they want.                                                                                                                                                                                                                                                                                                                                       |
|  13 | SIGPIPE    | If a process is producing output that is being fed into another process that consume it via a *pipe* `producer | consumer` and the consumer dies then the producer is sent this signal.                                                                                                                                                                                                  |
|  14 | SIGALRM    | A process can request a "wake up call" from the operating system at some time in the future by calling the `alarm()` function. When that time comes round the wake up call consists of this signal.                                                                                                                                                                                      |
|  15 | SIGTERM    | The process was explicitly killed by somebody wielding the kill program.                                                                                                                                                                                                                                                                                                                 |
|  16 | Unused     |                                                                                                                                                                                                                                                                                                                                                                                          |
|  17 | SIGCHLD    | The process had previously created one or more *child* processes with the `fork()` function. One or more of these processes has since died.                                                                                                                                                                                                                                              |
|  18 | SIGCONT    | (To be read in conjunction with SIGSTOP.) If a process has been paused by sending it SIGSTOP then sending SIGCONT to the process wakes it up again ("*cont*inues" it).                                                                                                                                                                                                                   |
|  19 | SIGSTOP    | (To be read in conjunction with SIGCONT.) If a process is sent SIGSTOP it is paused by the operating system. All its state is preserved ready for it to be restarted (by SIGCONT) but it doesn't get any more CPU cycles until then.                                                                                                                                                     |
|  20 | SIGTSTP    | Essentially the same as SIGSTOP. This is the signal sent when the user hits `Ctrl-Z` on the terminal. (SIGTSTP is short for "terminal stop".) The only difference between SIGTSTP and SIGSTOP is that pausing is only the _default_ action for SIGTSTP but is the _required_ action for SIGSTOP. The process can opt to handle SIGTSTP differently but gets no choice regarding SIGSTOP. |
|  21 | SIGTTIN    | The operating system sends this signal to a backgrounded process when it tries to read *in*put from its terminal. The typical response is to pause (as per SIGSTOP and SIFTSTP) and wait for the SIGCONT that arrives when the process is brought back to the foreground.                                                                                                                |
|  22 | SIGTTOU    | The operating system sends this signal to a backgrounded process when it tries to write output to its terminal. The typical response is as per SIGTTIN.                                                                                                                                                                                                                                  |
|  23 | SIGURG     | The operating system sends this signal to a process using a network connection when "*urg*ent" out of band data is sent to it.                                                                                                                                                                                                                                                           |
|  24 | SIGXCPU    | The operating system sends this signal to a process that has exceeded its CPU limit. You can cancel any CPU limit with the shell command `ulimit -t unlimited` prior to running make though it is more likely that something has gone wrong if you reach the CPU limit in make.                                                                                                          |
|  25 | SIGXFSZ    | The operating system sends this signal to a process that has tried to create a file above the file size limit. You can cancel any file size limit with the shell command `ulimit -f unlimited` prior to running make though it is more likely that something has gone wrong if you reach the file size limit in make.                                                                    |
|  26 | SIGVTALRM  | This is very similar to SIGALRM, but while SIGALRM is sent after a certain amount of real time has passed, SIGVTALRM is sent after a certain amount of time has been spent running the process.                                                                                                                                                                                          |
|  27 | SIGPROF    | This is also very similar to SIGALRM and SIGVTALRM, but while SIGALRM is sent after a certain amount of real time has passed, SIGPROF is sent after a certain amount of time has been spent running the process and running system code on behalf of the process.                                                                                                                        |
|  28 | SIGWINCH   | (Mostly unused these days.) A process used to be sent this signal when one of its windows was resized.                                                                                                                                                                                                                                                                                   |
|  29 | SIGIO      | (Also known as SIGPOLL.) A process can arrange to have this signal sent to it when there is some input ready for it to process or an output channel has become ready for writing.                                                                                                                                                                                                        |
|  30 | SIGPWR     | A signal sent to processes by a power management service to indicate that power has switched to a short term emergency power supply. The process (especially long-running daemons) may care to shut down cleanlt before the emergency power fails.                                                                                                                                       |
|  31 | SIGSYS     | Unused.                                                                                                                                                                                                                                                                                                                                                                                  |

# Variable Shadowing

In computer programming, variable shadowing occurs when a variable declared within a certain scope (decision block, method, or inner class) has the same name as a variable declared in an outer scope. At the level of identifiers (names, rather than variables), this is known as name masking. This outer variable is said to be shadowed by the inner variable, while the inner identifier is said to mask the outer identifier. This can lead to confusion, as it may be unclear which variable that subsequent uses of the shadowed variable name refer to, which depends on the name resolution rules of the language. Some languages allow variable shadowing while others do not, but many modern languages don't because it leads to programmer error.

## Allows

Languages like C and Python allow this:

 - The first x is _shadowed_ by the second.
 - The inner x _masks_ the outer x.

### C

```c
int main() {
  int x = 10; // First, Outer
  if(x != 0) {
    int x = 888; // Second, Inner
    printf("%d", x);
  }
}
```
```
888
```

### Python

```python
x = 10

if x != None:
    x = 888
    print(x)
```
```
888
```

## Disallows

Languages like Java do not allow this.

- This java program does not compile for example.

### Java

```java
public static void main(String[] args) {
    int x = 10; // First, Outer
    if(x != 0) {
        int x = 888; // Second, Inner
        System.out.println(x);
    }
}
```
```
Error: Variable x is already defined in method main(String[])

int x = 888; // Second, Inner
    ^
```