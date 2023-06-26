# [Longest Repeating Character Replacement](https://leetcode.com/problems/longest-repeating-character-replacement/)

    Medium

# Table of Contents

- [Longest Repeating Character Replacement](#longest-repeating-character-replacement)
- [Table of Contents](#table-of-contents)
- [Question](#question)
- [Solutions](#solutions)
  - [Python](#python)
    - [My Solutions](#my-solutions)
      - [Initial Solution](#initial-solution)
    - [NeetCode Solution](#neetcode-solution)
    - [Other Solutions](#other-solutions)
      - [Friend's Solution](#friends-solution)
        - [Algorithm Walkthrough](#algorithm-walkthrough)
      - [Solution 1](#solution-1)
      - [Solution 2](#solution-2)
  - [Java](#java)
    - [My Solutions](#my-solutions-1)
      - [Initial Solution](#initial-solution-1)
      - [Revised Solution](#revised-solution)
    - [Other Solutions](#other-solutions-1)
      - [Solution 1](#solution-1-1)
      - [Solution 2](#solution-2-1)

# Question

# Solutions

## Python

### My Solutions

#### Initial Solution

```python
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:

        substring = set()
        longest = 0
        length = 0
        index = 0
        i = 0

        while index < len(s) and i < len(s):
            if s[i] not in substring:
                substring.add(s[i])
                length = len(substring)
                if length > longest:
                    longest = length
                i += 1
            elif s[i] in substring:
                substring = set()
                length = 0
                index += 1
                i = index

        return longest
```

### NeetCode Solution

```python
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        charSet = set()
        l = 0
        res = 0

        for r in range(len(s)):
            while s[r] in charSet:
                charSet.remove(s[l])
                l += 1
            charSet.add(s[r])
            res = max(res, r - l + 1)
        return res
```

### Other Solutions

#### Friend's Solution

```python
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        length = 0
        maxL = 0
        string = ""
        for i in s:
            if i not in string:
                string += i
                length += 1
            else:
                string = string[string.index(i) + 1:] + i
                length = len(string)

            if length > maxL:
                maxL = length

        return maxL
```

##### Algorithm Walkthrough

- The code snippet you provided performs the following operation on a string:

  1. `string.index(i)` finds the index of the first occurrence of the character `i` within the string.
  2. `string.index(i) + 1` adds `1` to the index value obtained in the previous step. This effectively gives the index of the character immediately following the first occurrence of `i`.
  3. `string[string.index(i) + 1:]` extracts a substring from the original string starting from the character immediately following the first occurrence of `i` until the end of the string.
  4. `- i` concatenates the character `i` to the end of the substring obtained in the previous step.

- In simpler terms, this code snippet moves the first occurrence of the character i to the end of the string while preserving the order of the other characters.

#### Solution 1

#### Solution 2

## Java

### My Solutions

#### Initial Solution

#### Revised Solution

### Other Solutions

#### Solution 1

#### Solution 2
