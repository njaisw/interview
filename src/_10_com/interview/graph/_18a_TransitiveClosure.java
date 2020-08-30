package _10_com.interview.graph;

/**
 * Given a directed graph, find out if a vertex j is reachable from another vertex i for all vertex pairs (i, j) in the given graph.
 * Here reachable mean that there is a path from vertex i to j. The reach-ability matrix is called transitive closure of a graph.
 * http://www.geeksforgeeks.org/transitive-closure-of-a-graph/
 */
public class _18a_TransitiveClosure {


    final static int V = 4; //Number of vertices in a graph

    // Prints transitive closure of graph[][] using Floyd Warshall algorithm
    void transitiveClosure(int graph[][]) {
        /* reach[][] will be the output matrix that will finally have the shortest  distances between every pair of vertices */
        int reach[][] = new int[V][V];
        int row, col, vertex;

        /* Initialize the solution matrix same as input graph matrix. Or we can say the initial values of shortest distances are based  on shortest paths considering no intermediate vertex. */
        for (row = 0; row < V; row++)
            for (col = 0; col < V; col++)
                reach[row][col] = graph[row][col];

        /* Add all vertices one by one to the set of intermediate vertices.
          ---> Before start of a iteration, we have reachability  values for all  pairs of vertices such that the reachability values consider only the vertices in set {0, 1, 2, .. vertex-1}
              as intermediate vertices.
         ----> After the end of a iteration, vertex no. vertex is added to the set of intermediate vertices and the set becomes {0, 1, 2, .. vertex} */

        for (vertex = 0; vertex < V; vertex++) {
            // Pick all vertices as source one by one
            for (row = 0; row < V; row++) {
                // Pick all vertices as destination for the above picked source
                for (col = 0; col < V; col++) {
                    // If vertex vertex is on a path from row to col, then make sure that the value of reach[row][col] is 1
                    reach[row][col] = (reach[row][col] != 0) ||
                            ((reach[row][vertex] != 0) && (reach[vertex][col] != 0)) ? 1 : 0;
                }
            }
        }

        // Print the shortest distance matrix
        printSolution(reach);
    }

    /* A utility function to print solution */
    void printSolution(int reach[][]) {
        System.out.println("Following matrix is transitive closure" +
                " of the given graph");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++)
                System.out.print(reach[i][j] + " ");
            System.out.println();
        }
    }

    // Driver program to test above function
    public static void main(String[] args) {
        /* Let us create the following weighted graph
           10
        (0)------->(3)
        |         /|\
      5 |          |
        |          | 1
        \|/        |
        (1)------->(2)
           3           */

        /* Let us create the following weighted graph

              10
         (0)------->(3)
          |         /|\
        5 |          |
          |          | 1
         \|/         |
         (1)------->(2)
            3           */
        int graph[][] = new int[][]{
                {1, 1, 0, 1},
                {0, 1, 1, 0},
                {0, 0, 1, 1},
                {0, 0, 0, 1}
        };

        // Print the solution
        _18a_TransitiveClosure g = new _18a_TransitiveClosure();
        g.transitiveClosure(graph);
    }
}
