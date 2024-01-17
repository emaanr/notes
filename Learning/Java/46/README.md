# FileWriter

    Java FileWriter (Write to a File).

# Table of Contents

- [FileWriter](#filewriter)
- [Table of Contents](#table-of-contents)
- [`FileWriter`](#filewriter-1)
  - [`write()`](#write)
  - [`append()`](#append)
- [`try-catch`](#try-catch)
  - [`IOException`](#ioexception)
- [Code](#code)
- [Source](#source)

# `FileWriter`

- Java class that writes files.
- Exploring some methods of the `FileWriter` class in Java.
- `FileWriter writer = new FileWriter(filepath)`

## `write()`

- Writes argument to the specified file.
- Overwrites the file contents if the file is not empty.

## `append()`

- Appends argument to the file contents.

# `try-catch`

- Need to put `FileWriter` in a `try-catch` block because it is considered dangerous code that is prone to throwing an `IOException`.

## `IOException`

- It throws an `IOException` if the file:
  1. Exists but is a directory rather than a regular file.
  2. Does not exist but cannot be created.
  3. Cannot be opened for any other reason.

# Code

[FileWriters.java](https://github.com/emaanr/notes/blob/main/Programming/Java/46/FileWriters/src/FileWriters.java)

# Source

[BroCode: Java `FileWriter` (Write to a File)](https://www.youtube.com/watch?v=kjzmaJPoaNc&list=PLZPZq0r_RZOMhCAyywfnYLlrjiVOkdAI1&index=46)
