package _9_com.interview.tree;

/**
 * Date 03/22/2016
 * @author Tushar Roy
 *
 * Given a binary tree, find the maximum path sum. For this problem, a path is defined as any sequence of nodes
 * from some starting node to any node in the tree along the parent-child connections.
 * 
 * Time complexity O(n)
 * Space complexity depends on depth of tree.
 *
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 */
public class BinaryTreeMaximumPathSum_IMP_2 {
    int max = 0;

    public int maxPathSum(Node root) {
        max = Integer.MIN_VALUE;
        maxPathSumUtil(root);
        return max;
    }

    private int maxPathSumUtil(Node root) {
        if (root == null) {
            return 0;
        }
        int left = maxPathSumUtil(root.left);
        int right = maxPathSumUtil(root.right);
        //TODO to ignore the left if it is sum is negative
        if (left < 0) {
            left = 0;
        }
        //TODO ignore rigt if sum is less than zero
        if (right < 0) {
            right = 0;
        }
        max = Math.max(max, root.data + left + right);
        //todo return
        return root.data + Math.max(left, right);
    }
}
