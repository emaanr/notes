# [Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/)

    Medium

# Table of Contents

- [Longest Substring Without Repeating Characters](#longest-substring-without-repeating-characters)
- [Table of Contents](#table-of-contents)
- [Question](#question)
  - [Example 1](#example-1)
    - [Input](#input)
    - [Output](#output)
    - [Explanation](#explanation)
  - [Example 2](#example-2)
    - [Input](#input-1)
    - [Output](#output-1)
  - [Explanation](#explanation-1)
  - [Constraints](#constraints)
- [Solutions](#solutions)
  - [Python](#python)
    - [My Solutions](#my-solutions)
      - [Initial Solution](#initial-solution)
      - [Revised Solution](#revised-solution)
    - [Other Solutions](#other-solutions)
      - [Solution 1](#solution-1)
      - [Solution 2](#solution-2)
  - [Java](#java)
    - [My Solutions](#my-solutions-1)
      - [Initial Solution](#initial-solution-1)
      - [Revised Solution](#revised-solution-1)
    - [Other Solutions](#other-solutions-1)
      - [Solution 1](#solution-1-1)
      - [Solution 2](#solution-2-1)

# Question

You are given a string `s` and an integer `k`. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most `k` times.

_Return the length of the longest substring containing the same letter you can get after performing the above operations._

## Example 1

### Input

```
s = "ABAB", k = 2
```

### Output

```
4
```

### Explanation

- Replace the two 'A's with two 'B's or vice versa.

## Example 2

### Input

```
s = "AABABBA", k = 1
```

### Output

```
4
```

## Explanation

- Replace the one 'A' in the middle with 'B' and form "AABBBBA".
- The substring "BBBB" has the longest repeating letters, which is 4.
- There may exists other ways to achive this answer too.

## Constraints

- `1 <= s.length <= 105`
- `s` consists of only uppercase English letters.
- `0 <= k <= s.length`

# Solutions

## Python

### My Solutions

#### Initial Solution

#### Revised Solution

### Other Solutions

#### Solution 1

#### Solution 2

## Java

### My Solutions

#### Initial Solution

#### Revised Solution

### Other Solutions

#### Solution 1

#### Solution 2
