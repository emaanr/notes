# Dynamic Memory Management: `malloc`/`free`

# Table of Contents

- [Dynamic Memory Management: `malloc`/`free`](#dynamic-memory-management-mallocfree)
- [Table of Contents](#table-of-contents)
- [Outline](#outline)
- [Explicit Memory Management](#explicit-memory-management)
- [Dynamic Memory Allocation](#dynamic-memory-allocation)
- [Process Memory Image](#process-memory-image)
- [The `malloc` API](#the-malloc-api)
- [Assumptions](#assumptions)
- [Allocation Examples](#allocation-examples)
- [Constraints](#constraints)
- [Goals for `malloc`/`free` Design](#goals-for-mallocfree-design)
- [Performance Goals](#performance-goals)
  - [Throughput](#throughput)
  - [Peak Memory Utilization](#peak-memory-utilization)
- [Fragmentation](#fragmentation)
  - [Internal](#internal)
  - [External](#external)
- [Implementation Issues](#implementation-issues)
- [Knowing how much to Free](#knowing-how-much-to-free)
- [Keeping Track of Free Blocks](#keeping-track-of-free-blocks)
  - [Method 1: Implicit List](#method-1-implicit-list)
    - [Side Note](#side-note)
    - [Finding a Free Block](#finding-a-free-block)
    - [Allocating in Free Block](#allocating-in-free-block)
    - [Freeing a Block](#freeing-a-block)
    - [Coalescing](#coalescing)
    - [Bidirectional Coalescing](#bidirectional-coalescing)
    - [Constant Time Coalescing](#constant-time-coalescing)
      - [Case 1](#case-1)
      - [Case 2](#case-2)
      - [Case 3](#case-3)
      - [Case 4](#case-4)
    - [Summary of Key Allocator Policies](#summary-of-key-allocator-policies)
    - [Summary of Implicit Lists](#summary-of-implicit-lists)
  - [Method 2: Explicit List](#method-2-explicit-list)
    - [Explicit Free Lists](#explicit-free-lists)
    - [Allocated vs Free Blocks](#allocated-vs-free-blocks)
    - [Splitting & Explicit Free Lists](#splitting--explicit-free-lists)
    - [Freeing](#freeing)
      - [w/ Explicit Free Lists](#w-explicit-free-lists)
      - [w/ LIFO Policy](#w-lifo-policy)
    - [Summary of Explicit Lists](#summary-of-explicit-lists)
  - [Method 3: Segregated Lists](#method-3-segregated-lists)
    - [Segregated Storage](#segregated-storage)
    - [Simple Segregated Storage](#simple-segregated-storage)
    - [Segregated Fits](#segregated-fits)
- [Source](#source)

# Outline

# Explicit Memory Management

# Dynamic Memory Allocation

# Process Memory Image

# The `malloc` API

# Assumptions

# Allocation Examples

# Constraints

# Goals for `malloc`/`free` Design

# Performance Goals

## Throughput

## Peak Memory Utilization

# Fragmentation

## Internal

## External

# Implementation Issues

# Knowing how much to Free

# Keeping Track of Free Blocks

## Method 1: Implicit List

### Side Note

### Finding a Free Block

### Allocating in Free Block

### Freeing a Block

### Coalescing

### Bidirectional Coalescing

### Constant Time Coalescing

#### Case 1

#### Case 2

#### Case 3

#### Case 4

### Summary of Key Allocator Policies

### Summary of Implicit Lists

## Method 2: Explicit List

### Explicit Free Lists

### Allocated vs Free Blocks

### Splitting & Explicit Free Lists

### Freeing

#### w/ Explicit Free Lists

#### w/ LIFO Policy

### Summary of Explicit Lists

## Method 3: Segregated Lists

### Segregated Storage

### Simple Segregated Storage

### Segregated Fits

# Source

[Godmar Back](https://people.cs.vt.edu/~gback/)