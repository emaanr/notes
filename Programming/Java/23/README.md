# Overloaded Methods

    Java Overloaded Methods.

# Table of Contents

- [Overloaded Methods](#overloaded-methods)
- [Table of Contents](#table-of-contents)
- [Definition](#definition)
  - [Method Signature](#method-signature)
    - [Parameters](#parameters)
- [Examples](#examples)
- [Code](#code)
- [Source](#source)

# Definition

- Methods that share the same name but have different method signatures due to differences in method parameters.

## Method Signature

- This is allowed because every method has a unique method signature comprised of its name and parameters.
  - Method Name + Parameters = Method Signature.

### Parameters

> Note that the order of parameters, parameter data types, and return type of the method matters.
>
> - This means that we can have two methods with the same name and same number of parameters but different returns types and parameter data types.

# Examples

```java
// Add two integers
static int method(int param1, int param2) {
    return param1 + param2;
}

// Add three integers
static int method(int param1, int param2, int param3) {
    return param1 + param2 + param3;
}

// Add two doubles
static double method(double param1, double param2) {
    return param1 + param2;
}
```

# Code

[OverloadedMethods.java](https://github.com/emaanr/notes/blob/main/Programming/Java/23/OverloadedMethods/src/OverloadedMethods.java)

# Source

[BroCode: Java Overloaded Methods](https://www.youtube.com/watch?v=kArGE1-vRrw&list=PLZPZq0r_RZOMhCAyywfnYLlrjiVOkdAI1&index=23)
