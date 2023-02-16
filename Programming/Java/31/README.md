# Array of Objects

    Java Array of Objects.

# Table of Contents

- [Array of Objects](#array-of-objects)
- [Table of Contents](#table-of-contents)
- [Definition](#definition)
  - [1st Way](#1st-way)
  - [2nd Way](#2nd-way)
- [Code](#code)
- [Source](#source)

# Definition

- We will discuss two ways to create an array of objects in Java.

## 1st Way

```java
// Create Array of Objects
Object[] objects = new Object[length];

// Create Objects to populate Array with
Object obj_1 = new Object();
Object obj_2 = new Object();
...
Object obj_n = new Object();

// Populate Array of Objects with Objects
// Recall that indexing starts from 0
objects[0] = obj_1;
objects[1] = obj_2;
...
objects[n] = obj_n;

// Print Array of Objects
System.out.println(objects[0]);
System.out.println(objects[1]);
...
System.out.println(objects[n]);
```

## 2nd Way

```java
// Create Objects to populate Array with
Object obj_1 = new Object();
Object obj_2 = new Object();
...
Object obj_n = new Object();

// Create and populate Array of Objects
Object[] objects = {obj_1, obj_2, ... , obj_n};

// Print Array of Objects
for (Object object : objects) {
    System.out.println(object);
}
```

# Code

[ArrayOfObjects.java](https://github.com/emaanr/notes/blob/main/Programming/Java/BroCode/31/ArrayOfObjects/src/ArrayOfObjects.java)

# Source

[BroCode: Java Array of Objects](https://www.youtube.com/watch?v=nhIB2S6NiFA&list=PLZPZq0r_RZOMhCAyywfnYLlrjiVOkdAI1&index=31)
