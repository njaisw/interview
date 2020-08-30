package _10_com.interview.graph;

import java.util.*;

/**
 * Date 03/08/2016
 * @author Tushar Roy
 *
 * Given a graph representing a tree. Find all minimum height trees.
 *
 * Time complexity O(n)
 * Space complexity O(n)
 *
 * https://leetcode.com/problems/minimum-height-trees/
 * https://www.youtube.com/watch?v=4_kTnU05118
 *
 * Example 1 :
 *
 * Input: n = 4, edges = [[1, 0], [1, 2], [1, 3]]
 *
 *         0
 *         |
 *         1
 *        / \
 *       2   3
 *
 * Output: [1]
 *
 * Example 2 :
 *
 * Input: n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
 *
 *      0  1  2
 *       \ | /
 *         3
 *         |
 *         4
 *         |
 *         5
 *
 * Output: [3, 4]
 */
//TODO the idea is to remove leaves from the adjacent node till it is v
public class _30_B_MinimumHeightTree_3 {
    public List<Integer> findMinHeightTrees(int v, int[][] edges) {
        if (v == 1) {
            return Collections.singletonList(0);
        }
        List<Set<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            adj.add(new HashSet<>());
        }
        for (int[] edge: edges) {
            //TODO Adds edges to both the vertex
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            //TODO count leaf nodes
            if (adj.get(i).size() == 1) {
                //
                leaves.add(i);
            }
        }
       // TODO while vertex is greater than 2
        while (v > 2) {
            //TODO non leaves nodes  for example2 v is 2 ( 3,4)
            v -= leaves.size();

            List<Integer> newLeaves = new ArrayList<>();
            for (int leaf : leaves) {
                int node = adj.get(leaf).iterator().next();
                //TODO removes leaf from the adjacent node, leaf 0 is removed from node 3
                adj.get(node).remove(leaf);
                //TODO
                if (adj.get(node).size() == 1) {
                    newLeaves.add(node);
                }
            }
            //TODO newleaves become leaves
            leaves = newLeaves;
        }
        //TODO return leaves
        return leaves;
    }

    public static void main(String args[]) {
        _30_B_MinimumHeightTree_3 mht = new _30_B_MinimumHeightTree_3();
        int input[][] = {{1,0},{1,2},{1,3}};
        List<Integer> result = mht.findMinHeightTrees(4, input);
        result.forEach(System.out::println);
    }
}
