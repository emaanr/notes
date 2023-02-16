# Inner Classes

    Java Inner Classes.

# Table of Contents

- [Inner Classes](#inner-classes)
- [Table of Contents](#table-of-contents)
- [Inner Class](#inner-class)
- [Creation](#creation)
- [Code](#code)
- [Source](#source)

# Inner Class

- As the name suggests, it is a class within another class.
- Useful if a class should be limited in scope.
  - Usually private, but not always the case.
- Helps group classes that belong together.
- Useful for listeners for specific events.

> One use case of a private inner class may be if we have a user-defined `Node` class that is used by only one user-defined Data Structure such as an `ArrayList`. In this case it would be beneficial, secure, and wise to include user-defined `Node` as a private inner class of the user-defined `ArrayList` class.

> Note that I emphasize "User-Defined" since Java has its own implementation of `ArrayList` that may or may not include its own private inner `Node` class.

# Creation

- In order to access and create the inner class, we need to access the inner class _via_ the outer class as demonstrated below using:
  - `Outer.Inner` instead of just `Inner`
  - `out.new` instead of just `new`

```java
public class Outer {
    // Code

    public class Inner {
        // Code
    }
}

public static void main(String[] args) {
    Outer out = new Outer();
    Outer.Inner in = out.new Inside();
}
```

# Code

[InnerClasses.java](https://github.com/emaanr/notes/blob/main/Programming/Java/BroCode/52/InnerClasses/src/InnerClasses.java)

# Source

[BroCode: Java Inner Classes](https://www.youtube.com/watch?v=paKrmEMvkU4&list=PLZPZq0r_RZOMhCAyywfnYLlrjiVOkdAI1&index=78)
