Assignment 3: Minimum Spanning Tree (MST)

Student: Akhmetov Dauren
Group: SE-2430
Course: Algorithms and Data Structures
University: Astana IT University

1. Summary of Input Data and Algorithm Results

The input consisted of several graphs of different sizes. Each was processed using both Prim’s and Kruskal’s algorithms to find the Minimum Spanning Tree (MST).
Execution time and operation counts were measured for each case.

Graph	Vertices	Edges	Prim Cost	Kruskal Cost	Prim Ops	Kruskal Ops	Prim Time (ms)	Kruskal Time (ms)
1	5	7	16	16	10	23	1.92	9.11
2	12	18	48	48	27	60	0.15	0.08
3	25	42	107	107	69	152	0.31	0.20

Observation:
Both algorithms produced identical MST costs for all test graphs, confirming correctness.

2. Comparison Between Prim’s and Kruskal’s Algorithms
Aspect	Prim’s Algorithm	Kruskal’s Algorithm
Approach	Expands MST by choosing minimum-weight edge connected to the growing tree	Builds MST by selecting smallest edges globally and avoiding cycles
Data Structure	Priority Queue (Min-Heap)	Disjoint Set (Union-Find)
Time Complexity	O(E log V)	O(E log E)
Best for	Dense graphs	Sparse graphs
Implementation Complexity	Higher (requires heap operations)	Lower (simple sorting and union-find)
Space Complexity	O(V + E)	O(E)
3. Conclusions

Both algorithms give the same MST result, but performance depends on graph density.

Prim’s algorithm works better on dense graphs, where the adjacency structure helps reduce edge comparisons.

Kruskal’s algorithm is simpler and usually faster on sparse graphs, where sorting a smaller edge list is more efficient.

In practice, both algorithms executed extremely fast on small datasets (under 1 ms), which is expected for graphs up to 25 vertices.

Recommendation:
Use Prim’s for dense, connected graphs and Kruskal’s for sparse or edge-list-based representations
