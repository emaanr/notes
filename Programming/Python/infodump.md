# Infodump

    Temp file to dump info and notes until I decide how I wanna organize things.

# Todo

- Add more examples to [Datatypes: Get/Set](#datatypes) from this site [here](https://www.w3schools.com/python/python_datatypes.asp)
- Take notes on [here](https://realpython.com/python-modules-packages/) for [Packages vs Modules](#packages-vs-modules) and link your own notes instead.

# Table of Contents

- [Infodump](#infodump)
- [Todo](#todo)
- [Table of Contents](#table-of-contents)
- [Variables \& Datatypes](#variables--datatypes)
  - [Datatypes](#datatypes)
    - [Get](#get)
    - [Set](#set)
    - [Cast](#cast)
      - [Typecasting](#typecasting)
        - [Explicit](#explicit)
        - [Implicit](#implicit)
  - [Variables](#variables)
  - [Declaring](#declaring)
    - [Way 1](#way-1)
    - [Way 2](#way-2)
    - [Way 3](#way-3)
- [Printing](#printing)
  - [`print()`](#print)
    - [Strings](#strings)
    - [Variables](#variables-1)
    - [String Concatenation](#string-concatenation)
      - [`+`](#)
      - [`,`](#-1)
        - [Another Example](#another-example)
      - [TypeError](#typeerror)
        - [Incorrect](#incorrect)
        - [Correct](#correct)
  - [f-Strings](#f-strings)
- [User Input](#user-input)
  - [`input()`](#input)
- [Math](#math)
  - [Arithmetic Operations](#arithmetic-operations)
    - [Augmented Operations](#augmented-operations)
      - [`+=`](#-2)
      - [`-=`](#-)
      - [`*=`](#-3)
      - [`/=`](#-4)
      - [`//=`](#-5)
      - [`%=`](#-6)
      - [`**=`](#-7)
  - [Built-In Functions](#built-in-functions)
    - [`round(number, decimal)`](#roundnumber-decimal)
    - [`abs(n)`](#absn)
    - [`pow(x, y, z)`](#powx-y-z)
    - [`max(iterable)`](#maxiterable)
      - [TypeError](#typeerror-1)
    - [`min(iterable)`](#miniterable)
      - [TypeError](#typeerror-2)
  - [Math Module](#math-module)
    - [Constants](#constants)
      - [`math.pi`](#mathpi)
      - [`math.e`](#mathe)
    - [Functions](#functions)
      - [`math.ceil(x)`](#mathceilx)
      - [`math.floor(x)`](#mathfloorx)
- [Packages vs Modules](#packages-vs-modules)
- [Iterable](#iterable)

# Variables & Datatypes

Python is a dynamically-typed language where the interpreter assigns variables a data type at runtime based on the variable's value at the time.

- This means we do not need to declare the variable type in Python, it is intuited by the interpretor at run-time.

## Datatypes

Python has the following data types built-in by default, in these categories:

- Text Type:
  - `str`
- Numeric Types:
  - `int`
  - `float`
  - `complex`
- Sequence Types:
  - `list`
  - `tuple`
  - `range`
- Mapping Type:
  - `dict`
- Set Types:
  - `set`
  - `frozenset`
- Boolean Type:
  - `bool`
- Binary Types:
  - `bytes`
  - `bytearray`
  - `memoryview`
- None Type:
  - `NoneType`

### Get

```python
x = 25
print(type(x))
```
```
<class 'int'>
```
- The `type()` function will return the datatype of its argument.

### Set

```python
x = 25
```
- Setting a variable `x` of type `int` to `25`.

### Cast

```python
x = int(25)
```

- Explicitly setting the specific type of variable using the `int()` constructor function.

#### Typecasting

The process of converting a value of one data type to another data type:

- E.g:
  - String
  - Integer
  - Float
  - Boolean
  - Etc.

##### Explicit

```python
x = int(25.0)
print(type(x))
```
```
<class 'int'>
```
- Variable `x` is originally a float, but is explicit cast to an int.

##### Implicit

```python
x = 25
print(type(x))
y = 25.0
print(type(y))
x = x / y
print(type(x))
```
```
<class 'int'>
<class 'float'>
<class 'float'>
```

- A value or variable is converted to a different data type automatically.
- Variable `x` becomes implicitly casted to a float due to the division operation with `y` which is a float.

## Variables

Recall that a variable is a reusable container for storing a value and behaves as if it were the value it contains.

## Declaring

There are various ways to declare variables that may be beneficial given a particular use case.

### Way 1

```python
x = 1
y = True
z = "Three"
```
- Simplest way to declare a variable.
- Can be good to:
  - Separate the declarations of unrelated variables.
  - Declare certain variables closer to the blocks of code that use them.

### Way 2

```python
x, y, z = 1, True, "Three"
```
- Can declare variables on one line like this regardless of the data type.
- Can be beneficial if:
  - Variables are related somehow.
  - It's more convenient to declare in one place for the particular program being written.

### Way 3

```python
x = y = z = 0
```

- Beneficial if all the variables need to be initialized to the same value.
  - Especially true if they represent similar ideas within the context of the program.
  - Might become confusing if the variables represnt different things, depending on the program.

# Printing

We can print using:

1. `print()`
2. f-Strings

## `print()`

The `print()` function is one way to print to console in Python.

### Strings

```python
print("Message")
print('Message')
```
```
Message
Message
```

- If argument is a String:
  - Surround string with either single `''` or double `""` quotes.

### Variables

```python
integer = 25
print(integer)

string = "String"
print(string)
```
```
25
String
```

- If argument is a Variable:
  - We can simply pass the name of the variable as the argument to print.

### String Concatenation

- String concatenation can be done using `+` or `,` within `()`.

#### `+`

```python
name = "Emaan Rana"
print("My name is " + name + "!")
```
```
My name is Emaan Rana!
```
#### `,`

```python
name = "Emaan Rana"
print("My name is", name, "!")
```
```
My name is Emaan Rana !
```

- Note that this may not be possible in older versions of python like Python2.
- Additionally, note that using commas will automatically insert a space.

##### Another Example

```python
age = 23
print("I am", 23, "years old!")
```
```
I am 23 years old!
```

- Note that this is another way to handle the TypeError issue discussed directly below this.

#### TypeError

- If we want to concatenate a string, type `str`, and a variable that is not type `str`, we would need to cast the other, non-`str` variable to a `str` using `str(<non-str var>)`.

##### Incorrect

```python
integer = 25
string = "My favorite number is: "

print(string + integer)
```
```
TypeError: Can only concatenate str (not "int") to a str.
```

##### Correct

```python
integer = 25
string = "My favorite number is: "

print(string + str(integer))
```
```
My favorite number is 25
```
- We can cast the type `int` variable called `integer` to a `str` using `str(integer)`.

## f-Strings

Read as "format strings", f-Strings are another way to print in Python.

- Similar to using format specifiers in other languages.
- Denote location of variable using `{}` notation within the string and include the name of the variable in it like so: `{<var>}`.

```python
age = 23
print(f"I am {age} years old!")
```
```
I am 23 years old!
```

# User Input

  We can accept user input using the `input()` function in Python.

## `input()`

```python
input()
```

- Grants terminal access/control to user to provide input until user hits `enter` at which point the function will terminate.

```python
user_input = input("Accept some user input: ") # Store in variable
print(user_input) # Print variable to confirm assignment
```
```
Accept some user input: Hello World!
Hello World!
```

- Need to store return of function in a variable to actually accesss it.

# Math

Math in Python:

1. Arithmetic Operations
2. Built-In Functions
3. Math Module

## Arithmetic Operations

Python can perform the same basic arithmetic operations as any other language including augmented operations.

| Operator | Operation      | Example       |
| :------: | -------------- | ------------- |
|     +    | Addition       | `2 + 5 = 7`   |
|     -    | Subtraction    | `4 - 2 = 2`   |
|     *    | Multiplication | `2 * 3 = 6`   |
|     /    | Division       | `5 / 2 = 2.5` |
|    //    | Floor Division | `5 // 2 = 2`  |
|     %    | Modulo         | `5 % 2 = 1`   |
|    **    | Power          | `4 ** 2 = 16` |

### Augmented Operations

- Recall that some augmented operations include `+=`, `-=`, `*=`, `/=`, `//=` `%=` and `**=`.

#### `+=`

```python
num = 2
num += 5
print(num) # 7
```
```
7
```

#### `-=`

```python
num = 4
num -= 2
print(num) # 2
```
```
2
```

#### `*=`

```python
num = 2
num *= 3
print(num) # 6
```
```
6
```

#### `/=`

```python
num = 5
num /= 2
print(num) # 2.5
```
```
2.5
```

#### `//=`

```python
num = 5
num //= 2
print(num) # 2
```
```
2
```

#### `%=`

```python
num = 5
num %= 2
print(num) # 1
```
```
1
```

#### `**=`

```python
num = 4
num **= 2
print(num) # 16
```
```
16
```

## Built-In Functions

Built-In functions do not require explicit import of external modules or packages.
 
1. `round()`
2. `abs()`
3. `pow()`
4. `max()`
5. `min()`

A list of more built-ins can be found [here](https://www.w3schools.com/python/python_ref_functions.asp).

### `round(number, decimal)`

```python
result = round(3.1415)
print(result)

result = round(3.1415, 2)
print(result)
```
```
3
3.14
```

- The `round()` function returns a floating point `number` rounded to some number of `decimal` places.
- The default number of `decimal` is 0, meaning that the function will return the nearest integer.

### `abs(n)`

```python
result = abs(-25)
print(result)
```
```
25
```

- The `abs()` functions returns the absolute value of the numerical argument passed to it.

### `pow(x, y, z)`

```python
result = pow(4, 3)
print(result)

result = pow(4, 3, 5)
print(result)
```
```
64
4
```

- Returns `x` to the power of `y` with an optional modulus operation of `z`.
  - That is, `pow(4, 3, 5)` is the same as `(4 * 4 * 4) % 5`.

### `max(iterable)`

```python
result = max(10, 31, 99)
print(result)

result = max('Emaan', 'Ben', 'Aki')
print(result)
```
```
99
Emaan
```

- The `max()` function can return:
  - The element with the highest value.
  - The element with the highest value in an iterable.
- If the values are strings, an alphabetical comparison is done.

#### TypeError

```
TypeError: 'int' object is not iterable
```

- Note that `max(n)` where `n` is a singular `int` datatype will return a TypeError.

### `min(iterable)`

```python
result = min(10, 31, 99)
print(result)

result = min('Emaan', 'Ben', 'Aki')
print(result)
```
```
10
Aki
```

- The `min()` function can return:
  - The element with the lowest value.
  - The element with the lowest value in an iterable.
- If the values are strings, an alphabetical comparison is done.

#### TypeError

```
TypeError: 'int' object is not iterable
```

- Note that `min(n)` where `n` is a singular `int` datatype will return a TypeError.

## Math Module

The `math` module contains some useful functions and constants that can be used by including `import math` at the top of a Python file.

### Constants

- Some useful constants:

  1. `math.pi`
  2. `math.e`

#### `math.pi`

```python
# Import math library
import math

# Print the value of pi
print (math.pi)
```
```
3.141592653589793
```

- Constant `math.pi` returns a float representing the value of pi.

#### `math.e`

```python
# Import math library
import math

# Print the value of e
print (math.e)
```
```
2.718281828459045
```

- Constant `math.e` returns a float representing the value of e.


### Functions

- Some useful functions:

  1. `math.ceil()`
  2. `math.floor()`

#### `math.ceil(x)`

```python
# Import math library
import math

# Round a number upward to its nearest integer
print(math.ceil(3.1))
print(math.ceil(1.9))
print(math.ceil(-1.9))
print(math.ceil(9.9))
print(math.ceil(10.0))
```
```
4
2
-1
10
10
```

- The `math.ceil()` method rounds a required numerical parameter, denoted by `x`, **UP** to the nearest integer, if necessary, and returns the result.

#### `math.floor(x)`

```python
# Import math library
import math

# Round numbers down to the nearest integer
print(math.floor(0.6))
print(math.floor(3.1))
print(math.floor(1.9))
print(math.floor(-1.9))
print(math.floor(9.9))
print(math.floor(10.0))
```
```
0
3
1
-2
9
10
```

- The `math.floor()` method rounds a required numerical parameter, denoted by `x`, **DOWN** to the nearest integer, if necessary, and returns the result.

# Packages vs Modules

- Any Python file is a [*module*](https://docs.python.org/3/tutorial/modules.html), its name being the file's base name without the `.py` extension.
- A [*package*](https://docs.python.org/3/tutorial/modules.html#packages) is a collection of Python modules.
  - While a module is a single Python file, a package is a directory of Python modules containing an additional `__init__.py` file, to distinguish a package from a directory that just happens to contain a bunch of Python scripts.
  - Packages can be nested to any depth, provided that the corresponding directories contain their own `__init__.py file.`
- The distinction between module and package seems to hold just at the file system level.
  - When you import a module or a package, the corresponding object created by Python is always of type module.
  - Note, however, when you import a package, only variables/functions/classes in the `__init__.py` file of that package are directly visible, not sub-packages or modules.
- More information can be found [here](https://realpython.com/python-modules-packages/).

# Iterable

- Iterable is an object which can be looped over or iterated over with the help of a for loop.
- Some objects that are considered iterables include:
  - Lists
  - Tuples
  - Sets
  - Dictionaries
  - Strings
  - Etc.
- In short and simpler terms, iterable is anything that you can loop over.