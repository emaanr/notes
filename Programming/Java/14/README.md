# Nested Loops

    Java Nested Loops.

# Table of Contents

- [Nested Loops](#nested-loops)
- [Table of Contents](#table-of-contents)
- [Definition](#definition)
  - [Examples](#examples)
    - [Nested `for` Loop](#nested-for-loop)
    - [Nested `if-else` Loop](#nested-if-else-loop)
- [Code](#code)
- [Source](#source)

# Definition

- A loop inside of another loop.
- For every iteration of the outer loop, all iterations of the inner loop will run.
- Nested loops can appear in a variety of combinations of different types of loops such as:
  - `if-else`
  - `while`
  - `do-while`
  - `for`

## Examples

### Nested `for` Loop

```java
for (int i=1; i<=n; i++) {
    // Code to run 'n' number of times
    for (int j=1; j<=m; j++) {
        // Code to run 'm' number of times
    }
}
```

### Nested `if-else` Loop

```java
// Outer if
if (cond) {
    // Inner if-else
    if (cond) {
        // Code to run
    } else {
        // Code to run
    } // End of inner if-else
// Outer else
} else {
    // Code to run
} // End of outer if-else
```

# Code

[NestedLoops.java](https://github.com/emaanr/notes/blob/main/Programming/Java/BroCode/14/NestedLoops/src/NestedLoops.java)

# Source

[BroCode: Java Nested Loops](https://www.youtube.com/watch?v=oF3nBQFfpeM&list=PLZPZq0r_RZOMhCAyywfnYLlrjiVOkdAI1&index=14)
