# Copy Objects

    Java Copy Objects.

# Table of Contents

- [Copy Objects](#copy-objects)
- [Table of Contents](#table-of-contents)
- [Shallow Copy](#shallow-copy)
  - [Example](#example)
- [Deep Copy](#deep-copy)
  - [Deep Copy Constructor](#deep-copy-constructor)
  - [Example](#example-1)
- [Code](#code)
- [Source](#source)

# Shallow Copy

- When we do a copy of some entity to create two or more entities such that changes in one entity are reflected in the other entities as well.
- New memory allocation never happens for the other entities, and only the reference is copied to the other entities.
  - That is, the new entities act as aliases for the original entity and now all reference the same data in memory.

## Example

```java
class Shallow {
     int integer = 0;
}

public class Main {
    public static void main(String args[]) {
        Shallow shallow1 = new Shallow();
        Shallow shallow2 = shallow1; // Shallow Copy

        System.out.prinf("Integer shallow1 = %d\n", shallow1.integer)
        System.out.prinf("Integer shallow2 = %d\n", shallow2.integer)

        shallow2.integer = 25;

        System.out.prinf("\nInteger shallow1 = %d\n", shallow1.integer)
        System.out.prinf("Integer shallow2 = %d", shallow2.integer)
    }
}
```

```
Integer shallow1 = 0
Integer shallow2 = 0

Integer shallow1 = 25
Integer shallow2 = 25
```

- A practical example might be the situation where we have a `Person` object called `robert` and a `Person` object called `bob` such that `robert` goes by `robert` or `bob`.
  - Regardless of which name you use for this `Person`, we are (and want to) reference the same data for this `Person`.

# Deep Copy

- When we do a copy of some entity to create two or more entities such that changes in one entity are _not_ reflected in the other entities.
- New memory allocation happens for the other entities, and reference is not copied to the other entities.
  - Each entity has its own independent reference.

## Deep Copy Constructor

- In order to create a new instance of the `Deep` object `deep2` with the same properties as the `deep1` instance, we call a constructor that takes a datatype of itself (class) as a parameter.
  - This is a kind of constructor specifically used to create deep copies.

## Example

```java
class Deep {
    int integer = 25;
}

public class Main {
    public static void main(String args[]) {
        Shallow deep1 = new Deep();
        Shallow deep2 = new Deep(deep1); // Deep copy

        System.out.prinf("Integer deep1 = %d\n", deep1.integer)
        System.out.prinf("Integer deep2 = %d\n", deep2.integer)

        shallow2.integer = 0;

        System.out.prinf("\nInteger deep1 = %d\n", deep1.integer)
        System.out.prinf("Integer deep2 = %d", deep2.integer)
    }
}
```

```
Integer deep1 = 25
Integer deep2 = 25

Integer deep1 = 25
Integer deep2 = 0
```

- A practical example might be the situation where we have a set of `Person`s who are identical twins with the same qualities at the time that the deep copy is created.
  - Although they both possess the same genetics, they are separate entities who will make different decisions from one another that may need to be updated in their respective instances.
    - Such as if `twin1.getHairColor()` and `twin2.getHairColor()` are initially `"blonde"` but:
      - `Person twin1` dyes their hair to be `twin1.setHairColor("red")`
      - `Person twin2` dyes their hair to be `twin2.setHairColor("black")`

# Code

[CopyObjects.java](https://github.com/emaanr/notes/blob/main/Programming/Java/40/CopyObjects/src/CopyObjects.java)

# Source

[BroCode: Java Copy Objects](https://www.youtube.com/watch?v=ljGH04_ASG4&list=PLZPZq0r_RZOMhCAyywfnYLlrjiVOkdAI1&index=40)
