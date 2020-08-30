

https://hackernoon.com/shortest-and-longest-path-algorithms-job-interview-cheatsheet-2adc8e18869

https://github.com/Nideesh1/Algo/blob/master/leetcode/L_207.java

https://happygirlzt.com/codelist.html

https://stackoverflow.com/questions/20556802/determining-whether-or-not-a-directed-or-undirected-graph-is-a-tree

For a directed graph:

    Find the vertex with only outgoing edges (if there is more than one or no such vertex, fail).

    Do a BFS or DFS from that vertex. If you encounter an already visited vertex, it's not a tree.

    If you're done and there are unexplored vertices, it's not a tree - the graph is not connected.

    Otherwise, it's a tree.

    To check for a binary tree, additionally check if each vertex has at most 2 outgoing edges.

For an undirected graph:

    Check for a cycle with a simple depth-first search (starting from any vertex) - "If an unexplored edge leads to a node visited before, then the graph contains a cycle." If there's a cycle, it's not a tree.

    If the above process leaves some vertices unexplored, it's not a tree, because it's not connected.

    Otherwise, it's a tree.

    To check for a binary tree, additionally check that all vertices have 1-3 edges (one to the parent and 2 to the children).

    Checking for the root, i.e. whether one vertex contains 1-2 edges, is not necessary as there has to be vertices with 1-2 edges in an acyclic connected undirected graph.

    Note that identifying the root is not generically possible (it may be possible in special cases) as, in many undirected graphs, more than one of the nodes can be made the root if we were to make it a binary tree.

