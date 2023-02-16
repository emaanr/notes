# Linking & Loading: Part I

# Table of Contents

- [Linking & Loading: Part I](#linking--loading-part-i)
- [Table of Contents](#table-of-contents)
- [Introduction: Learning Goals](#introduction-learning-goals)
- [Big Picture](#big-picture)
- [Compiler & Assembler](#compiler--assembler)
- [Relocatable Object Files: Text Section](#relocatable-object-files-text-section)
- [Executable & Linkable Format (ELF)](#executable--linkable-format-elf)
- [Treatment of Global Variables](#treatment-of-global-variables)
- [Relocatable Object Files: Data, BSS, Read-Only Section](#relocatable-object-files-data-bss-read-only-section)
- [Linking Multiple Object Files](#linking-multiple-object-files)
- [Resulting Symbol Table](#resulting-symbol-table)
- [Conceptual Depiction of Merging](#conceptual-depiction-of-merging)
- [Content of Final Executable](#content-of-final-executable)
- [Virtual Address Space Layout (Linux x86_64, 48-bit)](#virtual-address-space-layout-linux-x86_64-48-bit)
- [Address Space Layout Randomization (ASLR)](#address-space-layout-randomization-aslr)
- [Summary](#summary)
- [Source](#source)

# Introduction: Learning Goals

- Understanding the overall processes which most major systems and infrastucture software are built and executed by today.
  - How symbols in high-level languages are resolved to addresses and constants in machine code.
  - The coordination of linker and loader, particularly in systems exploting virtual address spaces.
  - How linkers allocate space for variables and functions, including the role of symbol tables.
- Become proficient as a software engineer at the intermediate level in the C language when separate compilation is used for medium and large programs.
  - Separate compilation and the role of header files in creating modular code.
  - Common mistakes.
  - Best practices when declaring and defining functions and variables.
  - The role and purpose of static libraries.
  - The role and purpose of dynamic libraries.
  - The purpose of whole program link-time optimization.
  - The implications of virtual address space layout for debugging program faults.
  - How to use common tools such as `nm`, `objdump`, etc.

# Big Picture

<p align="center" width="100%">
    <img src="figure-1.png">
</p>

# Compiler & Assembler

<p align="center" width="100%">
    <img src="figure-2.png">
</p>

- Preprocessor performs textual insertion of `include` files.
- Compiler resolved the following symbolic names:
  - Local automatic variables.
  - Function parameters.
  - Field names in structures.
- Assembler resolves certain labels for relative branches.
- The resulting relocatable `.o` file still retains symbolic name for all functions and variables that are global in extent.

# Relocatable Object Files: Text Section

<p align="center" width="100%">
    <img src="figure-3.png">
</p>

- Contain multiple sections (only `text` shown here).
- Each section is laid out as if starting at 0.
- Contains _relocation records_:
  - Placeholders and meta information about how to patch them up once actual addresses are known.

# Executable & Linkable Format (ELF)

<p align="center" width="100%">
    <img src="figure-4.png">
</p>

- ELF is a standard format for relocatable object files, executable, and shared objects (dynamic libraries) used in System V and derived systems, including Linux [URL].
- Other formats include:
  - Mach-O (OSX)
  - PE (Windows)
  - `a.out`
- Provides the link between compiler → linker → loader.
- Carries all information needed by the next tool as well as debugging and exception handling information.
- Extensive tool support.

# Treatment of Global Variables

<p align="center" width="100%">
    <img src="figure-5.png">
</p>

# Relocatable Object Files: Data, BSS, Read-Only Section

<p align="center" width="100%">
    <img src="figure-6.png">
</p>

- Global variable that have programmer defined initial values are stored in the `data` section (`readonly` if constant).
- Global variables without programmer defined initial values are listed in so-called BSS section where BSS stands for "Better Save Space".

# Linking Multiple Object Files

<p align="center" width="100%">
    <img src="figure-7.png">
</p>

- Multiple `.o` object files are merged into an executable by the linker.
- The merging process creates an in-memory layout of the process's code and data.
- The linker resolves references (by matching them to definitons) and relocates symbols to their computed address and fills in any placeholders referring to them.

# Resulting Symbol Table

- `source1.o`
    ```
                     U longabs
    0000000000000000 T manhattan
    ```
- `source2.o`
    ```
    0000000000000000 T adder
                     U elong
    0000000000000010 D name
    0000000000000008 D ptr
    0000000000000000 D s_long
    0000000000000008 C w_long

    ```
- `source3.o`
    ```
                     U adder
    0000000000000000 D elong
    0000000000000000 T longabs
    000000000000001a T main
    ```
- `exe`
    ```
    // .text.startup
    0000000000400450 T main

    // .text
    0000000000400550 T manhattan
    0000000000400580 T adder
    00000000004005a0 T longabs
    
    // .data
    0000000000601020 D s_long
    0000000000601028 D ptr
    0000000000601030 D name
    0000000000601038 D elong

    // .bss
    0000000000601048 B w_long
    ```
# Conceptual Depiction of Merging

<p align="center" width="100%">
    <img src="figure-8.png">
</p>

- The linker merges like-sections in sequention order (usually as provided on the command line).
- Guided by the linker script `ld --verbose`.
- Resulting executable is designed to be efficiently loaded (or mapped) at load time into the process's virtual address space.

# Content of Final Executable

<p align="center" width="100%">
    <img src="figure-8.png">
</p>

- Showing excerpts from `.text` and `.data` sections.

# Virtual Address Space Layout (Linux x86_64, 48-bit)

<p align="center" width="100%">
    <img src="figure-9.png">
</p>

# Address Space Layout Randomization (ASLR)

- To increase defenses against remote execution vulnerabilities, modern systems try to randomize as much of their address space as possible.
- Examples:
  - Stack,
  - Heap locations,
  - To an increasing extent also code + data.
- This impacts the linking process:
  - In general, linker-assigned addresses are "baked" into the machine code, which can be loaded directly.
- Loaders can also perform load time relocation (at a cost).
- Position-Independent Code (PIC) can be loaded at any address in the address space without further relocation.
- In general, PIC requires indirection.
  - The x86_64's IP-relative addressing mode `disp (%rip)` was introduced to assist in this.

# Summary

- Compiler resolves certain symbolic names, but passes any that are global in extent onto the linker as references in relocatable object files.
- Linker merges object files to produce an executable, computing a virtual address space layout in the process.
- The executable contains the text and data needed to load a program into memory.
- We have ignored so far:
  - Lexical scoping rules:
    - Global vs Local to a compilation unit.
  - Rules the linker applies when deciding how to resolve an external reference.
  - Static and dynamic libraries.

# Source

[Godmar Back](https://people.cs.vt.edu/~gback/)