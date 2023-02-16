# Recurrence

    Recursion is a method of solving a computational problem where the solution depends on solutions to smaller instances of the same problem. It achieves this by calling itself until some base case is met. Only use recursion for a problem if it is naturally recursive.

# Table of Contents

- [Recurrence](#recurrence)
- [Table of Contents](#table-of-contents)
- [Question 1](#question-1)
  - [Solution](#solution)
- [Question 2](#question-2)
  - [Solution](#solution-1)
- [Question 1 \& 2](#question-1--2)
  - [Solution](#solution-2)
- [Question 3](#question-3)
  - [Solution](#solution-3)
- [Question 4](#question-4)
  - [Solution](#solution-4)
- [Question 5](#question-5)
  - [Solution](#solution-5)
- [Source](#source)

# Question 1

The following `isSorted` takes an array and its length and returns if the array is sorted or not. Find its recurrence relation and solve it to find the Big-O.

```java
public static boolean isSorted(int [] a, int n) {
    if (n == 1) {
        return true;
    }
    if (a[n-2] > a[n-1]) { // Are the last two elements out of order?
    return false;
    } else {
        return isSorted(a, n - 1); // Is the initial part of the array sorted?
    }
}
```

## Solution

  - Walking through the algorithm gives 1 step for the first `if` plus 1 step for the second `if` plus the time `isSorted` will take on an input of size `n-1`, which will be $T(n-1)$, which gives the recurrence relation:

    > $T(n) \le 1 + 1 + T(n-1) = T(n-1) + O(1)$

  - Which has a solution of $T(n) = O(n)$, which happens to be the same as the non-recursive version of `isSorted` in the following question.

***

# Question 2

Consider the following non-recursive implementation of the above `isSorted`. Find its Big-O and compare with the recursive implementation Big-O. Which implementation would you use to solve this problem?

```java
public static boolean isSorted(int [] a, int n) {
    if (n == 1) {
        return true; // A 1-element array is always sorted
    }
    for (a[i] > a[i+1]) { // Found two adjacent elements out of order
        return false;
    }
    return true;
} // Everything is in sorted order
```
## Solution

  - The size of the input here will simply be $n$, the size of the array. How many steps will be performed in the worst case for input $n$?
    - The first `if` statement counts as 1 step.
    - The `for`-loop will execute $n-1$ times in the worst case (assuming the internal test doesn't kick us out), for a total time of $n-1$ for the loop test and the increment of the index.
    - Inside the loop, there is another `if` statement which will be executed once per iteration for a total of $n-1$ time, at worst.
    - The last `return` will be executed once.
  - So in the worst case, we will have done $1 + (n-1) + (n-1) + 1$ computations, for a total runtime $T(n) \le 1 + (n-1) + (n-1) + 1 = 2n$ and so we have the timing function:
    
    > $T(n) = O(n)$

  - For non-recursive algorithms, the process is as follows:
    - Find a parameter, $n$, that expresses the "size" of the input. Walk through the algorithm, assuming:
       1. Every statement executed will take time 1,
       2. Every `if` statement will take its longest branch,
       3. Every loop will iterate the maximum number of times allowable.
    - Then express the runtime of your algorithm as a function of the sum of statements executed, using (1) through (3) above.

***

# Question 1 & 2

Between the recursive `isSorted` implementation in Question 1 and the non-recursive `isSorted` implementation in Question 2, which one should we use given that they have the same runtime of $O(n)$?

## Solution

- We should use the non-recursive solution demonstrated in Question 2 because the recursive solution demonstrated in Question 1 may result in a stack overflow if the $n$ is too large. Both are $O(n)$ so the tradeoff is eliminating the possibility of a stack overflow occurring.
- More on `isSorted`:
  - Tries to find if a certain array is sorted or not.
  - The number of sorts is $n-1$ because we are comparing each element to its predecessor to determine if it is sorted.
    - Therefore, the last element and the second to last element being compared count as one comparison. We cannot compare the last element to itself.
      - Therefore, the number of sorts is $n-1$.
    - Therefore, we are making $n-1$ amount of comparisons on an array of length $n$.
  - A point of confusion may be the line `if (a[n-2] > a[n-1])`.
    - The reason we are comparing the `n-1`th position and the `n-2`nd position of the array is because $n$ is the size of the array and the index of the array is always `0` to `n-1`.
    - It is important to understand that $n-1$ comparisons does not refer to the indices of the array, but rather the number of comparisons that are happening.

***

# Question 3

Given the following mysterious function. Find its recurrence relation and solve it to find the Big-O.

```java
public static void doSomething(int [] a, int left, int right) {
    if (left == right) {
        for (int j = 0; j < right; ++j) {
            System.out.print(a[j]);
        }
        System.out.println();
        return;
    }
    for (int i = left; i < right, ++i) {
        // Swap
        int temp = a[left];
        a[left] = a[i];
        a[i] = temp;
        doSomething(a, left + 1, right);
        // Swap
        temp = a[left];
        a[left] = a[i];
        a[i] = temp;
    }
}
```

## Solution

  - The call `doSomething(arr, j, j)` prints `j` things.
  - The call `doSomething(arr, i, j)` makes `j-1` calls to `doSomething(arr, i+1, j)`.
  - Let's redefine the variables a bit and define `f(i)` as `doSomething(arr, j-1, j)`. That way `f(0)` is the base case. And now the recurrence rule can be rewritten as:
    - The call `f(i)` makes `i` calls to `f(i-1)`.
    - Which makes the recurrence relation pretty clear:
      
        > $T(n) = n * T(n-1)$
        >
        > $T(1) = O(n)$

        - Which is to say:

            > $T(n) = O(n! * n)$

  - Needless to say, this is quite a big runtime.
  - $O(n! * n)$ where $O(n)$ is the base case and $n!$ is the `for`-loop.

***

# Question 4

For the following `binsearch` code, find its recurrence relation and solve it to find the Big-O.

```java
public static int binsearch(int low, int high, int [] S, int x) {
    if (low <= high) {
        int mid = (low + high) / 2;
        if (x == S[mid]) {
            return mid;
        }
        else if (x < S[mid]) {
            return binsearch(low, mid - 1, S, x);
        } else {
            return binsearch(mid + 1, high, S, x);
        }
    } else {
        return 0;
    }
}
```

## Solution

  - We say $n = 2^k$ because every time we call the function we are dividing the samble size by $2$.
  - $2^{k-1}$ comes from $2^k/2$ which can be rewritten as $2^k/2^1$ which gives us $2^{k-1}$.

    > $A(2^k) = A(2^{k-1}) + 1$ for $k > 0$
    > 
    > $A(2^0) = 0$

  - Using _backwards substitution_:

    > $A(2^k) = A(2^{k-1})$
    >
    > > substitute $A(2^{k-1}) = A(2^{k-2}) + 1$ for next step
    >
    > $[A(2^{k-2}) + 1] + 1 = A(2^{k-2}) + 2$
    >
    > > substitute $A(2^{k-2}) = A(2^{k-3}) + 1$ for next step
    >
    > $[A(2^{k-3}) + 1] + 2 = A(2^{k-3}) + 3$
    >
    > > $\dots$ for next step
    >
    > $\dots$

    - We keep doing this on every iteration and determine a pattern:

        > $\dots$
        >
        > $A(2^{k-i}) + i$
        >
        > $\dots$

        - This continues until we get:

            > $\dots$ 
            >
            > $A(2^{k-k}) + k$

            - Thus we end up with:

                > $A(2^k) = A(1) + k = k$

                - $A(1)$ is simplification of $A(2^{k-k})$ which can be rewritten as $A(2^0)$ which gives us $A(1)$.
            - After returning to the original variable $n = 2^k$ upon which we take the $log$ of both sides to find $k$ hence $k = log_2n$ which finally gives us:

                > $A(n) = log_2n \in \theta(logn)$

  - Additionally, using the master theorem yields $a = 1$, $b = 2$, and $d = 0$.

***

# Question 5

Suppose you are given the price of a stock on each day, and you have to decide when to buy and when to sell to maximize your profit. Note that you cannot sell before you buy (so you can’t just sell on the highest day and buy on the lowest day). Write a brute force algorithm and a divide and conquer algorithm to find best buy dates and best sell dates. Using the master theorem, find the asymptotic analysis of the divide and conquer algorithm.

## Solution

- **Naive Strategy: Brute Force Algorithm**
  - Try all pairs of _(buy, sell)_ dates, where the _buy date_ must be before the _sell date_. This takes $\theta(n^2)$ time.
    ```
    bestProfit = -MAX_INT
    bestBuyDate = None
    bestSellDate = None

    for i = 1 to n:
        for j = i + 1 to n:
            if price[j] - price[i] > bestProfit:
            bestBuyDate = i;
            bestSellDate = j;
            bestProfit = price[j] - price[i]
    return (bestBuyDate, bestSellDate)
    ```
- **Recurrence Strategy: Divide and Conquer Algorithm** 
  - Instead of the _daily price_, consider the _daily change in price_, which (on each day) can be either a positive or negative number.
    - Let `array A` store these changes.
    - Now we have to find the subarray of A that maximizes the sum of the numbers in that subarray.
  - Now divide the array into two.
    - Any maximum subarray must either be:
      1. Entirely in the first half,
      2. Entirely in the second half,
      3. Or it must span the border between the first and the second half.
    - If the maximum subarray is entirely in the first half or the second half, we can find it using a recursive call on a subproblem half as large.
    - If the maximum subarray spans the border, then the sum of that array is the sum of two parts:
      1. The part between the buy date and the border,
      2. and the part between the border and the sell date.
  - To maximize the sum of the array, we must maximize the sum of each part.
    - We can do this by simply:
      1. Iterating over all possible buy dates to maximize the first part,
      2. Iterating over all possible sell dates to maximize the second part.
   - Note that this takes linear time instead of quadratic time, because we no longer have to iterate over buy and sell dates simultaneously.
      - **FIND-MAXIMUM-SUBARRAY** (_A, low, high_)
        ```
        1   if high == low
        2       return (low, high, A[low])      // Base case: Only one element
        3   else mid = [(low +high)/2]
        4       (left-low, left-high, left-sum) =
                    FIND-MAXIMUM-SUBARRAY(A, low, mid)
        5       (right-low, right-high, right-sum) =
                    FIND-MAXIMUM-SUBARRAY(A, mid + 1, high)
        6       (cross-low, cross-high, cross-sum) =
                    FIND-MAX-CROSSING-SUBARRAY(A, low, mid, high)
        7       if left-sum >= right-sum and left-sum >= cross-sum
        8           return (left-low, left-high, left-sum)
        9       elseif right-sum >= left-sum and right sum >=cross-sum
        10          return (right-low, right-high, right-sum)
        11      else return (cross-low, cross-high, cross-sum)
        ```
      - **FIND-MAX-CROSSING-SUBARRAY** (_A, low, mid, high_)
        ```
        1   left-sum = -infinity
        2   sum = 0
        3   for i = mid downto low
        4       sum = sum + A[i]
        5       if sum > left-sum
        6           left-sum = sum
        7           max-left = i
        8   right-sum = -infinity
        9   sum = 0
        10  for j = mid + 1 to high
        11      sum = sum + A[j]
        12      if sum > right-sum
        13          right-sum = sum
        14          max-right = j
        15  return (max-left, max-right, left-sum + right-sum)
        ```
      - Runtime Analysis
        - First we analyze the runtime of **FIND-MAX-CROSSING-SUBARRAY**.
          - Since each iteration of each of the two `for`-loops takes $\theta(1)$ time, we just need to count up how many iterations there are altogether.
            - The `for`-loop of lines 3-7 makes $mid - low + 1$ iterations.
            - The `for`-loop of lines 10-14 makes $high - mid$ iterations.
          - So the total number of iteration is $high - low + 1 = n$.
          - Therefore, the helper function takes time:

            > $\theta(n)$

        - Now we need to analyze the runtime of the main function, **FIND-MAX-CROSSING-SUBARRAY**.
          - For the base case, $T(1) = \theta(1)$, since line 2 takes constant time.
          - For the recursive case:
            - lines 1 and 3 take constant time.
            - Lines 4 and 5 take $T(n/2)$ and $T(n/2)$ time, since each of the subproblems has that many elements.
          - The **FIND-MAX-CROSSING-SUBARRAY** procedure takes $\theta(n)$ time, and the rest of the code takes $\theta(1)$ time. So, ignoring the floors and cielings:

            > $T(n) = \theta(1) + T(n/2) + T(n/2) + \theta(n) + \theta(1) = 2T(n/2) + \theta(n)$

        - By the master theorem, this recurrence has the solution:
        
          > $T(n) = \theta(nlogn)$

# Source

[Sally Hamouda](https://sallyhamouda.com/)