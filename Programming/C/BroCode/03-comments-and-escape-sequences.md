# Comments and Escape Sequences

# Table of Contents

- [Comments and Escape Sequences](#comments-and-escape-sequences)
- [Table of Contents](#table-of-contents)
- [Comments](#comments)
- [Escape Sequences](#escape-sequences)
- [Newline](#newline)
- [Tab](#tab)
- [Newline \& Tab](#newline--tab)
- [Double Quotes](#double-quotes)
- [Single Quotes](#single-quotes)
- [Backslash](#backslash)
- [Source](#source)

# Comments

- Some text that is ignored by the compiler that is used as an explanation, description, or note for yourself or anyone else reading the associated code.
- Comments in C are denoted by two forward slashes.
    ```
    //  This is a comment in C
    ```
- Multi-Line Comments can be achieved using forward slashes and asterisks.
    ```
    /* 
        This is a multi-line comment in C
    */
    ```

# Escape Sequences

- A character combination consisting of a backslash `\` followed by a letter or combination of digits.
- Specify actions within a line of text or string of text.
  - **Examples:**
    - `\n` is newline.
    - `\t` is tab.
- Appears directly before certain characters in a string in order to display them as output.
  - **Examples:**
    - `\"` outputs `"`.
    - `\'` outputs `'`.
    - `\\` outputs `\`.
      - Note that `\\` outside of a string denotes single line comments in C.

# Newline

```c
#include <stdio.h>

int main() {

    printf("Hello\nWorld.");
    return 0;
}
```
```c
Hello
World.
```

# Tab

```c
#include <stdio.h>

int main() {

    printf("1\t2\t3");
    return 0;
}
```
```c
1   2   3
```

# Newline & Tab

```c
#include <stdio.h>

int main() {

    printf("1\t2\t3\n4\t5\t6\n7\t8\t9");
    return 0;
}
```
```c
1   2   3
4   5   6
7   8   9
```

# Double Quotes

What if double quotes `"` need to be displayed?
```c
#include <stdio.h>

int main() {

    printf("\"Simple and Clean\" - Utada Hikaru");
    return 0;
}
```
```
"Simple and Clean" - Utada Hikaru
```

# Single Quotes

What if single quotes `'` need to be displayed?
```c
#include <stdio.h>

int main() {

    printf("\'Simple and Clean\' - Utada Hikaru");
    return 0;
}
```
```
'Simple and Clean' - Utada Hikaru
```

# Backslash

What if backlash `\` needs to be displayed?
```c
#include <stdio.h>

int main() {

    printf("\\Simple and Clean\\ - Utada Hikaru");
    return 0;
}
```
```
\Simple and Clean\ - Utada Hikaru
```

# Source

[BroCode: Comments and Escape Sequences](https://www.youtube.com/watch?v=8Vt9k0bh_Q8&list=PLZPZq0r_RZOOzY_vR4zJM32SqsSInGMwe&index=3)