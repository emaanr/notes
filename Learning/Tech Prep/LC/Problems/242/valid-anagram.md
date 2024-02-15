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
  - [HashMap](#hashmap)
    - [Complexity](#complexity)
  - [Counter](#counter)
    - [Complexity](#complexity-1)
  - [Sorted](#sorted)
    - [Complexity](#complexity-2)
  - [Count](#count)
    - [Complexity](#complexity-3)

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

- `1 <= s.length, t.length <= 5 * 10^4`
- `s` and `t` consist of lowercase English letters.

## Follow-Up

What if the inputs contain Unicode characters? How would you adapt your solution to such a case?

# Solutions

1. HashMap
2. Counter
3. Sorted
4. Count

## HashMap

```python
def isAnagram(self, s: str, t: str) -> bool:
    if len(s) != len(t):
        return False

    countS, countT = {}, {}

    for i in range(len(s)):
        countS[s[i]] = 1 + countS.get(s[i], 0)
        countT[t[i]] = 1 + countT.get(t[i], 0)
    for key in countS: # for key in countT
        if countS[key] != countT.get(key, 0): # if countT[key] != countS.get(key, 0)
            return False
    return True
```

- First and foremost, by defintion, `s` and `t` cannot be anagrams if they are of different lengths, so we check for that first.
- Next, we initialize two dictionaries: `countS` and `countT` which will represent two separate HashTables to record characeter frequencies in `s` and `t` respectively.
  - Note that in Python, dictionaries (`dict`) are implemented using a "Hash Table" data structure, which makes them effectively a "Hash Map".
- Next we iterate over every character in `s` and `t`.
  - Note that we use `for i in range(len(s))` for both `countS` and `countT`. This is because they should be the same length if they passed the first `if len(s) != len(t)` check.
  - Note also that, `len(s)` will return the number of characters in `s`, let's call this number `n`. Then `range(len(s))` will generate the indices from 0 up to (but _not including_) `n`: Which would be $0, 1, 2, \dots, n - 2, n - 1$. This is likely due to the 0-indexed nature of programming.
- Within the first `for`-loop, we set the character `s[i]` or `t[i]` to be the key and set its value to be `1 + countS.get(s[i], 0)` or `1 + countT.get(t[i], 0)` respectively.
  - Note that the `get(key[, default])` method belongs to `dict` here. It returns the value of the passed `key`. By passing the optional parameter `[, default]`, we can determine what value should be returned when the `key` is not found. This means that the first time a character is encountered, `get(key[, default])` will return `0` which will then have `1` added to it, based on how we have written it in the solution.
- The next `for`-loop iterates over the key-value pairs in `countS` and checks if the value for the curent `key` is the same as the value for the same `key` in `countT`.
  - Note that we use `get(key[, default])` again here like so: `countT.get(key, 0)`. This is because, in the case that the `key` does not exist in `countT` (which would mean they aren't anagrams by the way), it will return 0 instead for the comparison which will trigger `return False` since if `key` is in `countS` it has a value of 1 _at least_, based on how the solution is written.
  - Note also that we can effective swap `countS` and `countT` for this second `for`-loop and produce the same result.
- Finally, if the `return False` is not triggered by the second `for`-loop, then it exits the loop normally and will `return True`.

### Complexity

- Time Complexity: $O(n)$
  - The first `if` condition is `O(1)` and represents the best case.
  - The first `for` loop iterates over both input strings `s` and `t` which will always be the same length if this point in the function is reached, therefore the time complexity is $O(n) + O(n) = O(2n)$ which reduces to $O(n)$.
  - The second `for`-loop has a time complexity of $O(k)$ when iterating over the key-value pairs of `countS`. The `get()` method operation has an average time complexity of $O(1)$. Therefore the time complexity of the second `for`-loop is $O(k)$.
    - Note that $m$ is _always_ less than $n$ since $k$ represents the number of keys in the `dict` and $n$ represents the number of characters in the input strings and we can't have more keys than characters.
  - Therefore $O(n) + O(n) + O(k) = O(2n + k)$ which reduces to $O(n)$ since the following is _always_ true in the context of this solution: $n \geq k$.
- Space Complexity: $O(m)$
  - The code uses two dictionaries, `countS` and `countT` to store character counts. In the worst case scenario, both dictionaries will have to store counts for all the characters in both strings. Therefore the time complexity in this case would be $O(m)$ where $m$ is the total number of unique characters in both strings.

## Counter

```python
def isAnagram(self, s: str, t: str) -> bool:
    return Counter(s) == Counter(t)
```

- `Counter` is a Python subclass of `dict` that is used to count the occurrences of elements in an iterable. It's particularly useful for tasks like finding the frequency of characters in a string or countring the ocurrences of items in a list. Typically needs to be imported using `from collections import Counter`.
- For this solution we use `Counter` to count the frequence of every character in the input strings `s` and `t` and then return the result of the comparison of the two.

### Complexity

- Time Complexity: $O(n)$
  - `Counter()` has a time complexity of $O(n)$ each time it is used since it iterates over the argument passed to it. In this case it would be $O(n) + O(n) = O(2n)$ due to `Counter(s)` and `Counter(t)`, which reduces to $O(n)$.
  - Comparing two `Counter` objects involves comparing the counts of each unique element. This operation has a time complexity of $O(m)$ where $m$ is the number of unique elements in the `Counter`.
  - Therefore the overall time complexity can start by being represented as $O(n + m)$. However, because we know that the following will _always_ be true in the context of this solution: $n \geq m$, we can reduce the overall time complexity to be $O(n)$.
    - We know this is _always_ true because we cannot have more elements in the `Counter`, denoted by $m$, than characters in the input strings `s` or `t`, denoted by $n$.
- Space Complexity: $O(n)$
  - This operation requires $O(n)$ space for each string (in the worst case) where $n$ is the length of the string.
  - Since there are two `Counter`s, this will be $O(n) + O(n) = O(2n)$ which reduces to $O(n)$ space complexity in the worst case.

## Sorted

```python
def isAnagram(self, s: str, t: str) -> bool:
    return sorted(s) == sorted(t)
```

- Here we are calling the `sorted()` function in Python to convert the input strings `s` and `t` to arrange their characters in the same relative order.
- Then we check if the sorted strings are the same and return the result of that comparison.

### Complexity

- Time Complexity: $O(nlogn)$
  - The time complexity of the `sorted()` function in Python is $O(nlogn)$ where $n$ is the length of the input string.
  - Therefore, sorting both strings `s` and `t` using `sorted()` will take $O(nlogn)$ time each.
  - Finally, comparing the two sorted strings for equality using `==` is a linear time operation, which takes $O(n)$ time.
  - Combining these operations we get $O(nlogn) + O(nlogn) + O(n)$ which results in $O(nlogn)$ overall.
- Space Complexity: $O(n)$
  - The space complexity is determined by the additional space required to store the sorted versions of the strings `s` and `t`.
  - Sorting both strings using `sorted()` creates new lists with the characters orted in non-decreasing order. Therefore, the space complexity for sorting each string is $O(n)$, where $n$ is the length of the input string.
  - Hence the total space complexity is $O(n) + O(n) = O(2n)$ which reduces to $O(n)$.

## Count

```python
def isAnagram(self, s: str, t: str) -> bool:
    if (len(t) != len(s)):
        return False
    for j in t: # for i in s
        if t.count(j) != s.count(j): # if s.count(i) != t.count(i)
            return False
    return True
```

- First and foremost, by defintion, `s` and `t` cannot be anagrams if they are of different lengths, so we check for that first.
- Next, for every character in one of the input strings (either one works), we check if its count is the same as its count in the other input string using the `count()` method.
- As soon as their counts are found to be different, the solution returns `False`, otherwise it exits the loop normally and returns `True`.
- This solution is much slower than the others due to the $O(n^2)$ quadratic time complexity as a result of the `for`-loop and the use of `count()` which has a $O(n)$ linear time complexity.

### Complexity

- Time Complexity: $O(n^2)$
  - The initial check for the lengths of the strings is $O(1)$.
  - In the loop, since both strings `s` and `t` are of the same length, the iteration only needs to traverse one of the strings. This traversal takes $O(n)$ time, where $n$ is the length of either `s` or `t`.
  - Within the `for`-loop, the `count()` method is called twice: Once for `t` and once for `s`. Each `count()` operation has a time complexity of $O(n)$, where $n$ is the length of the string being counted.
    - Therefore, for each character in one of the input strings, `s` or `t`, the counting operation takes $O(n)$ time.
  - Essentially, `for j in t` or `for i in s` counts as one $O(n)$ which then has $O(n) + O(n)$ nested under it in the `if t.count(j) != s.count(j)` or `if s.count(i) != t.count(i)`. This results in $O(n^2)$.
  - Thus the overall time complexity can be evaluated as $O(1) + (O(n) * (O(n) + O(n))) = O(1) + O(2n^2)$ which can be simplified to just $O(n^2)$.
- Space Complexity: $O(1)$
  - There are no additional data structures created, therfore the space complexity is $O(1)$.
