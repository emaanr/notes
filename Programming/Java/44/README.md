# Exception Handling

    Java Exception Handling.

# Table of Contents

- [Exception Handling](#exception-handling)
- [Table of Contents](#table-of-contents)
- [Exception](#exception)
- [`try-catch`](#try-catch)
- [`Exception e`](#exception-e)
- [`finally`](#finally)
- [`if-else if-else`](#if-else-if-else)
- [Code](#code)
- [Source](#source)

# Exception

- An event that occurs during the execution of a program that disrupts the normal flow of instructions (stop the program).
  - An example of this is an arithmetic exeception when trying to divide by zero.

# `try-catch`

- Surround any code that is prone to throwing an exception within a `try` block.
- Following the `try` block, we will have a `catch` block that will run if an exception is encountered.
- We will "try" all of the code in the `try` block and "catch" the exeption with the `catch()` block.
  - List the type of exception in the parens `()`.
- We can have multiple `catch()`s associated with the same `try`.
  - There must be at least one `catch()` associated with a `try`.
- Functions similarly to an `if-else` but specifically for exceptions and exception handling.

```java
try {
    // Code
} catch (Exception e) {
    // Code
}
```

# `Exception e`

- Passing `Exception e` as an argument to a `catch()` block will catch all exceptions.
  - However, this is considered a bit lazy and you may want different behaviors for different exceptions.
- Considered good to handle exceptions more specifically and then include `Exception e` as a final check.
  - Similar to the function of an `else` in an `if-else if-else` statement.

```java
try {
    // Code
} catch (ArithmeticException e) {
    // Code
} catch (InputMismatchException e) {
    // Code
}
... // Any number of catches
} catch (Exception e) {
    // Code
}
```

# `finally`

- Optional component of the `try-catch` thats runs no matter what.
- Can be compared to a `do-while` versus a `while` loop since in a `do-while`, the block of code is run at least once in the same way the `finally` block of code is run no matter what (at least once).
- Good use of this block includes closing any open `Scanner`s or `File`s that might be open.

# `if-else if-else`

- The `try-catch` is similar to an `if-else if-else` statement where:
  - `if` is comparable to the first `catch()`.
  - `else if` is comparable to every additional `catch()`.
  - `else` is comparable to the final `catch(Exception e)` or `finally` block.

# Code

[ExceptionHandling.java](https://github.com/emaanr/notes/blob/main/Programming/Java/BroCode/44/ExceptionHandling/src/ExceptionHandling.java)

# Source

[BroCode: Java `Exception` Handling](https://www.youtube.com/watch?v=adTDlH0lhaA&list=PLZPZq0r_RZOMhCAyywfnYLlrjiVOkdAI1&index=44)
