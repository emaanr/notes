# Starting Out

# Table of Contents

- [Starting Out](#starting-out)
- [Table of Contents](#table-of-contents)
- [Ready, set, go!](#ready-set-go)
- [Simple Arithmetic](#simple-arithmetic)
- [Boolean Algebra](#boolean-algebra)
- [Testing for Equality](#testing-for-equality)
- [Infix Functions](#infix-functions)
- [Prefix Functions](#prefix-functions)
- [First Functions](#first-functions)
- [If-then-else](#if-then-else)
- [Function naming](#function-naming)
- [An intro to lists](#an-intro-to-lists)
- [List Functions](#list-functions)
- [Source](#source)

# Ready, set, go!

    Open your terminal and type in ghci.

# Simple Arithmetic

- Follows order of operations (PEMDAS).

    ```haskell
    ghci> 2 + 15  
    17

    ghci> 49 * 100  
    4900

    ghci> 1892 - 1472  
    420

    ghci> 5 / 2  
    2.5

    ghci> (50 * 100) - 4999  
    1

    ghci> 50 * 100 - 4999  
    1

    ghci> 50 * (100 - 4999)  
    -244950

    ghci> 5 + 12 - (6-2) * 2
    9

    -- Note that Haskell requires parens around negative numbers when performing operations
    ghci > 5 * -3
    <interactive>:5:1: error:
    Precedence parsing error
        cannot mix ‘*’ [infixl 7] and prefix `-' [infixl 6] in the same infix expression

    -- And now it works
    ghci > 5 * (-3)
    -15
    ```

# Boolean Algebra

- This is pretty standard, something to note is the use of *"not"* rather than *"!"* for negation.

    ```haskell
    ghci> True && False
    False

    ghci> True && True
    True

    ghci> False || True
    True

    ghci> not False
    True

    ghci> not (True && True)
    False
    ```

# Testing for Equality

- Similarly, something to note is the use of "/=" rather than "!=" for *not equals*.

    ```haskell
    ghci> 5 == 5
    True

    ghci> 1 == 0
    False

    -- "/=" is "not equals: !=" for Haskell
    ghci> 5 /= 5
    False

    ghci> 5 /= 4
    True

    ghci> "hello" == "hello"
    True
    ```

# Infix Functions

- Functions that are inbetween the affected such as `*`.
- If a function takes two parameters, we can also call it as an infix function by surrounding it with backticks.
- **Example:** The `div` function which performs the integral division on two integer parameters.
  
  ```haskell
  -- When we call div like this, there may be some confusion as to which number is doing the division and which one is being divided
  ghci> div 92 10
  9

  -- We can call it as an infix function to make the code more intuitive and therefore more readable
  ghci 92 `div` 10
  9
  ```

# Prefix Functions

- Functions that are preceding the affected.
- In most imperative languages, functions are called by writing the function name and then writing its (usually comma separated) parameters in parens.
- However, in Haskell, functions are called by writing the function name following by space separated parameters with no commas.

  ```haskell
  -- Takes anything that has a defined successor and returns that successor
  ghci> succ 8
  9

  -- Returns the lesser of two values
  ghci> min 9 10
  9

  -- Returns the lesser of two values
  ghci> min 3.4 3.2
  3.2

  -- Returns the greater of two values
  ghci> max 100 101
  101
  ```
- Function application (calling a function by putting a space after it and then typing out the parameters) has the highest precedence of them all. What that means is that these two statements are equivalent:

  ```haskell
  ghci> succ 9 + max 5 4 + 1
  16

  ghci> (succ 9) + (max 5 4) + 1
  16
  ```
- However, if we wanted to get the successor of the product of numbers 9 and 10, we couldn't write `succ 9 * 10` because that would get the successor of 9, which would then be multiplied by 10 resulting in 100. We'd have to write `succ (9 * 10)` to get 91.
- **Comparison**: Function `bar(int i)` versus `bar i`.
  - **Imperative**: Lots of people who come from imperative languages tend to stick to the notion that parens should denote function application such as `bar(int i)` which takes an integer as a parameter.
    - Haskell's `bar(bar 3)` would be `bar(bar(3))` in an imperative language like C.
  - **Haskell**: However, in Haskell, spaces are used for function application resulting in a function that looks like this `bar i`. Note that we do not assign a type to `i` because Haskell is statically typed.
    - In Haskell, `bar(bar 3)` does not mean that `bar` is being called with `bar` and `3` as parameters, but rather `bar` is being called on the result of `bar 3`.

# First Functions

- Getting started:
  - Create Haskell Script file named anything.
  - Include the function `doubleMe x = x + x`.
    - Functions are defined in a similar way that they are called. The function name is followed by parameters seperated by spaces. But when defining functions, there's a `=` after which the behavior of the function is defined.
    - Note that the `=` acts as a *return* in Haskell.
  - Navigate to location of the Haskell Script file and run ghci.
  - One inside GHCi, do `:l <file>` without the file extension.
  - Now that the script is loaded we can utilize the function we defined earlier:

    ```haskell
    ghci> :l filename
    [1 of 1] Compiling Main             ( filename.hs, interpreted )
    Ok, modules loaded: Main.

    ghci> doubleMe 9
    18

    ghci> doubleMe 8.3
    16.6
    ```
  - We can define a function during this instance of the GHCi:

    ```haskell
    -- Define function
    doubleUs x y = x*2 + y*2

    -- Calling the function
    ghci> doubleUs 4 9
    26

    -- Note that it works with integers as well as floats due to the staticly typed nature of Haskell
    ghci> doubleUs 2.3 34.2
    73.0

    ghci> doubleUs 28 88 + doubleMe 123
    478
    ```
  - You can call your own functions from other functions that you made. With that in mind, we could redefine doubleUs like this:

    ```haskell
    doubleUs x y = doubleMe x + doubleMe y
    ```
  - Functions in Haskell don't have to be in any particular order, so it doesn't matter if you define doubleMe first and then doubleUs or if you do it the other way around.
  - This is a very simple example of a common pattern you will see throughout Haskell.
    - Making basic functions that are obviously correct and then combining them into more complex functions, which reduces code redundancy.

# If-then-else

| Imperative                                   | Functional                                       |
| -------------------------------------------- | -------------------------------------------------|
| `If` statements not necessarily expressions  | `If` statements in Haskell are expressions       |
| `else` *not* mandatory                       | `else` *mandatory*                               |
| Skip code if condition not satisfied         | Every expression & function must return something|

- An expression is a piece of code that returns a value.
  - `5` is an expression because it returns 5.
  - `4 + 8` is an expression.
  - `x + y` is an expression because it returns the sum of x and y.
- Because the `else` is mandatory in Haskell, an `if` statement will always return something and that is why it is an expression.

# Function naming

- Conventionally use `'` to either
  1. Denote a strict version of a function (one that isn't lazy).
  2. A slightly modified version of a function or a variable.
- Because ' is a valid character in functions, we can make a function like this:

    ```haskell
    galarianFarfetch'd = "A wild Farfetch'd appeared !"   
    ```
  - There are two noteworthy points to address:
    1. Functions cannot begin with capital letters.
    2. When a function does not take any parameters, it is called a *definition* or a *name*.
       - Because we can't change names or functions once we define them, `galarianFarfetch'd` and "A wild Farfetch'd appeared !" can be used interchangeably.

> Note: We can use the `let` keyword to define a name right in GHCi. Doing `let a = 1` inside GHCi is the equivalent of writing `a = 1` in a script and then loading it.

# An intro to lists

- Overview:
  - Basics of lists
  - Strings (which are lists)
  - List comprehensions

---
- In Haskell, list are *homogenous* data structures, meaning they are comprised of elements of the same time *only*.
- Lists are represented as comma separated elements contained in [] brackets like so:

    ```haskell
    ghci> let numbers = [4,8,15,16,23,42]
    ghci> numbers
    [4,8,15,16,23,42]
    ```
---
- Strings are just lists of characters.
  - The double quoted string representation `"hello"` is syntactic sugar for `['h', 'e', 'l'. 'l', 'o']` where a character, char,  is denoted by single quotes: `'c'`.
  - List functions can be used on strings since they are lists.
  - A common task is combining two lists using the `++` operator.
    > Note that `++` is normally shorthand for "increment by 1" in some other languages.
    
    ```haskell
    ghci> [1,2,3,4] ++ [9,10,11,12]
    [1,2,3,4,9,10,11,12]

    ghci> "hello" ++ " " ++ "world"
    "hello world"

    ghci> ['m','a','g','n','e','t'] ++ ['f','r','o','g']
    "magnetfrog"
    ```
---
- **Watch out** when repeatedly using the `++` operator on long strings.
  - When you put together two lists (even if you append a singleton list to a list, for instance: `[1,2] ++ [4]`), internally, Haskell has to walk through the whole list on the left side of `++`.
    - That's not a problem when dealing with lists that aren't too big. But putting something at the end of a list that's fifty million entries long is going to take a while.
- However, putting something at the beginning of a list using the `:` operator (also called the *cons operator*) is instantaneous.

    ```haskell
    ghci> 'SONIC':" THE HEDGEHOG"
    "SONIC THE HEDGEHOG"

    ghci> 5:[1,2,3,4,5]
    [5,1,2,3,4,5]
    ```

- `:` Takes a number and a list of numbers *or* a character and a list of characters.
- `++` takes two lists.
  - Even if you're adding an element to the end of a list with `++`, you have to surround it with square brackets so it becomes a list.
- `[1,2,3]` is actually just syntactic sugar for `1:2:3:[]`.
  - `[]` is an empty list.
  - If we prepend 2 to it, it becomes `[2]`. If we prepend 1 to that, it becomes `[1,2]`, if we append 3 to it, it becomes `[1, 2, 3]`.

    > Note: `[]`, `[[]]` and `[[],[],[]]` are all different things.
    > - The first one `[]` is an empty list.
    > - The seconds one `[[]]` is a list that contains one empty list.
    > - The third one `[[],[],[]]` is a list that contains three empty lists.

---

- List indices in Haskell start at 0.
- If you want to get an element out of a list by index, use `!!`.

    ```haskell
    ghci> "Emaan Rana" !! 6
    'R' -- Indices start at 0

    ghci> [9.4,33.2,96.2,11.2,23.25] !! 1
    33.2
    ```
- Lists can also contain lists that contain lists that contain lists ...
- The lists within a list can be of different lengths but *not* of different types.

    ```haskell
    -- Define function b
    ghci> let b = [[1,2,3,4],[5,3,3,3],[1,2,2,3,4],[1,2,3]]
    ghci> b
    [[1,2,3,4],[5,3,3,3],[1,2,2,3,4],[1,2,3]]

    -- Append a list of size one with one list element in it at index zero into function b
    -- Notice the additional square brackets [] for the ++ operator
    ghci> b ++ [[1,1,1,1]]
    [[1,2,3,4],[5,3,3,3],[1,2,2,3,4],[1,2,3],[1,1,1,1]]

    -- Prepend one list element at index zero into function b
    -- Notice we only have one layer of square brackets around list for the : (cons) operator
    ghci> [6,6,6]:b
    [[6,6,6],[1,2,3,4],[5,3,3,3],[1,2,2,3,4],[1,2,3]]

    ghci> b !! 2
    [1,2,2,3,4]
    ```
---
- Lists can be compared if the stuff they contain can be compared.
- When using <, <=, > and >= to compare lists, they are compared in lexicographical order
  - First the heads are compared, if they are equal then the second elements are compared, etc.

    ```haskell
    ghci> [3,2,1] > [2,1,0]
    True

    ghci> [3,2,1] > [2,10,100]
    True

    ghci> [3,4,2] > [3,4]
    True

    ghci> [3,4,2] > [2,4]
    True

    ghci> [3,4,2] == [3,4,2]
    True
    ```
# List Functions

# Source

[Learn You A Haskell: Starting Out](http://learnyouahaskell.com/starting-out)