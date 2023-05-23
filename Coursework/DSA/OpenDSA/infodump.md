# Infodump

# Table of Contents

- [Infodump](#infodump)
- [Table of Contents](#table-of-contents)
- [Memory Management](#memory-management)
  - [MM1: Introduction](#mm1-introduction)
    - [Fixed-Length](#fixed-length)
    - [Variable-Length](#variable-length)
    - [Basic Model](#basic-model)
      - [Memory Allocation](#memory-allocation)
      - [Handles](#handles)
      - [Memory Deallocation](#memory-deallocation)
    - [Simple ADT](#simple-adt)
      - [`insert`](#insert)
      - [`getRecord`](#getrecord)
      - [`release`](#release)
    - [Dynamic Memory Allocation](#dynamic-memory-allocation)
      - [Example 1](#example-1)
      - [Example 2](#example-2)
      - [Example 3](#example-3)
    - [Heap](#heap)
  - [MM2: Dynamic Storage Allocation](#mm2-dynamic-storage-allocation)
- [Indexing](#indexing)
  - [I1: Introduction](#i1-introduction)
  - [I2: Linear Indexing](#i2-linear-indexing)
    - [Storage](#storage)
      - [Example](#example)
        - [Searching](#searching)
    - [Advantages](#advantages)
    - [Simple Two-Level Linear Index](#simple-two-level-linear-index)
    - [TODO](#todo)

# Memory Management

## MM1: Introduction

In languages like C++ and Java, programmers can allocate space as necessary either explicitly with `new` or implicitly with a variable declaration. This section discusses memory management techniques for the general problem of handling space requests of variable size.

### Fixed-Length

- Most DSA designed for storage/access of uniform sized objects (fixed-length).
  - Such as an integer stored in a list or queue.

### Variable-Length

- Need ability to store variable-length records such as strings of abitrary lengths.
  - One Solution:
    - In a list or queue, store a bunch of pointers to strings, where each pointer is pointeing to space of whatever size is necessary to hold that string.
      - This is fine for data structures stored in main memory, but even then we need a way to figure out where there are available bytes to hold a given string.
- However, if the collection of strings needs to be stored on disk, then we may need to worry more about how these structures are actually stored.

### Basic Model

- The basic model for memory management is having a (large) block of contiguous memory locations, called a memory pool.

#### Memory Allocation

- A memory manager has the job of finding a contiguous block of locations of at least the requested size from somewhere within the memory pool.
  - Honoring such a request is called memory allocation.

#### Handles

- The memory manager will typically return some piece of information that the requester can hold on to so that later it can recover the data that was just stored by the memory manager.
  - This information is called a handle.

#### Memory Deallocation

- At some point, space that has been requested might no longer be needed, and this space can be returned to the memory manager so that it can be reused.
  - This is called a memory deallocation.

### Simple ADT

- We can define an ADT for a simple memory manager for storing variable length arrays of integers as follows.

```java
// Memory Manager abstract class
public interface MemManager {
  // Store a record and return a handle to it
  public MemHandle insert(byte[] info);

  // Release the space associated with a record
  public void release(MemHandle h);

  // Get back a copy of a stored record
  public byte[] getRecord(MemHandle h);
}
```

- The user of the MemManager ADT provides a pointer to space that holds some message to be stored or retrieved.
  - See the `info` parameter.
  - This is similar to the C++ basic file read/write methods.
- The fundamental idea is that:
  1. The client gives messages to the memory manager for safe keeping.
  2. The memory manager returns a receipt for the message in the form of a `MemHandle` object.
  3. The client holds the `MemHandle` until it wishes to get the message back.

#### `insert`

- Method `insert` lets the client tell the memory manager the length and contents of the message to be stored.

#### `getRecord`

- This ADT assumes that the memory manager will remember the length of the message associated with a given handle, thus method `getRecord` does not include a length parameter but instead returns the message actually stored.

#### `release`

- Method release allows the client to tell the memory manager to release the space that stores a given message.

### Dynamic Memory Allocation

- Memory management is fairly easy when all inserts and releases follow a simple pattern, such as:
  - Stack Order:
    - Last requested, first released
  - Queue Order:
    - First requested, first released
- Dynamic memory allocation describes the general case where blocks of any size might be requested and released in any order.

#### Example 1

- Managing free store for a compiler's runtime environment, such as the system-level `new` and `delete` operations in C++.

#### Example 2

- Managing main memory in a multitasking operating system.
  - A program might require a certain amount of space, so the memory manager must keep track of which programs are using which parts of the main memory.

#### Example 3

- File manager for a disk drive.
  - When a disk file is created, expanded, or deleted, the file manager must allocate or deallocate disk space.

### Heap

- A block of memory or disk space managed in this way is sometimes referred to as a heap.

> Note: The term "heap" is being used here in a different way than the heap data structure typically used to implement a priority queue. Here "heap" refers to the memory controlled by a dynamic memory management scheme.

## MM2: Dynamic Storage Allocation

Stuff goes here

# Indexing

## I1: Introduction

## I2: Linear Indexing

A linear index is an index file organized as a sequence of key-value pairs where the keys are in sorted order and the pointers either:

1. Point to the position of the complete record on disk
2. Point to the position of the primary key in the primary index
3. Are actually the value of the primary key.

### Storage

- Depending on its size, a linear index might be stored in main memory or on disk.
- If the database contains enough records, the linear index might be too large to store in main memory.
  - This makes binary search of the index more expensive due to the large number of disk accesses.
    - One solution to this problem is to store a second-level linear index in main memory that indicates which disk block in the index file stores a desired key.

#### Example

- The linear index on disk might reside in a series of 1024-byte blocks.
- If each key/pointer pair in the linear index requires 8-bytes (a 4-byte key and a 4-byte pointer), then 128 key/pointer pairs are stored per block.
- The second-level index, stored in main memory, consists of a simple table which stores the value of the key in the first position of each block in the linear index file.
- If the linear index requires 1024 disk blocks (1MB), the second-level index contains only 1024 entries, one per disk block.

##### Searching

- To find which disk block contains a desired search key value:
  1. First search through the 1024-entry table to find the greatest value less than or equal to the search key.
     - This directs the search to the proper block in the index file, which is then read into memory.
  2. At this point, a binary search within this block will produce a pointer to the actual record in the database.
     - Because the second-level index is stored in main memory, accessing a record by this method requires two disk reads:
       1. One from the index file
       2. One from the database file for the actual record

### Advantages

- A linear index provides a number of advantages:
  - Convenient access to variable-length database records.
    - Because each entry in the index file contains a fixed-length key field and a fixed-length pointer to the beginning of a (variable-length) record as shown in the following.
  - Allows for efficient search and random access to database records.
    - Because it is amenable to binary search.

### Simple Two-Level Linear Index

- A simple two-level linear index has:
  1. The linear index is stored on disk.
  2. The smaller, second-level index is stored in main memory.
- Each element in the second-level index stores the first key value in the corresponding disk block of the index file.

### TODO

- Refer back to this section to try to figure out a better way to express the information presented since it is quite confusing.
