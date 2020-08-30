package _9_com.interview.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/path-sum-iii/description/
 *
 *https://www.youtube.com/watch?v=7oL8kDCk1OI
 *
 * 
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11

https://stackoverflow.com/questions/11328358/algorithm-to-print-all-paths-with-a-given-sum-in-a-binary-tree

Well, this is a tree, not a graph. So, you can do something like this:

Pseudocode:

global ResultList

function ProcessNode(CurrentNode, CurrentSum)
    CurrentSum+=CurrentNode->Value
    if (CurrentSum==SumYouAreLookingFor) AddNodeTo ResultList
    for all Children of CurrentNode
          ProcessNode(Child,CurrentSum)

Well, this gives you the paths that start at the root. However, you can just make a tiny change:

    for all Children of CurrentNode
          ProcessNode(Child,CurrentSum)
          ProcessNode(Child,0)

You might need to think about it for a second (I'm busy with other things), but this should basically run the same algorithm rooted at every node in the tree

EDIT: this actually gives the "end node" only. However, as this is a tree, you can just start at those end nodes and walk back up until you get the required sum.

EDIT 2: and, of course, if all values are positive then you can abort the descent if your current sum is >= the required one


 */
public class CountPathSum_IMP_3X {
    public int pathSum(Node root, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return countPathSum(root, sum, map, 0);
    }

    private int countPathSum(Node root, int sum, Map<Integer, Integer> map, int prefixSum) {
        if (root == null) {
            return 0;
        }

        prefixSum += root.data;
        int count = map.getOrDefault(prefixSum - sum,0);
        map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        count += countPathSum(root.left, sum, map, prefixSum) + countPathSum(root.right, sum, map, prefixSum);
        map.put(prefixSum, map.getOrDefault(prefixSum, 1) - 1);
        return count;
    }
}

