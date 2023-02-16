# 2D ArrayList

    Java 2D ArrayList.

# Table of Contents

- [2D ArrayList](#2d-arraylist)
- [Table of Contents](#table-of-contents)
- [Definition](#definition)
- [Printing](#printing)
  - [`get().get()`](#getget)
- [Code](#code)
- [Source](#source)

# Definition

- A dynamic list of lists.
- You can change the size of these lists during run time.

# Printing

- `ArrayList`s can be printed by directly calling the `ArrayList` itself unlike arrays which print an address instead.

```java
ArrayList<T> arrList = new ArrayList<T>();
System.out.println(arrList); // Multi-Dimensional ArrayList
```

## `get().get()`

- Recall discussion of outer and inner arrays from notes on Arrays, it is the same idea.
- If we want to obtain a particular element it can be done by calling `get(arrList).get(elem)` where:
  - The first `get(arrList)` is an `ArrayList<T>` element and the second `get(elem)` is an element, `T`, of that `ArrayList<T>`.'

```java
System.out.println(arrList_name.get(arrList).get(elem));
```

# Code

[TwoDArrayList.java](https://github.com/emaanr/notes/blob/main/Programming/Java/20/TwoDArrayList/src/TwoDArrayList.java)

# Source

[BroCode: Java 2D `ArrayList`](https://www.youtube.com/watch?v=9tBxJoQF74E&list=PLZPZq0r_RZOMhCAyywfnYLlrjiVOkdAI1&index=20)
