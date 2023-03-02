# What's the difference between a Console, a Terminal, and a Shell?

    Console, Terminal, and Shell.

## Table of Conents

- [What's the difference between a Console, a Terminal, and a Shell?](#whats-the-difference-between-a-console-a-terminal-and-a-shell)
  - [Table of Conents](#table-of-conents)
  - [Terminal](#terminal)
  - [Console](#console)
  - [Shell](#shell)
- [Source](#source)

## Terminal

    The word Terminal comes from "terminate", indicating that it is the terminating end or "terminal" end of a communication process.

- "Dumb Terminal" often refers to a text-based environment where the computer you are at simply takes input and displays the text while the real work is occuring somewhere else in a mainframe or large computer.
- TTY or "Teletypewriter" was the first kind of terminal where the typed input would display to a physical piece of paper as well as being sent to a computer whose response would then automatically get output by the typewriter to the same physical piece of paper.
- When we refer to a Terminal in the software sense, we are referring to a literal software version of a TTY or Terminal.
  - This is what the Windows Terminal is. It's really good at displaying textual output and can pass input but the Terminal isnt't smart.
    - It doesn't actually _process_ input or _look_ at your files or _think_.

## Console

    Folks in the mid 20th century would have a piece of furniture in their living room called a console or a console cabinet. A Console
    in the context of computers is a console or cabinet with a screen and keyboard combined inside it, but it's effectively a Terminal.
    Technically the Console is the device and the Terminal is now the software program inside the Console.

- Think of Console as a "Gaming Console" where the Terminal is the "Game" in the Gaming Console.
- In the software world, a Terminal and a Console are, for all intents, synonymous.

## Shell

    Shell is the program that the Terminal sends user input to. Shell generates output and passes it back to the Terminal for display.

- Some examples of Shells:
  - Unix
    - bash, fish, zsh, ksh, sh, tsch
  - Microsoft
    - PowerShell, pwsh
  - Windows
    - cmd, yori, 4dos, command.com
- Your choice of shell doesn't and shouldn't dictate your choice of terminal applications.

> **Aside:** WSL and WSL2 (Windows Subsystem for Linux) are complete local Linux (or many Linuxes) that run on Windows 10. They are full and real. WSL2 ships a real Linux kernel and runs it on Windows. Cygwin does NOT. Cygwin is a large collection of GNU and Open Source tools which provide functionality similar to Linux on Windows, but it is not Linux. It's a simulacrum. It's GNU utils compiled against Win32. It's great, but it's important to know the difference. Cygwin may let you run your bash shell scripts but it will NOT run Apache, Docker, or other real ELF-binaries and Linux apps.

# Source

[Scott Hanselman](https://www.hanselman.com/blog/whats-the-difference-between-a-console-a-terminal-and-a-shell)
