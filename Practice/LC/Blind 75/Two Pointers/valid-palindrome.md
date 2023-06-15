# [Valid Palindrome](https://leetcode.com/problems/valid-palindrome/)

    Easy

# Table of Contents

- [Valid Palindrome](#valid-palindrome)
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
  - [Example 3](#example-3)
    - [Input](#input-2)
    - [Output](#output-2)
    - [Explanation](#explanation-2)
  - [Constraints](#constraints)
- [Solutions](#solutions)
  - [Python](#python)
    - [My Solutions](#my-solutions)
      - [Initial Solution](#initial-solution)
      - [Revised Solution](#revised-solution)
    - [NeetCode Solution](#neetcode-solution)
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

A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

## Example 1

### Input

```
s = "A man, a plan, a canal: Panama"
```

### Output

```
true
```

### Explanation

- "amanaplanacanalpanama" is a palindrome.

## Example 2

### Input

```
s = "race a car"
```

### Output

```
false
```

### Explanation

- "raceacar" is not a palindrome.

## Example 3

### Input

```
s = " "
```

### Output

```
true
```

### Explanation

- `s` is an empty string `""` after removing non-alphanumeric characters.
- Since an empty string reads the same forward and backward, it is a palindrome.

## Constraints

- `1 <= s.length <= 2 * 10^5`
- `s` consists only of printable ASCII characters.

# Solutions

## Python

### My Solutions

#### Initial Solution

```python
class Solution:
    def isPalindrome(self, s: str) -> bool:

        # Convert to all lowercase
        s = s.lower()

        for char in s:
            if not char.isalnum():
                s = s.replace(char, "")

        if s[::-1] == s:
            return True
        else:
            return False
```

#### Revised Solution

```python
class Solution:
    def isPalindrome(self, s: str) -> bool:

        # Convert to lowercase
        s = s.lower()

        # Remove non-alphanumeric characters
        s = ''.join(c for c in s if c.isalnum())

        # Compare with reversed string
        return s == s[::-1]
```

### NeetCode Solution

```python
class Solution:
    def isPalindrome(self, s: str) -> bool:
        l, r = 0, len(s) - 1
        while l < r:
            while l < r and not self.alphanum(s[l]):
                l += 1
            while l < r and not self.alphanum(s[r]):
                r -= 1
            if s[l].lower() != s[r].lower():
                return False
            l += 1
            r -= 1
        return True

    # Could write own alpha-numeric function
    def alphanum(self, c):
        return (
            ord("A") <= ord(c) <= ord("Z")
            or ord("a") <= ord(c) <= ord("z")
            or ord("0") <= ord(c) <= ord("9")
        )
```

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
