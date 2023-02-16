# Overloaded Constructors

    Java Overloaded Constructors.

# Table of Contents

- [Overloaded Constructors](#overloaded-constructors)
- [Table of Contents](#table-of-contents)
- [Defintion](#defintion)
  - [Constructor Signature](#constructor-signature)
    - [Parameters](#parameters)
- [Examples](#examples)
- [Code](#code)
- [Source](#source)

# Defintion

- Multiple constructors within a class with the same name, but with different parameters.

## Constructor Signature

- Recall that a constructor is a method.
- This is allowed because every method has a unique method signature comprised of its name and parameters.
  - Name + Parameters = Signature.

### Parameters

> Note that the order of parameters and parameter data types matters.
>
> - This means that we can have two methods, or constructors in this case, with the same name and same number of parameters but different parameter data types.

# Examples

```java
// Default Constructor
Object() {
    // Code to run
}

// Overloaded Constructor #1
Object(datatype param_1) {
    // Code to run
}

// Overloaded Constructor #2
Object(datatype param_1, datatype param_2) {
    // Code to run
}

// Overloaded Constructor #3
Object(datatype param_1, datatype param_2, datatype param_3, ... , datatype param_n) {
    // Code to run
}
```

# Code

[OverloadedConstructors.java](https://github.com/emaanr/notes/blob/main/Programming/Java/BroCode/29/OverloadedConstructors/src/OverloadedConstructors.java)

# Source

[BroCode: Java Overloaded Constructors](https://www.youtube.com/watch?v=Xngu-8pt_TA&list=PLZPZq0r_RZOMhCAyywfnYLlrjiVOkdAI1&index=29)
