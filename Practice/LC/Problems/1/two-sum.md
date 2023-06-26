# [Two Sum](https://leetcode.com/problems/two-sum/)

    Easy

# Table of Contents

- [Two Sum](#two-sum)
- [Table of Contents](#table-of-contents)
- [Question](#question)
  - [Example 1](#example-1)
    - [Input](#input)
    - [Output](#output)
    - [Explanation](#explanation)
  - [Example 2](#example-2)
    - [Input](#input-1)
    - [Output](#output-1)
  - [Example 3](#example-3)
    - [Input](#input-2)
    - [Output](#output-2)
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

Given an array of integers `nums` and an integer `target`, return _indices of the two numbers such that they add up to `target`_.

You may assume that each input would have **exactly one solution**, and you may not use the _same_ element twice.

You can return the answer in any order.

## Example 1

### Input

```
nums = [2,7,11,15], target = 9
```

### Output

```
[0,1]
```

### Explanation

- Because `nums[0] + nums[1] == 9`, we return `[0, 1]`.

## Example 2

### Input

```
nums = [3,2,4], target = 6
```

### Output

```
[1,2]
```

## Example 3

### Input

```
nums = [3,3], target = 6
```

### Output

```
[0,1]
```

## Constraints

- `2 <= nums.length <= 10^4`
- `-10^9 <= nums[i] <= 10^9`
- `-10^9 <= target <= 10^9`
- **Only one valid answer exists**.

## Follow-Up

Can you come up with an algorithm that is less than $O(n^2)$ time complexity?

# Solutions

## Python

### My Solutions

#### Initial Solution

```python
def twoSum(self, nums: List[int], target: int) -> List[int]:
    for i in range(0, len(nums)):
        for num in nums:
            j = nums.index(num)
            if num + nums[i] == target and j != i:
                return [i, j]
```

- Correct output, but times out.

#### Revised Solution

### NeetCode Solution

```python
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        prevMap = {}  # val -> index

        for i, n in enumerate(nums):
            diff = target - n
            if diff in prevMap:
                return [prevMap[diff], i]
            prevMap[n] = i
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
