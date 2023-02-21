# Linking: Part II

    February 21, 2023

# Table of Contents

- [Linking: Part II](#linking-part-ii)
- [Table of Contents](#table-of-contents)
- [Review](#review)
  - [RWE Permissions](#rwe-permissions)
  - [Address Space Layout Randomization (ASLR)](#address-space-layout-randomization-aslr)
  - [Big Picture](#big-picture)
    - [Compiler + Assembler](#compiler--assembler)
    - [Linker](#linker)
    - [Executable](#executable)
- [Symbol Conflicts @ Linker Level in C](#symbol-conflicts--linker-level-in-c)
  - [Example `source1.c`](#example-source1c)
    - [`nm source1.c`](#nm-source1c)
  - [Example `source2.c`](#example-source2c)
    - [`nm source2.c`](#nm-source2c)
  - [Example `source3.c`](#example-source3c)
    - [`nm source3.c`](#nm-source3c)
  - [Example `source4.c`](#example-source4c)
    - [`nm source4.c`](#nm-source4c)
  - [Example `source5.c`](#example-source5c)
    - [`nm source4.c`](#nm-source4c-1)
- [Global Conflict Resolution](#global-conflict-resolution)
  - [Strong vs Weak Symbols](#strong-vs-weak-symbols)
    - [Functions](#functions)
    - [Variables](#variables)
    - [Functions vs Variables](#functions-vs-variables)
  - [Header Files](#header-files)
  - [Best Practice](#best-practice)
    - [Functions](#functions-1)
- [Outro](#outro)
  - [Link Time Optimizations (LTO)](#link-time-optimizations-lto)
- [Source](#source)

# Review

- We have some `.o` files called Relocatable Object Files that are in ELF format.
  - These are not executable yet.
  - Each of these `.o` have some relocation entries that need to be figured out:
    - Job of the Linker.
- Linker takes all `.o` files and produces an executable from them which is also in ELF format.
- Linker is creating an in-memory layout for the process.
  - Mostly entails code (`.text` section) and data (`.bss`, etcetera).
- Linkers job to:
  1. Resolve references.
  2. Relocate symbols.
  3. Fills in placeholders.
- In the end, the Linker produces an executable.

## RWE Permissions

> Aside: Don't make things writable and executable at the same time. This allows security issues and attacks that exploit the ability to execute something that you can write to.

## Address Space Layout Randomization (ASLR)

> Aside: We can run `file [executable]` to see what kind of executable it is. If it is a `pie` this means it is a Position Independent Executable" which is for security reasons. It allows a binary to be loaded in different places in the address space (randomize location) so finding "gadgets" is more difficult for attackers. That is, they cannot just jump to the some place in memory with certainty that the data they are looking for is indeed there.
>
> Note: The debugger `gdb` has a flag `disable-randomization` that is on by default that disables randomization of debugee's program's address space to make debugging easier for programmer (debugee).

## Big Picture

- We have a `.c` that we compile $\rightarrow$ to an executable.

### Compiler + Assembler

- Resolves local symbol names.
- Passed off global names to Linker in relocatable `.o` files.
    - These dont have absolute addresses yet.

### Linker

- Merges object files for executable.
- Compute virtual address space layout.

### Executable

- All text & data needed to load program into memory.

# Symbol Conflicts @ Linker Level in C

- Compilers catch conflicts in the same file, but sometimes two different `.o` files might be trying to define the same symbol.
  - C defines Local and Global as such:
    - Local to a `.o` versus Global to all `.o` files.
  - Local is `static`ly defined in C which denotes that that `static` "local" entity should not be present in other files.
    - `static int x;`
  - Global is defined by default as such:
    - `int x;`

## Example `source1.c`

```c
int x = 1; // Global in Linker Scope
static void f() {
    x = 1; // Local in Linker Scope
}
```

### `nm source1.c`

```
t f // Text (Lowercase)
D x // Data (Uppercase)
```

- Local $\rightarrow$ Lowercase
- Global $\rightarrow$ Uppercase

## Example `source2.c`

```c
static int x // Local in Linker Scope
static void f() {
    x = 2; // Local in Linker Scope
}
```

### `nm source2.c`

```
t f // Text (Lowercase)
b x // Bss (Lowercase)
```

- Recall that `.bss` is "Better Save Space".

## Example `source3.c`

```c
int x; // Global in Linker Scope
static void f() { // Local in Linker Scope
    x = 3;
}
int main { } // Global in Linker Scope
```

- The `main` function is always global.

### `nm source3.c`

```
t f
T main
B x
```

## Example `source4.c`

```c
void g();

int x = 1; // Global in Linker Scope
static void f() {
    x = 1; // Local in Linker Scope
}
```

### `nm source4.c`

```
t f // Text (Lowercase)
D x // Data (Uppercase)
```

- Note that `void g();` doesn't show up anywhere.

## Example `source5.c`

```c
void g() { }; // 

int x = 1; // Global in Linker Scope
static void f() {
    x = 1; // Local in Linker Scope
}
```

### `nm source4.c`

```
t f // Text (Lowercase)
D x // Data (Uppercase)
```

- Note that `void g();` doesn't show up anywhere.

# Global Conflict Resolution

- Strong vs Weak Symbols.
  - Weak symbols are uninitialized global variables.
- Can cause "subtle bugs".
- Table:
  - Strong vs Strong
    - Conflict.
      - Fix it.
  - Strong vs Weak
    - Weak is ignored.
      - Maybe okay.
  - Weak vs Weak
    - One of the weak's will be ignored (up to linker).
    - Not a good situation to be in, likely a bug.

## Strong vs Weak Symbols

- Declaration vs Definition.

### Functions

- Declaration:
  - `void f();`
    - Nothing actually defined.
  - `extern void f();`
    - Extern says that another file is defining this, still means it isn't defined in this file.
- Definition:
  - `void f(); { }`
    - Needs a "body" denoted by `{ }`.
    - Strong global symbol.
  - `static f() { }`
    - The `static` modifier make this a "local" global symbol.

### Variables

- Definition:
  - `int v;`
    - `B` symbol.
    - Weak global symbol.
    - Equivalent to `int v = 0` sort of.
  - `int v = 0;`
    - `D` symbol.
    - Strong global symbol.
  - Linker sees these as different even though they may mean effectively the same thing.
    - This is where we start to see issues where the weak symbol could be overwritten by something else in the case of a conflict.
- Declaration: 
  - `extern int v;`
    - This is how we declare variables in C.

### Functions vs Variables

- Using `extern` for functions doesn't mean anything different for functions but can be used for code hygeine.
  - Actually means something in contenxt of variables.

## Header Files

> Beware: Header files may have weak global symbols like `int v;` (weak definition) in them. So anywhere we `#include` this `.h` file, we have introduced many instances of a weak global symbol. Because they are weak, when these `.c` files become `.o` files, the Linker will throw out some of these weak global symbols due to "Weak vs Weak" conflicts. This can be bad if your code is dependent on some data layout etcetera but in general it is undesirable for our code to be altered in such an unpredictable way.
>
> Example: `int v = 10;` is a strong definition that will cause "Strong vs Strong" conflicts which results in an error that needs to be handled by the programmer.
>
> Example: `static int v;` and `static int v = 10;` causes no error from Linker but probably not what the programmer intended. Each compilation object has it's own copy of `v`, it is NOT a shared variable.
>
> Example: `extern int v;` is a declaration so nothing is defined, therefore this is fine. Causes no symbol conflicts because we have not defined any symbols. If we want a local variable to be shared across files, this is how we should do so. One C file will define `v`.
>
> However: Header files may have `void f();` or `extern void f();` because these are declarations.
>
> However: Header files that have `void f() { }` is a strong symbol definition that will cause many "Strong vs Strong" conflicts that the Linker will enforce correction of by the programmer.
>
> However: Header files that have `static void f() { }` will be fine since they will be treated as local to each file that they are `#include`d in. Will cause larger binaries than necessary due to copied code. Programmers do this because they want this to be inlined for further optimizations by the compiler. Can also be defined as `static inline void f() { }`. This can be efficient to avoid excessive function calls. (See figure in notes and include it).

## Best Practice

- Avoid global symbols (use static).
  - All function in a linux kernel are static for this reason.
- Do not _define_ in header files.
  - Declare using `extern` even if its not needed for functions.
  - Define in a single `.c` file.
- Flag `-WL` passses to Linker and `--warn-common` will warn about "Weak vs Weak" conflicts.

### Functions

- Using naming conventions.
  - If file is called `list.c` then functions are named `list-add` and `list-remove` opposed to just `add` and `remove`.
- Inline functions are really the only definition you want in header files.

# Outro

- When the `.c` file becomes other file formats, the compiler is performing optimizations.
- When we have a bunch of `.o` files, the optimizations have already occured in the steps between `.c` \$rightarrow$ `.o`.

## Link Time Optimizations (LTO)

- Whole program optimization during link-time with `.o` files upon which compiler has performed optimizations already.

// Include figure here.

# Source

[Dan Williams](https://people.cs.vt.edu/djwillia/)