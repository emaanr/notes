# Hello World

# Table of Contents

- [Hello World](#hello-world)
- [Table of Contents](#table-of-contents)
- [Preprocessor](#preprocessor)
- [Main](#main)
- [Hello World](#hello-world-1)
- [Source](#source)

# Preprocessor

- `#include` is a preprocessor command that tells the compiler to include the contents of the indicated file.
- `<stdio.h>` is the header file which contains useful functions for input output.
  - `stdio` is "Standard Input Output".

# Main

- The entry point of the program.
- Everything in the main function is read procedurally from top to bottom.
- At the end of the main function, we need `return 0;` which returns the exit status of the program.
  - Return `0` if program runs successfully without errors.
  - Return `1` if any errors are found.

# Hello World

```c
// File called hello.c

#include <stdio.h>

int main() {    // Note that 'int' is the return type of the main function

    printf("Hello World.");
    return 0;
}
```
```c
Hello World.

[Done] exited with code=0   // Would output code=1 instead if an error was found by the compiler
```

# Source

[BroCode: C Tutorial for Beginners](https://www.youtube.com/watch?v=nrbBmoINqtk&list=PLZPZq0r_RZOOzY_vR4zJM32SqsSInGMwe&index=1)