# Hello World

    Java Tutorial for Beginners.

# Table of Contents

- [Hello World](#hello-world)
- [Table of Contents](#table-of-contents)
- [Java Compilation](#java-compilation)
- [JDK](#jdk)
- [JRE](#jre)
- [JVM](#jvm)
- [IDE](#ide)
- [Classes](#classes)
- [Main Method](#main-method)
- [`print()`](#print)
- [`println()`](#println)
- [Streams](#streams)
- [Escape Characters](#escape-characters)
  - [Some Escape Characters](#some-escape-characters)
- [Comments](#comments)
- [Code](#code)
- [Source](#source)

# Java Compilation

- Computer languages exist on a spectrum from High-Level to Low-Level.
- Computers only understand Binary, also known as Machine Code.
- Humans write Source Code which is later compiled into Machine Code.
- When we compile Source Code, it is machine specific.
  - Source Code compiled on a Windows OS can only be run on a Windows OS and Source Code compiled on a Mac can only run on a Mac so on so forth.
  - Java gets around this via an intermediary step where Source Code becomes Byte cCode which is cross platform and ends with a `.class` file extension.
  - This bytecode can be shared accross platforms and compiled further into machine code using a JVM (Java Virtual Machine).

# JDK

    Java Development Kit.

- Contains:
  1. Developer's Tools.
  2. Java Runtime Environment (JRE).
  3. Java Virtual Machine (JVM).

# JRE

    Java Runtime Environment.

- Contains:
  1. Libraries.
  2. Toolkits.

# JVM

    Java Virtual Machine

- Translates Byte Code to Machine Code and runs Java programs.

# IDE

    Integrated Development Environment.

- Software that helps us write other software.
- Provides an interface to write code, check for errors, compile and run code.

# Classes

- A collection of related code.
- Class shares name of Java file it is in.
- Example is `Main.java` which is a Java file that contains the `Main {}` class.
- Classes contan Source Code, when we compile the Java Project, it will create a `Main.class` file which is Byte Code.

```java
public class Main {
    // TO-DO
}
```

# Main Method

- Program won't run without Main Method.
- When we run our code, the Main Method is the first method that is called.
  - Starting point of sorts.
  - Think of Main Method as an incantation of sorts to get the program to run.

```java
public class Main {
    public static void(String[] args) {
        // TO-DO
    }
}
```

# `print()`

- This is a function that prints text to the console on a single line (no new line afterwards).
- Accomplish this by including desired output inbetween double quotes within parens of the function call.

```java
public class Main {
    public static void(String[] args) {
        System.out.print("Hello World!");
    }
}
```

```
Hello World!
```

# `println()`

- Accomplishes the same functionality as `print()` but includes a newline character `\n` after the desired output.

```java
public class Main {
    public static void(String[] args) {
        System.out.println("Hello") // Adds a newline after text
        System.out.print("World!")  // Does not add newline after text
    }
}
```

```
Hello
World!
```

# Streams

- Processes in modern operating systems (and for that matter, several older operating systems) get three standard "streams" associated with them:
  1. Standard in:
     - Stream-based input (stdin).
  2. Standard out:
     - Stream-based output (stdout).
  3. Standard error:
     - Stream-based error output (stderr).
- Collectively (and creatively) they're called the standard streams.
- By default, Java's standard mechanism for writing to those streams are the following:
  1. `System.in`
  2. `System.out`
  3. `System.err`

# Escape Characters

- Escape Characters are characters preceded by a Backslash character `\`.
- This character is followed by some other character such as `n` in `\n` and signifies a newline.
- In the code below, we replace the `println()` function call with a `print()` function call whose output explicitly contains a newline using `\n`.

```java
public class Main {
    public static void(String[] args) {
        System.out.print("Hello\n") // Adds a newline after text with escape character
        System.out.print("World!")
    }
}
```

```
Hello
World!
```

## Some Escape Characters

- `\n`
  - Newline.
- `\t`
  - Tab.
- `\\`
  - Output Backslash `\` itself in output.
- `\"`
  - Output Doublequotes `"` itself in output.

# Comments

- Ignored by the compiler.
- Single-Line Comment:
  - Denoted by two Forwardslashes `// Comment`.
- Multi-Line Comment:
  - Denoted by `/* Comment */`.

```java
/**
 * Main
 *
 * This is a Multi-Line comment.
 *
 */
public class Main {
    public static void(String[] args) {
        System.out.print("Hello World!"); // This is a Single-Line comment
    }
}
```

# Code

[HelloWorld.java](https://github.com/emaanr/notes/blob/main/Programming/Java/BroCode/01/HelloWorld/src/HelloWorld.java)

# Source

[BroCode: Java Tutorial for Beginners](https://www.youtube.com/watch?v=NBIUbTddde4&list=PLZPZq0r_RZOMhCAyywfnYLlrjiVOkdAI1&index=1)
