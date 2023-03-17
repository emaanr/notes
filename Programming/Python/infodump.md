# Infodump

    Temp file to dump info and notes until I decide how I wanna organize things.

# Table of Contents

- [Infodump](#infodump)
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

# Variables & Datatypes

- Python is a dynamically-typed language where the interpreter assigns variables a data type at runtime based on the variable's value at the time.
  - This means we do not need to declare the variable type in Python, it is intuited by the interpretor at run-time.

## Datatypes

- Python has the following data types built-in by default, in these categories:
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

- The process of converting a value of one data type to another data type:
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

- A value or variable is converted to a different data type automatically.

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
- Variable `x` becomes implicitly casted to a float due to the division operation with `y` which is a float.

## Variables

- Recall that a variable is a reusable container for storing a value.
- A variable behaves as if it were the value it contains.

## Declaring

- There are various ways to declare variables that may be beneficial given a particular use case.

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

- We can print using:
  1. `print()`
  2. f-Strings

## `print()`

- The `print()` function is one way to print to console in Python.

### Strings

- If argument is a String:
  - Surround string with either single `''` or double `""` quotes.

```python
print("Message")
print('Message')
```
```
Message
Message
```
### Variables

- If argument is a Variable:
  - We can simply pass the name of the variable as the argument to print.

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

- Read as "format strings", f-Strings are another way to print in Python.
  - Similar to using format specifiers in other languages.
  - Denote location of variable using `{}` notation within the string and include the name of the variable in it like so: `{<var>}`.

```python
age = 23
print(f"I am {age} years old!")
```
```
I am 23 years old!
```



