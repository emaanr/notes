# Prolog-5

    5 of 5 planned lectures explaining Prolog.

# Table of Contents

- [Prolog-5](#prolog-5)
- [Table of Contents](#table-of-contents)
- [Cuts 2](#cuts-2)
- [Not](#not)
- [Source](#source)

# Cuts 2

- In Prolog, a _cut_ prevents consideration of alternate solutions by freezing parts of the current solution.
- A _cut_ is denoted by the symbol `!` and is the _goto_ of Prolog, use it with great precaution.
- By itself, _cut_ always evaluates to true.
- **Examples:**

  - `gettingback.pl`

    ```prolog
    % Prolog file called "gettingback.pl"

    /* More Practice with Cuts
    Determine what each of back1, back2, and back3 will print */

    back1 :- example(X),
             d(Y),
             write(X), write(Y), nl,
             fail.

    back2 :- example(X), !,
             d(Y),
             write(X), write(Y), nl,
             fail.

    back3 :- example(X),
             e(Y),
             write(X), write(Y), nl,
             fail.

    example(1).
    example(2).

    d(1).
    d(2).
    d(3).

    e(1) :- !.
    e(2).
    ```

    ```prolog
    ?- [gettingback].   % Load gettingback.pl

        true.           % Successfully loaded

    ?- back1.

        11
        12
        13
        21
        22
        23
        false.

    ?- back2.

        11
        12
        13
        false.

    ?- back3.

        11
        21
        false.
    ```

  - `newancestor.pl`

    ```prolog
    % Prolog file called "newancestor.pl"

    ancestor(X, Y) :- parent(X, Z), ancestor(Z, Y).
    ancestor(X, X).
    parent(ash, max).

    /* Query is ancestor(X, max) */

    /*
        Try these various combos:

        ancestor(X,Y) :- parent(X,Z), !, ancestor(Z,Y).
        ancestor(X,X).
        parent(ash, max).

        ancestor(X,Y) :- !, parent(X,Z), ancestor(Z,Y).
        ancestor(X,X).
        parent(ash, max).

        ancestor(X,Y) :- parent(X,Z), ancestor(Z,Y).
        ancestor(X,X) :- !.
        parent(ash, max).
    */
    ```

  - `hanoi.pl`

    ```prolog
    % Prolog file called "hanoi.pl"

    /* Move 'n' disks from peg 'a' to peg 'b' using peg 'c' as intermediary move(N,A,B,C) */

    move(0,_,_,_) :- !.
    move(N,A,B,C) :- M  is N-1,
                     move(M,A,C,B),
                     step(A,B),
                     move(M,C,B,A).

    step(A,B) :- write('move a disk from peg '),
                 write(A),
                 write(' to peg '),
                 write(B),
                 nl.

    ```

    ```prolog
    ?- [hanoi].     % Load hanoi.pl

        true.       % Successfully loaded

    ?- move(0, a, b, c).

        true.

    ?- move(1, a, b, c).

        move a disk from peg a to peg b
        true.

    ?- move(1, a, b, c).

        move a disk from peg a to peg b
        move a disk from peg a to peg c
        move a disk from peg b to peg c
        move a disk from peg a to peg b
        move a disk from peg c to peg a
        move a disk from peg c to peg b
        move a disk from peg a to peg b
        true.

    ?- move(3, X, Y, Z).

        move a disk from peg _18368 to peg _18370
        move a disk from peg _18368 to peg _18372
        move a disk from peg _18370 to peg _18372
        move a disk from peg _18368 to peg _18370
        move a disk from peg _18372 to peg _18368
        move a disk from peg _18372 to peg _18370
        move a disk from peg _18368 to peg _18370
        true.
    ```

# Not

- In Prolog, `not` negates.
  - Effectively the `!` used to negate in other languages, but for Prolog.
    - Likely because `!` is reserved for _cuts_ in Prolog.
- **Example:**

  - `not.pl`

    ```prolog
    % Prolog file called "not.pl"

    human(dave).
    human(kelly).
    ```

    ```prolog
    ?- [not].   % Load not.pl

        true.   % Successfully loaded

    ?- human(X).

        X = dave ;
        X = kelly.

    ?- not(not(human(X))).

        true.

    ?- not(human(X)).

        false.

    ?- X = 0, not(X = 1).   % Second predicate is effectively 'not(false.)' which is 'true.'

        X = 0.

    ?- not(X = 1), X = 0.   % Calls 'not' on an unbound variable

        false.
    ```

# Source

[David McPherson](https://people.cs.vt.edu/dmcphers/)
