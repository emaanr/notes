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
        - [Explanation](#explanation)
        - [Complexity](#complexity)
          - [Time Complexity](#time-complexity)
          - [Space Complexity](#space-complexity)
      - [Solution 2: Set](#solution-2-set)
        - [Explanation](#explanation-1)
        - [Complexity](#complexity-1)
          - [Time Complexity](#time-complexity-1)
          - [Space Complexity](#space-complexity-1)
      - [Solution 3: Sorting](#solution-3-sorting)
        - [Explanation](#explanation-2)
        - [Complexity](#complexity-2)
          - [Time Complexity](#time-complexity-2)
          - [Space Complexity](#space-complexity-2)
      - [Solution 4: Counter](#solution-4-counter)
        - [Explanation](#explanation-3)
        - [Complexity](#complexity-3)
          - [Time Complexity](#time-complexity-3)
          - [Space Complexity](#space-complexity-3)
      - [Solution 5: Hashmap](#solution-5-hashmap)
        - [Explanation](#explanation-4)
        - [Complexity](#complexity-4)
          - [Time Complexity](#time-complexity-4)
          - [Space Complexity](#space-complexity-4)

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

- `1 <= nums.length <= 10^5`
- `-10^9 <= nums[i] <= 10^9`

# Solutions

## Python

### My Solutions

#### Initial Solution

```python
def containsDuplicate(nums):
    for num in nums:
        if nums.count(num) >= 2:
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

##### Explanation

- Use two `for`-loops to compare pairs of integers in the array.
  - Once a comparison in which the numbers are the same is reached, return `True`.
  - If all integers of the array are looped through without reaching a similar pair of numbers, return `False`.
- This solution times out.

##### Complexity

- Time Complexity: $O(n^2)$
- Space Complexity: $O(1)$

###### Time Complexity

- The outer `for`-loop runs from `0` to `n-2` where `n` is the length of the input list `nums`.
- The inner `for`-loop runs from `i+1` to `n-1` for each iteration of the outer loop.
- The number of comparisons grows quadratically with the size of the input list.

> The total number of comparisons made by the nested loop can be calculated as follows:
>
> > $(n - 1) + (n - 2) + (n - 3) + \dots + 2 + 1 = \frac{(n - 1)(n-2)}{2}$
>
> Which can be simplified to:
>
> > $\frac{n^2 - 3n + 2}{2}$
>
> Which can be further reduced to an overall time complexity of:
>
> > $O(n^2)$

###### Space Complexity

- Uses a constant amount of additional space to store the loop variables `i` and `j`.
- Therefore, the space complexity is $O(1)$, indicating constant space usage.

#### Solution 2: Set

```python
def containsDuplicate(self, nums: List[int]) -> bool:
    return len(set(nums)) != len(nums)
```

##### Explanation

- Convert array `nums` using `set(nums)` into a set.
- Sets by definition contain unique values and as such there exists no duplicate elements.
- If the set version of the input array has a different length than the array, it means there are duplicate values in the input array.

##### Complexity

- Time Complexity: $O()$
- Space Complexity: $O()$

###### Time Complexity

###### Space Complexity

#### Solution 3: Sorting

```python
def containsDuplicate(self, nums: List[int]) -> bool:
    nums.sort()
    for i in range(len(nums)-1):
        if nums[i] == nums[i+1]:
          return True
    return False
```

##### Explanation

- Sort the given array and iterate over it from the beginning.
  - If the value immediately following the current value is the same, `True` is returned.
  - Otherwise, if the entire array has been successfully looped through without returning, this means there are no duplicates and `False` is returned.

##### Complexity

- Time Complexity: $O()$
- Space Complexity: $O()$

###### Time Complexity

###### Space Complexity

#### Solution 4: Counter

```python
def containsDuplicate(self, nums: List[int]) -> bool:
    freq = Counter(nums)
    for num, freq in freq.items():
        if freq > 1:
            return True
    return False
```

##### Explanation

- `Counter` is a subclass of `dict` desifned for counting hashable objects in Python.
  - It is a dictionary that stores the objects as keys and the frequencies of those objects as values.
- In this solution, `Counter` is used to create a map or table of frequencies for every integer object found.
- After mapping the frequencies using counter, return `True` if any values are greater than 1 and `False` otherwise.

##### Complexity

- Time Complexity: $O()$
- Space Complexity: $O()$

###### Time Complexity

###### Space Complexity

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

##### Explanation

- Similar approach as previous solution using `Counter` except the `counter` is made manually using `counter = {}`.

##### Complexity

- Time Complexity: $O()$
- Space Complexity: $O()$

###### Time Complexity

###### Space Complexity
