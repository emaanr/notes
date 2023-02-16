# Processes

    January 19, 2023

# Table of Contents

- [Processes](#processes)
- [Table of Contents](#table-of-contents)
- [Processes](#processes-1)
  - [Memory](#memory)
  - [CPU Power](#cpu-power)
  - [Abstracted Devices/Resources](#abstracted-devicesresources)
    - [Why?](#why)
      - [Mainframes](#mainframes)
      - [Minicomputers](#minicomputers)
        - [Multiprogramming](#multiprogramming)
        - [Time-Sharing](#time-sharing)
        - [OS "Dark Ages"](#os-dark-ages)
    - [Protection](#protection)
      - [Scheduling Mechanisms vs Scheduling Policies](#scheduling-mechanisms-vs-scheduling-policies)
      - [Dual-Mode Operation](#dual-mode-operation)
      - [User Space vs Kernel Space](#user-space-vs-kernel-space)
        - [User $\\rightarrow$ Kernel](#user-rightarrow-kernel)
        - [Kernel $\\rightarrow$ User](#kernel-rightarrow-user)
      - [Mode-Switch vs Context-Switch](#mode-switch-vs-context-switch)
        - [Mode-Switching](#mode-switching)
        - [Context-Switching](#context-switching)
      - [Limited Directed Execution](#limited-directed-execution)
  - [More on Dual-Mode Operation](#more-on-dual-mode-operation)
    - [User Space](#user-space)
    - [Kernel Space](#kernel-space)
      - [Microkernel](#microkernel)
- [Source](#source)

# Processes

- Programs (regardless of language) are interacting with the kernel by using system calls.
- Processes are an abstraction of a running program.
  - A program is running if it is being allocated resources such as system memory, CPU power (something is executing, that is, it has at least one thread of execution), and abstracted devices/other resources.

## Memory

- There is an array of bytes representing allocated memory.
  - Need to put stuff into the memory, such as the code itself (text section in binary/machine code).
  - Memory contains a heap and a stack that are growing in opposite directions within the array of bytes representing memory.
  - Note that registers are not in memory (they are in the CPU).
  - A "process's address space" is how this process associated entity is commonly referred to.

## CPU Power

- There is some logical control flow through instructions (in the CPU).
  - This is called a "Thread" of execution.
  - A running process can have more than one thread executing for it (Thread $\geq 1$).


## Abstracted Devices/Resources

- Processes are granted an abstract view of other devices and resources.
  - `write(1, "hello world", 12);
    - The `1` is a file descriptor which is how the process refers to an abstracted resource.
      - `1` is reserved for "standard out" or `STDOUT` which is output to the console.
      - `0` is reserved for "standard in" or `STDIN`.
      - `2` is reserved for 'standard error" or `STDERR`.

### Why?

- Why do we want these abstractions?
  - Easier to program with abstractions.
    - Could use libraries.
  - In the beginning, there was no need for an operating system and would run programs directly on very expensive hardware.
    - At some point, certain routines were deemed common and so they created libraries of special code to avoid redundancy (especially useful since they used punch cards back then).

#### Mainframes

- Mainframes would carry out batch processes which ran one program at a time.
- Folks realized that OS libraries were doing things that we didn't want programmers to mess up.
  - If code wasn't executing properly and some code messed something up via and I/O instruction, it would create issues for everyone (machines were shared even more so than now and we scarce).
    - As a result, they decided to protect operations related to the OS which introduced "protection" for priviledged CPU instructions.

#### Minicomputers

- CPUs were incredibly expensive at the time and CPU power was wasted if processes/programs were waiting for some I/O during which time another program could have been using CPU resource.
- Think of minicomputers as modern day servers.
- Unix embodied both of the following ideas.

##### Multiprogramming 

- Multiprogramming introduced to handle this issue.
  - Switches programs if one program is waiting (idle) for some I/O.

##### Time-Sharing

- Time-Sharing is the idea of switching programs so all the programs could make progress.

##### OS "Dark Ages"

- Around the 80s.
- Emergence of the "personal computer".
  - Thought we didn't need the OS anymore on this smaller scale.
    - Led to:
        1. DOS: No protection.
        2. macOS: Cooperative scheduling.
           - Led to issues if a program was infinite looping.
- Eventually, programmers realized we still need the OS and protection on the scale of the personal computer.
  - Re-adopted Unix principles previously mentioned.
  - As a result Unix ideas are everywhere now.

### Protection

#### Scheduling Mechanisms vs Scheduling Policies

- We have discussed Scheduling Mechanisms in this lecture.
- Scheduling mechanisms do not change (are the same no matter the operating systems).
- Scheduling policies are operating systems specific and operate on different decision making heuristics.
  - An example is the Completely Fair Scheduler (CSF) in Linux.
  
#### Dual-Mode Operation

- Dual-Mode Operation is the idea where the CPU has a bit that tracks whether the user is a regular user or a supervisor when a process is being run.
  - So when certain instructions are ran, it is required to be ran by a supervisor, otherwise the CPU will throw an exception.

#### User Space vs Kernel Space

- User Space and Kernel space have different privileges in the context of processes that can run via the operating system.
- Mode is not always represented as a single bit corresponding to `1` or `0`.
- Privilege Rings is the idea of increasing privileges where more privileged users have the same privileges as less privileged users than them.
  - There are "ranges" that depending on the number of ranges will require more bits to represent them.
    - Example being a range of 0 to 3 inclusive which has 4 different privilege clearances would require 2 bits to represent.

##### User $\rightarrow$ Kernel

- When does the User enter the Kernel?
  - Bit flip from User $\rightarrow$ Kernel.
    1.  System calls.
    2.  Synchronous interrupt (aka Internal interrupt).
        - Can happen because of an instruction, traps, or exceptions.
    3. Asynchrnous interrupt (aka External interrupt. 
        - Can happen at any time and is timer and hardware related.
          - Timer related interrupt during an infinite loop is a timed out interrupt in order to maintain control.

##### Kernel $\rightarrow$ User

- Special instruction `iret`.
- Where does the Kernel return to?
  1.  Back to retry an instruction.
  2.  Just after the instruction.
      - Timer interrupts do this.

#### Mode-Switch vs Context-Switch

1. Mode-Switch without Context-Switch is a System Call.

    > "Meltdown 2018": Hardware would disallow something but access it anyway and place it in a cache which could then be accessed by the user via the cache.
    > - A technical security attack.
    > - This is introducing an idea of context switching even for system calls.
    > - Kernel Page-Table Isolation (KPTI) is how they mitigated this vulnerability.
    >   - Kernel Page-Table Isolation (KPTI or PTI previously called KAISER) is a Linux kernel feature that mitigates the Meltdown security vulnerability (affecting mainly Intel's x86 CPUs) and improves kernel hardening against attempts to bypass kernel address space layout randomization (KASLR).
    >   - It works by better isolating user space and kernel space memory.

2. Context-Switch without Mode-Switch happens during User Threading.
   - Switching between threads of execution.
   - Has plus sides and down sides.

##### Mode-Switching

- Mode-Switching is the idea of swapping from User to Kernel and vice versa.
- CPU register keeps track of what instructions or processes are running at the time of a mode switch (saves the state so it knows where to return to).
  - ISR: Interrupt Service Routine
    - Is a software routine that hardware invokes in response to an interrupt.
  - IDT: Interrupt Discriptor Table
    - A data structure used by the x86 architecture to implement an interrupt vector table.
  
##### Context-Switching

- Context-Switching is the idea of switching between processes rather than modes of control (user vs kernel).
- Utilizing multiprogramming and time-sharing principles.
  1. Save `P1` state.
  2. Restore `P2` state.

#### Limited Directed Execution

- Limited means no priileged instructions and the instructons cannot run infinitely.
- Direct Execution means the process runs directly on the CPU so its fast.
  - The operating system checks before mode switching.

## More on Dual-Mode Operation

- User space requests privileged behavior from the kernel via syscalls.
  - These syscalls are often being directly called or internally called by some function in a library.

### User Space

1. Libraries
2. GUI
3. Network Management
   - Communicates with TCP/IP.
4. Power Management
5. sshd

### Kernel Space

- Special, only one thing that runs (the kernel).
1. Kernel
   1. Linux
   2. Process Schedule
   3. TCP/IP Stack
   4. File System
   5. Memory Management

#### Microkernel

- Some of the aforementioned kernel responsibilities can be delegated to the user space as well.
- Microkernels are borne from the idea of delegating as little "extra" work to the kernel.
- The kernel is highly privileged so they tried to minimize scope of kernel duties to be as small as possible.
- Suggested by Andrew Tanenbaum who worked on "Minix" that Linus Torvalds would later build "Linux" on top of.
  - Torvalds' Linux system is Monolithic while Tanenbaum's Minix system uses idea of Microkernels.

| Torvalds    | Tanenbaum    |
|-------------|--------------|
| Monolithics | Microkernels |
| Linux       | Minix        |

# Source

[Dan Williams](https://people.cs.vt.edu/djwillia/)