# Prolog-2

    2 of 5 planned lectures explaining Prolog.

# Table of Contents

- [Prolog-2](#prolog-2)
- [Table of Contents](#table-of-contents)
- [Functions](#functions)
- [Lists 2](#lists-2)
- [Source](#source)

# Functions

- All _functions_ in Prolog are just _predicates_ that return true or false.
- **Examples:**

  - `functions.pl`

    - Depicts different functions we can write pertaining to lists in Prolog.

    ```prolog
    % Prolog file called "functions.pl"

    % Returns true if empty, else returns false
    isempty([]).

    % If 'X' is the head of the list, it is a member
    % Otherwise, check if 'X' exists in the tail, denoted by 'Z'
    ismember(X, [X| _]).
    ismember(X, [_| Z]) :- ismember (X, Z).

    % Base case, empty list
    % Otherwise, any list with a head and a tail
    isalist([]).
    isalist([_| _]).
    ```

    ```prolog
    /* ISEMPTY */
    % isempty([]).

    ?- consult(functions).  % Load functions.pl

        true.               % Successfully loaded

    ?- [functions].         % Load functions.pl using [filename].

        true.               % Successfully loaded

    ?- isempty([]).

        true.

    ?- isempty(X).

        X = [].

    ?- isempty([sam, alex]).

        false.

    /* ISMEMBER */
    % ismember(X, [X| _]).
    % ismember(X, [_| Z]) :- ismember (X, Z).

    ?- make.                % Reload functions.pl

        true.               % Successfully loaded

    ?- ismember(sam, [sam, alex]).

        true ;

        false.

    ?- ismember (alex, [sam, alex]).

        true ;

        false.

    /* ISALIST */
    % isalist([]).
    % isalist([_| _]).

    ?- make.                % Reload functions.pl

        true.               % Successfully loaded

    ?- isalist([]).

        true.

    ?- isalist([sam, alex]).

        true.

    ?- isalist([sam| alex]).

        true.
    ```

  - `factorial.pl`

    ```prolog
    % Prolog file called "factorial.pl"

    factorial(0,1).             /* Base case, factorial of 0 is 1 */
    factorial(X,Y) :- X > 0,    /* Some outputs below didn't have this line */
                      Z is X-1,
                      factorial(Z,M),
                      Y is M*X.

    sum(0,0).           /* Base case, sum of 0 is 0 */
    sum(X,Y) :- X > 0,  /* Some outputs below didn't have this line */
                Z is X-1,
                sum(Z,M),
                Y is M+X.
    ```

    ```prolog
    ?- [factorial]. % Load factorial.pl

        true.       % Successfully loaded

    /* FACTORIAL */
    % factorial(0,1).
    % factorial(X,Y) :- X > 0,
    %                   Z is X-1,
    %                   factorial(Z,M),
    %                   Y is M*X.

    ?- factorial(0, X).

        X = 1 ;

        false.

    ?- factorial(3, X).

        X = 6 ;

        false.

    ?- trace.

        true.

    [trace] ?- factorial(3, X). % Tracing function call for factorial of 3

        Call: (10) factorial(3, _3672) ? creep
        Call: (11) 3>0 ? creep
        Exit: (11) 3>0 ? creep
        Call: (11) _4214 is 3+ -1 ? creep
        Exit: (11) 2 is 3+ -1 ? creep
        Call: (11) factorial(2, _4303) ? creep
        Call: (12) 2>0 ? creep
        Exit: (12) 2>0 ? creep
        Call: (12) _4440 is 2+ -1 ? creep
        Exit: (12) 1 is 2+ -1 ? creep
        Call: (12) factorial(1, _4530) ? creep
        Call: (13) 1>0 ? creep
        Exit: (13) 1>0 ? creep
        Call: (13) _4666 is 1+ -1 ? creep
        Exit: (13) 0 is 1+ -1 ? creep
        Call: (13) factorial(0, _4756) ? creep
        Exit: (13) factorial(0, 1) ? creep
        Call: (13) _4848 is 1*1 ? creep
        Exit: (13) 1 is 1*1 ? creep
        Exit: (12) factorial(1, 1) ? creep
        Call: (12) _4986 is 1*2 ? creep
        Exit: (12) 2 is 1*2 ? creep
        Exit: (11) factorial(2, 2) ? creep
        Call: (11) _3672 is 2*3 ? creep
        Exit: (11) 6 is 2*3 ? creep
        Exit: (10) factorial(3, 6) ? creep

        X = 6 ; % Result of function call

        Redo: (13) factorial(0, _6084) ? creep  % Calling base case
        Call: (14) 0>0 ? creep
        Fail: (14) 0>0 ? no debug

    false.  % Base case fails

    % Exit trace

    ?- tty_clear    % Clear the terminal

    /* SUM */
    % sum(0,0).
    % sum(X,Y) :- X > 0,
    %             Z is X-1,
    %             sum(Z,M),
    %             Y is M+X.

    ?- sum(0, X).

        X = 0.

    ?- sum(10, X).

        X = 55 ;

        false.
    ```

# Lists 2

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
- **Example:**

  - `lists.pl`

    ```prolog
    % Prolog file called "lists.pl"

    /* Function to append lists */
    /* First two are the inputs, last is the appended list */

    append([],X,X). % If the first parameter ever becomes empty, return the second list to the third parameter
    append(X,[],X). % If the second parameter ever becomes empty, return the first list to the third parameter
    append([X|Y],Z,[X|M]) :- append(Y,Z,M). % Take two lists, append them, and return

    /* Function to find the last element of a list */

    last(X,List) :- append(_,[X],List).

    /* Function to check if X is a member of list List ; fill in the blanks yourself

    member(X,List) :- append(  ,  ,  ). */

    member(X,List) :- append(_,[X|_],List).

    /* Function to check if X and Y are next to each other in a list L */

    nextto(X,Y,L) :- append(_,[X,Y|_],L).

    /* Function to check if X is a sublist of Y */

    sublist(X,Y) :- append(_,X,W), append(W,_,Y).

    /* Function to triple a list */
    /* Given [3] produce [3,3,3] as answer */
    /* X when tripled gives list Y */

    triple(X,XXX) :- append(X,X,XX),
                     append(XX,X,XXX).

    /* Function to reverse a list */
    /* Give X as input, Y is the reversed X */

    reverse([],[]).
    reverse([A|B],Y) :- reverse(B,Z),
                        append(Z,[A],Y).

    /* Function to do bubblesort */
    /* X when bubblesorted gives Y */

    bubblesort(X,Y) :- append(M,[A,B|N],X),
                       A > B,
                       append(M,[B,A|N],S),
                       bubblesort(S,Y).
    bubblesort(L,L).
    ```

    ```prolog
    ?- [lists]. % Load lists.pl

        true.    % Successfully loaded

    /* APPEND */
    % append([],X,X).
    % append(X,[],X).
    % append([X|Y],Z,[X|M]) :- append(Y,Z,M).

    ?- append([1, 2, 3], [4, 5, 6], List).

        List = [1, 2, 3, 4, 5, 6].

    ?- append(List, [4, 5, 6], [1, 2, 3, 4, 5, 6]).

        List = [1, 2, 3].

    ?- append([1, X, 3], [4, 5, 6], [1, 2, 3, 4, 5, 6])

        X = 2.

    ?- trace.

        true.

    [trace] ?- append([1, 2, 3], [4, 5, 6], List).  % Tracing function call on two lists

        Call: (10) append([1, 2, 3], [4, 5, 6], _13514) ? creep
        Call: (11) append([2, 3], [4, 5, 6], _13956) ? creep
        Call: (12) append([3], [4, 5, 6], _14006_) ? creep
        Call: (13) append([], [4, 5, 6], _14056) ? creep    % Invokes base case append([], X, X)
        Exit: (13) append([], [4, 5, 6], [4, 5, 6]) ? creep
        Exit: (12) append([3], [4, 5, 6], [3, 4, 5, 6]) ? creep
        Exit: (11) append([2, 3], [4, 5, 6], [2, 3, 4, 5, 6]) ? creep
        Exit: (10) append([1, 2, 3], [4, 5, 6], [1, 2, 3, 4, 5, 6]) ? creep

        List = [1, 2, 3, 4, 5, 6].  % Result of function call

    /* LAST */
    % last(X,List) :- append(_,[X],List).

    ?- last(X, [1, 2, 3]).

        X = 3.

    ?- trace.

        true.

    [trace] ?- last(X, [1, 2, 3]).  % Tracing function call on a list

        Call: (10) last(_8504, [1, 2, 3]) ? creep
        Call: (11) append(_8984, [_8504], [1, 2, 3]) ? creep    % Refer to how 'last()' is written
        Call: (12) append(_8978, [_8504], [2, 3]) ? creep
        Call: (13) append(_9028, [_8504], [3]) ? creep
        Exit: (13) append([], [3], [3]) ? creep
        Exit: (12) append([2], [3], [2, 3]) ? creep
        Exit: (11) append([1, 2], [3], [1, 2, 3]) ? creep
        Exit: (10) last(3, [1, 2, 3]) ? creep

        X = 3.  % Result of function call
    ```

# Source

[David McPherson](https://people.cs.vt.edu/dmcphers/)
