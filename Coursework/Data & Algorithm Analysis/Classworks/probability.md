# Probability

    Probability is the branch of mathematics concerning numerical descriptions of how likely an event is to occur, or how likely it is that a proposition is true.

# Table of Contents

- [Probability](#probability)
- [Table of Contents](#table-of-contents)
- [Question 1: Basketball](#question-1-basketball)
  - [Solution](#solution)
- [Question 2: Ants on a Triangle](#question-2-ants-on-a-triangle)
  - [Solution](#solution-1)
- [Question 3: Egg Drop](#question-3-egg-drop)
  - [Solution](#solution-2)
- [Source](#source)

# Question 1: Basketball

You have a basketball hoop and someone says that you can play one of two games. Game 1: You get one shot to make the hoop. Game 2: You get three shots and you have to make two of three shots. If p is the probability of making a particular shot, for which values of p should you pick one game or the other?

## Solution

- **Probability of winning Game 1**
  - The probability of winning Game 1 is $p$, by definition.
- **Probability of winning Game 2**
  - Let $s(k, n)$ be the probability of making exactly $k$ shots out of $n$. The probability of winning Game 2 is the probability of making exactly two shots out of three _OR_ making all three shots. In other words:
    
    > $P(\text{winning}) = s(2, 3) + s(3, 3)$
  
  - The probability of making all three shots is:

    > $s(3, 3) = p^3$

  - The probability of making exactly two shots is:
 
    > $P(\text{making first and second, and missing third}) + P(\text{making first and third, and missing second}) + P(\text{missing first, and making second and third})$
    >
    > $= p * p * (1 - p) + p * (1 - p) * p + (1 - p) * p * p$
    >
    > $= 3(1-p)p^2$

  - Adding these together, we get:

    > $= p^3 + 3(1 - p)p^2$
    >
    > $= p^3 + 3p^2 - 3p^3$
    >
    > $= 3p^2 - 2p^3$

- **Which game should you play?**
  - You should play Game 1 if $P(\text{Game 1}) > P(\text{Game 2})$:
  
    > $p > 3p^2 - 2p^3$
    >
    > $1 > 2p - 2p^2$
    >
    > $2p^2 - 3p + 1 > 0$
    >
    > $(2p - 1)(p - 1) > 0$

  - Both terms must be positive, or both terms must be negative. But we know $p < 1$, so $p - 1 < 0$. This means both terms must be negative.

    > $2p - 1 < 0$
    >
    > $2p < 1$
    >
    > $p < .5$

  - So, we should play Game 1 if $0 < p < .5$ and Game 2 if $.5 < p < 1$.
  - If $p = 0$, $0.5$, or $1$, then $P(\text{Game 1}) = P(\text{Game 2})$, so it doesn't matter which game is played.

***

# Question 2: Ants on a Triangle

There are three ants on different vertices of a triangle. What is the probability of collision (between any two or all of them) if they start walking on the sides of the triangle? Assume that each ant randomly picks a direction, with either direction being equally likely to be chosen, and that they walk at the same speed.

## Solution

- The ants will collide if any of them are moving towards each other. So, the only way that they won't collide is if they are all moving in the same direction (clockwise or counterclockwise).
- Since each ant can move in two directions and there are three ants, the probabilities can be represented as such: 

  > $P(\text{clockwise}) = (\frac{1}{2})^3$
  >
  > $P(\text{counterclockwise}) = (\frac{1}{2})^3$ 
  >
  > $P(\text{same direction}) = (\frac{1}{2})^3 + (\frac{1}{2})^3 = \frac{1}{4}$

  - The probability of collision is therefore the probability of the ants _not_ moving in the same direction:
    - The probability of all outcomes is $1$ and the probability of no collisions such that all ants go clockwise or counterclockwise both have a probability of $\frac{1}{8}$ each.


      > $P(\text{collision}) = 1 - P(\text{same direction}) = 1 - \frac{1}{4} = \frac{3}{4}$

      - Therefore, $\frac{1}{8}$ + $\frac{1}{8}$ = $\frac{1}{4}$ and $1 - \frac{1}{4}$ = $\frac{3}{4}$ which gives us the probability of a collision happening to be $75\%$.

- To generalize this to an $n$-vertex polygon:
  - There are still only two ways in which the ants can move to avoid a collision, but there are $2^n$ ways they can move in total where $n$ is the number of vertices in the polygon. Therefore, in general, probability of collision is:

    > $P(\text{clockwise}) = (\frac{1}{2})^n$
    >
    > $P(\text{counterclockwise}) = (\frac{1}{2})^n$
    >
    > $P(\text{same direction}) = 2(\frac{1}{2})^n = (\frac{1}{2})^{n-1}$
    >
    > $P(\text{collision}) = 1 - P(\text{same direction}) = 1 - (\frac{1}{2})^{n-1}$

***

# Question 3: Egg Drop

There is a building of 100 floors. If an egg drops from the Nth floor or above, it will break. If it's dropped from any floor below, it will not break. You're given two eggs. Find N, while minimizing the number of drops for the worst case.

## Solution

- We may observe that, regardless of how we drop $Egg 1$, $Egg 2$ must do a linear search (from lowest to highest) between the "breaking floor" and the next highest "non-breaking" floor. For example, if $Egg 1$ is dropped from floor $5$ and $10$ without breaking, but it breaks when it's dropped from floor $15$, then $Egg 2$ must be dropped, the worst case, from floors $11$, $12$, $13$, and $14$.
- **Approach:**
  - As a first try, suppose we drop an egg from the $10$th floor, then the $20$th floor, $\dots$
    - If $Egg 1$ breaks on the first drop (floor $10$), then we have at most $10$ drops total.
    - If $Egg 1$ breaks on the last drop (floor $100$), then we have at most $19$ drops total: floors $10$, $20$, $\dots$ , $90$, $100$, then $91$ through $99$.
  - That's pretty good, but all we've considered is the absolute worst case. We should do some "load balancing" to make those two cases more even.
  - Our goal is to create a system for dropping $Egg 1$ such that the number of drops is as consistent as possible, whether $Egg 1$ breaks on the first drop or the last drop.
    1. A perfectly load-balanced system would be one in which $Drops(Egg 1) + Drops(Egg 2)$ is always the same regardless of where $Egg 1$ breaks.
    2. For that to be the case, since each drop of $Egg 1$ takes one more step, $Egg 2$ is allowed one fewer step.
    3. We must, therefore, reduce the number of steps potentially required by $Egg 2$ by one drop each time.
       - For example, if $Egg 1$ is dropped on floor $20$ and then floor $30$, $Egg 2$ is potentially required to take $9$ steps. When we drop $Egg 1$ again, we must reduce the potential $Egg 2$ steps to only $8$. That is, we must drop $Egg 1$ at floor $39$.
    4. Therefore, $Egg 1$ must start at floor $X$, then go up by $X-1$ floors, then $X-2$, $\dots$ , until it gets to $100$.
    5. Solve for $X$.

        > $X + (X-1) + (X-2) + \dots + 1 = 100$
        >
        > $\frac{X(X-1)}{2} = 100$
        >
        > $X \approx 13.65$

       - $X$ clearly needs to be an integer. Should we round $X$ up or down?
         - If we round $X$ up to $14$, then we would go up by $14$, then $13$, then $12$, and so on. The last increment would be $4$, and it would happen on floor $99$.
           - If $Egg 1$ broke on any of the prior floors, we know we've balanced the eggs such that the number of drops of $Egg 1$ and $Egg 2$ always sum to the same thing: $14$.
           - If $Egg 1$ hasn't broken by floor $99$, then we just need one more drop to determine it will break at floor $100$.
           - Either way, the number of drops is no more than $14$.
         - If we round $X$ down to $13$, then we would go up by $13$, then $12$, then $11$, and so on. The last increment would be $1$, and it would happen on floor $91$.
           - This is after $13$ drops. Floor $92$ through $100$ have not been covered yet. We can't cover those floors in just one drop (which would be necessary to tie merely tie the "round up" case).
       - Therefore, we should round $X$ up to $14$. That is, we go to floor $14$, then $27$, then $39$, $\dots$ , This takes $14$ steps in the worst case.
       - As with many other _maximizing/minimizing_ problems, the key in this problem is "worst case balancing".

# Source

[Sally Hamouda](https://sallyhamouda.com/)
