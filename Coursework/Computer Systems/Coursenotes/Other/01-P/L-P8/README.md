# Job Control

    February 9, 2023

# Table of Contents

- [Job Control](#job-control)
- [Table of Contents](#table-of-contents)
- [Review](#review)
  - [Creation](#creation)
  - [Communication](#communication)
  - [Signalling](#signalling)
- [Introduction](#introduction)
- [Job-Control Shell](#job-control-shell)
  - [Read-Eval Loop](#read-eval-loop)
    - [Read](#read)
    - [Eval](#eval)
  - [Shells](#shells)
    - [Examples](#examples)
  - [Piping](#piping)
  - [`fg` vs `bg`](#fg-vs-bg)
    - [States of Job](#states-of-job)
      - [Foregound](#foregound)
      - [Background](#background)
      - [Stopped](#stopped)
  - [OS View](#os-view)
    - [Process Groups](#process-groups)
  - [Shell Responsibilties](#shell-responsibilties)
- [Source](#source)

# Review

- Process is an abstraction for a running program.
- API's are uniforms accross resources.
  - Recall `open`, `read`, `write`, and `close` for File Descriptors.

## Creation

- API's create a new process.
  - Recall `fork` and `exec` to spawn children processes from a parent process.

## Communication

- APIs for processes to communicate.
  - Pipes, AKA FIFO, to redirect data streams.
  - Processes can be using a pipe without knowing it necessarily.
  - Kernel handles blocking reads/writes to a pipe, user doesn't have to handle it or worry about it or "synchronize" data.

## Signalling

- OS can communicate with processes using Signals while processes communicate with OS using System Calls.

# Introduction

- User program can use these to manage/control life cycle of programs.
  - "User program" typically refering to a shell.
    - Shell tries to capture user intention.
- Recall the start of course when discussing dual-mode operation and kernel privileges.
  - It's nice to keep these privileges lean, to do the minimal amount of functionality inside the kernel.
  - Gives us a lot of flexbility to manage processes in a user-defined way.

# Job-Control Shell

- The "process" is the OS's view of a program while a "job" is the user's view of a program.
  - The user cares more about the "job" than the "process" because we want to run a program or "job" that might spawn a bunch of "processes".

## Read-Eval Loop

- A simple interactive computer programming environment that takes single user inputs, executes them, and returns the result to the user.
- Idea is to get user input to maybe `fork` a program and then `exec` and then `wait` and return output to prompt.

### Read

- Read input from user.

### Eval

- Executable File (ELF)
  - Binary.
- Built-in
  - Not a new program.
  - Think of `cd` in the context of a shell.
  - Some things are easier/faster to do as a built-in.

<p align="center" width="100%">
    <img src="img/figure-1.png">
</p>


## Shells

- Functionality may differ from shell to shell.

### Examples

1. `bash`
2. `sh`
3. `zsh`
4. `cush`

## Piping

- Piping programs together is another feature supported by shells.
- Programs being pipes don't need to know about each other at all.
  - All that matters is the idea of `stdin` to `stdout`.
- Useful/powerful because it allows us to re-use pre-existing programs rather than rewriting them.

## `fg` vs `bg`

- Idea of running a process in the background, `bg`, rather than in the foreground, `fg`, with control over the prompt.
  - Consider the `sleep` command.
    - Running this in the foreground prevents us from reading any more user input from the prompt, but if we run it in the background using `&` instead, we can still perform other tasks with the prompt.

### States of Job

- Jobs are made up of processes but they are not processes.
  - Do not confuse with states of _processes_.
  
#### Foregound

- Foreground job gets input from the terminal.

#### Background

- Background job is executing but input is going to shell or foregound job.
- User can still use the shell and maintain control of prompt.

#### Stopped

- Can occur if a foregound process is sent a signal like `SIGINT` using `^Z`.
- Can later be sent to run in the background using `&`.
- Can be killed using `kill -9 <pid>`.

## OS View

- Has an idea of what is in the foreground.
- In Linux, the `+` status denotes a foregound process.

### Process Groups

- Process groups denote a job.
- Signals can be delivered to entire group, that is, every process in a process group.
  - Example being if you want to kill all the processes in a group using a command like `kill -9 <pgid>`.
- Each process can belong to only one process group at any given time.
- Process groups have a "leader" whose `pid` is the `pgid` of the process group.
  - Even if the leader process itself is killed, the rest of the process group can still live on.
- Any process can create a process group with itself as the leader.
- Any process may join or be assigned to a process group.

## Shell Responsibilties

- Will arrange processes into process groups to handle the following:
  - `^C`
  - `^Z`
  - Other Signals:
    - `SIGTTOU`
    - `SIGTTIN`
- Forked children with inherit parent's process group by default.
  - However, parent process can also decide to make their child process be the leader of their own process group.
    - That is, children of a parent process do not always share a `pgid` with their parent.

<p align="center" width="100%">
    <img src="img/figure-2.png">
</p>

# Source

[Dan Williams](https://people.cs.vt.edu/djwillia/)