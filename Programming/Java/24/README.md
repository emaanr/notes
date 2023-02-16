# Printf

    Java printf.

# Table of Contents

- [Printf](#printf)
- [Table of Contents](#table-of-contents)
- [`printf()`](#printf-1)
- [Format `String`](#format-string)
- [Format Specifer `%`](#format-specifer-)
  - [Flags](#flags)
    - [Left-Justify](#left-justify)
    - [Numeric Signage](#numeric-signage)
    - [Numeric Zero-Padding](#numeric-zero-padding)
    - [Numeric Comma Separation](#numeric-comma-separation)
  - [Precision](#precision)
    - [Float Precision](#float-precision)
    - [String Precision](#string-precision)
  - [Width](#width)
  - [Conversion-Character](#conversion-character)
    - [String `%s`](#string-s)
    - [Char `%c`](#char-c)
    - [Decimal Integers `%d`](#decimal-integers-d)
    - [Floating-Point Numbers `%f`](#floating-point-numbers-f)
    - [Boolean `%b`](#boolean-b)
- [Code](#code)
- [Source](#source)

# `printf()`

- An optional method to control, format, and display text to the console.
- Two arguments:
  1. Format `String`
     - Format Specifier
  2. Formatted Element
     - Object
     - Variable
     - Value

> Note that we can actually have many formatted elements for a total of more than two arguments, but there is always only one format `String` for the first argument of the method.
>
> ```java
> System.out.printf("%s, %c, %d, %f, %b", str, ch, number, flo-number, bool);
> ```

# Format `String`

- Includes a format specifier denoted by `%` somewhere in the `String`.
- Depending on where the format specifer `%` is placed, the associated argument will appear in this location in the first `String` argument.
  - Depending on the combination of [flags], [.precision], [width], and [conversion-character] after the `%`, the data held by the argument will be displayed in the specified manner.

# Format Specifer `%`

    % [flags] [.precision] [width] [conversion-character]

## Flags

| Flag | Description                                              |
| :--: | -------------------------------------------------------- |
|  -   | Left-Justify                                             |
|  +   | Output a (+) or (-) sign for numeric values              |
|  0   | Numeric values are zero-padded                           |
|  ,   | Comma grouping separator if numbers are greater than 999 |

- The [flags] define standard ways to modify the output and are most common for formatting integers and floating-point numbers.
- Adds an effect to output based on the flag added to the format specifier.
- Flags must immediately follow the `%`.
- Where it makes sense, more than one flag can be used.

### Left-Justify

```java
System.out.printf("%-d", num);
```

### Numeric Signage

```java
System.out.printf("%+d", num);
```

### Numeric Zero-Padding

```java
System.out.printf("%0d", num);
```

### Numeric Comma Separation

```java
System.out.printf("%,d", num);
```

## Precision

- The [.precision] takes different meanings for different format types.
  1. Float Precision
  2. String Precision

### Float Precision

- The [.precision] specifies the number of digits of precision when outputting floating-point values.

```java
System.out.printf("%f", flo-num);
```

### String Precision

- The [.precision] defines the length of a substring to extract from a String.
  - In other words, "**Maximum** Field Width" that will truncate any characters of a string whose indices exceed the defined length.

```java
System.out.printf("%s", str);
```

## Width

- The [width] specifies field width for outputting the argument.
  - Represents minimum number of characters written to output.
  - In other words, "**Minimum** Field Width"

```java
// Display at least 10 characters for str
System.out.printf("%10s", str);
```

## Conversion-Character

- The [conversion-character] is required and determines how the argument is formatted.
- Conversion characters are only valid for certain data types.
- Capital conversion-character exhibits different behavior than lowercase counterpart.

### String `%s`

```java
System.out.printf("%s", str);
```

### Char `%c`

```java
System.out.printf("%c", character);
```

### Decimal Integers `%d`

```java
System.out.printf("%d", num);
```

### Floating-Point Numbers `%f`

```java
System.out.printf("%f", flo-num);
```

### Boolean `%b`

```java
System.out.printf("%b", bool);
```

# Code

[Printf.java](https://github.com/emaanr/notes/blob/main/Programming/Java/BroCode/24/Printf/src/Printf.java)

# Source

[BroCode: Java `printf`](https://www.youtube.com/watch?v=c2B_Av3x65s&list=PLZPZq0r_RZOMhCAyywfnYLlrjiVOkdAI1&index=24)
