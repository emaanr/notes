# Prolog-4

    4 of 5 planned lectures explaining Prolog.

# Table of Contents

- [Prolog-4](#prolog-4)
- [Table of Contents](#table-of-contents)
- [Cuts 1](#cuts-1)
- [Source](#source)

# Cuts 1

- In Prolog, a _cut_ prevents consideration of alternate solutions by freezing parts of the current solution.
- A _cut_ is denoted by the symbol `!` and is the _goto_ of Prolog, use it with great precaution.
- By itself, _cut_ always evaluates to true.
- **Examples:**

  - `skinner.pl`

    ```prolog
    % Prolog file called "skinner.pl"

    /* Predicate 'squarelist' takes a list of integers and squares every entry */

    squarelist([], []).                                 % Rule 1
    squarelist([A| B], [C| D]) :- integer(A),           % Rule 2
                                  C is A*A,
                                  squarelist(B, D).
    squarelist([A| B], [A| D]) :- squarelist(B, D).     % Rule 3
    ```

    ```prolog
    ?- [skinner].   % Load skinner.pl

        true.       % Successfully loaded

    ?- squarelist([1, 2, 3], List).

        List = [1, 4, 9] ;  % We just want this result
        List = [1, 4, 3] ;  % But all these other results are called as well
        List = [1, 2, 9] ;
        List = [1, 2, 3] ;
        List = [1, 4, 9] ;
        List = [1, 4, 3] ;
        List = [1, 2, 9] ;
        List = [1, 2, 3].
    ```

    - Add _cut_ to `skinner.pl`

      ```prolog
      % Prolog file called "skinner.pl"

      /* Predicate 'squarelist' takes a list of integers and squares every entry */

      /* Cut here is doing:
          - Fix Rule 2 when you know 'A' is an integer
          - Skip all the subsequent Rules (In this case, Rule 3)
      */

      squarelist([], []).                                 % Rule 1
      squarelist([A| B], [C| D]) :- integer(A), !,        % Rule 2    % Cut placed here
                                    C is A*A,
                                    squarelist(B, D).
      squarelist([A| B], [A| D]) :- squarelist(B, D).     % Rule 3
      ```

      ```prolog
      ?- make.    % Reloads Prolog file

          true.   % Successfully reloaded

      ?- squarelist([1, 2, 3], List).

          List = [1, 4, 9].   % Now notice that this is the only result that is returned
      ```

  - `green.pl`

    ```prolog
    % Prolog file called "green.pl"

    /* Cut by itself always evalutes to true */

    drink(beer).
    drink(gin) :- !.
    drink(juice).

    /* Try the above code with the following queries:
    drink(X).
    drink(X), drink(Y).
    drink(X), ?, drink(Y) */

    /* Cut prevents multiple solutions from being produced. */

    member(X,[X|_]) :- !.
    member(X,[_|Y]) :- member(X,Y).

    /* max - first two are input arguments, last is the result of max */

    /* max(X,Y,X) :- X>=Y.
       max(X,Y,Y) :- X<Y. */

    /* Don't try to simulate if-then-else loop in Prolog.
    Make each clause stand independently by itself. */

    /* max(X,Y,X) :- X>=Y, !.
       max(X,Y,Y). */

    /*
        if x>=y then return(x)
        else return (y)
    */

    /* The nice way to write the max predicate is: */
    max(X,Y,X) :- X>=Y, !.
    max(X,Y,Y) :- X<Y.

    /*
        "if A then B else C"
        - in C-like language

        In Prolog-like notation, this will
        look like:

        B :- A, !.
        C :- not(A).
    */
    ```

# Source

[David McPherson](https://people.cs.vt.edu/dmcphers/)
