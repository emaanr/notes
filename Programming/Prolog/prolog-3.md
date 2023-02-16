# Prolog-3

    3 of 5 planned lectures explaining Prolog.

# Table of Contents

- [Prolog-3](#prolog-3)
- [Table of Contents](#table-of-contents)
- [Lists 3](#lists-3)
- [Depth-First Search](#depth-first-search)
- [Source](#source)

# Lists 3

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
    ?- [lists].     % Load lists.pl

        true.       % Successfully loaded

    /* MEMBER */
    % member(X,List) :- append(_,[X|_],List).

    ?- member(3, [1, 2, 3]).

        true.

    ?- member(X, [1, 2, 3]).

        X = 1 ;
        X = 2 ;
        X = 3 ;

        false.

    ?- member(3, List).

        List = [3| _18454].

    ?- member(3, [1, 2, X]).

        X = 3.

    ?- member(3, [1, 2, 3, X]).

        true.

    /* NEXTTO */
    % nextto(X,Y,L) :- append(_,[X,Y|_],L).

    ?- nextto(1, Y, [1, 2, 3]).

        Y = 2.

    ?- nextto(Y, 3, [1, 2, 3]).

        Y = 2.

    ?- nextto(1, 3, [1, 2, 3]).

        false.

    /* SUBLIST */
    % sublist(X,Y) :- append(_,X,W), append(W,_,Y).

    ?- sublist([1, 2], [1, 2, 3]).

        true.

    ?- sublist([1, 2], Y).

        Y = [1, 2].

    ?- sublist([1, 2], [2, X, Y]).

        X = 1,
        Y = 2.

    /* TRIPLE */
    % triple(X,XXX) :- append(X,X,XX),
    %                  append(XX,X,XXX).

    ?- triple([1], List).

        List = [1, 1, 1].

    ?- triple([1, 2, 3], List).

        List = [1, 2, 3, 1, 2, 3, 1, 2, 3].

    ?- triple([a, b, c], List).

        List = [a, b, c, a, b, c, a, b, c].

    ?- triple(List, [1, 1, 1]).

        List = [1].

    ?- triple(List, [a, b, c, a, b, c, a, b, c]).

        List = [a, b, c].

    /* REVERSE */
    % reverse([],[]).
    % reverse([A|B],Y) :- reverse(B,Z),
    %                     append(Z,[A],Y).

    ?- reverse([1, 2, 3], List).

        List = [3, 2, 1].

    ?- reverse(List, [3, 2, 1]).

        List = [1, 2, 3].

    /* BUBBLESORT */
    % bubblesort(X,Y) :- append(M,[A,B|N],X),
    %                    A > B,
    %                    append(M,[B,A|N],S),
    %                    bubblesort(S,Y).
    % bubblesort(L,L).

    ?- bubblesort([2, 3, 1], List).

        List = [1, 2, 3].
    ```

# Depth-First Search

- What is the _Depth-First Search_ Algorithm?
  - The algorithm starts at the root node (selecting some arbitrary node as the root node in the case of a graph) and explores as far as possible along each branch before _backtracking_.
  - This is how Prolog goes about finding all solutions that satisfy a predicate query or function call.
- **Example:**

  - `family.pl`

    ```prolog
    % Prolog file called "family.pl"

    ancestor(X, X).
    ancestor(X, Y) :- ancestor(Z, Y), parent(X, Z).
    parent(ash, max).
    ```

    ```prolog
    ?- [family].

        true.

    ?- ancestor(ash, ash).

        true.

    ?- ancestor(ash, max).

        true.

    ?- ancestor(max, ash).

        % Gets stuck here due to depth-first search
        % We are calling 'ancestor(X, Y) :- ancestor(Z, Y), parent(X, Z).'
        %   This results in 'ancestor(Z, ash), parent(max, Z).'
        %   Causing the predicate call to get infinitely stuck in the 'ancestor(Z, ash)' call

        ERROR: Stack limit exceeded
    ```

# Source

[David McPherson](https://people.cs.vt.edu/dmcphers/)
