# [3Sum](https://leetcode.com/problems/3sum/)

    Medium

# Table of Contents

- [3Sum](#3sum)
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

Given an integer array nums, return all the triplets `[nums[i], nums[j], nums[k]]` such that `i != j`, `i != k`, and `j != k`, and `nums[i] + nums[j] + nums[k] == 0`.

Notice that the solution set must not contain duplicate triplets.

## Example 1

### Input

```
nums = [-1,0,1,2,-1,-4]
```

### Output

```
[[-1,-1,2],[-1,0,1]]
```

### Explanation

- `nums[0] + nums[1] + nums[2]` = (-1) + 0 + 1 = 0.
- `nums[1] + nums[2] + nums[4]` = 0 + 1 + (-1) = 0.
- `nums[0] + nums[3] + nums[4]` = (-1) + 2 + (-1) = 0.
- The distinct triplets are `[-1,0,1]` and `[-1,-1,2]`.
- Notice that the order of the output and the order of the triplets does not matter.

## Example 2

### Input

```
nums = [0,1,1]
```

### Output

```
[]
```

### Explanation

- The only possible triplet does not sum up to 0.

## Example 3

### Input

```
nums = [0,0,0]
```

### Output

```
[[0,0,0]]
```

### Explanation

- The only possible triplet sums up to 0.

## Constraints

- `3 <= nums.length <= 3000`
- `-10^5 <= nums[i] <= 10^5`

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

```

```
