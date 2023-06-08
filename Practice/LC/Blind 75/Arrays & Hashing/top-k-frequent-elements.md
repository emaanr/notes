# [Top K Frequent Elements](https://leetcode.com/problems/top-k-frequent-elements/)

    Medium

# Table of Contents

- [Top K Frequent Elements](#top-k-frequent-elements)
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

## Example 1

### Input

```

```

### Output

```

```

## Example 2

### Input

```

```

### Output

```

```

## Example 3

### Input

```

```

### Output

```

```

## Constraints

## Follow-Up

# Solutions

## Python

### My Solutions

#### Initial Solution

```python
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:

        # Base Cases
        if len(nums) <= 1:
            return nums

        # All Other Cases
        nums_sorted = sorted(nums)
        distinct_nums = set()
        for i in nums_sorted:
            distinct_nums.add(i)

        # Add k elements and sort in descending order upon every alteration
        top_k = []
        for num in distinct_nums:
            new_freq = [num, nums_sorted.count(num)]
            print(f"CREATED NEW_FREQ: {new_freq}")
            top_k.sort(key = lambda x: x[1])
            if len(top_k) == k:
                for old_freq in top_k:
                    if new_freq[1] > old_freq[1] and new_freq not in top_k:
                        print(f"NEW_FREQ[1] > OLD_FREQ[1]: {new_freq[1]} > {old_freq[1]}")
                        print(f"NEW_FREQ: {new_freq}")
                        print(f"OLD_FREQ: {old_freq}\n")
                        top_k.remove(old_freq)
                        top_k.append(new_freq)
            else:
                top_k.append(new_freq)
                print(f"APPENDED: {new_freq}")
                print(f"TOP K ELEMENTS: {top_k}\n")

        top_k_frequent = []
        top_k = sorted(top_k)
        for k in top_k:
            top_k_frequent.append(k[0])

        return top_k_frequent
```

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
