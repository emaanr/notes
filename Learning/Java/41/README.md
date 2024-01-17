# Interface

    Java Interface.

# Table of Contents

- [Interface](#interface)
- [Table of Contents](#table-of-contents)
- [Definition](#definition)
- [`implements`](#implements)
- [Code](#code)
- [Source](#source)

# Definition

- A template that can be applied to a class.
- Similar to inheritance but speicifies what a class has to do or must implement through use of abstract methods for example.
- Classes can apply more than one interface but inheritance (recall `super` keyword) is limited to one `super` class.

# `implements`

- The keyword used to apply an interface to a class.
  - `Class implements Interface`

```java
interface Interface {
    void abstractMethod();
}

class Class implements Interface {
    public void abstractMethod() {
        // Implementation
    }
}
```

# Code

[Interface.java](https://github.com/emaanr/notes/blob/main/Programming/Java/41/Interface/src/Interface.java)

# Source

[BroCode: Java `Interface`](https://www.youtube.com/watch?v=GhslBwrRsnw&list=PLZPZq0r_RZOMhCAyywfnYLlrjiVOkdAI1&index=41)
