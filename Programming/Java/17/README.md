# String Methods

    Java String Methods.

# Table of Contents

- [String Methods](#string-methods)
- [Table of Contents](#table-of-contents)
- [`String`](#string)
- [`equals()`](#equals)
- [`equalsIgnoreCase()`](#equalsignorecase)
- [`length()`](#length)
- [`charAt()`](#charat)
- [`indexOf()`](#indexof)
- [`isEmpty()`](#isempty)
- [`toUpperCase()`](#touppercase)
- [`toLowerCase()`](#tolowercase)
- [`trim()`](#trim)
- [`replace()`](#replace)
- [Code](#code)
- [Source](#source)

# `String`

- A reference data type that can store one or more characters.
- Has access to some useful methods.

# `equals()`

- Checks for equality.
  - Same data type and same value.
    - That is, if we have `String one = "1";`, then:
      - `one.equals(1);` returns `false`
      - `one.equals("1");` returns `true`
- Is case sensitive.
  - That is, if we have `String name = "Name", then:
    - `name.equals("name");` returns `false`
    - `name.equals("Name");` returns `true`

# `equalsIgnoreCase()`

- Checks for equality in the same way as `equals()` but disregards case sensitivity.

# `length()`

- Returns the length of the `String` as an integer.

# `charAt()`

- Returns the character at the index requested.

# `indexOf()`

- Returns index of passed character parameter as an integer.

# `isEmpty()`

- Returns a boolean `true` if is empty and `false` if is not empty.

# `toUpperCase()`

- Returns entire `String` calling the method as a `String` in all upper case.

# `toLowerCase()`

- Returns entire `String` calling the method as a `String` in all lower case.

# `trim()`

- Returns the `String` calling the method as a `String` with all excess white space before and after removed.

# `replace()`

- Replaces all instances of a character in the calling `String`.
- Has two parameters.
  - First parameter is the chararacter to be replaced.
  - Second parameter is the character replacing all instances of first parameter.

# Code

[StringMethods.java](https://github.com/emaanr/notes/blob/main/Programming/Java/17/StringMethods/src/StringMethods.java)

# Source

[BroCode: Java `String` Methods](https://www.youtube.com/watch?v=P9hEmbfdiuc&list=PLZPZq0r_RZOMhCAyywfnYLlrjiVOkdAI1&index=17)
