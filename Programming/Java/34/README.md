# Inheritance

    Java Inheritance.

# Table of Contents

- [Inheritance](#inheritance)
- [Table of Contents](#table-of-contents)
- [Defintion](#defintion)
- [`extends`](#extends)
- [Code](#code)
- [Source](#source)

# Defintion

- Process by which one class acquires the attributes and methods of another class.

# `extends`

- Keyword to enable inheritance of some class by another class.
- `ChildClass extends ParentClass` can be read as:
  - `ChildClass` is an extension of `ParentClass`.
    - As its child, it inherits its characteristics such as attributes and methods.

```java
class ParentClass {

    // Parent Attributes

    int parentAttr;

    // Parent Methods

    void parentMethod() {
        // Code
    }
}

class ChildClass extends ParentClass {
    // Child Attributes and Methods
}

Main {

    public static void main(String[] args) {

        ChildClass child = new ChildClass();
        System.out.print(child.parentAttr);
        child.parentMethod()

    }
}
```

# Code

[Inheritance.java](https://github.com/emaanr/notes/blob/main/Programming/Java/34/Inheritance/src/Inheritance.java)

# Source

[BroCode: Java Inheritance](https://www.youtube.com/watch?v=Zs342ePFvRI&list=PLZPZq0r_RZOMhCAyywfnYLlrjiVOkdAI1&index=34)
