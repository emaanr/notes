# Variable Scope

    Java Variable Scope.

# Table of Contents

- [Variable Scope](#variable-scope)
- [Table of Contents](#table-of-contents)
- [Definition](#definition)
  - [Local](#local)
  - [Global](#global)
- [Code](#code)
- [Source](#source)

# Definition

- In computer programming, the scope of a name binding is the part of a program where the name binding is valid.
  - That is, where the name can be used to refer to the entity.
- In other parts of the program, the name may refer to a different entity, or to nothing at all

## Local

- Declared inside of a method.
- Visible only to that method.

```java
void method() {
    datatype variable = value; // Declared and instantiated to only exist within this method
}
```

## Global

- Declared outside of a method, but within a class.
- Visible to all parts of a class.

```java
datatype variable; // Declared to exist globally to be called anywhere

void method1() {
    variable = value1; // Different value instantiated from method1
}

void method2() {
    variable = value2; // Different value instantiated from method2
}
```

# Code

[VariableScope.java](https://github.com/emaanr/notes/blob/main/Programming/Java/28/VariableScope/src/VariableScope.java)

# Source

[BroCode: Java Variable Scope](https://www.youtube.com/watch?v=pSokndJB3Pw&list=PLZPZq0r_RZOMhCAyywfnYLlrjiVOkdAI1&index=28)
