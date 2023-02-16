# Signals (L-P6)

- An old, low-level mechanism whose development roots back to Unix.
- Fixed set of events.
  - Fall under synchronous (interally generated event by the process) or asynchronous (externally generated event unrelated to what the process currently does).
- User defined handler is some code written by the programmer to handle some SIGNAL. // Not sure abt this, double check
- Signals have sensible default actions depending on what triggered them.
  - Example: Segfault (SIGSEGV)
    - Default action (1) which is to terminate the process
  - Terminal input and output, suspend a process temporarily if they are trying to do something that can't be done (e.g. no access to terminal etcetera) // double check this
- SIGTERM is the default to terminate and can be ignored, SIGKILL on the other hand cannot be caught or ignored
  - Same deal with SIGSTOP, can't be caught or ignored.
- SIGCHLD will be used in proj 1.
  - Gives recieving process an opportunity to reap the outcome of the child.
- Ctrl+Z and Ctrl+C are sent by the operating system and does not involve your shell, contrary to popular belief // double check
- Signal handlers in a way are spontaneously called where the kernel will take the currently executing process and tweak its state to allow another process to run after which's termination the originial process will continue to run? // not sure he spoke too fast but it was related to one of the SIG demos
  - Alarm went off but the program has not exited.
  - Compiler essentially did this : int should_I_exit = should_exit and then used !should_I_exit in the loop where the intiial value of should_I_exit is zero (because should_exit is 0)
    - Compilers don't know about Signals
    - We can handle this by using the "volatile" keywork, e.g. static volative int should exit
- Figure 1
  - Mode switch to kernel mode so the kernel knows to set up the handler
  - Handler returns back into the kernel which sees it is returning something to the original program?
  - Kernel resume the regular program
- There might be some points in your program where you dont want a signal handler to be triggered
  - Linked list class for project 1 in the provided code
    - Suppose we want to remove an items from the list, this requires us to rearrange some pointers as a result.
    - Lets say we want to insert a new element, we need to update 4 pointers.
    - Notice that the starter code list_insert is not checking for NULL.
      - If we have a list that terminates to null, does this code work?
        - It does not.
        - This code is for a type of list that is implemented using ??? sentiments? segments? SENTILAL i think.
        - When we start with an empty list, it will point to itself rather than to NULL. It is the head and the tail.
          - see list_init
          - Checking for null complicates and slows down code.
  - What if the child returns before the job was even added to the job list (before an insert happened).
    - The program might have only gone as far as the second movq. But the signal is being delivered.
      - See picture.
      - This is a problem because only two of the four pointers have been set and so now the list is in an incosistent state.
        - If at this point we read code that would act on this list, that code would not work correctly because the list is not in a consistent state.
- There are some points in the code where we don't want to return a Signal.
  - The answer is to use Blocking/Masking Signals.
    - Im going to do someething where I dont want to take the signal. Even if the signal becomes pending, do not take it, wait until some other point to take it. This is called blocking.
      - Here blocking means to keep away rather than to tempoarily suspend as was meant in previous lectures of simplified process states.
      - Blocking, in this context, is also called masking.
  - Figure 2 ^^^ Does this have to do with zombie processes ?
- Async-Signal safety has to do with, is it safe to call a function from the signal handler when that same function is executed?
  - It may have been in the middle of manipulating some data, is it okay to call a signal here or do we need to block the signal until a later point?
  - POSIX defines a list of functions that are safe to invoke from the signal handler even if those function are in progress at the time of the signal call // look into this more
    - printf is not on this list...or is it, idk i have to double check
    - write is on the list tho
- A signal that is sent twice is not pending twice, signals dont queue.
  - The second attempt to send the signal will be ignored.
  - We need to compensate for this shortcoming.
    - We need to understand that there may have been some signals that were sent while another was being blocked.
      - How does this effect the behavior of our program ?
  - WUNTRACED
    - Also tell me about the child processes that have stopped? Check what this actually means later maybe.
- See what code shows up in the demos on the website.
- See `wait_for_job` to block SIGCHILD. See starter code?
  
# Day 2

- Signals are sent by the kernel or by the user executing some command, what a process is doing will determine this.
- Signal could ignored, (something else), or handled
  - Handling is useful for handling events asynchronously
  - Mask the signal or block it so I can finish what I am doing uninterrupted, once i finish, now you can deliver that signal we blocked or masked before.

# SIGSEGV Demo

- We get a seg fault, what to do?
  1. Run valgrind because it will give you a decent amount of useful information.
  2. See demo.
  3. Keep in mind the infinite loop is caused because we are trying to dereference a null pointer in the print statement, but we cannot output the print without retrieving data, so it is segfaulting infinitely because we call it on a segfault and there is no print statement because of the segfaults.