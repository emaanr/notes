# [Container With Most Water](https://leetcode.com/problems/container-with-most-water/)

    Medium

# Table of Contents

- [Container With Most Water](#container-with-most-water)
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
        - [Algorithm Walkthrough: Bruteforce](#algorithm-walkthrough-bruteforce)
          - [Input](#input-2)
          - [Variables: Two Pointers](#variables-two-pointers)
      - [Revised Solution](#revised-solution)
        - [Algorithm Walkthrough: Two Pointers](#algorithm-walkthrough-two-pointers)
          - [Input](#input-3)
          - [Variables: Two Pointers](#variables-two-pointers-1)
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

You are given an integer array `height` of length `n`. There are `n` vertical lines drawn such that the two endpoints of the `i`th line are `(i, 0)` and `(i, height[i])`.

Find two lines that together with the x-axis form a container, such that the container contains the most water.

_Return the maximum amount of water a container can store._

Notice that you may not slant the container.

## Example 1

<figure align="center" width="100%">
  <img title="Example 1" src="img/figure.png" />
</figure>

### Input

```
height = [1,8,6,2,5,4,8,3,7]
```

### Output

```
49
```

### Explanation

- The above vertical lines are represented by array `[1,8,6,2,5,4,8,3,7]`.
- In this case, the max area of water (blue section) the container can contain is `49`.

## Example 2

### Input

```
height = [1,1]
```

### Output

```
1
```

## Constraints

- `n == height.length`
- `2 <= n <= 10^5`
- `0 <= height[i] <= 10^4`

# Solutions

## Python

### My Solutions

#### Initial Solution

```python
class Solution:
    def maxArea(self, height: List[int]) -> int:

        maxArea = 0

        for left in range(len(height)):
            for right in range(left+1, len(height)):
                area = (right-left) * min(height[right], height[left])
                maxArea = max(area, maxArea)

        return maxArea
```

- Correct output, but times out.

##### Algorithm Walkthrough: Bruteforce

###### Input

###### Variables: Two Pointers

#### Revised Solution

```python
class Solution:
    def maxArea(self, height: List[int]) -> int:

        maxArea = 0
        left = 0
        right = len(height)-1

        while left != right:
            area = (right-left) * min(height[left], height[right])
            maxArea = max(area, maxArea)

            if height[left] < height[right]:
                left += 1
            elif height[left] > height[right]:
                right -= 1
            elif height[left] == height[right]:
                if (height[left+1]) > (height[right-1]):
                    right -= 1
                else:
                    left += 1

        return maxArea
```

##### Algorithm Walkthrough: Two Pointers

###### Input

###### Variables: Two Pointers

### NeetCode Solution

```python
class Solution:
    def maxArea(self, height: List[int]) -> int:
        l, r = 0, len(height) - 1
        res = 0
        h = max(height)

        while l < r:
            res = max(res, min(height[l], height[r]) * (r - l))
            if height[l] < height[r]:
                l += 1
            elif height[r] <= height[l]:
                r -= 1

            if (r-l) * h <= res:
                break
        return res
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
