# Compile and Run with Command Prompt

# Table of Contents

- [Compile and Run with Command Prompt](#compile-and-run-with-command-prompt)
- [Table of Contents](#table-of-contents)
- [Check if GCC Compiler Installed](#check-if-gcc-compiler-installed)
- [Navigate to Directory](#navigate-to-directory)
- [Compile the C File](#compile-the-c-file)
- [Run the Compiled Program](#run-the-compiled-program)
- [Source](#source)

# Check if GCC Compiler Installed

- Open the command prompt and input `gcc --version`.

# Navigate to Directory

- Navigate to the directory that contains the C file to compile and run.
- Done using command `cd` which stands for "Change Directory".

# Compile the C File

- This is done using the input `gcc filename.c`.
  - In the case of this example, it would be `gcc hello.c`.
  - By default, the compiler will name the resultant executable file `a.exe`.

# Run the Compiled Program

- Two ways:
  1. `a.exe`
  2. `./a`
     - `./` denotes that the filename that follows it is located in the current directory.
       - Simply means "Current Directory".
- Resulting output to terminal will be the same for both inputs.
    ```
    Hello World.
    ```

# Source

[BroCode: Compile and Run a C Program with Cmd](https://www.youtube.com/watch?v=ME1CNzcHOCY&list=PLZPZq0r_RZOOzY_vR4zJM32SqsSInGMwe&index=2)