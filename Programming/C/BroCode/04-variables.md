# Variables

# Table of Contents

- [Variables](#variables)
- [Table of Contents](#table-of-contents)
- [Variables](#variables-1)
- [Data Type](#data-type)
- [Declaration \& Initialization](#declaration--initialization)
- [Examples: Data Types](#examples-data-types)
- [Format Specifiers](#format-specifiers)
- [Examples: Format Specifiers](#examples-format-specifiers)
- [Source](#source)

# Variables

- Allocated space in memeory to store a value.
- Refer to a variable's name to access the stored value.
- That variable now behaves as if it was the value assigned to it, or that it "contains".
- In order to do this, the type of the variable must be declared first so appropriate space in memory can be allocated for it.
- After declaring the data type, a name can be defined for the allocation.

# Data Type
- A _data type_ is a particular kind of data item defined by the values it can take, the programming language used, or the operations that can be performed on it.
- Additionally, a data type, in programming, is a classification that specifies which type of value a variable has and what type of mathematical, relational or logical operations can be applied to it without causing an error.

# Declaration & Initialization

- _Declaring_ the data type is the first part of creating a variable and must be done to allocate some space in memory.
- _Initializing_ actually sets, or "stores", a value to associate with the declared variable at the particular memory address (handled by the computer) reserved at declaration.

    > Aside: Memory is allocated when a variable is declared, not when it's initialized.

- This can be done in two ways, either on one line or separate lines, both of which have different benefits and use cases where they are preferred given the variable's intended use.
  - One Line:
    ```c
    int x = 25; // Declare and Initialize
    ```
  - Separate Lines:
    ```c
    int x;      // Declare
    x = 25;     // Initialize
    ```
# Examples: Data Types

```c
int age = 22;               // Integer
float gpa = 3.5;            // Floating Point Number
char grade = 'A';           // Single Character
char name[] = "Emaan Rana"  // Array of Characters (String)
```

# Format Specifiers

- _Format specifiers_ can be used to output the value of a variable.
- Consider the following code.
    ```c
    printf("I am age years old");
    ```
    - In order to replace `age` with the value stored in the variable age, the format specifier %d will replace it.
        ```c
        printf("I am %d years old", age);
        ```
        ```
        I am 22 years old
        ```
        - After the string to be printed, a comma is followed by the name of the variable containing the data intended to output at `%d`.
- The syntax for format specifers is the char `%` immediately followed by a predefined char for all datatypes.
  - Which is why `d` is used here, standing for "decimal", which is the char that handles number data types.
- Format specifiers are beneficial for writing cleaner code as well as due to ease of use.
- Alternatively, the same could be accomplished like so, but is much clumsier and less readable.
    ```c
    printf("I am " + age + " years old");
    ```
    ```
    I am 22 years old
    ```
# Examples: Format Specifiers

```c
printf("Hello, my name is %s\n", name);
printf("I am %d years old\n", age);
printf("My grade is an %c\n", grade);
printf("My gpa is %f\n", gpa);
```
```
Hello, my name is Emaan Rana
I am 22 years old
My grade is an A
My gpa is 3.5
```

# Source

[BroCode: Variables](https://www.youtube.com/watch?v=aIQk1O08zpg&list=PLZPZq0r_RZOOzY_vR4zJM32SqsSInGMwe&index=4)