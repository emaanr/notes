# [Longest Consecutive Sequence](https://leetcode.com/problems/longest-consecutive-sequence/)

    Medium

# Table of Contents

- [Longest Consecutive Sequence](#longest-consecutive-sequence)
- [Table of Contents](#table-of-contents)
- [Question](#question)
  - [Example 1](#example-1)
    - [Input](#input)
    - [Output](#output)
    - [Explanation](#explanation)
  - [Example 2](#example-2)
    - [Input](#input-1)
    - [Output](#output-1)
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

Given an unsorted array of integers `nums`, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in `O(n)` time.

## Example 1

### Input

```
nums = [100,4,200,1,3,2]
```

### Output

```
4
```

### Explanation

- The longest consecutive elements sequence is `[1, 2, 3, 4]`. Therefore its length is 4.

## Example 2

### Input

```
nums = [0,3,7,2,5,8,4,6,0,1]
```

### Output

```
9
```

## Constraints

- `0 <= nums.length <= 10^5`
- `-10^9 <= nums[i] <= 10^9`

# Solutions

```python
class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        if len(nums) <= 1:
            return len(nums)

        nums = sorted(nums)
        length = 1
        longest = 1

        for i in range(0, len(nums)-1):
            if nums[i] + 1 == nums[i+1]:
                length += 1
                if length >= longest:
                    longest = length
                    print(f"LENGTH: {length} AND LONGEST: {longest}")
            elif nums[i] == nums[i+1]:
                continue
            else:
                length = 1

        return longest
```

## Python

### My Solutions

#### Initial Solution

#### Revised Solution

### NeetCode Solution

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
