# HashMap

    Java HashMap.

# Table of Contents

- [HashMap](#hashmap)
- [Table of Contents](#table-of-contents)
- [`HashMap`](#hashmap-1)
  - [`HashMap<T, T>`](#hashmapt-t)
  - [`put(T, T)`](#putt-t)
  - [`remove(T)`](#removet)
  - [`get(T)`](#gett)
  - [`clear()`](#clear)
  - [`size()`](#size)
  - [`replace(T, T)`](#replacet-t)
  - [`containsKey(T)`](#containskeyt)
  - [`keySet()`](#keyset)
- [Printing](#printing)
  - [`System.out.println()`](#systemoutprintln)
  - [`for-each`](#for-each)
- [Code](#code)
- [Source](#source)

# `HashMap`

- `HashMap` implements the `Map` interface and requires `import java.util.HashMap` statement at the start of the Java file.
- `HashMap` is similar to `ArrayList`, but with `key-value` pairs.
- Stores objects, need to use `Wrapper` class.

> Recall that `Wrapper` classes are the concept of taking a primitive data type and converting it to an object. Some examples are:
>
> - Integer
> - Double
> - Float
> - Boolean
>
> So on so forth.

## `HashMap<T, T>`

- Like `ArrayList`, when creating a `HashMap`, the data type(s) must be defined in angle brackets `<>` where `T` is the data type(s) in `<T, T>` such that the first `T` is the data type of the `key` and the second `T` is the data type of the `value` in the `key-value` pair.

```java
HashMap<T, T> hash = new HashMap<T, T>();
```

## `put(T, T)`

- This is the function used to add `key-value` pairs to an initialized `HashMap`.
  - `hash.put(T, T)`

## `remove(T)`

- This is the function used to remove `key-value` pairs from a populated `HashMap`.
- Takes the `key` as a parameter.
  - `hash.remove(T)`

## `get(T)`

- This is a getter method of the `HashMap` class which takes the `key` as a parameter and returns the associated `value` in the `key-value` pair.
- Returns `null` is there is no either no `key` or associated `value`.
  - `hash.get(T)`
  - `System.out.println(hash.get(T))`
    - Need to use a print statement to actually output the `return` to console.

## `clear()`

- Clears contents of `HashMap`.

## `size()`

- Returns the size of the `HashMap`, that is, how many `key-value` pairs exist in the `HashMap`.
  - `hash.size()`
  - `System.out.println(hash.size())`
    - Need to use a print statement to actually output the `return` to console.

## `replace(T, T)`

- Takes an existing `key` as the first parameter and takes any input of type `T` for the second parameter in order to replace the pre-existing associated `pair` value of the specified `key`.
  - `hash.replace(T, T)`

## `containsKey(T)`

- Checks to see if some input of type `T`, such that `T` is a `key` or a `value`, exists in the `HashMap` or not and returns a boolean result.
  - `hash.containsKey(T)`
  - `System.out.println(hash.containsKey(T))`
    - Need to use a print statement to actually output the `return` to console.

## `keySet()`

- Returns the set of `key`s in the `HashMap`.
  - `hash.keySet()`
  - `System.out.println(hash.keySet())`
    - Need to use a print statement to actually output the `return` to console.

# Printing

- Using a `for-each` loop is a reasonable way to output the contents of the `HashMap` without using a standard print statement since they both display the contents differently.

## `System.out.println()`

```java
System.out.println(hash);
```

```
{key_1=value_1, key_2=value_2, ... , key_n = value_n}`
```

## `for-each`

```java
for (T key : hash.keySet()) {
    System.out.printf("%T, %T\n", key, hash.get(key));
}
```

```
key_1, value_1
key_2, value_2
...
key_n, value_n
```

# Code

[HashMaps.java](https://github.com/emaanr/notes/blob/main/Programming/Java/50/HashMaps/src/HashMaps.java)

# Source

[BroCode: Java `HashMap`](https://www.youtube.com/watch?v=0dR-YAFFg6I&list=PLZPZq0r_RZOMhCAyywfnYLlrjiVOkdAI1&index=75)
