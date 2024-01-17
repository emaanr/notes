# Arrays

    Java Arrays.

# Table of Contents

- [Arrays](#arrays)
- [Table of Contents](#table-of-contents)
- [Defintion](#defintion)
- [Creation](#creation)
- [Printing](#printing)
- [Length vs Indices](#length-vs-indices)
- [Code](#code)
- [Source](#source)

# Defintion

- Used to store multiple values in a single variable.
- An array is contiguous in memory.

# Creation

- All values in the array must be of the same data type.
- Can be declared in two different ways:
  1. `type var-name[];`
  2. `type[] var-name;`

# Printing

- In order to print an array, we need to use a loop to iterate over the indices of the array to print each individual element.
- If we simply call `System.out.print(array);` it will print the address of the array.

> Note that we want to start our iteration from index `0` since arrays label their indices from `0` onwards.

```java
for (int i=0; i < array.length; i++) {
    System.out.println(array[i]);
}
```

# Length vs Indices

- Indices of an array start from `0`.
- An array of length `5` would have a maximum index of value `4`.
  - Indices `array[0]` to `array[4]` is 5 elements.
- Can directly access the length of any array by calling `array.length`.

# Code

[Arrays.java](https://github.com/emaanr/notes/blob/main/Programming/Java/15/Arrays/src/Arrays.java)

# Source

[BroCode: Java Arrays](https://www.youtube.com/watch?v=ei_4Nt7XWOw&list=PLZPZq0r_RZOMhCAyywfnYLlrjiVOkdAI1&index=15)
