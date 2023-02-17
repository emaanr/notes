# Unicode

    January 24, 2023

# Table of Contents

- [Unicode](#unicode)
- [Table of Contents](#table-of-contents)
- [Shell](#shell)
  - [I/O](#io)
    - [Input](#input)
- [Digital Information](#digital-information)
  - [Endianness Concern](#endianness-concern)
- [Characters](#characters)
  - [Fixed-Length Encoding](#fixed-length-encoding)
  - [Variable-Length Encoding](#variable-length-encoding)
- [Character Sets](#character-sets)
  - [Past](#past)
  - [Now](#now)
- [Unicode](#unicode-1)
  - [Example](#example)
  - [UTF](#utf)
    - [BOM](#bom)
    - [UTF-32](#utf-32)
      - [Advantages](#advantages)
      - [Disadvantages](#disadvantages)
    - [UTF-16](#utf-16)
      - [Disadvantages](#disadvantages-1)
    - [UTF-8](#utf-8)
      - [Advantages](#advantages-1)
      - [Disadvantages](#disadvantages-2)
- [Outro](#outro)
- [Source](#source)


# Shell

- A user process that runs and allows the user to interface with the kernel.
  - Acts as a mediator for the user space and the kernel space to "talk".
  - Will make syscalls to talk to the kernel space.
  - Runs other processess.

## I/O

- I/O is shorthand for "Input/Output".

### Input

- Typically some "text"-ual information from the user.
- Represented by Unicode.

# Digital Information

- Binary is bits representing 1's and 0's.
- Bytes have 8 bits and are the unit of information used in digital space.
  - Decimal System: `0` $\rightarrow$ `255`.
  - Hexadecimal System: `0x00` $\rightarrow$ `0xff`.
    - `xxd` process can dump hexadecimal representation of bytes for any text file passed as an argument on the command line interface (CLI).

## Endianness Concern

- Determines what the Most Significant Bit and Least Significant Bit are.
- Examples:
  - Where there is a 16-bit short.
    - `0x0102`
      - Little Endian: $(1 \times 256) + 2$
        - LSB $\rightarrow$ Right
        - Left $\leftarrow$ MSB
      - Big Endian: $1 + (256 \times 2)$
        - MSB $\rightarrow$ Right
        - Left $\leftarrow$ LSB
  - Network Byte Order
    - Big Endian
  - Host Byte Order
    - Little Endian

# Characters

- Entity from some defined alphabet.

## Fixed-Length Encoding

- If there are 6 entities in alphabet, we need 3-bits to uniquely encode each of the entities.
  - 0: `000`
  - 1: `001`
  - 2: `010`
  - 3: `011`
  - 4: `100`
  - 5: `101`
- This is somwhat wasteful because we aren't representing the full range of values capable by 3-bits.
- The most straightforward approach.

## Variable-Length Encoding

- Use the smaller encodings for more commonly used (frequent) entities to minimize overall space usage.
  - 0: `00`
  - 1: `01`
  - 2: `10`
  - 3: `1100`
  - 4: `1101`
  - 5: `1110`
- This strategy uses a 2-bit range instead where the more frequent characters have their own 2-bit encodings but the less common characters start with a unique 2-bit encoding not used for any other character followed by the unique 2-bit encodings of the more frequent characters.
  - This way, in a stream of bits, we know that if a `11` appears in the sequence, that the 2-bits that follow it will, as a whole 4-bit entity, embody the encoding of a less frequent character.
    - This would be become confusing and possibly impossible if there was a character who had a 2-bit encoding of `11` by itself.
- An issue can occur however if we run into a sequence like `1111`.

# Character Sets

- Need for Unicode as a result of 8-bits no longer being sufficient for representing all character entities.
  - As a result of:
    - Introduction of new characters like emojis.
    - Different character sets and languages needing to represent different quantities of characters (may require more than 8-bits).

## Past

- ASCII
- ISO 8859-1
- Etcetera

## Now

- Unicode

# Unicode

- Characters have "Code Points".
- There is not necessarily 1 Code Point per entity.
  - Code points can be added together to create an entity.

## Example

- `U+0041` $\rightarrow$ `A`
- `U+00C4` $\rightarrow$ `Ä`
- `U+0308` $\rightarrow$ `¨`
- `U+004N + 0308` $\rightarrow$ `Ä`
  - Where `N` is some number associated with a regular character entity.
    - Example being `A` where `N = 1` whose code point is `U+0041`.

## UTF

- Unicode Transformation Format.
- Different tradeoffs (space vs computing power) and use cases for each.
- Looking at bytes, can't tell what encoding.
  - Can't tell if valid under an/some encoding.
  - End up with "Metadata".
    - HTTP Requests have headers that might say:
      - `Content-Type: text/html; charset=UTF-8`
        - Text is HTML and needs to be interpreted using UTF-8.

### BOM

- The byte order mark (BOM) is a particular usage of the special Unicode character, `U+FEFF`, whose appearance as a magic number at the start of a text stream can signal several things to a program reading the text:
  1. The byte order, or endianness, of the text stream in the cases of 16-bit and 32-bit encodings.
  2. The fact that the text stream's encoding is Unicode, to a high level of confidence.
  3. Which Unicode character encoding is used.
- BOM use is optional and can interfere with UTF-8.

### UTF-32

- 32-bits for each character would result in 4 times more space than needed for the English alpahabet.
- This makes it easy to process in languages like Python-3.
- Easy indexing where `i`th unit is the `i`th character `s[i]`.
  - Linux: `wchar_t`
  - C11: `char 32_t`
- A fixed-length encoding, in contrast to all other Unicode transformation formats which are variable-lenth encodings, used to encode Unicode code points that uses exactly 32 bits (four bytes) per code point.
  - But a number of leading bits must be zero as there are far fewer than 232 Unicode code points, needing actually only 21 bits.
  - Each 32-bit value in UTF-32 represents one Unicode code point and is exactly equal to that code point's numerical value.

#### Advantages

- The main advantage of UTF-32 is that the Unicode code points are directly indexed.
  - Finding the `N`th code point in a sequence of code points is a constant-time operation.
    - In contrast, a variable-length code requires linear-time to count `N` code points from the start of the string.

#### Disadvantages

- The main disadvantage of UTF-32 is that it is space-inefficient, using four bytes per code point, including 11 bits that are always zero.
- UTF-32 is close to twice the size of UTF-16 and can be up to four times the size of UTF-8 depending on how many of the characters are in the ASCII subset.

### UTF-16

- Kind of the worst of both worlds.
- 2 bytes per character.
  - Not enough for all unicode characters so some characters use 2 bytes and some use two 2 bytes (4 bytes).
- Used in Java and JavaScript.

#### Disadvantages

- A bit more compact, but not compact enough.
- Error prone because `i`th unit does not always equal the `i`th character `s[i]`.

### UTF-8

- Most common when transmitted or stored.
- Can be 1, 2, 3, or 4 bytes.

#### Advantages

- Uses a variable length encoding.
  - No longer need to store a bunch of extra space as a result (space saving).
- ASCII strings (which there are a lot of) are valid UTF-8.

#### Disadvantages

- There is no easy indexing to get the `i`th character `s[i]`.

# Outro

- Some practical issues to consider (that may or may not come up depending on what the language itself inherently handles for yous):
  - `String` Operations
    - Searching for characters.
  - Internal Representation
    - Storing characters.
    - Buffers could be too big or small which could be exploited.
      - Buffer overflow if buffer too small.
- Be careful about `chars` vs `bytes`.

# Source

[Dan Williams](https://people.cs.vt.edu/djwillia/)