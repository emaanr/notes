# Quicksort

    Quicksort is an in-place sorting algorithm that utilizes a "pivot".

# Table of Contents

- [Quicksort](#quicksort)
- [Table of Contents](#table-of-contents)
- [Question 1: Peaks \& Valleys](#question-1-peaks--valleys)
  - [Solution](#solution)
    - [Suboptimal Solution](#suboptimal-solution)
    - [Algorithm](#algorithm)
- [Question 2: Rearrange](#question-2-rearrange)
  - [Solution](#solution-1)
    - [Algorithm](#algorithm-1)
- [Question 3: Dutch Flag](#question-3-dutch-flag)
  - [Solution](#solution-2)
    - [Algorithm](#algorithm-2)
- [Source](#source)

# Question 1: Peaks & Valleys

In an array of integers, a "peak" is an element which is greater than or equal to the adjacent integers and a "valley" is an element which is less than or equal to the adjacent integers. For example, in the array $\{5, 8, 6, 2, 3, 4, 6\}$, $\{8, 6\}$ are peaks and $\{5, 2\}$ are valleys. Given an array of integers, sort the array 
into an alternating sequence of peaks and valleys.

- Example
  - Input: $\{5, 3, 1, 2, 3\}$
  - Output: $\{5, 1, 3, 2, 3\}$
 
## Solution

- Since this problem asks us to sort the array in a particular way, one thing we can try is doing a normal sort and then "fixing" the array into an alternating sequence of peaks and valleys.

### Suboptimal Solution

- Imagine we are given an unsorted array and then sort it to become the following:

    ```
    0       1       4       7       8       9
    ```

- We now have an ascending list of integers.
- Process to rearrange this into a proper alternating sequence of peaks and valleys:
  1. The `0` is okay.
  2. The `1` is in the wrong place so it can be swapped with either the `0` or the `4`, let's swap `0`.

        ```
        1       0       4       7       8       9
        ```

  3. The `4` is okay.
  4. The `7` is in the wrong place so it can be swapped with either the `4` or the `8`, let's swap `4`.

        ```
        1       0       7       4       8       9
        ```

  5. The `9` is in the wrong place, let's swap with `8`.

        ```
        1       0       7       4       9       8
        ```

- Observe that there's nothing special about the array having these values. The relative order of the elements matters, but all sorted arrays will have the same relative order. Therefore this approach can be used on any sorted array.

### Algorithm

1. Sort the array in ascending order.
2. Iterate through every other element in the array, starting from index 1, not 0.
3. At each element, swap it with the previous element.
   - Since every three elements appear in the order `small < medium < large`, swapping these elements will always put `medium` as a peak: `medium < small < large`.
- This approach will ensure that the peaks are in the right place.
- As long as the odd-numbered elements (the peaks) are bigger than the adjacent elements, then the even-numbered elements (the valleys) must be smaller than the adjacent elements.

```
void sortValleyPeak(int[] array) {
    Arrays.sort(array);
    for (int i = 1; i < array.length; i += 2) {
        swap(array, i - 1, i);
    }
}

void swap(int[] array, int left, int right) {
    int temp = array[left];
    array[left] = array[right];
    array[right] = temp;
}
```

- Runtime for this algorithm is $O(nlogn)$.

***

# Question 2: Rearrange

Design an algorithm to rearrange elements of a given array of $n$ real numbers so that all its negative elements precede all its positive elements. Your algorithm should be both time-efficient and space-efficient.

## Solution

- The following algorithm uses the partition idea similar to that of quicksort, although it's implemented somewhat differently.
- Namely, on each iteration, the algorithm maintains three sections (possibly empty) in a given array:
  1. All the elements in $A[0 \dots i-1]$ are negative.
  2. All the elements in $A[i \dots j]$ are unknown.
  3. All the elements in $A[j+1 \dots n]$ are non-negative.

```
+--------+-------+----------+--------+-------+--------+----------+-------+---------+
|  A[0]  |  ...  |  A[i-1]  |  A[i]  |  ...  |  A[j]  |  A[j+1]  |  ...  |  A[n-1] |
+--------+-------+----------+--------+-------+--------+----------+-------+---------+
         all are < 0        |         unknown         |        all are >= 0       
```

- On each iteration, the algorithm shrinks the size of the unknown section by one element either from the left or right.

### Algorithm

```java
NegBeforePos (A[0 ... n-1])

// Puts negative elements before positive elements (and zeroes, if any) in an array
// Input: Array A[0 ... n-1] of real numbers
// Output: Array A[0 ... n-1] in which all its negative elements precede the non-negative elements

i <- 0
j <- n-1

while i <= j do             // i < j would suffice
    if A[i] < 0             // Shrink the unknown section from the left
        i <- i + 1
    else                    // Shrink the unknown section from the right
        swap(A[i], A[j])
        j <- j - 1
```
> Note:
> If we want all the zero elements placed after all the negative elements but before all the positive ones, the problem becomes the Dutch Flag problem.

***
 
# Question 3: Dutch Flag

The Dutch flag problem is to rearrange an array of characters $R$, $W$, and $B$ (red, white, and blue are the colors of the Dutch national flag) so that all the $R$'s come first, the $W$'s come next, and the $B$'s come last. Design a linear in-place algorithm for this problem.

## Solution

- The following algorithm uses the partition idea similar to that of quicksort.
- See [Question 2](#question-2-rearrange) for a simpler 2-color version of this problem.
- On each iteration, the algorithm maintains four sections (possibly empty) in a given array:
  1. All the elements $A[0 \dots r-1]$ are filled with $R$'s.
  2. All the elements $A[r \dots w-1]$ are filled with $W$'s.
  3. All the elements $A[w \dots b]$ are unknown.
  4. All the elements $A[b+1 \dots n-1]$ are filled with $B$'s.

```
+--------+-------+----------+--------+-------+----------+--------+-------+-------+----------+-------+----------+
|  A[0]  |  ...  |  A[r-1]  |  A[r]  |  ...  |  A[w-1]  |  A[w]  |  ...  |  A[b] |  A[b+1]  |  ...  |  A[n-1]  |
+--------+-------+----------+--------+-------+----------+--------+-------+-------+----------+-------+----------+
   all are filled with R's  |  all are filled with W's  |         unknown        |   all are filled with B's
```

- On each iteration, the algorithm shrinks the size of the unknown section by one element either from the left or from the right.

### Algorithm

```java
DutchFlag (A[0 ... n-1])

// Sorts an array with values in a three-element set
// Input: An array A[0 ... n-1] of characters from {'R', 'W', 'B'}
// Output: Array A[0 ... n-1] in which all its R elements precede all its W elements that precede its B elements

r <- 0
w <- 0
b <- n-1

while w <= b do
    if A[w] = 'R'
        swap(A[r], A[w])
        r <- r + 1
        w <- w + 1
    else if A[w] = 'W'
        w <- w + 1
    else // A[w] = 'B'
        swap[A[w], A[b]]
        b <- b - 1 
```

# Source

[Sally Hamouda](https://sallyhamouda.com/)