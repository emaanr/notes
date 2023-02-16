# Data Types

# Table of Contents

- [Data Types](#data-types)
- [Table of Contents](#table-of-contents)
- [Data Types](#data-types-1)
- [Doubles](#doubles)
- [Booleans](#booleans)
- [Chars](#chars)
- [Shorts](#shorts)
- [Integers](#integers)
- [Long Long Integers](#long-long-integers)
- [Source](#source)

# Data Types

| Code                                                | Data Type                  | Size                                           | Format Spec. |
| --------------------------------------------------- | -------------------------- | ---------------------------------------------- | ------------ |
| `char a = 'C';`                                     | Single Character           | 'Signed' by default unless otherwise specified | `%c`         |
| `char b[] = "Emaan";`                               | Array of Characters        | Dependent on number of chars present in array  | `%s`         |
| `float c = 3.141592;`                               | Floating Point Number      | 4 bytes (32 bits of precision) 6 - 7 digits    | `%f`         |
| `double d = 3.141592653589793;`                     | Double                     | 8 bytes (64 bits of precision) 15 - 16 digits  | `%lf`        |
| `bool e = true;`                                    | Boolean                    | 1 byte (true or false)                         | `%d`         |
| `char f = 12;`                                     | Signed Character           | 1 byte (-128 to +127)                          | `%d` or `%c` |
| `unsigned char g = 255;`                            | Unsigned Character         | 1 byte (0 to +255)                             | `%d` or `%c` |
| `short h = 32767;`                                  | Short                      | 2 bytes (-32,768 to +32,767)                   | `%d`         |
| `unsigned short i = 65535;`                         | Unsigned Short             | 2 bytes (0 to +65,535)                         | `%d`         |
| `int j = 2147483647;`                               | Integer                    | 4 bytes (-2,147,483,648 to +2,147,483,647)     | `%d`         |
| `unsigned int k = 4294967295;`                      | Unsigned Integer           | 4 bytes (0 to +4,294,967,295)                  | `%u`         |
| `long long int l = 9223372036854775807;`            | Long Long Integer          | 8 bytes (-9 quintillion to +9 quintillion)     | `%lld`       |
| `unsigned long long int m = 18446744073709551615U;` | Unsigned Long Long Integer | 8 bytes (0 to +18 quintillion)                 | `%llu`       |

# Doubles

- `Doubles` have _double_ the precision of a `Float`.
  - Consider the following demo where `float c` and `double d` are set to the same value:
    ```c
    float c = 3.141592653589793;    // 4 bytes (32 bits of precision) 6 - 7 digits %f
    double d = 3.141592653589793;   // 8 bytes (64 bits of precision) 15 - 16 digits %lf

    printf("%0.15f\n", c);          // Float with 15 digits of precision as denoted by the inclusion of '0.15'
    printf("%0.15lf\n", d);         // Double with 15 digits of precision as denoted by the inclusion of '0.15'
    ```
    ```
    3.141592741012573               // Note that we lose precision with the float's output
    3.141592653589793               // Where as the double's output is the exact same as input
    ```

# Booleans

- To work with `Booleans` in C, use preprocessor `#include <stdbool.h>`.
  - `Booleans` store true or false where 1 represents true and 0 represents false.
  - Techinally only one bit is needed to represent _true or false (1 or 0 respectively)_ but the `Boolean` _object_ is 1 byte in size.
> Aside: Why is `Boolean` a size of 1 byte when only 1 bit is needed to represent true or false?
> > The CPU can't address anything smaller than a byte.
>
> > Historically, a byte was the number of bits used to encode a single character of text in a computer and it is for this reason that it is the basic addressable element in many computer architectures. So _byte_ is the basic addressable unit below which computer architecture cannot address.
> 
> > In general, CPU allocates memory with 1 byte as the basic unit, although some CPU like MIPS use a 4-byte word.
>
> > Most CPU architectures do not let you allocate just 1 bit for a variable. And 1 byte does not have to be 8 bits. The size of a byte is dependant on and contextualized by the particular architecture.
> 
> > Booleans are objects. A bit is not an object in C because:
> > - It is not addressable via pointers. An object is data storage of 1 or more bytes. A byte is the smallest addressable unit of memory.
> > - `sizeof` and `alignof` cannot be applied.
> > - You can still represent your booleans with bits using bit-fields or toggling bits in an integer with bitwise operators.
> >
> > If you want to represent a bunch of booleans, you can use a bit vector. For example you can have an integer variable, that's 4 bytes or 32 bits. You can flip or read individual bits using bitwise operations. So you could treat that integer as 32 booleans if you wanted to. After all it is just 32 0's or 1's. This is beneficial because rather than using 32 bytes of space in memory for 32 Boolean _objects_, you can represent 32 booleans with 4 bytes instead as an integer.
> 
> Source: Stack Overflow

# Chars

- `Chars` are signed by default and can store an integer from the range of -128 to 127 because they are of size 1 byte.
- `Signed Chars` can be output via format specifers `%d` or `%c`.
  - `%d` will output the specified value.
  - `%c` will output the ASCII representation of the value assigned to the variable.
    ```c
    char f = "12";      // 1 byte (-128 to +127) %d or %c
    printf("%d\n", f);  // Char as numeric value
    printf("%c\n", f);  // Char as ASCII character
    ```
    ```
    12
    C
    ```
- `Unsigned Chars` omit negative values from the range, allowing a new set of valid values ranging from 0 to 255
- Effectively doubles the number of valid positive values assignable to the data type compared to `Signed Chars`.
- `Chars` are _not_ unsigned by default, so it is necessary to declare them as such.
- `Unsigned Chars` can also be output via format specifiers `%d` or `%c`.
  - `%d` will output the specified value.
  - `%c` will output the ASCII representation of the value assigned to the variable.
    ```c
    unsigned char g = "255";    // 1 byte (0 to +255) %d or %c
    printf("%d\n", g);          // Unsigned char as numeric value
    printf("%c\n", g);          // Unsigned char as ASCII character

    unsigned char g = "256";    // Assign a value out of range
    printf("%d\n", g);          // Printf for char out of range
    ```
    ```
    255
    x
    0   // Returns 0 as well as a Warning for the value out of range
    ```
- In summary,
  - `Chars` can store more than just a single character.
  - `Chars` can store integers within appropriate ranges for signed and unsigned variants.
  - `Chars` can be displayed as integers using `%d` or can be coverted to an ASCII character using `%c`.

# Shorts

- `Short Ints`, also referred to as `Shorts` use two bytes of memory and also have a signed and unsigned variant following the same convention of being signed by default.
    ```c
    short h = 32767;            // 2 bytes (-32,768 to +32,767) %d
    unsigned short i = 65535;   // 2 bytes (0 to +65,535) %d
    printf("%d\n", h);          // Short
    printf("%d\n", i);          // Unsigned short

    short h = 32768;            // Assign a value out of range
    unsigned short i = 65536;   // Assign a value out of range
    printf("%d\n", h);          // Printf for short out of range
    printf("%d\n", i);          // Printf for unsigned short out of range

    short h = 32769;            // Assign another value out of range
    unsigned short i = 65537;   // Assign another value out of range
    printf("%d\n", h);          // Printf for another short out of range
    printf("%d\n", i);          // Printf for another unsigned short out of range
    ```
    ```
    32767
    65535

    -32,768     // Overflow results in output of value after wrapping to lower bound of range
    0           // Overflow results in output of value after wrapping to lower bound of range

    -32,767     // Overflow results in output of value after wrapping to lower bound of range
    1           // Overflow results in output of value after wrapping to lower bound of range
    ```

# Integers

- `Integers` store whole numbers that can be represented by 4 bytes of memory.
- `Integers` behave similarly to `Shorts` besides two things:
  1. Use 4 bytes rather than 2 bytes.
  2. `Unsigned Integers` have their own format specifier `%u` for "unsigned".
- Standard `Integers` are already considered `Long Integers` by default, so the `Long` is often omitted when declaring `Integers.`

# Long Long Integers

- `Long Long Integers` are double the size of `Integers` and use 8 bytes of memory.
- `Long long Integers` behave like `Integers` besides the fact that they are "longer".
- `Long Long Integers` are signed by default and use format specifier `%lld`.
- `Unsigned Long Long Integers` must be declared as such and use the format specifier `%llu`.

# Source

[BroCode: Data Types](https://www.youtube.com/watch?v=1eyf1-RU_eg&list=PLZPZq0r_RZOOzY_vR4zJM32SqsSInGMwe&index=5)