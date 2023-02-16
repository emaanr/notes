# ArrayLists

    Java ArrayList.

# Table of Contents

- [ArrayLists](#arraylists)
- [Table of Contents](#table-of-contents)
- [Definition](#definition)
- [Creation](#creation)
- [Length vs Size](#length-vs-size)
- [Collections](#collections)
  - [Example Classes:](#example-classes)
  - [Example Interfaces](#example-interfaces)
  - [`Collection`](#collection)
  - [`ArrayList`](#arraylist)
- [Code](#code)
- [Source](#source)

# Definition

- A resizable array.
- Elements can be added and removed after compilation (which cannot be done with standard arrays).
- Store reference data types.

# Creation

- Need to import the collection using `import java.util.ArrayList;` at the top of the program.
- Declare the reference data type in angle brackets `<>` immediately following `ArrayList`.

```java
// 'T' is a placeholder for a reference data type as determined by the programmer
ArrayList<T> name = new ArrayList<T>();
```

> Note that because `ArrayList` is a collection/class, it is modified using methods/functions that belong to the `ArrayList` such as:
>
> - `add()`
> - `set()`
> - `remove()`
> - `clear()`

# Length vs Size

- Unlike arrays, `ArrayList` uses `size()` rather than `length` to determine how many elements it can accomodate.

```java
String arr[] = {"elem1", "elem2", "elem3"}; // Length = 3

System.out.println("Array is of length " + arr.length);

ArrayList<String> arrList = new ArrayList<T>(); // Size 0

arrList.add("elem1") // Size 1
arrList.add("elem2") // Size 2
arrList.add("elem3") // Size 3
arrList.add("elem4") // Size 4

System.out.println("ArrayList is of size " + arrList.size());
```

```
Array is of length 3
ArrayList is of size 4
```

# Collections

- The Collections API is a set of classes and interfaces that support operations on collections of objects.
- It implements polymorphic algorithms which operate on collections.

## Example Classes:

- `HashSet`
- `HashMap`
- `ArrayList`
- `LinkedList`
- `TreeSet`
- `TreeMap`

## Example Interfaces

- `Collection`
- `Set`
- `List`
- `Map`

## `Collection`

- It is the root interface in the `Collection` hierarchy.
- The following interfaces (collection types) extends the `Collection` interface:
  - `List`
  - `Set`
  - `SortedSet`
  - `NavigableSet`
  - `Queue`
  - `Deque`
- Java does not come with a usable implementation of the `Collection` interface, so you will have to use one of the listed subtypes.
- The `Collection` interface just defines a set of methods (behaviour) that each of these `Collection` subtypes share.
  - In other words, standard inheritance.

## `ArrayList`

- It is resizable array implementation.
- Belongs to `List` group in `Collection`.
  - `public interface List extends Collection`
  - `ArrayList` is implementation of `List` which is also type of `Collection`.
- It permits all elements, including `null`.

# Code

[ArrayLists.java](https://github.com/emaanr/notes/blob/main/Programming/Java/BroCode/19/ArrayLists/src/ArrayLists.java)

# Source

[BroCode: Java `ArrayList`](https://www.youtube.com/watch?v=1nRj4ALuw7A&list=PLZPZq0r_RZOMhCAyywfnYLlrjiVOkdAI1&index=19)
