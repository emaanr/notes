# FileReader

    Java FileReader (Read a File).

# Table of Contents

- [FileReader](#filereader)
- [Table of Contents](#table-of-contents)
- [`FileReader`](#filereader-1)
  - [`read()`](#read)
- [`try-catch`](#try-catch)
  - [`FileNotFoundException`](#filenotfoundexception)
  - [`IOException`](#ioexception)
- [Code](#code)
- [Source](#source)

# `FileReader`

- Java class that reads contents of a file as a stream of characters.
- Exploring some methods of the `FileReader` class in Java.
- `FileReader reader = new FileReader(filepath)`

## `read()`

- One by one, `read()` returns an integer value which contains the byte value of whichever character is being read, which can be cast back to a character.
- When `read()` returns `-1`, there is no more data to be read.

```java
FileReader reader = new FileReader(filepath);

int data = reader.read();
while (data != -1) {
    System.out.print((char)data);
    data = reader.read();
}

reader.close();
```

# `try-catch`

- Need to put `FileReader` in a `try-catch` block because it is considered dangerous code that is prone to throwing a `FileNotFoundException` or an `IOException`.

## `FileNotFoundException`

- It throws a `FileNotFoundException` if the reader is unable to find the file for whatever reason such as:
  1. Does not exist, therefore it cannot be read.
  2. Cannot be found due to incorrect filepath.

## `IOException`

- It throws an `IOException` if the file:
  1. Exists but is a directory rather than a regular file.
  2. Cannot be opened for any other reason.

# Code

[FileReaders.java](https://github.com/emaanr/notes/blob/main/Programming/Java/BroCode/47/FileReaders/src/FileReaders.java)

# Source

[BroCode: Java `FileReader` (Read a File)](https://www.youtube.com/watch?v=Hr8tLlj32BQ&list=PLZPZq0r_RZOMhCAyywfnYLlrjiVOkdAI1&index=47)
