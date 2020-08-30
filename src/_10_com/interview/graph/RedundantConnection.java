package _10_com.interview.graph;

/**
 *
 * https://leetcode.com/problems/redundant-connection/
 * Example 1:
 *
 * Input: [[1,2], [1,3], [2,3]]
 * Output: [2,3]
 * Explanation: The given undirected graph will be like this:
 *   1
 *  / \
 * 2 - 3
 *
 * Example 2:
 *
 * Input: [[1,2], [2,3], [3,4], [1,4], [1,5]]
 * Output: [1,4]
 * Explanation: The given undirected graph will be like this:
 * 5 - 1 - 2
 *     |   |
 *     4 - 3
 */
public class RedundantConnection {

    class Node{
         int id;
         int parent;
         int rank;
    }







    public int[] findRedundantConnection(int[][] edges) {

        return null;

    }
}
