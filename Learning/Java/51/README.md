# Custom Exceptions

    Java Custom Exceptions.

# Table of Contents

- [Custom Exceptions](#custom-exceptions)
- [Table of Contents](#table-of-contents)
- [Definition](#definition)
- [Creation](#creation)
- [`throws`](#throws)
  - [`throw`](#throw)
- [Code](#code)
- [Source](#source)

# Definition

> Recall that an exception is an event, after execution, that interrupts the normal flow of a program.

- Custom Exceptions are also called "User-Defined Exceptions".
- Useful for when programmers want to be specific about the nature of an exception.
  - Some practical examples include:
    - DuplicateEmailException
    - InvalidCreditCardException
    - AgeException

# Creation

- Custom exceptions are made the same way classes are made.
- Custom exceptions `extends` the `Exception` class.

```java
public class CustomException extends Exception {
    CustomException() {
        // Constructor
    }
}
```

# `throws`

- Keyword `throws` is the keyword used to declare which exceptions can occur during the execution of a program.

## `throw`

- Keyword `throw` used to explicitly throw an exception.

```java
static void customException() throws CustomException {
    throw new CustomException();
}
```

# Code

[CustomExceptions.java](https://github.com/emaanr/notes/blob/main/Programming/Java/51/CustomExceptions/src/CustomExceptions.java)

# Source

[BroCode: Java Custom Exceptions](https://www.youtube.com/watch?v=XhH93_woZIY&list=PLZPZq0r_RZOMhCAyywfnYLlrjiVOkdAI1&index=76)
