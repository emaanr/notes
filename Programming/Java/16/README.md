# 2D Arrays

    Java 2D Arrays.

# Table of Contents

- [2D Arrays](#2d-arrays)
- [Table of Contents](#table-of-contents)
- [Definition](#definition)
- [Creation](#creation)
- [Printing](#printing)
- [Length vs Indices](#length-vs-indices)
- [Code](#code)
- [Source](#source)

# Definition

- Also known as multidimensional arrays.
- Essentially an array of arrays.
- Read as row first and column second:
  - Consider `array[r][c]` where `r` is row and `c` is column.

# Creation

- All values in the 2D Array must be of the same data type.
- Can be declared in two different ways:
  1. `type var-name[][];`
  2. `type[][] var-name;`

# Printing

- In order to print a 2D Array, we need to use a loop to iterate over the indices of the inner array (columns) of each outer array element (rows).
  - The inner arrays are the rows themselves, while the elements of the inner arrays are the columns.
- If we simply call `System.out.print(array);` it will print the address of the 2D Array.

> Note that we want to start our iteration from index `0` since arrays label their indices from `0` onwards.

```java
// Outer Array Elements
for (int i=0; i < array.length; i++) {
    // Inner Array Elements
    for (int j=0; j < array[i].length; j++) {
        System.out.print(array[i][j] + " ");
    }
}
```

- Think of it as:
  - The outer array has some number of inner arrays which have some number of elements and the inner arrays are the elements of the outer array.

# Length vs Indices

- Indices of an array start from `0`.
- An array of length `5` would have a maximum index of value `4`.
  - Indices `array[0]` to `array[4]` is 5 elements.
  - We can store 5 inner arrays into our outer array of length 5 elements.
    - These inner arrays can be of any length as defined by the programmer.
- Can directly access the length of any array by calling `array.length`.

# Code

[TwoDArrays.java](https://github.com/emaanr/notes/blob/main/Programming/Java/16/TwoDArrays/src/TwoDArrays.java)

# Source

[BroCode: Java 2D Arrays](https://www.youtube.com/watch?v=alwukGslBG8&list=PLZPZq0r_RZOMhCAyywfnYLlrjiVOkdAI1&index=16)
