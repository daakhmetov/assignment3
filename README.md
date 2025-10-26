Minimum Spanning Tree Algorithms — Assignment 3
Overview

This project implements and compares two classical Minimum Spanning Tree (MST) algorithms — Prim’s and Kruskal’s.
Both algorithms were applied to multiple graph datasets loaded from input.json, and the results were saved to output.json.

Summary of Input Data and Algorithm Results
+-----------+-----------+--------+------------+---------------+------------+--------------+----------------+-------------------+
| Graph ID  | Vertices  | Edges  | Prim Cost  | Kruskal Cost  | Prim Ops   | Kruskal Ops  | Prim Time (ms) | Kruskal Time (ms) |
+-----------+-----------+--------+------------+---------------+------------+--------------+----------------+-------------------+
| 1         | 5         | 7      | 16         | 16            | 10         | 23           | 1.9185         | 9.109             |
| 2         | 12        | 18     | 48         | 48            | 27         | 60           | 0.146          | 0.0787            |
| 3         | 25        | 42     | 107        | 107           | 69         | 152          | 0.3115         | 0.1998            |
+-----------+-----------+--------+------------+---------------+------------+--------------+----------------+-------------------+

Algorithm Comparison
+----------------------+--------------------------+----------------------------+
| Aspect               | Prim’s Algorithm         | Kruskal’s Algorithm        |
+----------------------+--------------------------+----------------------------+
| Approach             | Grows MST from one node  | Sorts all edges globally   |
| Data Structures      | Min-Heap / PriorityQueue | Union-Find (Disjoint Set)  |
| Time Complexity      | O(E log V)               | O(E log E) ≈ O(E log V)    |
| Best for             | Dense graphs             | Sparse graphs              |
| Implementation Level | Moderate                 | Simple                     |
+----------------------+--------------------------+----------------------------+

Practical Analysis

Both algorithms produced identical MST costs → correctness confirmed.

Prim’s required fewer operations on smaller graphs.

Kruskal’s was slightly faster on larger, sparser graphs.

Execution times were very low (<10 ms), typical for small inputs.

For the 25-vertex graph:

Prim’s: 0.3115 ms, Kruskal’s: 0.1998 ms → Kruskal faster.

Conclusions

Prim’s is generally better for dense graphs.

Kruskal’s performs better for sparse graphs.

Both yield the same MST total cost.

In this experiment, Kruskal’s algorithm showed slightly better real-time efficiency.

Implementation Notes

Input graphs → input.json

Output results → output.json

Includes JUnit 5 tests validating:

Same MST cost between algorithms,

MST has V – 1 edges,

MST is not empty.
