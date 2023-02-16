# Abstraction

    Java Abstraction.

# Table of Contents

- [Abstraction](#abstraction)
- [Table of Contents](#table-of-contents)
- [Defintion](#defintion)
- [`abstract`](#abstract)
  - [Classes](#classes)
  - [Methods](#methods)
    - [Error: Inherited Abstract Method](#error-inherited-abstract-method)
    - [Error: Must be Abstract Class](#error-must-be-abstract-class)
- [Code](#code)
- [Source](#source)

# Defintion

- Data abstraction is the process of hiding certain details and showing only essential information to the user.
- Abstraction can be achieved with either abstract classes or interfaces.
- Think of something that is `abstract` as something that is general or an idea such that it makes no sense to instantiate it in the context of its existence.
  - Forces the use of:
    1. Children classes of abstract classes.
    2. Overridden methods of abstract classes.

# `abstract`

- A keyword that can be applied to both classes and methods when you define them.
- Adds a layer of security to programs.
  - `abstract class`:
    - User cannot instantiate an instance of that class.
    - Is a restricted class that cannot be used to create objects.
      - To access it, it must be inherited from another class.
  - `abstract method`:
    - User cannot implement the method in its respective class, but must implement it in any children classes of it.
    - Can only be used in an abstract class, and it does not have a body.
      - The body is provided by the subclass (inherited from).

## Classes

- An `abstract` class cannot be instantiated, but they can have a subclass that _can_ be.
  - Adds a layer of security in the case that we do not want to permit the instantiation of certain classes.
- Consider the example of requesting a vehicle at a car dealership (too general).
  - You can't get a plain generic _vehicle_, but you _can_ get a _car_ which happens to be a _vehicle_.

```java
// Cannot instantiate
abstract class ParentClass {
    // Attributes and Methods
}

// Can instantiate
class ChildClass extends ParentClass {
    // Attributes and Methods
}
```

## Methods

- Abstract methods are declared without an implementation, that is, without a body.
  - No curly braces `{}`.
- This forces implementation of the method in a child class in order to actually use it.
  - Required to do method overriding.
- Abstract methods can only be defined in abstract classes.

```java
abstract class ParentClass {
    abstract void method(); // No curly braces
}

class ChildClass extends ParentClass {
    @Override
    void method() {
        // Must implement inherited abstract method
    }
}
```

### Error: Inherited Abstract Method

- The type `ChildClass` must implement the inherited abstract method `ParentClass.method()`.

### Error: Must be Abstract Class

- The type `ParentClass` must be an abstract class to define abstract methods.

# Code

[Abstraction.java](https://github.com/emaanr/notes/blob/main/Programming/Java/37/Abstraction/src/Abstraction.java)

# Source

[BroCode: Java Abstraction](https://www.youtube.com/watch?v=Lvnb83qt57g&list=PLZPZq0r_RZOMhCAyywfnYLlrjiVOkdAI1&index=37)
