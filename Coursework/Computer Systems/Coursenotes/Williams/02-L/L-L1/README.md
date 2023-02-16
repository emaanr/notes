# Undefined Behavior & Building Executables

    February 14, 2023

# Table of Contents

- [Undefined Behavior \& Building Executables](#undefined-behavior--building-executables)
- [Table of Contents](#table-of-contents)
- [Introduction](#introduction)
  - [Process Life Cycle](#process-life-cycle)
  - [Building Executables](#building-executables)
- [U.B.](#ub)
  - [Specs](#specs)
    - [Result](#result)
    - [Compiler Optimization Levels](#compiler-optimization-levels)
      - [02](#02)
      - [00](#00)
      - [Makefile](#makefile)
    - [Aside](#aside)
    - [Examples](#examples)
      - [Example 1](#example-1)
        - [Unoptimized](#unoptimized)
        - [Optimized](#optimized)
      - [Example 2](#example-2)
  - [Why?](#why)
  - [What can we do in C?](#what-can-we-do-in-c)
- [Building Executable](#building-executable)
  - [Translation](#translation)
    - [Compiler Driver](#compiler-driver)
    - [Preprocesser](#preprocesser)
  - ["-Time" Diagram](#-time-diagram)
- [Source](#source)

# Introduction

## Process Life Cycle

- Moving away from process life cycle which covers how to create and manage new programs (ELF: Executable Linkable Format).
  - `fork`
  - `exec`
  - Signals
  - Etc.

## Building Executables

- To look at how programs themselves, their binaries, are being built and executed.

# U.B.

- First:
  U.B. "Undefined Behavior" $\leftarrow$ Compilation of C Project.

## Specs

  - Spec manuals sometimes have keywords like `SHOULD`, `SHOULD NOT`, `MUST`, and `MUST NOT`.
    - Essentially the compiler writers will look at these statements and make some optimizations related to them.
    - Compiler:
      - Takes advantage of these statements.

### Result

- Horrible bugs:
  - Integer Overflow
  - Out of Bounds Arrays

### Compiler Optimization Levels

-

#### 02

- Normal level of optimization.

#### 00

- No optimization.

#### Makefile

```c
```

- Makefile used for the examples.

### Aside

- `0xdeadbeef` often used in programs for testing bugs and undefined behavior due to visual ease of recognition.

### Examples

1. Integer Overflow
   - Consider a 32-bit un-signed integer like `0xffffffff + 1` would cause an integer overflow.
   - Now the statement `x + 1 > x` is no longer true.
   - Causes a bug in the program as a result of programmer error.
2. Out of Bounds Array
   - Consider an attempt to access an index of an array that is out bounds.

#### Example 1

```c
```

- Keyword `volatile` tells the compiler not to optimize out anything with this keyword.
  - Despite that it still removes this.
- Current state of the code won't work because the compiler tries to be smart and removes

##### Unoptimized

- Still has the dangerous `0xdeadbeef`.

##### Optimized

- Compiler gets rid of `test_overflow` as a result of optimizations and never runs `my_abort`.

#### Example 2

```c
```

- Another example of U.B. using a table.
- In C spec if you access an elements that is out of bounds of an array that is Undefined Behavior.
  - Of of the iterations in this example is out of bounds.
    - The compiler will try to optimize this.
- Unoptimized `objdump` is very long with optimized `objdump` is very short.
  - Since it knows that one of these loops is always undefined, the compiler chooses to just return true for it.
  - The `objdump` being shorter is a result of the compiler trying to make the program "faster", in other words, more "optimized".

## Why?

- Compiler Optimizations $\leftarrow$ Some need U.B.
  - If we can't make certain statements, they can't make optimizations.
  - Explore further what compiler people say about this subject matter.
    - How much responsibility to we want to place on the Compiler vs Programmer.
      - Rust for example tries to eliminate some of this Undefined Behavior.
        - However this results in a challenge for compiler people to determine how to base their optimizations schemas.
- Ultimately, U.B. is a "contract" between the Compiler and the Programmer.
  - More U.B. means more power to the compiler to perform optimizations vs Programmer responsibility.
    - Optimization aims to make programs faster.

## What can we do in C?

1. Flags that will turn compiler optimizations into warnings:
   - `Werror`
   - `Wall`
1. Increasing effort to catch undefined behavior using external tools.
   - `clang -f catch-undefined-behavior`
     - A different compiler from `gcc` that is a bit more advanced in some areas of analysis.
   - `valgrind memcheck`
   - Can't find bugs that are optimized out.
2. Use `objdump -S`.

# Building Executable

- C Code $\rightarrow$ Machine Code
  - C Code has a lot of symbols, what happens to them?
    - Functions
    - Globals
    - Locals
  - Machine Code does not have symbols, just has concrete addresses and maybe some constants.

<p align="center" width="100%">
    <img src="img/figure-1.png">
</p>

## Translation

- Done by the Compiler.
  - Under the hood, it is much more than a compiler.

### Compiler Driver

- GNU Compiler Collection: `gcc`
  - Name implies that it is more than just a compiler.
- Not just one program, but many programs.
  - When you say `gcc`, depending on how it is invoked, you could call one or many of these programs:
    1. Preprocesser
    2. Compiler
    3. Assembler
    4. Linker
    5. Loading
    6. Etcetera.

### Preprocesser

- One example of a program that runs during compile-time is the preprocessor which handles the following:
  - `#include`
  - `#ifdef`
  - `#if`
  - `#else`
  - `#define ADD_ONE(x) (x + 1)` $\leftarrow$ Macro

## "-Time" Diagram

<p align="center" width="100%">
    <img src="img/figure-2.png">
</p>

- Preprocessor inserts text.
  - Can be done with just `gcc -E`.
  - Header files can be included in multiple files.
- Compiler transforms `.c` C code into `.s` assembly.
- Assembler takes `.s` assembly files to create the `.o` object files.
- Linker links all `.o` object files together to create an executable.
  - Other libraries get linked in as well.
  - Now we have a single binary.
- Loading takes a `.so` shared object (dynamically linked libraries) to perform dynamic linking since some code is shared and we won't want to include this during link time necessarily.

# Source

[Dan Williams](https://people.cs.vt.edu/djwillia/)