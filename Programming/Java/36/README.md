# Super Keyword

    Java super Keyword.

# Table of Contents

- [Super Keyword](#super-keyword)
- [Table of Contents](#table-of-contents)
- [`super`](#super)
  - [Variable](#variable)
  - [Method](#method)
- [Code](#code)
- [Source](#source)

# `super`

- Refers to the superclass (parent) of an object.
- Similar to the `this` keyword.

## Variable

```java
ParentClass {
    String str;

    ParentClass(String str) {
        this.str = str;
    }
}

ChildClsss extends ParentClass {
    int integer;

    ChildClass(String str, int integer) {
        super(str);
        this.integer = integer;
    }
}
```

## Method

```java
ParentClass {
    String str;

    public String method() {
        return this.str;
    }
}

ChildClsss extends ParentClass {
    int integer;

    @Override
    public String method() {
        return super.toString() + this.integer;
    }
}
```

# Code

[SuperKeyword.java](https://github.com/emaanr/notes/blob/main/Programming/Java/36/SuperKeyword/src/SuperKeyword.java)

# Source

[BroCode: Java `super` Keyword](https://www.youtube.com/watch?v=oKZnHNM9Ew4&list=PLZPZq0r_RZOMhCAyywfnYLlrjiVOkdAI1&index=36)
