# Generics

    Java Generics.

# Table of Contents

- [Generics](#generics)
- [Table of Contents](#table-of-contents)
- [Definition](#definition)
- [Benefits](#benefits)
  - [Reusability](#reusability)
  - [Type-Safety](#type-safety)
  - [No Type-Casting](#no-type-casting)
  - [Compile-Time Checking](#compile-time-checking)
- [Creation](#creation)
  - [Methods](#methods)
  - [Classes](#classes)
- [Type Parameter Naming Conventions](#type-parameter-naming-conventions)
  - [Table](#table)
- [Bounded Types](#bounded-types)
- [Code](#code)
- [Source](#source)

# Definition

- Enable types (classes and interfaces) to be parameters when defining:
  1.  Methods
  2.  Classes
  3.  Interfaces

# Benefits

1. Reusability
2. Type-Safety
3. No Type-Casting
4. Compile-Time Checking

## Reusability

- Eliminates the need to create multiple versions of methods or classes for various datatypes.
  - Use one version for all reference data types.

## Type-Safety

- Generics enforce that we select some type that then disallows any type besides the one selected.

## No Type-Casting

- There is no need to typecase since generics requires explicit declaration of some type in order to be used.

## Compile-Time Checking

- As a result of explicity selecting some type, congruence and adherence to that type is checked at compile-time such that problems will not arise during run time.
  - Good programming strategy asserts that it is always better to catch errors at compile-time than during run-time.

# Creation

## Methods

- In order to create a Generic Method of type `T`, include angle brackets `<>` before the return type of the method.
  - Conventially, programmers indicate generic type with `T` (for type) or `E` for (parameter) inside the angle brackets `<T>` or `<E>`.
    - `T` acts like a placeholder variable the same way the names of parameters behave.
- If we want to return the generic type `T` that is being passed, we simply indicate `T` to be the return type in the place of `void`.

```java
// Generic method that takes a generic array of type T as a parameter
public static <T> void method(T[] arr) {
    for (T t : array) {
        // Code
    }
}

// Generic method that take a generic array of type T as a parameter AND returns generic type T
public static <T> T void method(T[] arr) {
    for (T t : array) {
        return t;
    }
}
```

## Classes

- In order to create a Generic Class of type `T`, include angle brackets `<>` after the name of the class.
  - Conventially, programmers indicate generic type with `T` (for type) or `E` for (parameter) inside the angle brackets `<T>` or `<E>`.
    - `T` acts like a placeholder variable the same way the names of parameters behave.
- In order to initialize the class as some type, we need to do the following:
  - `GenericClass<T> className = new GenericClass<T>()`
    - Such that `T` is replaced with the data type we want.
- Reminiscent of how `ArrayList<T>`s are created.

```java
class GenericClass <T> {

    // Attributes

    T t;

    // Methods

    GenericClass(T t) {
        this.t = t;
    }

    public T getGeneric() {
        return t;
    }
}

// Main

public static void main(String[] args) {

    GenericClass<T> className = new GenericClass<T>(t);
    System.out.println(className.getGeneric());
}
```

# Type Parameter Naming Conventions

- By convention, type parameter names are single, uppercase letters.
- This stands in sharp contrast to the variable naming conventions that you already know about, and with good reason:
  - Without this convention, it would be difficult to tell the difference between a type variable and an ordinary class or interface name.

## Table

- The most commonly used type parameter names are:

| Parameter | For     |
| --------: | ------- |
|       `E` | Element |
|       `K` | Key     |
|       `N` | Number  |
|       `T` | Type    |
|       `V` | Value   |
|       `S` | Type    |
|       `U` | Type    |
|       `V` | Type    |

> - `E` is used extensively in the Java Collections Framework.
> - `S`, `U`, and `V` are the conventional names for additional type parameters beyond just one which is usually `T` or `E`.
>   - Although it seems `E` may be reserved for non user-defined generics while `T` is being used for user-defined generics.

# Bounded Types

- Enables creation of objects of a Generic class to have data of specified derived types.
  - Example being the `Number` reference type.
- Limits the scope of acceptable reference data types for any Generic entity.
- Bounding is done using the `extends` keyword on any generic parameters.

```java
class GenericClassBounded <T extends Class, V extends Class> {
    // Code such that type 'T' and type 'V' are children of class 'Class'
}
```

# Code

[GenericClasses.java](https://github.com/emaanr/notes/blob/main/Programming/Java/53/Generics/src/GenericClasses.java)

[GenericMethods.java](https://github.com/emaanr/notes/blob/main/Programming/Java/53/Generics/src/GenericMethods.java)

# Source

[BroCode: Java Generics](https://www.youtube.com/watch?v=jUcAyZ5OUm0&list=PLZPZq0r_RZOMhCAyywfnYLlrjiVOkdAI1&index=81)
