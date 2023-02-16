# Prolog

    Class lecture going over Prolog.

# Table of Contents

- [Prolog](#prolog)
- [Table of Contents](#table-of-contents)
- [Introduction](#introduction)
- [Swipl REPL](#swipl-repl)
- [Atoms](#atoms)
- [Facts](#facts)
- [Variables](#variables)
- [Rules/Predicates](#rulespredicates)
- [Lists](#lists)
- [Pattern Matching](#pattern-matching)
- [Recursion](#recursion)
- [Cuts](#cuts)
- [Member \& Select Predicates](#member--select-predicates)
- [Resources](#resources)
- [Source](#source)

# Introduction

- Prolog is a declarative, logical programming language.
- Prolog files are interpreted.
- Files are made up of atoms, facts, and rules or productions or predicates.
- Based on Predicate Calculus.
  - Proving something is true or false.
- Originally intended for use in Aritifical Intelligence (AI).
- Some Natural Language Processing (NLP) is done with Prolog.
- Comments are preceded by a percent symbol `%`.

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
  - Enter `A` instead of `Spacebar` during trace to abort the trace.
- `gtrace.` allows tracing with a graphical user interface if Prolog installed locally.
- `make.` reloads the current file.
- `tty_clear` to clear the screen when within the REPL.

# Atoms

- Naming conventions
  - Constants
  - Lowercase words
  - Numbers
  - Etcetera
  - **Examples:**
    - `dog`
    - `cat`
    - `frog`
    - `a`
    - `b`
    - `25`
- Atoms are not variables.
- Cannot be acted on.
- Can be used to [pattern match](#pattern-matching).

# Facts

- Something that is true, at least in the particular system or file.
- All facts and rules end with a `.`.
- **Examples:**
  ```prolog
  animal(cat).      % Cat is an animal, or animal is a cat
  animal(dog).      % Dog is an animal, or animal is a dog
  animal(frog).     % Frog is an animal, or animal is a frog
  ```

# Variables

- Start with uppercase letter.
- Singleton variables are _useless_ in Prolog, and are easily introduced by editing typos.
  - The singleton warning tells you, "You've reserved a name for something here, but you never call anything by that name."
    - If it isn't an obvious typo, replace the name with `_` and see if the code still makes sense.
      - If it doesn't, there may be a logic error.
      - If it does, it was probably unnecessary.
  - The most common cases this warning appears are:
    1. Spelling mistakes in variables
    2. Forget to use/bind a variable
  - SWI suggest some ways to ignore it:
    1. Use anonymous variable named `_` for this purpose.
    2. Use your variable starting with `_` (like `_T`, `_X`), to avoid warning and document what you ignore.
    3. If you are aware of what you are doing, you can use `:- style_check(-singleton)` and all warnings should go away.
- Variable Unification
  ```prolog
  both_like(Who1, Who2, What) :-
      likes(Who1, What),
      likes(Who2, What),
      Who1 \= Who2. % \= is 'not equals'
  ```
  - When the value for variable `Who1` is determined, the `Who1` on the left hand side of `:-` and the `Who1` on the right hand side of `:-` will become _unified_.
    - When they are unified, they get unified to the same value accross the entire rule. The same applies to `Who2` and `What`.

# Rules/Predicates

- `is_animal(X) :- animal(X).` is a predicate.
  - `X` is a variable and must be uppercase.
  - The left hand side is true if the right hand side is true.
  - `is_animal(emu).` returns `false.` and `is_animal(frog).` returns `true.`
    - We have not established `animal(emu).` as a fact but we have established `animal(frog).` as a fact.
- Don't have to be singular like facts.
- **Example 1:**

  ```prolog
  likes(dave, pizza).
  likes(dave, programming).
  likes(dave, running).
  ```

  ```prolog
  % Will return things that 'dave' likes bound to variable "What"
  ?- likes(dave, What).

  What = pizza ;
  What = programming ;
  What = running.
  ```

  - Prolog is going to try to satisfy all of the applicable predicates, rules and facts that it has until it has exhausted them all for a particular invokation, after which it will terminate.

- **Example 2:**

  ```prolog
  likes(kelly, pizza).
  likes(kelly, biking).
  likes(molly, pizza).
  likes(molly, running).
  both_like(Who1, Who2, What) :-
      likes(Who1, What), % Commas act as an "and"
      likes(Who2, What), % Another comma separated condition
      % \= is 'not equals' and must be included to avoid having Who1 and Who2 be the same person
      Who1 \= Who2.
  ```

  ```prolog
  % Variable names don't need to match at call time to the variable names used when declaring the predicate
  ?- both_like(Who, Who1, What).

      Who = dave,
      Whol = kelly,
      What = pizza ;

      Who = dave,
      Whol = molly,
      What = pizza ;

      Who = dave,
      Whol = molly,
      What = running ;

      Who = kelly,
      Whol = dave,
      What = pizza ;

      Who = kelly,
      Whol = molly,
      What = pizza ;

      Who = molly,
      Whol = dave,
      What = pizza ;

      Who = molly,
      Whol = kelly,
      What = pizza ;

      Who = molly,
      Whol = dave,
      What = running ;

      false.
  ```

  - Prolog will exhaust all possible results to the predicate call until no results remain at which point `false.` will return.
  - To continue to cycle through the results, hit enter after each result to call the next result.
  - Hitting the `Spacebar` places a semicolon at the end of the current result and then returns the next result.
    - Hit the `A Key` on your keyboard rather than `Spacebar` to abort the predicate call early (non-exhaustively).

- **Example 3:**

  ```prolog
  % This time we are pre-binding variable "What" to be "pizza"
  ?- both_like(W1, W2, pizza).

      W1 = dave,
      W2 = kelly ;

      W1 = dave,
      W2 = molly ;

      W1 = kelly,
      W2 = dave ;

      W1 = kelly,
      W2 = molly ;

      W1 = molly,
      W2 = dave ;

      W1 = molly,
      W2 = kelly ;

      false.

  % Now we are pre-binding variable "Who2" to be kelly and variable "What" to be "pizza"
  ?- both_like(W1, kelly, pizza)

      W1 = dave ;
      W2 = molly ;
      false.

  % There are currently no declared facts pertaining to "matt" in this system
  ?- both_like(matt, kelly, pizza)

      false.
  ```

  - Prolog will unify and prove whatever it can prove to be true until it cannot.

# Lists

- Lists in prolog are somewhat like in Haskell.
  - `Head` is an element.
  - `Tail` is a (potentially empty) list.
  - `[]` Square brackets to denote lists.
  - `|` Pipe to dilineate head and tail.
- **Examples:**

  ```prolog
  first_two([Head, Head2| Tail]) :-
  writeln(Head),
  writeln(Head2),
  writeln(Tail).
  ```

  ```prolog
  ?- first_two([dog, cat, frog]).

      dog
      cat
      [frog]
      true.

  ?- first_two([dog, cat, frog, emu]).

      dog
      cat
      [frog, emu]
      true.

  ?- first_two([dog, cat]).

      dog
      cat
      []
      true.

  ?- first_two([dog]).

      false.
  ```

  - `h` and `t` are commonly used, "terse" naming conventions to denote "head" and "tail" when dealing with lists in Prolog.

# Pattern Matching

- **Examples:**

  ```prolog
  dog_first([dog| Tail]) :-
      writeln("dog is in the head"),
      write("the rest of the list is "),
      writeln(Tail).
  ```

  ```prolog
  ?- dog_first([dog, cat, frog])

      dog is in the head
      the rest of the list is [cat, frog]
      true.

  ?- dog_first([cat, frog])

      false.
  ```

  ```prolog
  dog_first([Head| Tail]) :-
      write("dog is not in the head :( "),
      writeln(Head),
      write("the rest of the list is "),
      writeln(Tail).
  ```

  ```prolog
  % Returns the first version of the predicate that works for the parameters passed.
  ?- dog_first([cat, frog])

      dog is not in the head :( cat
      the rest of the list is [frog]
      true.
  ```

  - When predicate `dog_first` is called, Prolog will try to find it. Assuming it finds it, it will try the first predicate that matches, and this will be true of rules and facts as well.
  - In this case, because the pattern matching for [cat, frog] does not satisfy the first predicate `dog_first` it will defer to the next one it finds and will apply the rule if the parameters satisfy that version of the rule or predicate.

- **Example: Conditional**

  ```prolog
  dog_first_cond([Head| Tail]) :-
      % Start conditional
      (Head == dog
      % Note that there is no comma
      -> writeln("dog is in the head") % True case
      % Comma here because more than one thing needs to happen
      ; write("dog is not in the head :( "), % Else (False) case
      write(Head)
      ), % Outside of conditional
      % Comma here because more than one thing needs to happen
      writeln("the rest of the list is "), % Always runs
      write(Tail). % Period to terminate
  ```

  ```prolog
  ?- dog_first_cond([dog, cat, frog])

      dog is in the head
      the rest of the list is [cat, frog]
      true.

  ?- dog_first_cond([cat, frog])

      dog is not in the head :( cat
      the rest of the list [frog]
      true.
  ```

# Recursion

- Prolog uses recursion to do looping.
- **Example 1:**
  ```prolog
  list_length([], 0). % Base case
  list_length([Head| Tail], Length) :-
      list_length(Tail, NewLength),
      Length is NewLength + 1.
  ```
  - Once Prolog variables get "unified" they can't change. So a new variable `NewLength` is needed to send into the recursive call so that it gets bound to 0 and then the `Length` variable can be unified to a value.
  - The keyword for numeric assignments in Prolog is `is`.
  - Throws the warning:
    - Singleton Variables: [Head].
- **Example 2:**

  ```prolog
  list_length([], 0). % Base case
  list_length([_| Tail], Length) :-
      list_length(Tail, NewLength),
      Length is NewLength + 1.
  ```

  - In reality, for this predicate, we do not actually _need_ `Head` which is why the "Singleton Variable: [Head]" warning is thrown in Example 1.
  - Example 2 shows the solution to this warning.
  - Because we do not _need_ `Head`, Prolog registers this variable as an orphaned variable of sorts.
  - It would be best to use an _anonymous variable_ in this situation, denoted by `_`.
    - The `_` means it is not a variable and you cannot get to this value, but we need something to be there.
    - We are saying, "There is something in the head, but we do not care what it is for this predicate".

  ```prolog
  ?- list_length([], L)           % In other programming languages, we may "return" a value
  L = 0.                          % In Prolog, we have to provide variables as parameters that it can bind or unify to a value to use as apparatus for return

  ?- list_length([1], L)
  L = 1.

  ?- list_length([1, 2], L)
  L = 2.

  ?- list_length([1, 2, 3], L)
  L = 3.

  ?- list_length([1, 2, 3, 4], L)
  L = 4.
  ```

  - The line, `list_length(Tail, NewLength)` in Examples 1 and 2 is effectively a _Depth First Search_ on this tree.
    - Depth-first search is an algorithm for traversing or searching tree or graph data structures. The algorithm starts at the root node and explores as far as possible along each branch before backtracking.
  - These predicate calls make a tree, although in this case there is just one predicate call.
    - If there were other predicate calls after this line, it would exhaust the depth first branch of the list length recursive call, and _then_ it would start making the other calls.
  - Creating a new variable `NewLength` and then using it immediately on the following line `Length is NewLength + 1.` works because it goes all the way down to the end, hits the base case predicate `ist_length([], 0).` and binds the `Length` to 0 which then gets bound to `NewLength` on the return back out.

    ```prolog
    ?- trace.
    true.

        [trace] ?- list_length([1,2], L)
        Call: (10) list_length([1, 2], _9220) ? creep
        Call: (11) list_length([2], _10454) ? creep
        Call: (12) list_length([], _11210) ? creep
        Exit: (12) list_length([], 0) ? creep
        Call: (12) _10454 is 0+1 ? creep
        Exit: (12) 1 is 0+1 ? creep
        Exit: (11) list_length([2], 1) ? creep
        Call: (11) _9220 is 1+1 ? creep
        Exit: (11) 2 is 1+1 ? creep
        Exit: (10) list_length([1, 2], 2) ? creep

    L=2.
    ```

    - Trace of the predicate call `list_length([1, 2], L)`.

# Cuts

- **Example:**

  ```prolog
  init([], []).               % Base case: Pass empty list, return empty list
  init([X], []).              % Pass a one element list, return empty list
  init([Head, Tail], [Head]). % Pass a two element list, return a one element list
  init([Head| Tail], [Head| Init]) :-
      init(Tail, Init).
  ```

  - This returns some "Singleton Variable" errors, lets fix those:

    ```prolog
    init([], []).
    init([_], []).              % Replaced singleton variable here
    init([Head, _], [Head]).    % Replaced singleton variable here as well
    init([Head| Tail], [Head| Init]) :-
        init(Tail, Init).
    ```

    ```prolog
    ?- init([], Init).

        Init = [].      % Works as intended

    ?- Init([1], Init).

        Init = [] ;
        Init = [1].     % That's not quite right
    ```

  - Let's introduce some print statements to manually debug. This turns the first three from _facts_ into _predicates_ (the last one is already a predicate).

    ```prolog
        init([], []) :- writeln("base case for empty list").              % Written to help debug
        init([_], []) :- writeln("case for a 1 element list").            % Written to help debug
        init([Head, _], [Head]) :- writeln("case for a 2 element list").  % Written to help debug
        init([Head| Tail], [Head| Init]) :-
            writeln("recurisve call")       % Written to help debug
            writeln(Head),                  % Additional information for debugging
            writeln(Tail),                  % Additional information for debugging
            init(Tail, Init).
    ```

    ```prolog
    ?- init([], Init).

        base case for empty list
        Init = [].

    ?- init([1], Init).

        case for a 1 element list
        Init = [] ;
        recursive call
        1
        []
        base case for empty list
        Init = [1].
    ```

  - Prolog continues to try to satisfy the predicates triggered by the result of the first predicate which in this case leads to:
    1. The recursive call (head is 1, tail is empty).
    2. which then leads to the base case (empty list).
  - This can be resolved using a _cut_.

    - A "cut" is an exclamation mark `!` that always returns `true` essentially acting as a return that prevents Prolog from attempting to satisfy any more predicates.

      ```prolog
      init([], []) :- writeln("base case for empty list").
      init([_], []) :- !, writeln("case for a 1 element list").           % Introduced a "cut" here
      init([Head, _], [Head]) :- writeln("case for a 2 element list").
      init([Head| Tail], [Head| Init]) :-
          writeln("recurisve call")
          writeln(Head),
          writeln(Tail),
          init(Tail, Init).
      ```

      ```prolog
      ?- init([], Init).

          base case for empty list
          Init = [].

      ?- init([1], Init).

          case for a 1 element list
          Init = []. % Now this one works

      % Let's continue to check the other cases
      ?- init([1, 2], Init).

          case for a 2 element list
          Init = [1]          % We get the correct answer but...
          recursive call      % We seem to end up in the recursive predicate and so on so forth
          1
          [2]
          base case for a 1 element list
          Init = [1]. % Causing us to return the correct answer more than once
      ```

      - Let's introduce another "cut" to the code.

        ```prolog
        init([], []) :- writeln("base case for empty list").
        init([_], []) :- !, writeln("case for a 1 element list").           % Introduced a "cut" here
        init([Head, _], [Head]) :- !, writeln("case for a 2 element list"). % Introduced another "cut" here
        init([Head| Tail], [Head| Init]) :-
            writeln("recurisve call")
            writeln(Head),
            writeln(Tail),
            init(Tail, Init).
        ```

        ```prolog
        ?- init([], Init).

            base case for empty list
            Init = [].

        ?- init([1], Init).

            case for a 1 element list
            Init = []. % Now this one works

        % Let's continue to check the other cases
        ?- init([1, 2], Init).

            case for a 2 element list
            Init = [1]. % Now this one works as well

        ?- init ([1, 2, 3, 4, 5], Init)

            recursive call
            1
            [2, 3, 4, 5]
            recursive call
            2
            [3, 4, 5]
            recursive call
            3
            [4, 5]
            case for a 2 element list
            Init = [1, 2, 3, 4, 5]. % This one also works fine with the amount of "cuts" currently present in the code
        ```

        - Be careful with "cuts" as they can sometimes prevent backtracking when you actually do need it to occur.
        - In this case, once we determined what `Init` was, we no longer needed to look for it.
          ```prolog
          init([], []).
          init([_], []) :- !.
          init([Head, _], [Head]) :- !.
          init([Head| Tail], [Head| Init]) :-
              init(Tail, Init).
          ```
          - Removed the write statements to clean up the code after debugging and to exemplify how to use "cuts" with facts rather than predicates
            - Reminder that the code we were working with were predicates due to the `:-` introduced in order to implement writeln for debugging purposes.

# Member & Select Predicates

- `member` predicate:

  ```prolog
  % Automatically traverses
  ?- member(Who, [cat, dog, frog, emu]) % The "member" predicate is naturally backtracking

      Who = cat ;
      Who = dog ;
      Who = frog ;
      Who = emu.
  ```

- `select` predicate:

  ```prolog
  % Similar to "member" predicate but with an extra parameter
  ?- select(Who, [cat, dog, frog, emu], NewList) % Additional variable parameter "NewList"

      % Selects like member does but also binds unselected list elements to a "NewList"

      Who = cat,
      NewList = [dog, frog, emu] ;

      Who = dog,
      NewList = [cat, frog, emu];

      who = frog,
      NewList = [cat, dog, emu];

      who = emu,
      NewList = [cat, dog, frog].
  ```

- **Examples:**

  ```prolog
  member_list_update(List, Member, NewList) :-
      select(Member, List, NewList).
  ```

  ```prolog
  ?- member_list_update([dog, cat, frog, emu], Who, NewList).

      Who = dog,
      NewList = [cat, frog, emu] ;

      Who = cat,
      NewList = [dog, frog, emu] ;

      Who = frog,
      NewList = [dog, cat, emu] ;

      Who = emu,
      NewList = [dog, cat, frog].
  ```

  - This works exactly like the select predicate up above, so why might we want to do this?

    - Maybe we need a list of _all_ of the _selections_ that got made:

      ```prolog
      give_me_all(List, BagOfMembers) :-
          findall(Member, select(Member, List, NewList), BagOfMembers).

      % Compiling throws this warning which will be addressed later
      Warning: Singleton variables: [NewList]
      ```

      1. Predicate `findall` takes a predicate that is backtrackable, like `select` or `member`, and it calls that predicate `findall(... , select(Member, List, NewList), ...)`.
      2. A value is found by the backtrackable predicate parameter, in this example, `Member`, in `select(Member, List, NewList)`.
      3. The found value is bound to the `Member` parameter of `findall` in `findall(Member, ... , ...)`.
      4. Predicate `findall` will then make a _collection_ or a _bag_ or a _list_ of those _things_, here called `Member`s, and bind it to the third parameter `findall(... , ... , BagOfMembers)`.

      ```prolog
      ?- give_me_all([dog, cat, frog, emu], Bag).

          Bag = [dog, cat, frog, emu].
      ```

    - What if we switched which `select` paramater was being found by `findall`?

      ```prolog
      give_me_all(List, BagOfLists) :-
          findall(NewList, select(Member, List, NewList), BagOfLists).

      % Compiling throws this warning which will be addressed later
      Warning: Singleton variables: [Member]
      ```

      - We made three changes
        1.  Changed the name of the first variable parameter for `findall` from `Member` to `NewList`.
            - Note that we named it `NewList` and not `List` which is reserved as the variable name of the first parameter for the `give_me_all` predicate.
        2.  Changed the name of the second variable parameter for `give_me_all` from `BagOfMembers` to `BagOfLists`.
        3.  Changed the name of the third variable parameter for `findall` from `BagOfMembers` to `BagOfLists`.

      ```prolog
      ?- give_me_all([dog, cat, frog, emu], Bag).

          Bag = [[cat, frog, emu], [dog, frog, emu], [dog, cat, emu], [dog, cat, frog]].
      ```

      > **Aside:** If both of the `give_me_all` parameters are written,
      >
      > > ```prolog
      > > give_me_all(List, BagOfMembers) :-
      > >    findall(Member, select(Member, List, NewList), BagOfMembers).
      > >
      > > give_me_all(List, BagOfLists) :-
      > >    findall(NewList, select(Member, List, NewList), BagOfLists).
      > > ```
      > >
      > > Then compiling and running `give_me_all` returns the output,
      > >
      > > ```prolog
      > > ?- give_me_all([dog, cat, frog, emu], Bag).
      > >
      > >    % First give_me_all predicate
      > >    Bag = [dog, cat, frog, emu] ;
      > >
      > >    % Second give_me_all predicate
      > >    Bag = [[cat, frog, emu], [dog, frog, emu], [dog, cat, emu], [dog, cat, frog]].
      > > ```
      > >
      > > Notice that Prolog calls the predicate it comes across first and then runs the next version of it. This happens because they are both predicates with the same name _and_ the same number of parameters. The names of the parameters don't need to be the same for Prolog to consider them the _same_ predicate call.
      > >
      > > ```prolog
      > > % Changed all instances of variable parameter name BagOfMembers to Bag
      > > give_me_all(List, Bag) :-
      > >    findall(Member, select(Member, List, NewList), Bag).
      > >
      > > % Changed all instances of variable parameter name BagOfLists to Bag
      > > give_me_all(List, Bag) :-
      > >    findall(NewList, select(Member, List, NewList), Bag).
      > > ```
      > >
      > > Because of this fact, we can simplify the variable parameter names to be `Bag` for both predicates.

    - Lastly, lets fix the `Warning: Singleton variables` warnings being thrown.

      ```prolog
      give_me_all(List, BagOfMembers) :-
          findall(Member, select(Member, List, _), BagOfMembers). % _ used to be "NewList"

      give_me_all(List, BagOfLists) :-
          findall(NewList, select(_, List, NewList), BagOfLists). % _ used to be "Member"
      ```

    - If we want to write both versions of the `give_me_all` as one predicate we can do so as shown.

      ```prolog
      now_really_give_me_all(List, Bag1, Bag2) :-
          findall(Member, select(Member, List, NewList), Bag1), % Does the same thing as first give_me_all predicate
          findall(NewList, select(Member, List, NewList), Bag2). % Does the same thing as second give_me_all predicate
      ```

      ```prolog
      ?- now_really_give_me_all([dog, cat, frog, emu], B1, B2).

          B1 = [dog, cat, frog, emu],
          B2 = [[cat, frog, emu], [dog, frog, emu], [dog, cat, emu], [dog, cat, frog]].
      ```

      - Accomplishing the same outcome in two different ways using the `select` predicate.

# Resources

[SWI-Prolog](https://www.swi-prolog.org/)

# Source

[David McPherson](https://people.cs.vt.edu/dmcphers/)
