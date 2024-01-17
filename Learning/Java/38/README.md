# Access Modifiers

    Java Access Modifiers (public, protected, private).

# Table of Contents

- [Access Modifiers](#access-modifiers)
- [Table of Contents](#table-of-contents)
- [Definition](#definition)
- [Table: Access Levels](#table-access-levels)
- [Four Types](#four-types)
  - [` `](#-)
  - [`public`](#public)
  - [`protected`](#protected)
  - [`private`](#private)
- [Packages](#packages)
- [Code](#code)
- [Source](#source)

# Definition

- Access modifiers are keywords that can be used to control the visibility of fields, methods, and constructors in a class.
- Adds a layer of security to programs.

> Note that access modifiers can be used for both classes themselves and data within classes, such as attributes and methods.
>
> - The modifiers behave the same regardless.

# Table: Access Levels

|     Modifer | Class | Package | Subclass | World |
| ----------: | :---: | :-----: | :------: | :---: |
|         ` ` |   Y   |    Y    |    N     |   N   |
|    `public` |   Y   |    Y    |    Y     |   Y   |
| `protected` |   Y   |    Y    |    Y     |   N   |
|   `private` |   Y   |    N    |    N     |   N   |

# Four Types

- There are four access modifiers in Java.
  1. ` `
  2. `public`
  3. `protected`
  4. `private`

## ` `

- Default modifier.
- Only accessible to other classes from the same package.

## `public`

- Visible to any class with the `public` modifer regardless of what package the class belongs to so long as `import`s are set up properly and all packages belong to the same project.

## `protected`

- Accessible to different class in a different package if and only if that class is a subclass of the class to which the protected data belongs to.

## `private`

- Only the class to which this data belongs to can access it.

# Packages

- Within project `src` folder.
- A collection of classes, whereass a class is a collection of code.
- In order to have classes from different packages interact, need to use `imports` at the top of class file.
  - One class:
    - `import package.ClassName`
  - All classes:
    - `import package.*`

# Code

[main/AccessModifiers.java](https://github.com/emaanr/notes/blob/main/Programming/Java/38/AccessModifiers/src/main/AccessModifiers.java)

[main/Child.java](https://github.com/emaanr/notes/blob/main/Programming/Java/38/AccessModifiers/src/main/Child.java)

[other/Parent.java](https://github.com/emaanr/notes/blob/main/Programming/Java/38/AccessModifiers/src/other/Parent.java)

# Source

[BroCode: Java Access Modifiers (`public`, `protected`, `private`)](https://www.youtube.com/watch?v=T632kAJ_9VA&list=PLZPZq0r_RZOMhCAyywfnYLlrjiVOkdAI1&index=38)
