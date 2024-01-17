# Prolog-1

    1 of 5 planned lectures explaining Prolog.

# Table of Contents

- [Prolog-1](#prolog-1)
- [Table of Contents](#table-of-contents)
- [Introduction](#introduction)
- [Swipl REPL](#swipl-repl)
- [Facts \& Predicates/Rules](#facts--predicatesrules)
- [Lists 1](#lists-1)
- [If](#if)
- [Source](#source)

# Introduction

- Prolog is a declarative, logical programming language.
- State what the _facts_ are and then state some _rules_ or _predicates_ about how those facts are related.
- Ask Prolog queries or questions that it will answer if it is able to with the information we define within the particular file.
- Prolog file extension is `.pl`.
  - Note that `pl.` happens to be the same file extension for Perl files.

# Swipl REPL

- `swipl` is the REPL for Prolog.

  - REPL is "Read-Eval-Print Loop"

    ```
    swipl

    Welcome to SWI-Prolog

    For online help and background, visit https://www.swi-prolog.org
    For built-in help, use ?- help(Topic). or ?- apropos(Word).
    ```

- `[file].` will load or consult a file.
  - `consult(file).` can also be used.
    - Do not include the `.pl` extension when invoking these commands.
- `halt.` to quit the REPL.
- `trace.` allows us to trace the invokation of a particular predicate, the iteration from one step in the trace to the next is called a _creep_.
  - Exit trace using `notrace.`
  - Enter `a` instead of `Enter Key` during trace to abort the trace.
- `gtrace.` allows tracing with a graphical user interface if Prolog installed locally.
- `make.` reloads the current file.
- `tty_clear` to clear the screen when within the REPL.

# Facts & Predicates/Rules

- Written with lowercase letters.
- End of a predicate / rule indicated by the `.` char.
- **Examples:**

  - `animal.pl`

    ```prolog
    % Prolog file called "animal.pl"

    animal(cow).
    animal(dog).
    animal(rabbit).
    animal(yak).
    animal(emu).
    ```

    ```prolog
    ?- consult(animal). % Load animal.pl

        true.           % Successfully loaded

    ?- animal(dog).

        true.   % This fact is defined in the file so it returns true

    ?- animal(emu).

        true.   % This fact is defined in the file so it returns true

    ?- animal(cat).

        false.  % This fact is not defined in the file so it returns false

    ?- animal(WhatIWant).   % Here we are using 'WhatIWant' as a variable

        WhatIWant = cow ;
        WhatIWant = dog ;
        WhatIWant = rabbit ;
        WhatIWant = yak ;
        WhatIWant = emu.
    ```

    - Add `animal(cat)` to `animal.pl`.

      ```prolog
      animal(cow).
      animal(dog).
      animal(rabbit).
      animal(yak).
      animal(emu).
      animal(cat).    % Added
      ```

      ```prolog
      ?- make.      % Reloads Prolog file

          true.     % Successuflly reloaded

      ?- animal(cat).

          true.

      ?- animal(X), animal(Y).    % Commas can be read as "and" in Prolog

          X = Y, Y = cow ;    % Associativity

          X = cow,
          Y = dog ;

          X = cow,
          Y = rabbit ;

          ...

          X = cat,
          Y = yak ;

          X = cat,
          Y = emu ;

          X = Y, Y = cat.

      ?- animal(X), animal(Y), X \= Y.    % "Not equal" indicated by \= omits associative answers

          X = cow,
          Y = dog ;

          X = cow,
          Y = rabbit ;

          ...

          X = cat,
          Y = yak ;

          X = cat,
          Y = emu.
      ```

  - `likes.pl`

    ```prolog
    % Prolog file called "likes.pl"

    likes(sam, alex).
    likes(alex, games).
    likes(sam, sam).
    ```

    ```prolog
    ?- consult(likes)   % Load likes.pl

        true.           % Successfully loaded

    ?- likes(sam, X), likes(X, games).  % The 'X' across these two queries is the same shared variable

        X = alex ;

        false.  % No more answers satisfy the query

    ?- likes(sam, X), likes(Y, games).

        X = Y, Y = alex ;   % Associativity

        X = sam,
        Y = alex.

    ?- likes(sam, X), likes(Y, games), X == Y.  % X and Y are the same

        X = Y, Y = alex ;
        false.  % No more answers satisfy the query

    ?- likes(sam, X), likes(Y, games), X \= Y.  % "Not equal" indicated by \= omits associative answers

        X = sam,
        Y = alex.
    ```

# Lists 1

- `[X| Y]`
  - `X` is the head of the list.
  - `Y` is the tail of the list.
    - Could be empty `[]`.
    - Could be a single element `[elem_0]`.
    - Could be more than one elements `[elem_0, elem_1, elem_2, ..., elem_n]`.
- `[X, Y]`
  - A list of _just_ two elements `X` and `Y`.
- `[X, Y| Z]`
  - A list where `X` is the first element, `Y` is the second element, and `Z` is the tail of the list.
- `[X, Y, W| Z]`
  - A list where `X` is the first element, `Y` is the second element, `W` is the third element, and `Z` is the tail of the list.
- **Examples:**

  - `lists.pl`

    ```prolog
    % Prolog file called "lists.pl"

    ihave([pencil, pen, watch]).                            % Rule 1
    ihave([cs3304, cs4804, cs4234, cs3204]).                % Rule 2
    ihave([nolife]).                                        % Rule 3
    ihave([[ford, 2011, fiesta], [honda, 2016, crv]]).      % Rule 4
    ihave([book, [pen1, pen2], [dollar]]).                  % Rule 5
    ihave(nolife).                                          % Rule 6
    ```

    ```prolog
    ?- consult(lists).  % Load list.pl

        true.           % Successfully loaded

    ?- ihave(X).

        X = [pencil, pen, watch] ;                          % List from Rule 1
        X = [cs3304, cs4804, cs4234, cs3204] ;              % List from Rule 2
        X = [nolife] ;                                      % List from Rule 3
        X = [[ford, 2011, fiesta], [honda, 2016, crv]] ;    % List of Lists from Rule 4
        X = [book, [pen1, pen2], [dollar]] ;                % List of Atom and Lists from Rule 5
        X = nolife.                                         % Atom from Rule 6

    ?- ihave[X| Y].

        X = pencil,                                         % Head of List in Rule 1
        Y = [pen, watch] ;                                  % Tail of List in Rule 1

        X = cs3304,                                         % Head of List in Rule 2
        Y = [cs4804, cs4234, cs3204] ;                      % Tail of List in Rule 2

        X = [nolife],                                       % Head of List in Rule 3
        Y = [] ;                                            % Tail of List in Rule 3 returns Empty List

        X = [ford, 2011, fiesta],                           % Head of List in Rule 4
        Y = [[honda, 2016, crv]] ;                          % Tail of List in Rule 4

        X = book,                                           % Head of List in Rule 5
        Y = [[pen1, pen2], [dollar]].                       % Tail of List in Rule 5

        % Rule 6 does not return a value for this query because Rule 6 is not a list
    ```

# If

- Denoted by `:-` in Prolog.
- **Example:**

  - `courses.pl`

    ```prolog
    % Prolog file called "courses.pl"

    cscourse(cs3304).           % Rule 1
    cscourse(cs4804).           % Rule 2
    bwcourse(bw101).            % Rule 3
    easy(X) :- cscourse(X).     % Rule 4
    easy(bw101).                % Rule 5
    ```

    - Rule 4 uses `:-` which denotes `if` in Prolog.
      - `X` is `easy` if, denoted by `:-`, `X` is a `cscourse`.
      - Alternatively, can be read as:
        - "In order to be `easy`, `X` has to be a `cscourse`."
        - "To satisfy the `easy` clause, the clause after the `:-` must be true."

    ```prolog
    ?- consult(courses).    % Load courses.pl

        true.               % Successfully loaded

    ?- cscourse(X).

        X = cs3304 ;

        X = cs4804.

    ?- easy(X).

        X = cs3304 ;    % Returned by Rule 4
        X = cs4804 ;    % Returned by Rule 4
        X = bw101.      % Returned by Rule 5
    ```

# Source

[David McPherson](https://people.cs.vt.edu/dmcphers/)
