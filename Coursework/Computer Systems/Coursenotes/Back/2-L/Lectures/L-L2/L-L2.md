# Linking & Loading: Part II

# Table of Contents

- [Linking & Loading: Part II](#linking--loading-part-ii)
- [Table of Contents](#table-of-contents)
- [Software Engineering Aspects](#software-engineering-aspects)
- [Local vs Global Symbols](#local-vs-global-symbols)
- [Conflict Resolution Rules for Global Symbols](#conflict-resolution-rules-for-global-symbols)
- [Understanding Definitions and Declarations in C](#understanding-definitions-and-declarations-in-c)
- [Effect of Definitions and Declarations in a Header File](#effect-of-definitions-and-declarations-in-a-header-file)
- [Best Practices](#best-practices)
  - [Variables](#variables)
  - [Functions](#functions)
  - [Inline Functions](#inline-functions)
- [Conclusion](#conclusion)
- [Source](#source)

# Software Engineering Aspects

<p align="center" width="100%">
    <img src="figure-1.png">
</p>

# Local vs Global Symbols

- `source1.c`
    ```c
    static int x;
    static void f() {
        x = 1;
    }

    0000000000000000 t f
    0000000000000000 b x
    ```
- `source2.c`
    ```c
    static int x;
    static void f() {
        x = 2;
    }

    0000000000000000 t f
    0000000000000000 b x
    ```
- `source3.c`
    ```c
    static int x;
    static void f() {
        x = 3;
    }
    int main() { }
    
    0000000000000000 t f
    0000000000000011 T main
    0000000000000000 b x
    ```
- `Symbols.exe`
    ```
    0000000000400536 t f
    0000000000400547 t f
    0000000000400558 t f
    0000000000400569 T main

    0000000000601020 b x
    0000000000601024 b x
    0000000000601028 b x
    ```
- From the linker's perspective, individual `.o` files' symbols are either global or local.
- Assmebly Level:
  - Default is local.
  - Must say `.globl` otherwise.
- At the C Level:
  - Default is global.
  - Must say `static` to make local.
- Note:
  - Different use of local/global than local vs global variables.
    - Here, "local" means local to a compilation unit.
      - I.e. A `.c` file (plus headers).
- Local symbols in different compilation units are separated and do not conflict with one another or with global symbols in other units.

# Conflict Resolution Rules for Global Symbols

- Question:
  - What happens if two or more modules define a global symbol with the same name?
- Answer:
  - It depends on whether the symbol is considered `strong` or `weak`:
    - `strong + strong`
      - Conflict "multiply defined".
    - `strong + weak`
      - Weak definition is ignored.
    - `weak + weak`
      - One of the weak definitions is used.
- These rules are a historic quirk (blame Fortan's COMMON blocks).
- Fortunately, there is only one case in normal use that makes a symbol `weak`:
    - Defining an uninitialized global variable.
      - Examples:
        1. `int x;`
        2. `struct type obj;`
- This allows for the (questionable) convenience of defining the same global variable multiple times in different compilation units and have the linker turn the other way.

# Understanding Definitions and Declarations in C

<p align="center" width="100%">
    <img src="figure-2.png">
</p>

# Effect of Definitions and Declarations in a Header File

<p align="center" width="100%">
    <img src="figure-3.png">
</p>

# Best Practices

## Variables

- Avoid global variables where possible, but if you must have them:
  - Do not define global variables in a header file, regardless of static or not.
    - Instead declare them in exactly one header file (with `extern`) and choose exactly one `.c` file in which to define them (these files often have the same basename, as the module is said to own them).
    - Do this regardless of whether an initial value is provided for the variable.
    - C++ even requires this:
      - One Definition Rule.
  - Do not define non-static global variables in a `.c` file unless they are used in more than one `.c` file:
    - If multiple files define the same name, then strong definitions will conflict, weak definitions will silently refer to the same copy, as will strong/weak combinations.
    - Make them static instead:
      - Maximize encapsulation.
  - `-Wl` and `--warn-common` should be quiet.

## Functions

- If not used in more than one `.c` file, make static and keep in `.c` file
- If used in more than one `.c` file, place prototype declaration in header file.
  - Enforce this with `-Wmissing-prototypes`.
- Do not ignore `implicit declaration` warnings.
- Choose good naming scheme, such as `file_` for functions in `file.c`.
- Define small functions you intend for the compiler to inline in header files.

## Inline Functions

- Inlining:
  - The compiler will insert the body of a function at the call site, avoiding procedure call overhead and enabling optimizations.
- Requires that the compuler has access to the source code of the function, this its definition in a header file.
  - Execessive use would increase compile times.
- Compiler will decide whether to inline, based on chosen optimization level and on heuristics.
- Which modifier should be used?
  - Option 1: 
    - `static` or `static inline`:
      - Adding `inline` is good practice, but doesn't sway or force compiler to actually inline.
  - Option 2:
    - In C99 or later (just) `inline` in a header file, and choose exactly one compliation unit to add an `extern inline` declaration.
- Option 2 has the advantage that it avoids multiple copies in the case where the compiler doesn't inline, but it more complicated and does not allow header-only libraries.

# Conclusion

- Discussed best practices for placing declarations and definitions in `.c` source and `.h` header files.
- Avoid/debug linker errors and fragile practices.
- Emerging Alternatives:
  - Whole-Program Optimization Techniques:
    - Link-Time Optimization (LTO):
      - Compiler stores intermediate representation in `.o` files, optimization and code generation is done at link time on whole program.
    - Concatenating the source code of multiple files:
      - So-called "Unity Builds".

# Source

[Godmar Back](https://people.cs.vt.edu/~gback/)