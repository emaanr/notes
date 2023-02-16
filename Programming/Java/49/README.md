# Enum

    Java enum.

# Table of Contents

- [Enum](#enum)
- [Table of Contents](#table-of-contents)
- [`enum`](#enum-1)
  - [Parameterized `enum`](#parameterized-enum)
- [Code](#code)
- [Source](#source)

# `enum`

- Short for "enumerated".
- Ordered listing of items within a collection.
- A way for the programmer to predefine a set of values that can be assigned.
- Constants that cannot change.
- Listing of constants that behave similarly to objects and are created similarly to classes.
- Enumerated items are written in UPPERCASE by convention.
- Some practical examples include:
  - Days of the week.
  - Months in a year.
  - Plants in the solar system.'

```java
enum Enum {
    ENUM_ONE, ENUM_TWO, ENUM_THREE, ... , ENUM_N;
}

Enum enum_1 = Enum.ENUM_ONE;
Enum enum_2 = Enum.ENUM_TWO;
Enum enum_3 = Enum.ENUM_THREE;
...
Enum enum_n = Enum.ENUM_N;
```

## Parameterized `enum`

- We can pass values as arguments to `enum`s.

```java
enum Enum {
    ENUM_ONE,
    ENUM_TWO,
    ENUM_THREE,
    ...
    ENUM_N;

    // Attributes

    int num;

    // Methods

    /**
     * Enum
     *      Constructor for enum Enum that takes one parameter.
     *
     * Parameters:
     *      num int
     *          Integer associated with enumerated element.
     */
    Enum(int num) {
        this.num = num;
    }
}

Enum enum_1 = Enum.ENUM_ONE;
Enum enum_2 = Enum.ENUM_TWO;
Enum enum_3 = Enum.ENUM_THREE;
...
Enum enum_n = Enum.ENUM_N;

System.out.println(enum_1.num); // Prints 1
System.out.println(enum_2.num); // Prints 2
System.out.println(enum_3.num); // Prints 3
...
System.out.println(enum_n.num); // Prints N
```

# Code

[Enum.java](https://github.com/emaanr/notes/blob/main/Programming/Java/BroCode/49/Enum/src/Enum.java)

# Source

[BroCode: Java `enum`](https://www.youtube.com/watch?v=TCMhP8trGwY&list=PLZPZq0r_RZOMhCAyywfnYLlrjiVOkdAI1&index=74)
