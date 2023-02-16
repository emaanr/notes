# Polymorphism

    Java Polymorphism.

# Table of Contents

- [Polymorphism](#polymorphism)
- [Table of Contents](#table-of-contents)
- [Definition](#definition)
- [Inheritance](#inheritance)
- [`Object`](#object)
- [Code](#code)
- [Source](#source)

# Definition

- Polymorphism is a greek word.
  - Poly meaning "many".
  - Morph meaning "form".
- Ability of an object to identify as more than one type.
  - Identified as more than one data type.

# Inheritance

- Ties into inheritance.
- The idea that if we want to iterate over the children of a super class, we can do so by indentifying the different children classes by their super class.

```java
class Parent {
    // Super Class Methods and Attributes
}

class Child1 extends Super {
    // Sub Class Methods and Attributes (Distinct from Child2)
}

class Child2 extends Super {
    // Sub Class Methods and Attributes (Distinct from Child1)
}

class Main {
    // Main Method
    public static void main(String[] args) {

        Child1 child1 = new Child1();
        Child2 child2 = new Child2();

        /**
         * We can create an array of object of different classes
         * since they extend (inherit) the same parent class. Thus
         * we can identify them by their parent and create an array.
         */
        Parent[] childrenArr = {child1, child2};
    }
}
```

# `Object`

- The parent of all classes is the `Object` class in Java.

# Code

[Polymorphism.java](https://github.com/emaanr/notes/blob/main/Programming/Java/BroCode/42/Polymorphism/src/Polymorphism.java)

# Source

[BroCode: Java Polymorphism](https://www.youtube.com/watch?v=2hkngtWLGvE&list=PLZPZq0r_RZOMhCAyywfnYLlrjiVOkdAI1&index=42)
