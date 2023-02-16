# Big-O

    Big-O notation is a mathematical notation that describes the limiting behavior of a function when the argument tends towards a particular value or infinity.

# Table of Contents

- [Big-O](#big-o)
- [Table of Contents](#table-of-contents)
- [Question 1](#question-1)
  - [Solution](#solution)
- [Question 2](#question-2)
  - [Solution](#solution-1)
- [Question 3](#question-3)
  - [Solution](#solution-2)
- [Question 4](#question-4)
  - [Solution](#solution-3)
- [Question 5](#question-5)
  - [Solution](#solution-4)
- [Question 6](#question-6)
  - [Solution](#solution-5)
- [Question 7](#question-7)
  - [Solution](#solution-6)
- [Question 8](#question-8)
  - [Solution](#solution-7)
- [Question 9](#question-9)
  - [Solution](#solution-8)
- [Question 10](#question-10)
  - [Solution](#solution-9)
- [Question 11](#question-11)
  - [Solution](#solution-10)
- [Question 12](#question-12)
  - [Solution](#solution-11)
- [Question 13](#question-13)
  - [Solution](#solution-12)
- [Question 14](#question-14)
  - [Solution](#solution-13)
- [Question 15](#question-15)
  - [Solution](#solution-14)
- [Question 16](#question-16)
  - [Solution](#solution-15)
- [Source](#source)

# Question 1

What is the runtime of the below code?

```java
void foo(int[] array) {
    int sum = 0;
    int product = 1;

    for (int i = 0; i < array.length; i++) {
        sum += array[i];
    }
    for (int i = 0; i < array.length; i++) {
        product *= array[i];
    }
    System.out.println(sum + ", " + product);
}
```

## Solution

- This will take $O(N)$ time. The fact that we iterate through the array twice does not matter.

---

# Question 2

What is the runtime of the below code?

```java
void printPairs(int[] array) {
    for (int i = 0; i < array.length; i++) {
        for (int j = 0; j < array.length; j++) {
            System.out.println(array[i] + ", " + array[j]);
        }
    }
}
```

## Solution

- The inner `for`-loop has $O(N)$ iterations and it is called $N$ times. Therefore, the runtime is $O(N^2)$. Another way we can see this is by inspecting what the "meaning" of the code is. It is printing all pairs (two element sequences). There are $O(N^2)$ pairs; therefore, the runtime is $O(N^2)$.

***

# Question 3

This is very similar code to the above example, but now the inner `for`-loop starts at `i + 1`.

```java
void printUnorderedPairs(int[] array) { 
    for (int i = 0; i < array.length; i++) {
        for (int j = i + 1; j < array.length; j++) {
            System.out.println(array[i] + ", " + array[j]);
        }
    }
}
```

## Solution

- The first time through, `j` runs for $N-1$ steps. The second time, it's $N-2$ steps. Then $N-3$ steps. And so on. There, the number of steps total is:

  > $(N-1) + (N-2) + ... + 2 + 1$
  > 
  > $= 1 + 2 + 3 + ... + (N-1)$
  > 
  > = Sum of $1$ through $(N-1)$
  > 
  >= $O(N^2)$

- Therefore, since the inner loop does $N/2$ work on average and it is run $N$ times, the total work is $N^2/2$ which is $O(N^2)$.

***

# Question 4

This is like the above, but now we have two different arrays.

```java
void printUnorderedPairs(int[] arrayA, int[] arrayB) {
    for (int i = 0; i < arrayA.length; i++) {
        for (int j = 0; j < arrayB.length; j++) {
            if (arrayA[i] < arrayB[j]) {
                System.out.println(arrayA[i] + ", " + arrayB[j]);
            }
        }
    }
}
```

## Solution

- For each element of `arrayA`, the inner `for`-loop goes through `b` iterations, where `b = arrayB.length`. If `a = arrayA.length`, then the runtime is $O(ab)$. If you said $O(N^2)$, then remember your mistake for the future. It's not $O(N^2)$ because there are two different inputs. Both matter. This is a common mistake. 

***

# Question 5

What about this code?

```java
void printUnorderedPairs(int[] arrayA, int[] arrayB) {
    for (int i = 0; i < arrayA.length; i++) {
        for (int j = 0; j < arrayB.length; j++) {
            for (int k = 0; k < 100000; k++) { // 100,000
                System.out.println(arrayA[i] + ", " + arrayB[j]);
            }
        }
    }
}
```

## Solution

- Nothing has really changed here. 100,000 units of work is still constant, so the runtime is $O(ab)$.

***

# Question 6

The following code reverses an array. What is its runtime?

```java
void reverse(int[] array) {
    for (int i = 0; i < array.length / 2; i++) {
        int other = array.length - i = 1;
        int temp = array[i];
        array[i] = array[other];
        array[other] = temp;
    }
}
```
## Solution

- This algorithm runs in $O(N)$ time. The fact that it only goes through half of the array (in terms of iterations) does not impact the Big-O time.

***

# Question 7

Which of the following are equivalent for $O(N)$? Why?
- $O(N + P)$, where $P < X$
- $O(2N)$
- $O(N + logN)$
- $O(N + M)$

## Solution

- Let's go through these:
  - If $P < X$, then we know that $N$ is the dominant term so we can drop the $O(P)$.
  - $O(2N)$ is $O(N)$ since we drop constants.
  - $O(N)$ dominates $O(logN)$,so we can drop the $O(logN)$.
  - There is no established relationship between $N$ and $M$, so we have to keep both variables in there.
- Therefore, all but the last one are equivalent to $O(N)$.

***

# Question 8

Suppose we had an algorithm that took in an array of strings, sorted each string, and then sorted the full array. What would the runtime be?

## Solution

- Let's define new terms-and use names that are logical. Let `s` be the length of the longest string. Let `a` be the length of the array. Now we can work through this in parts: 
  - Sorting each string is $O(slogs)$. 
  - We have to do this for every string (and there are `a` strings), so that's $O(a*slogs)$. 
- Now we have to sort all the strings in the array  of length `a`. There are `a` strings, so you may be inclined to say that this takes $O(aloga)$ time. This is what most candidates would say. You should also consider that you need to compare the strings. Each string comparison takes $O(s)$ time. There are $O(aloga)$ comparisons. Therefore, this will take $O(a*sloga)$ time. If you add up these two parts, you get:

    > $O(a * slogs) + O(a * sloga)$

    - Which can be simplified to:

      > $O(a * s(loga + logs))$

***

# Question 9

The following simple code sums the values of all the nodes in a balanced binary search tree. What is its runtime?

```java
int sum(Node node) {
    if(node == null) {
        return 0;
    }
    return sum(node.left) + node.value + sum(node.right);
}
```
## Solution

- Just because it's a binary search tree doesn't mean that there is a log in it! The most straightforward way is to think about what the code means. This code touches each node in the tree once and does a constant time amount of work with each "touch" (excluding the recursive calls). Therefore, the runtime will be linear in terms of the number of nodes. If there are $N$ nodes, then the runtime is $O(N)$.

***

# Question 10

The following code computes the product of `a` and `b`. What is its runtime?

```java
int product(int a, int b) {  
    int sum = 0;
    for (int i = 0; i < b; i++) {
        sum += a;
    }
    return sum;
}
```

## Solution

- $O(b)$. The `for`-loop just iterates through `b`.

***

# Question 11

The following code computes `a` to the power `b`. What is its runtime?

```java
int power (int a, int b) {
    if (b < 0) {
        return 0;
    }
    else if (b == 0) {
        return 1;
    }
    else {
        return a * power(a, b -1);
    }
}
```

## Solution

- $O(b)$. The recursive code iterates through `b` calls, since it subtracts one at each level.

***

# Question 12

The following code performs integer division. What is its runtime (assume `a` and `b` are both positive)?

```java
int div(int a, int b) { 
    int count = 0;
    int sum = b;
    while (sum <= a) {
        sum += b;
        count++;
    }
    return count;
}
```

## Solution

- $O(a/b)$. The variable count will eventually equal $a/b$. The `while`-loop iterates `count` times. Therefore, it iterates $a/b$ times.

***

# Question 13

The following code computes the [integer] square root of a number. If the number is not a perfect square (there is no integer square root), then it returns `-1`. It does this by successive guessing. If `n` is `100`, it first guesses `50`. Too high? Try something lower-halfway between `1` and `50`. What is its runtime?

```java
int sqrt(int n) {
    return sqrt_helper(n, 1, n);
}

int sqrt_helper(int n, int min, int max) {
    if (max < min) {
        return -1; // No square root
    }
    int guess = (min + max) / 2;
    if (guess * guess == n) { // Found it!
        return guess;
    }
    else if (guess * guess < n) { // Too low
        return sqrt_helper(n, guess + 1, max); // Try higher
    } else { // Too high
        return sqrt_helper(n, min, guess - 1); // Try lower
    }
}
```

## Solution

- $O(logn)$. This algorithm is essentially doing a binary search to find the square root. Therefore, the runtime is $O(logn)$.

***

# Question 14

The following code computes the [integer] square root of a number. If the number is not a perfect square (there is no integer square root), then it returns `-1`. It does this by trying increasingly large numbers until it finds the right value (or is too high). What is its runtime?

```java
int sqrt(int n) {
    for (int guess = 1; guess * guess <= n; guess++) {
        if (guess * guess == n) {
            return guess;
        }
    }
    return -1;
}
```

## Solution

- $O(\sqrt{n})$. This is just a straightforward loop that stops when `guess * guess` > `n`, or in other words, when `guess` > $\sqrt{n}$.

***

# Question 15

The `appendToNew` method appends a value to an array by creating a new, longer array and returning this longer array. You've used the `appendToNew` method to create a `copyArray` function that repeatedly calls `appendToNew`. How long does copying an array take?

```java
int[] copyArray(int[] array) {
    int[] copy = new int[0];
    for (int value : array) {
        copy = appendToNew(copy, value);
    }
    return copy;
}

int[] appendToNew(int[] array, int value) {
    // Copy all elements over to new array
    int[] bigger = new int[array.length + 1];
    for (int i = 0; i < array.length; i++) {
        bigger[i] = array[i];
    }
    // Add new element
    bigger[bigger.length - 1] = value;
    return bigger;
}
```
## Solution

- $O(n^2)$, where $n$ is the number of elements in the `array`. The first call to `appendToNew` takes 1 copy. The second call takes 2 copies. The third call takes 3 copies. And so on. The total time will be the sum of 1 through `n`, which is $O(n^2)$.

***

# Question 16

The following code sums the digits in a number. What is its Big-O time?

```java
int sumDigits (int n) {
    int sum = 0;
    while (n > 0) {
        sum += n % 10;
        n /= 10;
    }
    return sum;
}
```
## Solution

- $O(logn)$. The runtime will be the number of digits in the number. A number with $d$ digits can have a value up to $10d$. If $n = 10^d$, then $d = logn$. Therefore, the runtime is $O(logn)$.

# Source

[Sally Hamouda](https://sallyhamouda.com/)