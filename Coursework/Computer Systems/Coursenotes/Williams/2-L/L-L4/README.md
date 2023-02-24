# Linking Libraries

    February 23, 2023

# Table of Contents

- [Linking Libraries](#linking-libraries)
- [Table of Contents](#table-of-contents)
- [Review](#review)
  - [What's Left?](#whats-left)
- [Static Libraries](#static-libraries)
  - [Usage](#usage)
  - [Order Matters](#order-matters)
  - [Advantages](#advantages)
  - [Disadvantages](#disadvantages)
- [Dynamic Libraries](#dynamic-libraries)
  - [Procedure Linkage Table (PLT)](#procedure-linkage-table-plt)
    - [Advantages](#advantages-1)
    - [Disadvantages](#disadvantages-1)
  - [`LD_PRELOAD`](#ld_preload)
- [Source](#source)

# Review

// Include diagram from notes

- Review of the compilation process so far:
  1. Preprocessor
     - `.h` + `.c` $\rightarrow$ `.c`
  2. Compiler
     - `.c` $\rightarrow$ `.s`
  3. Assembler
     - `.s` $\rightarrow$ `.o`
       - Where `.o`s are an ELF Type, Relocatable Object Files.
  4. Linker
     - `.o` $\rightarrow$ `exe`

## What's Left?

- Static Libraries, `.a` and Dynamic Libraries, `.so`, "Shared Object".
  - Static Libraries are linked together with the other relocatable `.o` files to create the `exe`.
  - Dynamic Libraies will be utilized at run-time on the fly on an as-needed basis.

# Static Libraries

// Include diagram from notes

- The `.a` static library contains many `.o` files inside of it.
- The tool used to create a static library is `ar` which means archive.
  - Static libraries are an archive of `.o` files.

## Usage

- `gcc -L. -lA -lB` where `l` looks for `lib` and then whatever comes after it.
  - `lA` is looking for `libA`.
  - `lB` is looking for `libB`.
- One benefit to libraries is that we can simply call to compile with a library and let the linker figure out which `.o` files from that library are needed for our program rather than us, as the programmers, manually entering every file we need to include in our process in our `gcc` command.

## Order Matters

- Sometimes, the order you call your libraries in matters.
  - That is:
    - `gcc [file.c] -L. -lB -lA` may compile fine.
    - `gcc [file.c] -L. -lA -lB` may not, and vice versa.
  - Depending on the state of the `file.c` that is calling these libraries.
  - Linker goes through `-L` "static libraries to include" in order, keeping track of the `U` symbols.
    - Only picks the `.o`s we need.

## Advantages

- Smaller binaries.
  - We don't want a bunch of dead code in our binaries.
- Possibly faster LTO.
- Compatibility, all dependencies are self-contained so you can run code in libraries versioned way back in the day.

## Disadvantages

- Why might it be unideal to link everything staticly at link-time?
  - Updating the library requires rebuilding to an extent.
    - Can be a big headache from a deployment perspective.
  - Memory duplication, inefficient.
    - The main reason dynamic libraries exist and why they are called `.so` "Shared Object"s.
    - Memory was very precious back in the day.

# Dynamic Libraries

- Load library dynamically at runtime.
- Called `.so`, "Shared Object" in Linux/Unix.
- Called `.dll`, "Dynamically Linked Library" in Windows.
  - Has it's own set of issues: `dll` hell".
- Utilized after the Linker has done its job and the executable has been built.

## Procedure Linkage Table (PLT)

- Running in main, then we had `puts@plt`, then we had `???`, then we got `puts`, then we had our second call, that went directly to `puts` without the `???` intermediary step.
  - Linker runs and put the dynamic library into memory.
    - During this step, a PLT is created.
    - Every future call to `printf` will be `puts@plt` but it won't be as expensive beyond the first call.
  - The `???` is colloquially called a "Trampoline" since it bounces you to where you need to be.
- Recursively finds/loads `.so`s.

### Advantages

### Disadvantages

- Possibly some overhead.
- No longer ensures compatibility, that all dependencies are present since they are not self-contained like with static libraries.

## `LD_PRELOAD`

- Exploits that dynamic linker keeps track of the symbol resolution order.
- Library interposition type use cases.
- Allows interposing your own code when there is symbol resolution.
  - Can be used to debug issues with locks.

# Source

[Dan Williams](https://people.cs.vt.edu/djwillia/)