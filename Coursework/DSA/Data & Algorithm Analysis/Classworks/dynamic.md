<style>
  r { color: Red }
</style>

# Dynamic Programming

    Dynamic Programming is an Optimization (over Recursion) that stores results of subproblems to reuse without recomputing the same work.

# Table of Contents

- [Dynamic Programming](#dynamic-programming)
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
  - [Example](#example)
    - [Trial 1](#trial-1)
    - [Trial 2](#trial-2)
  - [Solution](#solution-4)
- [Source](#source)

# Question 1

A child is running up a staircase with n steps and can hop either $1$ step, $2$ steps, or $3$ steps at a time. Design and implement a Brute-Force Algorithm and then a Dynamic Programming Algorithm to count how many possible ways the child can run up the stairs.

## Solution

Solution goes here

---

# Question 2

Imagine a robot sitting on the upper left corner of grid with $r$ rows and $c$ columns. The robot can only move in two directions, right and down, but certain cells are "off limits" such that the robot cannot step on them. Design an algorithm to find a path for the robot from the top left to the bottom right. 

## Solution

Solution goes here

---

# Question 3

Solve the coin collecting problem by a robot on the following instance:

|     |      1     |      2     |      3     |      4     |      5     |      6     |
|:---:|:----------:|:----------:|:----------:|:----------:|:----------:|:----------:|
|  1  |            | <r>_7_</r> |            |            |            | <r>_4_</r> |
|  2  |            |            | <r>_5_</r> | <r>_3_</r> |            |            |
|  3  |            | <r>_8_</r> |            |            |            | <r>_2_</r> |
|  4  | <r>_4_</r> |            | <r>_6_</r> |            | <r>_1_</r> |            |
|  5  | <r>_9_</r> |            |            | <r>_5_</r> |            |            |
|  6  |            | <r>_3_</r> |            |            | <r>_7_</r> |            |

## Solution

Solution goes here

---

# Question 4

Using Dynamic Programming, solve the following Knapsack instance with a capacity of `knapsack = 8`:

| Item $i$ | Value $v_i$ | Weight $w_i$ |
|:--------:|:-----------:|:------------:|
|    1     |      15     |       1      |
|    2     |      10     |       5      |
|    3     |       9     |       3      |
|    4     |       5     |       4      |

## Solution

Solution goes here

---

# Question 5

Coins-in-a-Line Game Problem: In this game, an even number, $n$, of coins of various denominations from various countries, are placed in a line. Two players, who we will call Alice and Bob, take turns removing one of the coins from either end of the remaining line of coins. That is, when it is a player's turn, they remove the coin at the left or right end of the line of coins and adds that coin to their collection. The player who removes a set of coins with larger total value than the other player wins, where we assume that both Alice and Bob know  the value of each coin. 

## Example

coins [ ] = $\{6, 9, 1, 2, 16, 8\}$

### Trial 1

Players will pick the best option available to them.

> coins [ ] = $\{6, 9, 1, 2, 16, 8\}$
>
> > Alice picks $8$
>
> coins [ ] = $\{6, 9, 1, 2, 16\}$
> 
> >Bob picks $16$
> 
> coins [ ] = $\{6, 9, 1, 2\}$
> 
> > Alice picks $6$
> 
> coins [ ] = $\{9, 1, 2\}$
> 
> > Bob picks $9$
> 
> coins [ ] = $\{1, 2\}$
> 
> > Alice picks $2$
> 
> coins [ ] = $\{1\}$
> 
> > Bob picks $1$
> 
> Result:
> 
> > Alice: $8 + 6 + 2$ = $16$
> >
> > Bob: $16 + 9 + 1$ = $26$
>
> Alice lost.

So clearly picking up the best in each move is not good for Alice. What else Alice can do to win the game?

### Trial 2

Alice thinks about what moves Bob will make.

> coins [ ] = $\{6, 9, 1, 2, 16, 8\}$ 
>
> > Alice picks $6$
> 
> coins [ ] = $\{9, 1, 2, 16, 8\}$
> 
> > Bob picks $9$
> 
> coins [ ] = $\{1, 2, 16, 8\}$
> 
> > Alice picks $1$
> 
> coins [ ] = $\{2, 16, 8\}$
> 
> > Bob picks $8$
> 
> coins [ ] = $\{2, 16\}$
> 
> > Alice picks $16$
> 
> coins [ ] = $\{2\}$
> 
> > Bob picks $2$
>
> Result:
> 
> > Alice: $6 + 1 + 16$ = $23$
> > 
> > Bob: $9 + 8 + 2$ = $19$
>  
> Alice won.

## Solution

Solution goes here

# Source

[Sally Hamouda](https://sallyhamouda.com/)