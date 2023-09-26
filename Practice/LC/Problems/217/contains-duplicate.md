<details>
<details>
<details>

```python
int = 1
```

</details>
</details>
</details>

# [Contains Duplicate](https://leetcode.com/problems/contains-duplicate/)

    Easy

> Given an integer array `nums`, return `true` if any value appears at least twice in the array, and return `false` if every element is distinct.

<details><summary>Examples</summary></p> <!-- Examples Start -->

<details><summary>Example 1</summary></p> <!-- Example 1 Start -->

###### Input

```
nums = [1,2,3,1]
```

###### Output

```
true
```

</details> <!-- Example 1 End -->

<details><summary>Example 2</summary></p> <!-- Example 1 Start -->

###### Input

```
nums = [1,2,3,4]
```

###### Output

```
false
```

</details> <!-- Example 2 End -->

<details><summary>Example 3</summary></p> <!-- Example 3 Start -->

###### Input

```
nums = [1,1,1,3,3,4,3,2,4,2]
```

###### Output

```
true
```

</details> <!-- Example 3 End -->

</details> <!-- Examples End -->

<details><summary>Constraints</summary></p> <!-- Constraints Start -->

- `1 <= nums.length <= 10^5`
- `-10^9 <= nums[i] <= 10^9`

</details> <!-- Constraints End -->

<details><summary>Solutions</summary></p> <!-- Solutions Start -->

<details><summary>Python</summary></p> <!-- Python Start -->

<details><summary>My Solutions</summary></p> <!-- My Solutions Start -->

<details><summary>Initial Solution</summary></p> <!-- Initial Solution Start -->

```python
def containsDuplicate(nums):
    for num in nums:
        if nums.count(num) >= 2:
            return True
    return False
```

- Correct output, but times out.

</details> <!-- Initial Solution End -->

<details><summary>Revised Solution</summary></p> <!-- Revised Solution Start -->

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

</details> <!-- Revised Solution End -->

</details> <!-- My Solutions End -->

<details><summary>NeetCode Solution</summary></p> <!-- NeetCode Solution Start -->

```python
def containsDuplicate(self, nums: List[int]) -> bool:
    hashset = set()

    for n in nums:
        if n in hashset:
            return True
        hashset.add(n)
    return False
```

</details> <!-- NeetCode Solution End -->

<details><summary>Other Solutions</summary></p> <!-- Other Solutions Start -->

<details><summary>Solution 1: Bruteforce</summary></p> <!-- Solution 1 Start -->

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

</details> <!-- Solution 1 End -->

<details><summary>Solution 2: Set</summary></p> <!-- Solution 2 Start -->

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

</details> <!-- Solution 2 End -->

<details><summary>Solution 3: Sorting</summary></p> <!-- Solution 3 Start -->

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

</details> <!-- Solution 3 End -->

<details><summary>Solution 4: Counter</summary></p> <!-- Solution 4 Start -->

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

</details> <!-- Solution 4 End -->

<details><summary>Solution 5: Hashmap</summary></p> <!-- Solution 5 Start -->

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

</details> <!-- Solution 5 End -->

</details> <!-- Other Solutions End -->

</details> <!-- Python End -->

</details> <!-- Solutions End -->

<details><summary>Heuristic</summary></p> <!-- Heuristic Start -->

- Description and [Link]() to the Heuristic(s) utilized goes here.

</details> <!-- Heuristic End -->

<details><summary>Tags</summary></p> <!-- Tags Start -->

- List of "Tags" associated with LeetCode problem that describe what kind of problem it is.

</details> <!-- Tags End -->
