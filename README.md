# DSA-Assignment4
# Overview

The Algorithm Application is a Java-based GUI application that allows users to execute various brute force and exhaustive search algorithms. The application supports different types of algorithms and measures their execution time. After each execution, users can choose to either run another algorithm or quit the application.

## Key Features

Simple and intuitive GUI using Java Swing.
Supports a variety of brute force and exhaustive search algorithms.
Measures and displays the execution time for each algorithm.
Prompts the user to continue with another operation or quit after each execution.
Supported Algorithms
Brute Force Algorithms
Simple Search

### Description: Searches for a key in an array.
Input Example: 1 2 3 4 5 (array) and 3 (key).
Expected Output: Index of 3: 2.
### Naive String Matching

### Description: Finds all occurrences of a pattern in a text.
Input Example: hello world,world (text,pattern).      
Expected Output: Pattern found at positions: [6].
### Brute Force Cryptographic Attack

### Description: Finds the original string by matching hash.
Input Example: Hash of "abc".
Expected Output: Original string: abc.
### TSP Optimization Problem

### Description: Finds the minimum cost of visiting all cities (Traveling Salesman Problem).
Input Example: N/A (uses a default graph).
Expected Output: Minimum cost: X.
Exhaustive Search Algorithms
### Backtracking (N-Queens)

### Description: Solves the N-Queens problem.
Input Example: 4 (number of queens).
Expected Output: Number of solutions: 2.
### Branch and Bound (Knapsack)

### Description: Solves the Knapsack problem to maximize value.
Input Example: 1 2 3 4,2 4 4 5 (weights, values) and 5 (capacity).
Expected Output: Maximum value: X.
### Dynamic Programming (Fibonacci)

### Description: Computes the N-th Fibonacci number.
Input Example: 10.
Expected Output: Fibonacci number: 55.
### Depth-First Search (DFS)

## Description: Placeholder for DFS logic (not implemented).
Input Example: N/A.
Expected Output: DFS logic not implemented in this example..
### Breadth-First Search (BFS)

### Description: Placeholder for BFS logic (not implemented).
Input Example: N/A.
Expected Output: BFS logic not implemented in this example..

## Running the Application
Compile and Run: Use an IDE like IntelliJ IDEA or Eclipse to compile and run the AlgorithmApplication.java.
Enter Input: Provide the required input in the text area for the selected algorithm.
Execute Algorithm: Click the "Execute" button to run the selected algorithm.
View Output: The output and execution time will be displayed in the output area.
Continue or Quit: After execution, a prompt will ask whether you want to execute another algorithm or quit the application.

### Example Inputs and Outputs

## Simple Search
Input: 1 2 3 4 5
Search Key: 3
Output: Index of 3: 2

## Naive String Matching
Input: hello world,world
Output: Pattern found at positions: [6]

## Brute Force Cryptographic Attack
Input: 2e99758548972a8e8822f51124a5492494c2d05b8467e85c454751fd4b66d964 (SHA-256 hash of "abc")
Output: Original string: abc

## Backtracking (N-Queens)
Input: 4
Output: Number of solutions: 2

## Branch and Bound (Knapsack)
Input: 1 2 3 4,2 4 4 5 (weights and values), 5 (capacity)
Output: Maximum value: 9

## Dynamic Programming (Fibonacci)
Input: 10
Output: Fibonacci number: 55

### Notes
The application uses System.nanoTime() to measure the execution time.
The input format must be followed as described for each algorithm to avoid errors.
Placeholder logic for DFS and BFS can be implemented similarly.

