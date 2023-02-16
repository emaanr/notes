# Encapsulation

    Java Encapsulation.

# Table of Contents

- [Encapsulation](#encapsulation)
- [Table of Contents](#table-of-contents)
- [Definition](#definition)
- [`private`](#private)
  - [Error: Not Visible](#error-not-visible)
- [Getters \& Setters](#getters--setters)
  - [Getter](#getter)
  - [Setter](#setter)
- [Advantages](#advantages)
  - [Read-Write Permissions](#read-write-permissions)
  - [Control Over Data](#control-over-data)
  - [Data Hiding](#data-hiding)
- [Code](#code)
- [Source](#source)

# Definition

- Encapsulation in Java refers to integrating data (variables) and code (methods) into a single unit.
  - In encapsulation, a class's variables are hidden from other classes and can only be accessed by the methods of the class in which they are found.
- Attributes of a class are hidden or private and can only be accessed through methods within the class, conventionally called "getters" and "setters".
- Adds a layer of security.

# `private`

- You should make attributes private if there is otherwise no reason to make them not private (public/protected/default).

## Error: Not Visible

- Attempting to access a private attribute will result in the following error:
  - The field `Class.privateAttribute` is not visible.

# Getters & Setters

- Special methods for accessing and changing private data.

## Getter

- A special method found within classes with private members that can access the private attributes of a class.
- "Reads" the data.

```java
public Class {

    private attr;

    getAttr() {
        return Class.attr;
    }
}
```

## Setter

- A special method found within classes with private members that can alter the private attributes of a class.
- "Writes" the data.

```java
public Class {

    private attr;

    setAttr(attr) {
        this.attr = attr;
    }
}
```

# Advantages

- Encapsulation introduces another layer of security and control over our programs.

## Read-Write Permissions

- Control whether or not a programmer has "Read" (get) and "Write" (set) permission in regards to private data (attributes) within a class.

## Control Over Data

- Suppose the value of some attribute which should be greater than 100 only, this logic can be written inside the setter method.

## Data Hiding

- A way to achieve data hiding in Java because other classes will not be able to access the data due to the `private` access modifer of class attributes.

# Code

[Encapsulation.java](https://github.com/emaanr/notes/blob/main/Programming/Java/39/Encapsulation/src/Encapsulation.java)

# Source

[BroCode: Java Encapsulation](https://www.youtube.com/watch?v=eboNNUADeIc&list=PLZPZq0r_RZOMhCAyywfnYLlrjiVOkdAI1&index=39)
