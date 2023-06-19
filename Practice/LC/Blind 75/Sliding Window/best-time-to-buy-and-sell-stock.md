# [Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)

    Easy

# Table of Contents

- [Best Time to Buy and Sell Stock](#best-time-to-buy-and-sell-stock)
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
        - [Algorithm Walkthrough: Sliding Window](#algorithm-walkthrough-sliding-window)
          - [Input](#input-2)
          - [Variables: Sliding Window](#variables-sliding-window)
          - [Step 1](#step-1)
          - [Step 2](#step-2)
          - [Step 3](#step-3)
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

You are given an array `prices` where `prices[i]` is the price of a given stock on the `i`th day.

You want to maximize your profit by choosing a **single day** to buy one stock and choosing a **different day in the future** to sell that stock.

Return the _maximum profit you can achieve from this transaction_. If you cannot achieve any profit, return `0`.

## Example 1

### Input

```
prices = [7,1,5,3,6,4]
```

### Output

```
5
```

### Explanation

- Buy on day 2 (price = 1)
- Sell on day 5 (price = 6)
- Profit = 6 - 1 = 5

> **Note:** Buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

## Example 2

### Input

```
prices = [7,6,4,3,1]
```

### Output

```
0
```

## Constraints

- `1 <= prices.length <= 10^5`
- `0 <= prices[i] <= 10^4`

# Solutions

## Python

### My Solutions

#### Initial Solution

```python
class Solution:
    def maxProfit(self, prices: List[int]) -> int:

        cheapest = prices[0]
        maxProfit = 0

        for i in range(len(prices)-1):
            if prices[i] < cheapest:
                cheapest = prices[i]
            profit = prices[i+1] - cheapest
            if profit > maxProfit:
                maxProfit = profit

        return maxProfit
```

##### Algorithm Walkthrough: Sliding Window

- The brute force method of a double for loop is not necessary here, and this problem is marked with dynamic programming because it requires the [Sliding Window](https://algorithm-visualizer.org/dynamic-programming/sliding-window) technique.
- Based on the fact that we have to sell after we buy and we are trying to maximize profit, we can iterate through the prices and only need to consider two things:

  1. Is this price cheaper than any other price I've seen before?
  2. If I subtract current price by the cheapest price I've found, does this yield a greater profit than what I've seen so far?

> **Note:** A fun thing to note is if #1 is true, then #2 cannot be true as well so there isn't a need to check.

###### Input

```
[4,1,5,2,7]
```

1. `4` is the cheapest price we see to start.
   - We can't sell on the first day so `maxProfit` is `0`.
2. `1` is now the cheapest price we've seen.
   - Selling now would lose us money, so we can't update `maxProfit`.
3. `5` is not cheaper than `1`.
   - Selling now we get a `maxProfit` of `4`.
4. `2` is not cheaper than `1`.
   - If we sell, we only get a profit of `1`, no need to do anything here.
5. `7` is not cheaper than `1`.
   - If we sell here, we'll increase `maxProfit` to `6`, making this the best profit to return.

###### Variables: Sliding Window

```
cheapest = prices[0]
maxProfit = 0
```

###### Step 1

###### Step 2

###### Step 3

#### Revised Solution

### NeetCode Solution

```Python
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        res = 0

        lowest = prices[0]
        for price in prices:
            if price < lowest:
                lowest = price
            res = max(res, price - lowest)
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
