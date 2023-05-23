# Static Keyword

    Java static Keyword.

# Table of Contents

- [Static Keyword](#static-keyword)
- [Table of Contents](#table-of-contents)
- [`static`](#static)
  - [Variable](#variable)
    - [Warning: Static Field](#warning-static-field)
      - [Incorrect](#incorrect)
      - [Correct](#correct)
    - [Warning: Non-Static Field](#warning-non-static-field)
      - [Incorrect](#incorrect-1)
      - [Correct](#correct-1)
  - [Method](#method)
    - [Incorrect](#incorrect-2)
    - [Correct](#correct-2)
- [Code](#code)
- [Source](#source)

# `static`

- A modifier.
- A single copy of a variable/method is created and shared.
- The class "owns" the `static` member.
  - That is, if we create multiple objects out of the same class, they all share that singular copy variable/method.

## Variable

- Any `static` variables should be accessed via the class itself rather than an instance of the class since static variables are "owned" by the class.

### Warning: Static Field

- The static field `Object.staticField` should be accessed in a `static` way.

#### Incorrect

```java
Object obj1 = new Object();
System.out.println(obj.staticField); // Warning
```

#### Correct

```java
System.out.println(Object.staticField);
```

### Warning: Non-Static Field

- Cannot make a static reference to the non-static field `Object.nonStaticField`

#### Incorrect

```java
System.out.println(Object.nonStaticField); // Warning
```

#### Correct

```java
Object obj1 = new Object();
System.out.println(obj.nonStaticField);
```

## Method

- Any `static` methods can, and should, be accessed via the class itself rather than via an instance.
  - We will observe this using Java's `Math` class as an example.

### Incorrect

```java
Math math = new Math();
math.staticMethod(); // Warning
```

### Correct

```java
Math.staticMethod();
```

# Code

[StaticKeyword.java](https://github.com/emaanr/notes/blob/main/Programming/Java/33/StaticKeyword/src/StaticKeyword.java)

# Source

[BroCode: Java `static` Keyword](https://www.youtube.com/watch?v=wa1HzkMqY9A&list=PLZPZq0r_RZOMhCAyywfnYLlrjiVOkdAI1&index=33)
