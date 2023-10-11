# [Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/)

    Easy

# Table of Contents

# Question

Given `head`, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the `next` pointer. Internally, `pos` is used to denote the index of the node that tail's `next` pointer is connected to. **Note that** `pos` **is not passed as a parameter.**

_Return_ `true` _if there is a cycle in the linked list._ Otherwise, return `false`.

## Example 1

<div align="center" width="100%">
  <img title="Example 1" src="img/example-1.png" />
</div>

### Input

```
head = [3,2,0,-4], pos = 1
```

### Output

```
true
```

### Explanation

- There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).

## Example 2

<div align="center" width="100%">
  <img title="Example 2" src="img/example-2.png" />
</div>

### Input

```
head = [1,2], pos = 0
```

### Output

```
true
```

### Explanation

- There is a cycle in the linked list, where the tail connects to the 0th node.

## Example 3

<div align="center" width="100%">
  <img title="Example 3" src="img/example-3.png" />
</div>

### Input

```
head = [1], pos = -1
```

### Output

```
false
```

### Explanation

- There is no cycle in the linked list.

## Constraints

- The number of the nodes in the list is in the range `[0, 104]`.
- `-105 <= Node.val <= 105`
- `pos` is `-1` or a valid index in the linked-list.

## Follow-Up

- Can you solve it using $O(1)$ (i.e. constant) memory?

# Solutions

## Python

### My Solutions

#### Initial Solution

```python

```

#### Algorithm Walkthrough: [Technique/Data Structure]

- Note that there is a difference between:

```
head = [3, 2, 0, -4]
```

<div align="center" width="100%">
  <img title="Example 1" src="img/example-1.png" />
</div>

```
head = [3, 2, 0, -4, 2, 0, -4, ...]
```

<div align="center" width="100%">
  <img title="Explanation 1" src="img/explanation-1.png" />
</div>

- This implies that we need to think about this problem in terms of strictly pointers rather the values of the nodes.

##### Input

##### Variable(s): [Technique/Data Structure]

```

```

##### Step n

#### Revised Solution

```python

```

### Neetcode Solution

```python

```

### Other Solutions

#### Peer Solution

##### Algorithm Walkthrough

#### Solution 1: [Technique/Data Structure]

```python

```

#### Solution 2: [Technique/Data Structure]

```python

```

## Java

### My Solutions

#### Initial Solution

```java

```

#### Algorithm Walkthrough: [Technique/Data Structure]

##### Input

```

```

##### Variable(s): [Technique/Data Structure]

```

```

##### Step n

#### Revised Solution

```java

```

### NeetCode Solution

```java

```

### Other Solutions

#### Solution 1: [Technique/Data Structure]

```java

```

#### Solution 2: [Technique/Data Structure]

```java

```
