# Variables

    Variables in Java.

# Table of Contents

- [Variables](#variables)
- [Table of Contents](#table-of-contents)
- [Definition](#definition)
- [Data Types](#data-types)
  - [Primitive Data Type](#primitive-data-type)
  - [Reference Data Type](#reference-data-type)
  - [Primitive vs Reference](#primitive-vs-reference)
- [Creation](#creation)
  - [Declaration](#declaration)
  - [Assignment](#assignment)
  - [Initialization](#initialization)
- [Code](#code)
- [Source](#source)

# Definition

- A placeholder or a value that behaves as whatever it contains.
- In programming, variables can store numbers, sentences, or boolean values.
- In order to create a variable, we need to label the data so we properly accomodate whatever it contains.
  - This is done using "Data Types".

# Data Types

| Data Type | Size      | Type      | Value                                  |
| --------- | --------- | --------- | -------------------------------------- |
| Boolean   | $1$ bit   | Primitive | True or False                          |
| Byte      | $8$ bits  | Primitive | $-128$ to $127$                        |
| Short     | $2$ bytes | Primitive | $-32,768$ to $32,767$                  |
| Int       | $4$ bytes | Primitive | $-2$ billion to $2$ billion            |
| Long      | $8$ bytes | Primitive | $-9$ quintillion to $9$ quintillion    |
| Float     | $4$ bytes | Primitive | Fractional Number up to $6$-$7$ Digits |
| Double    | $8$ bytes | Primitive | Fractional Number up to $15$ Digits    |
| Char      | $2$ bytes | Primitive | Single Character/Letter/ASCII Value    |
| String    | Varies    | Reference | A Sequence of Characters               |

> Note that `float`s and `long`s behave somewhat differently than `double`s.
>
> - The `float` data type needs to be followed by an `f`.
>   - `3.1415192f`
> - The `long` data type needs to be followed by an `L`.
>   - `3141592653589793L`
> - The `double` data type does not have this requirement.
>   - `3.141592653589793`

## Primitive Data Type

- A primitive variable's information is stored as the value of that variable.
  - Java has $8$ different primitive variables.
- Declaring a primitive variable causes the computer to reserve some memory where the value assigned to the variable can be stored.
  - The size of the storage container reserved depends on type of the primitive.
- The name of the variable tells the memory location where its value is stored.
  - When you assign a value to a primitive variable with an equality sign, the value on the right side is copied to the memory location indicated by the name of the variable.
- The values of variables are also copied whenever they're used in method calls.
  - What this means in practice is that the value of a variable that's passed as a parameter during a method call is not mutated in the calling method by the method called.
- The most significant difference between primitive and reference variables is that primitives (usually numbers) are immutable.
  - This has to do with the fact that the value of a primitive variable is stored directly in the variable.

## Reference Data Type

- A reference variable holds a reference to information related to that variable.
- Reference variables are practically always objects in Java.
- A programmer is free to create their own variable types by defining new classes.
  - In practice, any object instanced from a class is a reference variable.
- The internal state of reference variables, unlike primitive variablesm, can typically be mutated.
  - This has to do with the fact that the value of a reference variable is a reference to the variable's data, in essence its internal state.

## Primitive vs Reference

| Primitive               | Reference                      |
| ----------------------- | ------------------------------ |
| $8$ Types               | Unlimited (User-Defined)       |
| Stores Data             | Stores an Address              |
| Can hold only $1$ value | Could hold more than $1$ value |
| Less memory             | More memory                    |
| Fast                    | Slower                         |
| Immutable               | Mutatable                      |

# Creation

## Declaration

- Declare the data type of the variable followed by its name.

```java
int x;
```

## Assignment

- Call the name of the variable and assign a value to it using the equal sign.

```java
x = 25;
```

## Initialization

- Initialization refers to the entire process of Declaration + Initialization.
- Can be done in one step rather than two separate steps.

```java
/**
 * Initialization:
 *      Declaration + Assignment
 */
int x = 25;

/**
 *  Opposed to:
 *      Declaration
 *      Assignment
 */
int x;      // Declare integer variable x
x = 25;     // Assign x to be of value 25
```

# Code

[Variables.java](https://github.com/emaanr/notes/blob/main/Programming/Java/02/Variables/src/Variables.java)

# Source

[BroCode: Variables in Java](https://www.youtube.com/watch?v=so1iUWaLmKA&list=PLZPZq0r_RZOMhCAyywfnYLlrjiVOkdAI1&index=2)
