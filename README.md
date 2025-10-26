Minimum Spanning Tree Algorithms — Assignment 3
Overview

This project implements and compares two classical Minimum Spanning Tree (MST) algorithms — Prim’s and Kruskal’s.
Both algorithms were applied to multiple graph datasets loaded from input.json, and the results were saved to output.json.

The goal is to analyze and compare the algorithms in terms of:

Total MST cost

Number of operations performed

Execution time

Summary of Input Data and Algorithm Results
Graph ID	Vertices	Edges	Prim Cost	Kruskal Cost	Prim Ops	Kruskal Ops	Prim Time (ms)	Kruskal Time (ms)
1	5	7	16	16	10	23	1.9185	9.109
2	12	18	48	48	27	60	0.146	0.0787
3	25	42	107	107	69	152	0.3115	0.1998
Algorithm Comparison
Theoretical Analysis
Aspect	Prim’s Algorithm	Kruskal’s Algorithm
Approach	Grows MST from a single starting vertex, adding the lowest-cost edge that connects a new vertex	Sorts all edges by weight and adds them one by one while avoiding cycles
Data Structures	Priority Queue (Min-Heap)	Union-Find (Disjoint Set)
Time Complexity	O(E log V) with a binary heap	O(E log E) (≈ O(E log V))
Best suited for	Dense graphs (many edges)	Sparse graphs (few edges)
Implementation complexity	Moderate	Slightly simpler conceptually
Practical Analysis (Based on Experimental Results)

Both algorithms produced identical MST total costs, confirming correctness.

Prim’s algorithm generally required fewer operations on smaller graphs.

Kruskal’s algorithm executed faster for larger and sparser graphs (e.g., Graph 3).

Execution times were extremely low for all datasets (under 10 ms), consistent with the small graph sizes used.

For the largest dataset (25 vertices, 42 edges), Prim’s took 0.31 ms, while Kruskal’s was slightly faster at 0.20 ms.

Conclusions

For dense graphs, Prim’s algorithm tends to perform better due to efficient edge relaxation via a priority queue.

For sparse graphs, Kruskal’s algorithm is more efficient because of its effective sorting and union-find operations.

Both algorithms are suitable for small to medium graph sizes and consistently produce the same MST cost.

In this project, Kruskal’s algorithm was slightly more time-efficient in practice.

Implementation Notes

Input graphs are stored in input.json.

Computed results are saved to output.json.

The project includes JUnit 5 tests ensuring that:

Prim’s and Kruskal’s MST costs are identical,

Each MST contains V-1 edges,

The MST is not empty.

All code is implemented in Java within the mst package.
