# Accept Input

    How to Accept User Input in Java.

# Table of Contents

- [Accept Input](#accept-input)
- [Table of Contents](#table-of-contents)
- [`Scanner`](#scanner)
- [`nextLine()`](#nextline)
- [`nextInt()`](#nextint)
  - [Issue Example](#issue-example)
    - [`nextInt()` followed by `nextLine()`](#nextint-followed-by-nextline)
      - [`nextLine()`](#nextline-1)
      - [`nextInt()`](#nextint-1)
      - [`nextLine()`](#nextline-2)
  - [Issue Solutions](#issue-solutions)
    - [`nextInt()` followed by `nextLine()` followed by `nextLine()`](#nextint-followed-by-nextline-followed-by-nextline)
    - [`nextInt()` followed by `next()`](#nextint-followed-by-next)
      - [`next()` Drawback](#next-drawback)
- [`next()`](#next)
- [`InputMismatchException`](#inputmismatchexception)
- [`scanner.close()`](#scannerclose)
- [Code](#code)
- [Source](#source)

# `Scanner`

- The Java class used to accept user input is found in the Java utility package called `util`.
- A `Scanner` breaks its input into tokens using a delimiter pattern, which by default matches whitespace.
- In order to use the `Scanner` we need to import the package it belongs to by including `import java.util.Scanner;` at the top of our program.

# `nextLine()`

- Advances this scanner past the current line, which is indicated by `\n`, and returns the input that was skipped.

# `nextInt()`

- Scans the next token of the input as an `int`.
- Does not read `\n`.
  - This causes an issue in some cases.

## Issue Example

- Consider the case where we are reading user input and after reading user input using `nextInt()`, we want to ask the user for textual input using `nextLine()` which delimits on `\n`.

### `nextInt()` followed by `nextLine()`

```java
// Ask user for their age
System.out.print("Enter your age: ");
int age = scanner.nextInt();
System.out.println("\nYou are " + age + " years old");

// Ask user for their name
System.out.print("Enter your name: ");
String name = scanner.nextLine();
System.out.println("\nHello " + name);
```

```
Enter your age: 23

You are 23 years old

Enter your name:

Hello
```

- Note that the input for Entering your name gets skipped.
- This is due to how the `nextInt()` function interacts with the `System.in` input stream buffer.

---

#### `nextLine()`

<p align="center" width="100%">
    <img src="img/figure-1-1.png">
</p>

- The `Scanner` called `scanner` recieves input from a user.

---

<p align="center" width="100%">
    <img src="img/figure-1-2.png">
</p>

- The user input an enter, or, `\n` character to submit input.
- The `nextLine()` method reads an entire line of text and stops after a newline `\n`.

---

<p align="center" width="100%">
    <img src="img/figure-1-3.png">
</p>

- After we call the `nextLine()` method, the `scanner` will be empty.

---

#### `nextInt()`

<p align="center" width="100%">
    <img src="img/figure-2-1.png">
</p>

- However, let us consider calling a method like `nextInt()` which does not read a newline `\n` character.

---

<p align="center" width="100%">
    <img src="img/figure-2-2.png">
</p>

- A newline `\n` is sent by the user via the enter key to submit the token.

---

<p align="center" width="100%">
    <img src="img/figure-2-3.png">
</p>

- The `nextInt` method only read the numerical part of the token, so there is still a newline character `\n` sitting in the `scanner` buffer.

---

#### `nextLine()`

<p align="center" width="100%">
    <img src="img/figure-3.png">
</p>

- Then when we call the `newLine()` method immediately after, there is already a newline `\n` character in the buffer, and so the `newLine()` method thinks we are already at the end.

## Issue Solutions

### `nextInt()` followed by `nextLine()` followed by `nextLine()`

<p align="center" width="100%">
    <img src="img/figure-4-1.png">
</p>

- After `nextInt()` finishes running, the buffer looks like this.

---

<p align="center" width="100%">
    <img src="img/figure-4-2.png">
</p>

- We can clear the buffer by calling `scanner.nextLine()` by itself.

---

<p align="center" width="100%">
    <img src="img/figure-4-3.png">
</p>

- Then we can call `nextLine()` again the accept input from the user.

---

### `nextInt()` followed by `next()`

<p align="center" width="100%">
    <img src="img/figure-5-1.png">
</p>

- Another solution is to use the `next()` method which delimits on white space.

---

#### `next()` Drawback

<p align="center" width="100%">
    <img src="img/figure-5-2.png">
</p>

- However, as a result, `next()` is not an optimal solution if the user sends input comprised of more than one token.

---

<p align="center" width="100%">
    <img src="img/figure-5-3.png">
</p>

- In this case, only `FName` would be accepted as input and `LName` would remain in the buffer.

# `next()`

- Finds and returns the next complete token, indicated by white space, from this scanner.

# `InputMismatchException`

- Note that methods, like `nextInt()`, require a certain data type as input.

```java
System.out.print("Enter your age: ");
int age = scanner.nextInt();
System.out.println("\nYou are " + age + " years old");
```

```
Enter your age: String
Exception in thread "main" java.util.InputMismatchException
        at java.base/java.util.Scanner.throwFor(Scanner.java:939)
        at java.base/java.util.Scanner.next(Scanner.java:1594)
        at java.base/java.util.Scanner.nextInt(Scanner.java:2258)
        at java.base/java.util.Scanner.nextInt(Scanner.java:2212)
        at AcceptInput.main(AcceptInput.java:21)
```

# `scanner.close()`

- Make sure to use `scanner.close` to close the `Scanner` once you are done with it.

# Code

[AcceptInput.java](https://github.com/emaanr/notes/blob/main/Programming/Java/BroCode/04/AcceptInput/src/AcceptInput.java)

# Source

[BroCode: How to Accept User Input in Java](https://www.youtube.com/watch?v=wAEPokhj5Q4&list=PLZPZq0r_RZOMhCAyywfnYLlrjiVOkdAI1&index=4)
