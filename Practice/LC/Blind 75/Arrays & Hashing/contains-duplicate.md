# [Contains Duplicate](https://leetcode.com/problems/contains-duplicate/)

    Easy

# Table of Contents

- [Contains Duplicate](#contains-duplicate)
- [Table of Contents](#table-of-contents)
- [Question](#question)
  - [Example 1](#example-1)
    - [Input](#input)
    - [Output](#output)
  - [Example 2](#example-2)
    - [Input](#input-1)
    - [Output](#output-1)
  - [Example 3](#example-3)
    - [Input](#input-2)
    - [Output](#output-2)
  - [Constraints](#constraints)
- [Solutions](#solutions)
  - [Python](#python)
    - [My Solutions](#my-solutions)
      - [Initial Solution](#initial-solution)
      - [Revised Solution](#revised-solution)
    - [NeetCode Solution](#neetcode-solution)
    - [Other Solutions](#other-solutions)
      - [Solution 1: Bruteforce](#solution-1-bruteforce)
      - [Solution 2: Set](#solution-2-set)
      - [Solution 3: Sorting](#solution-3-sorting)
      - [Solution 4: Counter](#solution-4-counter)
      - [Solution 5: Hashmap](#solution-5-hashmap)
  - [Java](#java)
    - [My Solutions](#my-solutions-1)
      - [Initial Solution](#initial-solution-1)
      - [Revised Solution](#revised-solution-1)
    - [Other Solutions](#other-solutions-1)
      - [Solution 1](#solution-1)
      - [Solution 2](#solution-2)

# Question

Given an integer array `nums`, return `true` if any value appears at least twice in the array, and return `false` if every element is distinct.

## Example 1

### Input

```
nums = [1,2,3,1]
```

### Output

```
true
```

## Example 2

### Input

```
nums = [1,2,3,4]
```

### Output

```
false
```

## Example 3

### Input

```
nums = [1,1,1,3,3,4,3,2,4,2]
```

### Output

```
true
```

## Constraints

- `1 <= nums.length <= 105`
- `-109 <= nums[i] <= 109`

# Solutions

## Python

### My Solutions

#### Initial Solution

```python
def containsDuplicate(nums):
    for num in nums:
        if nums.count(num) >= 2:
            print(nums.count(num))
            return True
    return False
```

- Correct output, but times out.

#### Revised Solution

```python
def containsDuplicate(self, nums: List[int]) -> bool:
    numset = set()
    for num in nums:
        if num in numset:
            return True
        else:
            numset.add(num)
    return False
```

### NeetCode Solution

```python
def containsDuplicate(self, nums: List[int]) -> bool:
    hashset = set()

    for n in nums:
        if n in hashset:
            return True
        hashset.add(n)
    return False
```

### Other Solutions

#### Solution 1: Bruteforce

```python
def containsDuplicate(self, nums: List[int]) -> bool:
    n = len(nums)
    for i in range(n - 1):
        for j in range(i + 1, n):
            if nums[i] == nums[j]: return True
    return False
```

- Use two `for`-loops to compare pairs of integers in the array.
  - Once a comparison in which the numbers are the same is reached, return `True`.
  - If all integers of the array are looped through without reaching a similar pair of numbers, return `False`.
- This solution times out.

#### Solution 2: Set

```python
def containsDuplicate(self, nums: List[int]) -> bool:
    return len(set(nums)) != len(nums)
```

- Convert array `nums` using `set(nums)` into a set.
- Sets by definition contain unique values and as such there exists no duplicate elements.
- If the set version of the input array has a different length than the array, it means there are duplicate values in the input array.

#### Solution 3: Sorting

```python
def containsDuplicate(self, nums: List[int]) -> bool:
    nums.sort()
    for i in range(len(nums)-1):
        if nums[i] == nums[i+1]:
          return True
    return False
```

- Sort the given array and iterate over it from the beginning.
  - If the value immediately following the current value is the same, `True` is returned.
  - Otherwise, if the entire array has been successfully looped through without returning, this means there are no duplicates and `False` is returned.

#### Solution 4: Counter

```python
def containsDuplicate(self, nums: List[int]) -> bool:
    freq = Counter(nums)
    for num, freq in freq.items():
        if freq > 1:
            return True
    return False
```

- `Counter` is a subclass of `dict` desifned for counting hashable objects in Python.
  - It is a dictionary that stores the objects as keys and the frequencies of those objects as values.
- In this solution, `Counter` is used to create a map or table of frequencies for every integer object found.
- After mapping the frequencies using counter, return `True` if any values are greater than 1 and `False` otherwise.

#### Solution 5: Hashmap

```python
def containsDuplicate(self, nums: List[int]) -> bool:
    counter = {}
    for num in nums:
        if num not in counter:
            counter[num] = 0
        counter[num] += 1
    for num, freq in counter.items():
        if freq > 1:
            return True
    return False
```

- Similar approach as previous solution using `Counter` except the `counter` is made manually using `counter = {}`.

## Java

### My Solutions

#### Initial Solution

#### Revised Solution

### Other Solutions

#### Solution 1

#### Solution 2
