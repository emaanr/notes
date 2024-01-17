# Constructors

    Java Constructors.

# Table of Contents

- [Constructors](#constructors)
- [Table of Contents](#table-of-contents)
- [Definition](#definition)
- [`this`](#this)
- [Code](#code)
- [Source](#source)

# Definition

- Special method that is called whenever an object is instantiated (created).
- We can define parameters for the constructor.
  - Meaning that in order to construct an instance of that object, we need to pass arguments that satisfy the parameters of the constructor.

```java
public class Object {

    // Attributes

    String str;
    int integer;
    double dub;

    // Methods

    // Constructor Method
    Object(String param1, int param2, double param3) {
        this.str = param1;
        this.integer = param2;
        this.dub = param3;
    }
}
```

# `this`

- In the previous section's example, we use a keyword called `this`.
  - This keyword is an object's way to be self referential of its attributes.
  - The keyword allows the arguments passed to the constructor to be assigned to the attribute variables of the object itself.
- Recall how we obtain an attribute of any object:
  - `Object.attribute`
    - Replace `Object` with `this`.

# Code

[Constructors.java](https://github.com/emaanr/notes/blob/main/Programming/Java/27/Constructors/src/Constructors.java)

# Source

[BroCode: Java Constructors](https://www.youtube.com/watch?v=lhf8gaUx4yU&list=PLZPZq0r_RZOMhCAyywfnYLlrjiVOkdAI1&index=27)
