# Methods

    Java Methods.

# Table of Contents

- [Methods](#methods)
- [Table of Contents](#table-of-contents)
- [Definition](#definition)
- [Creation](#creation)
- [Arguments \& Parameters](#arguments--parameters)
  - [Arguments](#arguments)
  - [Parameters](#parameters)
- [Return Types](#return-types)
  - [`void`](#void)
- [Code](#code)
- [Source](#source)

# Definition

- Block of code that is executed whenever it is called upon.
- When we run a program, the `Main Method` is always called first.
- We can create methods outside of the `Main Method` to call within the `Main Method`.

# Creation

- By common convention, the first letter of a function is lowercase.
- If we want to call a method in the `Main Method`, we need to declare it as a `static` method because the `Main Method` is a `static` method.
  - We will explore this topic in depth at a later time, for now this is sufficient.

```java
static void method() {
    // Code to run when method is invoked
}
```

# Arguments & Parameters

## Arguments

- We can pass data as arguments for a method.
- Can only pass arguments to a method if a method accepts arguments as indicated by number of parameters and types of those parameters of said method.

## Parameters

- In order to pass arguments to a method, we need to establish "parameters" that the function can accept or expect when it is called.

```java
// Can have any number of parameters
static void method(param1_data_type param1_name, param2_data_type param2_name , ...) {
    // Code to run when method is invoked
}
```

# Return Types

- We can return a value from a method call.
- We declare the return type of a method or function to introduce some constraint that ensures our programs are behaving how we want them to.

```java
// Example of non-void method return type
static int method() {
    // Needs to return an int or the method won't work
    return 0;
}
```

## `void`

- Return type `void` if we are not returning anything.

```java
static void method() {
    // Code to run when method is invoked
}
```

# Code

[Methods.java](https://github.com/emaanr/notes/blob/main/Programming/Java/22/Methods/src/Methods.java)

# Source

[BroCode: Java Methods](https://www.youtube.com/watch?v=v5p_SUfi710&list=PLZPZq0r_RZOMhCAyywfnYLlrjiVOkdAI1&index=22)
