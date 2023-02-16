# ToString Method

    Java toString Method.

# Table of Contents

- [ToString Method](#tostring-method)
- [Table of Contents](#table-of-contents)
- [`toString()`](#tostring)
  - [Implicit](#implicit)
  - [Explicit](#explicit)
- [Method Overriding](#method-overriding)
  - [`@Override`](#override)
- [Code](#code)
- [Source](#source)

# `toString()`

- Special method that all objects inherit.
- Returns a string that "textually represents" an object.
- By default, prints the "textual representation" of the address of the object.
- Can be used both implicitly and explicitly.

## Implicit

```java
Object object = new Object();
System.out.print(object);
```

- Implicitly calling `toString()` method.

## Explicit

```java
Object object = new Object();
System.out.print(object.toString());
```

- Explicitly calling `toString()` method.

# Method Overriding

- We can override the default behavior of the `toString()` method by explicitly writing a `toString()` method of our own in the class of the object.
  - This way, instead of printing out the textual representation of the address of the object, it can print out something more useful or relevant to the object as defined by the programmer.

## `@Override`

- The `@Override` annotation indicates that the child class method is over-writing its base class method.
- It extracts a warning from the compiler if the annotated method doesn't actually override anything.
- It can improve the readability of the source code.

# Code

[ToString.java](https://github.com/emaanr/notes/blob/main/Programming/Java/30/ToString/src/ToString.java)

# Source

[BroCode: Java `toString` Method](https://www.youtube.com/watch?v=GvbdMwfjB98&list=PLZPZq0r_RZOMhCAyywfnYLlrjiVOkdAI1&index=30)
