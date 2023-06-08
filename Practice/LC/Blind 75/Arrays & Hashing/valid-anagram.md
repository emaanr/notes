# [Valid Anagram](https://leetcode.com/problems/valid-anagram/)

    Easy

# Table of Contents

- [Valid Anagram](#valid-anagram)
- [Table of Contents](#table-of-contents)
- [Question](#question)
  - [Example 1](#example-1)
    - [Input](#input)
    - [Output](#output)
  - [Example 2](#example-2)
    - [Input](#input-1)
    - [Output](#output-1)
  - [Constraints](#constraints)
  - [Follow-Up](#follow-up)
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

Given two strings `s` and `t`, return `true` if `t` is an anagram of `s`, and `false` otherwise.

An **Anagram** is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

## Example 1

### Input

```
s = "anagram", t = "nagaram"
```

### Output

```
true
```

## Example 2

### Input

```
s = "rat", t = "car"
```

### Output

```
false
```

## Constraints

- `1 <= s.length, t.length <= 5 * 104`
- `s` and `t` consist of lowercase English letters.

## Follow-Up

What if the inputs contain Unicode characters? How would you adapt your solution to such a case?

# Solutions

## Python

### My Solutions

#### Initial Solution

```python
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        else:
            s_list = []
            t_list = []
            s_dict = {}
            t_dict = {}

            for c in s:
                if c not in s_list:
                    s_list.append(c)
                    count = s.count(c)
                    s_dict[c] = count

            for c in t:
                if c not in t_list:
                    t_list.append(c)
                    count = t.count(c)
                    t_dict[c] = count

            if s_dict == t_dict:
                return True
            else:
                return False
```

#### Revised Solution

```python
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if (len(t) != len(s)):
            return False
        for char in t:
            if (t.count(char) != s.count(char)):
                return False
        return True
```

### NeetCode Solution

```python
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False

        countS, countT = {}, {}

        for i in range(len(s)):
            countS[s[i]] = 1 + countS.get(s[i], 0)
            countT[t[i]] = 1 + countT.get(t[i], 0)
        return countS == countT
```

### Other Solutions

#### Solution 1

```python
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        return collections.Counter(s) == collections.Counter(t)
```

#### Solution 2

```python
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        dict = {}
        for char in s:
            if char not in dict:
                dict[char] = 1
            else:
                dict[char] += 1
        for char in t:
            if char not in dict:
                return False
            else:
                dict[char] -= 1
        return False if any(dict.values()) else True
```

## Java

### My Solutions

#### Initial Solution

```java
class Solution {
    public boolean isAnagram(String s, String t) {

    }
}
```

#### Revised Solution

```java
class Solution {
    public boolean isAnagram(String s, String t) {

    }
}
```

### Other Solutions

#### Solution 1

```java
class Solution {
    public boolean isAnagram(String s, String t) {

    }
}
```

#### Solution 2

```java
class Solution {
    public boolean isAnagram(String s, String t) {

    }
}
```
