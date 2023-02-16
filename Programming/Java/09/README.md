# If Statements

    Java if Statements.

# Table of Contents

- [If Statements](#if-statements)
- [Table of Contents](#table-of-contents)
- [`if`](#if)
- [`else if`](#else-if)
- [`else`](#else)
- [Examples](#examples)
  - [`if`](#if-1)
  - [`else if`](#else-if-1)
  - [`else`](#else-1)
- [Equals vs Equality](#equals-vs-equality)
- [Code](#code)
- [Source](#source)

# `if`

- Basic form of decision making that performs a block of code if the condiition evaluates to true.
- If false, then the block of code is simply skipped.

# `else if`

- A way to introduce more statements to check before reaching the final else statement.

# `else`

- If-Else statements only run one of the blocks of code that belong to whichever statement's condition is met first.
  - If neither are met, then neither blocks will run.
- That is, the statements are checked in order and as soon as one of the conditions is met, the corresponding block of code is run and then the entire `if-else` is exited.

# Examples

## `if`

```java
// Can have just one if statement by itself
if (cond) {
    // Code to run
}
// Can have multiple in one program
if (cond) {
    // Code to run
}

// Can have a bunch scattered throughout the program
. . .

if (cond) {
    // Code to run
}
if (cond) {
    // Code to run
}
```

- Both `if` conditions can be met and can have their respective code blocks run during the same invokation of a program.

## `else if`

```java
if (cond) {
    // Code to run
} else if (cond) {
    // Code to run
}
```

- In this case, only either the `if` statement or the `else if` statement can run.
  - Both cannot run.
  - It is possible for neither to run if neither conditions is met.

## `else`

```java
if (cond) {
    // Code to run
} else if (cond) {
    // Code to run
} else {
    // Code to run
}
```

- The `else` has no condition.
- It is assumed that its condition is that the other conditions are not satisfied.
- The `else` block will always run if the other conditions were not met.
- Does not necessarily need an `else if` before it.

```java
if (cond) {
    // Code to run
} else {
    // Code to run
}
```

- This is also a valid use case of `else` and is the simplest form of the `if-else`.

# Equals vs Equality

- In order to test for equality in a condition, we must use the double equals `==`.
  - This kind of statement evaluates to `true` or `false`.
- The usage of a single equals symbol `=` is reserved for assignment.

# Code

[IfStatements.java](https://github.com/emaanr/notes/blob/main/Programming/Java/BroCode/09/IfStatements/src/IfStatements.java)

# Source

[BroCode: Java `if` Statements](https://www.youtube.com/watch?v=MY03bt_0JQI&list=PLZPZq0r_RZOMhCAyywfnYLlrjiVOkdAI1&index=9)
