# Introduction

# Table of Contents

- [Introduction](#introduction)
- [Table of Contents](#table-of-contents)
- [So what's Haskell?](#so-whats-haskell)
- [Purely Functional](#purely-functional)
- [Lazy Language](#lazy-language)
- [Statically Typed](#statically-typed)
- [Compiler and Interpreter](#compiler-and-interpreter)
- [Command Summmary](#command-summmary)
- [Source](#source)

# So what's Haskell?

    Haskell is a purely functional, lazy, statically typed programming language.

- How does this differ from Imperative Languages?
  - In Imperative Languages, we give them sequences of tasks to execute. While executing these tasks, states can be altered. We also have control flow structures for doing some actions several times.

# Purely Functional

- In **Purely Functional Programming** you don't tell the computer what to do but rather you express what things *are*.
  - This is expressed in the form of *functions*.
  - Variables are immutable, that is, their values cannot be changed once they are initially set (initialized).
  - Functions have no side-effects, they aren't *changing* anything.
  - The only capability of a Function is calculating some result to return.
  - This may seem limiting, but there are some convenient consequences as a result of this constraint:
    - **Referential Transparency**
      - If you call the same function many times with identical parameters each time, you are *guaranteed* to return the same result.
      - Allows the compiler to reason about program behavior.
      - Allows the programmer to easuly deduce (and even prove) that a function is correct.
        - Simpler functions can then be used to build more complex functions.

# Lazy Language

- Haskell is **Lazy**, this means that unless it is specifically instructed otherwise, Haskell will not execute functions or perform calculations until it is forced to return some result.
  - This synergizes well with *referential transparency* and allows the Functional Programs to be thought of as series of *transformations on data*.
    - **Transformation** in mathematics can be defined as, "A process by which one figure, expression, or function is converted into another that is equivalent in some important respect but is differently expressed or represented."
      - This implies the idea we have previously discussed where a value is not changed, but used to convert and return a result that is separate from the initial values given (because values are immutable).
  - Allows "*infinite data structures*".
    - **Example:** Function `doubleMe` which doubles every element in a list and returns the new list called on an immutable list `xs = [1, 2, 3, 4]`. What if we want to multiply by 8?
      - **Imperative**: If we did something like `doubleMe(doubleMe(doubleMe(xs)))`, it would pass through the list, make a copy, and then return the copy for each encapsulated function.
      - **Lazy**: In a lazy language, calling `doubleMe` on a list without forcing it to show you a result causes the program to put off the calculation since it does not need to return anything to the programmer. However, once we do request some result from the function, the first `doubleMe` tells the second `doubleMe` tells the third `doubleMe` that it needs a result to return to the programmer. The first iteration doubles 1 into 2, the second iteration doubles 2 into 4, and the third iteration doubles 4 into 8 which is then returned as the first element of the list. This enables a single pass through of the list and *only* if or when we need it. This allows efficient transformation of initialized data.

# Statically Typed

- Haskel is **Statically Typed**. When the program is compiled (at compile time), the compiler can determine what kind of datatype is being passed without needing them to be explicitly defined.
  - This allows a lot of errors to be caught at compile time.
    - If an attempt to add an integer and a string is being made at compile time, it will throw an error.
  - Haskell uses a very good type system that has **Type Inference**.
    - This means it is not required to explicitly label every piece of code with a particular type because Haskell's type system can intelligently decipher a lot.
    - Type inference allows code to be written in a more general manner.
- Haskell is *elegant* and *concise*.
    - Haskell programs are often shorter than their imperative equivalents
      - Shorter programs are easier to maintain than longer ones and have less bugs.

# Compiler and Interpreter

- Haskell Script
  - File with **.hs** extension.
- GHC
  - The most widely used Haskell compiler.
  - Invoked as `ghc <file.hs>` in the command line and only takes one parameter.
    - If you want to include other .hs files in your compilation, include `module <file2.hs> where` at the top of any additional Haskell Scripts and then include `import <file2.hs>` at the top of the file you are calling ghc on, in this case `<file.hs>`.
- GHCi
  - The interactive interface to GHC
  - Invoked as `ghci <file.hs>` in the command line and only takes one parameter.

# Command Summmary
  - `:l <file.hs>` or `:load <file.hs>` ~> Loads functions, can be called again to reload changes to file.
  - `:r` or `:reload` ~> Reloads the current script, alternative to reinvoking `:l <file.hs`.
  - `:t <expr> or :type <expr>` ~> Print the type of the expression `<expr>`.
  - `:i <name>` or `:info <name>` ~> Display information about the given name(s). Works with function names, type names, etc.
  - `:browse` ~> List all functions in scope, with type signatures.
  - `let <pattern> = <expr>` ~> Introduce temporary value or function definition that disappear after reloading any files.
  - `:?` or `:help` ~> Print complete list of GHCi commands.
  - `:q` or `:quit` ~> To quit interactive interface.

# Source

[Learn You A Haskell: Introduction](http://learnyouahaskell.com/introduction)
