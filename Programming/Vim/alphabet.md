# Vim Alphabet

    Exploring Vim using the Alphabet.

# Table of Contents

- [Vim Alphabet](#vim-alphabet)
- [Table of Contents](#table-of-contents)
- [General](#general)
- [Quit](#quit)
  - [:q](#q)
  - [:q!](#q-1)
  - [:wq](#wq)
  - [:x](#x)
  - [:help](#help)
  - [:e](#e)
- [A](#a)
  - [a](#a-1)
  - [A](#a-2)
- [B](#b)
  - [b](#b-1)
  - [B](#b-2)
  - [\[count\]](#count)
- [C](#c)
  - [c](#c-1)
  - [cc](#cc)
  - [vc](#vc)
  - [C](#c-2)
- [D](#d)
  - [d](#d-1)
  - [dd](#dd)
  - [vd](#vd)
  - [D](#d-2)
- [E](#e-1)
  - [e](#e-2)
  - [E](#e-3)
  - [\[count\]](#count-1)
- [F](#f)
  - [f](#f-1)
  - [F](#f-2)
  - [\[count\]](#count-2)
- [G](#g)
  - [gg](#gg)
  - [gv](#gv)
  - [G](#g-1)
  - [\[count\]](#count-3)
  - [:\[count\]](#count-4)
- [HJKL](#hjkl)
  - [h](#h)
  - [H](#h-1)
  - [j](#j)
  - [J](#j-1)
  - [k](#k)
  - [l](#l)
  - [L](#l-1)
- [I](#i)
  - [i](#i-1)
  - [I](#i-2)
  - [\[count\]](#count-5)
- [M](#m)
  - [m](#m-1)
  - [:marks](#marks)
  - [\`](#)
  - ['](#-1)
  - [:delmark](#delmark)
  - [:delm](#delm)
  - [:delm!](#delm-1)
  - [m\<\>](#m-2)
  - [M](#m-3)
- [N](#n)
  - [/](#-2)
  - [n](#n-1)
  - [N](#n-2)
- [O](#o)
  - [o](#o-1)
  - [O](#o-2)
- [P](#p)
  - [p](#p-1)
  - [P](#p-2)
- [Q](#q-2)
  - [q](#q-3)
  - [@](#-3)
  - [@@](#-4)
- [R](#r)
  - [r](#r-1)
  - [R](#r-2)
- [S](#s)
  - [s](#s-1)
  - [vs](#vs)
  - [S](#s-2)
- [T](#t)
  - [t](#t-1)
  - [T](#t-2)
  - [\[count\]](#count-6)
- [U](#u)
  - [u](#u-1)
  - [Ctrl + R](#ctrl--r)
  - [U](#u-2)
- [V](#v)
  - [v](#v-1)
  - [V](#v-2)
  - [Ctrl + V](#ctrl--v)
- [W](#w)
  - [w](#w-1)
  - [W](#w-2)
- [X](#x-1)
  - [x](#x-2)
  - [X](#x-3)
  - [\[count\]](#count-7)
- [Y](#y)
  - [y](#y-1)
  - [vy](#vy)
  - [yy](#yy)
  - [Y](#y-2)
- [Z](#z)
  - [z](#z-1)
  - [zt](#zt)
  - [zb](#zb)
  - [zz](#zz)
  - [ZZ](#zz-1)
  - [ZQ](#zq)
  - [Z](#z-2)
- [Source](#source)

# General

- Default mode of Vim editor is `Command/Normal Mode`.
  - Every key on keyboard is a command or macro (movement).
- Hitting `a`, `i`, or `o`, puts us into `Insert Mode`.
  - Entering insert mode with `a` places text after the cursor.
  - Entering insert mode with `A` places text after the end of the line.
  - Entering insert mode with `i` places text before the cursor.
  - Entering insert mode with `I` places cursor at first character of current block.
  - Entering insert mode with `o` opens a line below the cursor.
  - Entering insert mode with `O` opens a line above the cursor.
- `Esc` to exit `Insert Mode` back into `Command/Normal Mode`.
- `$` to jump to the end.
- Use `:set number` to include line numbers and `:set nonumber` to turn line numbers off.

# Quit

    How to QUIT, etcetera.

## :q

- `:q` to "quit".

## :q!

- `q!` required to assert that we want to "quit" without saving (writing) any changes.
- `ZQ` is the same as `:q!`.

## :wq

- `:wq` to "write" and "quit".
- `ZZ` is the same as `:wq`.

## :x

- Like `:wq` but only "write" if changes have been made.
- `ZZ` is the same as `:x`.

## :help

- Alternatively `:h` for shorthand.
- For on-line help.

## :e

- `:e filename` edits a file in a new buffer.

# A

    APPEND text.

- One of the three ways to insert into a document.

## a

- Append means to add after.
- Entering insert mode with lowercase `a` places text after the cursor once in `Insert Mode`.

## A

- Shift `A` appends to the end of a line.

# B

    Move BACK by words.

## b

- Lowercase `b` in `Command/Normal Mode` will move to:
  - The first character of the previous word.
  - To a special character if present.
- Does not consider `_` a special character.
- Considers `-` a special character.

## B

- Shift `B` in `Command/Normal Mode` will skip special characters and only move by word.
- Ignores both `_` and `-`.

## [count]

- Takes a number `[count]` as a prefix to either `b` or `B` to move `[count]` number of words.

# C

    CHANGE text.

> Note `["x]` in the documentation, this indicates a buffer which stores the removed text to be pasted later with `P` if desired.

- Essentially a deleting and insert, in other words, a "change".

## c

- `Command/Normal Mode` command.
- Requires a direction.
- Once a direction is selected, it will delete in that direction and enter `Insert Mode`.
  - `LEFT/RIGHT`:
    - Deletes a character.
  - `UP/DOWN`:
    - Deletes current like and entire line above or below.
- Can be combined with other commands such as `b`.
  - Lowercase `cb` would delete to the beginning of the previous word and then enter `Insert Mode`.

## cc

- Lowercase `cc` deletes entirety of the current line regardless of where you are in the line and then enters `Insert Mode`.

## vc

- Visual selection, allows you to select chunk of text to delete and then enter `Insert Mode`.

## C

- Shift `C` deletes the remainder of the line from whereever the cursor is on the line and then enters `Insert Mode`.

# D

    DELETE.

> Note `["x]` in the documentation, this indicates a buffer which stores the removed text to be pasted later with `P` if desired.

> Another Note is that a "line" is determined by line breaks, not periods and sentences.

- `Command/Normal Mode` command.

## d

- Like `c`, requires a direction.
 Once a direction is selected, it will delete in that direction and enter `Insert Mode`.
  - `LEFT/RIGHT`:
    - Deletes a character.
  - `UP/DOWN`:
    - Deletes current like and entire line above or below.
- Very similar to `c` with the distinction that `c` leaves you in `Insert Mode` and `d` leaves you in `Command/Normal Mode`.

## dd

- Lowercase `dd` deletes entirety of the current line regardless of where you are in the line and leaves you in `Command/Normal Mode`.

## vd

- Visual selection, allows you to select chunk of text to delete and leaves you in `Command/Normal Mode`.

## D

- Shift `D` deletes the remainder of the line from whereever the cursor is on the line and leaves you in `Command/Normal Mode`.
  - A perk of this is that you can hit `u` to undo without having to `Esc` back into `Command/Normal Mode` like you would for shift `C`.

# E

    Move to the END of words.

- `Command/Normal Mode` command.

## e

- Lowercase `e` will move to:
  - The end of the current word if it is in the middle of the current word.
  - The end of the next word.
- Does not honor special characters as part of the word, ignores them.

## E

- Shift `E` will behave similarly to lowercase `e` but it will honor special characters as part of the word.

## [count]

- Takes a number `[count]` as a prefix to either `e` or `E` to move to the end of `[count]` number of words.

# F

    Move to FILL cursor with specified character.

- `Command/Normal Mode` command.

## f

- Lowercase `f` followed by the specified character to fill cursor with in forwards direction.

## F

- Shift `F` followed by the specified character to fill the cursor with in backwards direction.

## [count]

- Takes a number `[count]` as a prefix to either `f` or `F` to fill cursor with `[count]` number of a specified character.

# G

    GO to line (and other stuff, in other words GENERAL).

- Junk drawer of Vim (a lot you can do with it).
- Can be used as a general purpose modifier or prefix for other commands.

## gg

- Lowercase `gg` will take you to the first line in the document.

## gv

- Lowercase `gv` reselects the most recent visual selection. 

## G

- Shift `G` will take you to the last line in the document.

## [count]

- Shift `G` preceded by a `[count]` will go to that line number.

## :[count]

- A `:` followed by the line number, is shorthand to move the cursor to that line.
  - Example `:25` would move the cursor to line 25.

# HJKL

    Moving LEFT, DOWN, UP, RIGHT.

- `Command/Normal Mode` commands.

## h

- Lowercase `h` to move left.

## H

- Shift `H` to move cursor to header (top) line of current visible window.

## j

- Lowercase `j` to move down.

## J

- Shift `J` joins the current line to next line.

## k

- Lowercase `k` to move up.

## l

- Lowercase `l` to move right.

## L

- Shift `L` to move cursor to last line of current visible window.

# I

    INSERT.

- One of the three ways to insert into a document.

## i

- Lowercase `i` enters `Insert Mode` such that user input goes before the cursor.

## I

- Shift `I` enters `Insert Mode` at first character of current line/block (?).

## [count]

- Precede `i` with some `[count]` value so that when `Insert Mode` is exited, the inserted text repeats `[count]` number of times.

# M

    MARK buffers.

- A mark is a hidden marker in the file that allows us to go back to that place at any point.
- Marks set with alphabetic characters.

## m

- Lowercase `m` followed by any alphabetic character sets a mark.

## :marks

- Marks can be made visible using `:marks`.

## `

- Backtick `` ` `` followed by the alphabetic character associate with a mark will take us back to that mark.

## '

- Singlequote `'` followed by the alphabetic character associated with a mark will take us back to the start of the line that has the mark on it.

## :delmark

- Use `:delmark` followed by alphabetic character to delete that designated marker.

## :delm

- Shorthand for `:delmark`.

## :delm!

- Delete all markers using `:delm!`.

## m<>

- Use `m<` and `m>` to contain some text in the document to select and manipulate later using something like `gv`.

## M

- Shift `M` moves cursor to middle line of current visible window.

# N

    NEXT result in search.

## /

- Forwardslash `/` followed by the text you are searching for.

## n

- Once a search has been designated by forwardslash `/`, use `n` to continue looking for other instances of that designation in the forwards direction.

## N

- Once a search has been designated by forwardslash `/`, use shift `N` to continue looking for other instances of that designation in the forwards direction.

# O

    INSERT.

- One of the three ways to insert into a document.

## o

- Lowercase `o` inserts line below current line and enters `Insert Mode`.

## O

- Shift `O` inserts line above current line and enters `Insert Mode`.

# P

    PUT.

## p

- Lowercase `p` put yanked text below current line.

## P

- Shift `P` puts yanked text above current line.

# Q

    REQORD.

## q

- Lowercase `q` needs to be followed by a number or alphabetical character to map the recorded macro to, once macro is input, enter `q` to cease recording.

## @

- Use `@` followed by the character a macro was recorded to in order to play the macro.

## @@

- Use `@@` shortcut to play the most recently played macro again.

# R

    REPLACE.

## r

- Lowercase `r` followed by the character we want to replace with will replace the character at our cursor while still in `Command/Normal Mode`.

## R

- Shift `R` to enter `Replace Mode` which differs from `Insert Mode` because unlike `Insert Mode` it retains previous text when backspacing.

# S

    SUBSTITUTE.

## s

- Lowercase `s` deletes the character under the cursor and enters `Insert Mode`.
  - Somewhat of an alias for `cl` which is change to the right.

## vs

- Can use visual selection with `s` as well.
  - Example being `v`, then `e` then `s`.

## S

- Shift `S` deletes the entire line and enters `Insert Mode`.
  - Somewhat of an alias for `cc`.

# T

    Move 'TIL a character.

- Similar to `f`.

## t

- Lowercase `t` followed by a character will take the cursor to right before that character in the forwards direction.

## T

- Shift `T` followed by a character will take the cursor to right after that character in the backwards direction.

## [count]

- Preceding either `t` or `T` with some `[count]` value will take the cursor to right before the `[count]` instance of that character.

# U

    UNDO.

## u

- Lowercase `u` undos a change.

## Ctrl + R

- `Ctrl + R` redos a change.

## U

- Shift `U` will undo all the changes on a line.

# V

    Select VISUALLY.

## v

- Lowercase `v` will take us into `Visual Mode` after which we can use movement keys to make a visual selection.

## V

- Shift `V` will enter `Visual Mode` and do line wise visual selections.

## Ctrl + V

- `Ctrl + R` will enter `Visual Mode` and allows visual block selection that allows selection to go accross lines.

# W

    Move forward WORDS.

## w

- Lowercase `w` will take cursor to the beginning of the next word and considers special characters.

## W

- Shift `W` takes cursor to the beginning of the next word and does not consider special characters.

# X

    DELETE.

- `x` and `X` behave like delete and backspace respectively but in `Command/Normal Mode`, that is, without entering `Insert Mode`.

## x

- Lowercase `x` deletes the character under the cursor with text shifting back into the cursor.

## X

- Shift `X` behaves like a traditional backspace.

## [count]

- Takes a `[count]` prefix that designates deletions and backspaces of `[count]` size.

# Y

    YANK (copy).

## y

- Lowercase `y` can be used with a motion and other commands.

## vy

- Can be used with visual selection as well.
  - Example is `v`, followed by `e`, followed by `y`, followed by `p`.

## yy

- Lowercase `yy` will copy an entire line.

## Y

- Shift `Y` will copy an entire line, which is the same behavior as `yy`, that is, `Y` is an alias for `yy`.

# Z

    All the thingZ.

## z

- Lowercase `z` allows us to redraw the document with the cursor in a certain place.

## zt

- Lowercase `zt` moves the cursor to the top along with the text it is on.
  
## zb

- Lowercase, `zb` moves the cursor to th the bottom along with the text it is on.

## zz

- Lowercase `zz` moves the cursor to the center of the window along with the text it is on.
  
## ZZ

- Shift `ZZ` is an alias for `:wq`.

## ZQ

- Shift `ZQ` is an alias for `:q!`.

## Z

- Shift `Z`

# Source

[Chantastic: VIM ALPHABET](https://www.youtube.com/playlist?list=PLnc_NxpmOxaNqdGvUg8RBi8ZTaZGPdqBD)