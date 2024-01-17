# Dynamic Polymorphism

    Java Dynamic Polymorphism.

# Table of Contents

- [Dynamic Polymorphism](#dynamic-polymorphism)
- [Table of Contents](#table-of-contents)
- [Definition](#definition)
  - [Example](#example)
- [User Input](#user-input)
- [Code](#code)
- [Source](#source)

# Definition

- Also known as "Runtime Polymorphism".
- Dynamic, in this context, means "After compilation (during runtime)".
- Polymorphism means "Many shapes/forms".

## Example

- For a practical example, consider a Honda Accord.
  - It is a (idenitifies) as:
    1. Honda Accord
    2. Car
    3. Vehicle
    4. Object

# User Input

- Polymorphism can occur when reading user input if the initialization of an object's type is determined by user input.
  - This is an example of an object morphing into another form after compilation.
    - In this case, as a result of some input from the user.

```java
public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    String input = scanner.next();

    if (input.equals(arg1)) {           // Becomes object type Arg1
        Object obj = Arg1();
    } else if (input.equals(arg2)) {    // Becomes object type Arg2
        Object obj = Arg2();
    } else {
        // Code otherwise
    }
}
```

# Code

[DynamicPolymorphism.java](https://github.com/emaanr/notes/blob/main/Programming/Java/43/DynamicPolymorphism/src/DynamicPolymorphism.java)

# Source

[BroCode: Java Dynamic Polymorphism](https://www.youtube.com/watch?v=tAIaK5LNatE&list=PLZPZq0r_RZOMhCAyywfnYLlrjiVOkdAI1&index=43)
