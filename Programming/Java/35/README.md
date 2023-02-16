# Method Overriding

    Java Method Overriding.

# Table of Contents

- [Method Overriding](#method-overriding)
- [Table of Contents](#table-of-contents)
- [Definition](#definition)
- [`@Override`](#override)
- [Code](#code)
- [Source](#source)

# Definition

- Declaring a method in a sub-class that already exists in the parent class of the sub-class.
  - Done so that the child class can have its own implementation of a method of the same name in its parent class.
- We can override the default behavior of certain methods by explicitly writing a method of our own of the same name.
  - This way, instead of enacting that methods default behavior, it can perform something more useful or relevant to the object it belongs to as defined by the programmer.

# `@Override`

- The `@Override` annotation indicates that the child class method is over-writing its base class method.
- It extracts a warning from the compiler if the annotated method doesn't actually override anything.
- It can improve the readability of the source code.
- Not necessary but good practice to indicate that a method is an overriding method.

```java
ParentClass {
    // Method called 'method'
    method() {
        // Code
    }
}

ChildClass extends ParentClass {
    // Overrides parent method of the same name called 'method'
    @Override
    method() {
        // Different Code
    }
}
```

# Code

[MethodOverriding.java](https://github.com/emaanr/notes/blob/main/Programming/Java/35/MethodOverriding/src/MethodOverriding.java)

# Source

[BroCode: Java Method Overriding](https://www.youtube.com/watch?v=E-0MMeNi5Cw&list=PLZPZq0r_RZOMhCAyywfnYLlrjiVOkdAI1&index=35)
