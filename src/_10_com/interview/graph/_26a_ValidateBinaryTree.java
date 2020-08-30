package _10_com.interview.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/validate-binary-tree-nodes/
 *
 * https://www.youtube.com/watch?v=tQ7ycXxN6D8
 *
 * Input: n = 4, leftChild = [1,-1,3,-1], rightChild = [2,-1,-1,-1]
 * Output: true
 *
 * Input: n = 4, leftChild = [1,-1,3,-1], rightChild = [2,3,-1,-1]
 * Output: false
 *
 *Check indegree of each nodes. If any nodes having indegree more than 1, it means there are more than 1 parents for that node.
 * After that find count of such nodes which are having no parents. If such nodes count is more than 1, return false.
 * Last condition to check is whether there are any loop present and any node is isolated node. [Refer below diagram]
 * For example: left: [-1,2,3,1] and right: [-1,-1,-1,-1]
 *
 * Not a valid tree
 * 1: If a node has multiple parent (indegree of the node is greater than 1)
 * 2: If graph has multiple roots
 * 3: If graph has Cycle
 * 4: Graph are diconnected componennts
 *
 */
public class _26a_ValidateBinaryTree {

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        final int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            final int left = leftChild[i], right = rightChild[i];
            if (left >= 0) indegree[left]++;
            if (right >= 0) indegree[right]++;
        }
        //TODO BFS traversal
        final Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            //TODO Any in degres greater than 1 mean not valid tree ( as it has two parents while node in a tree has only one parent)
            if (indegree[i] > 1) return false;
            //TODO Insert nodes with zero indegrees
            if (indegree[i] == 0) q.offer(i);
        }
        // TODO if there multiple indegreess with zero means node has multiple root
        if (q.size() > 1) return false;

        int total = 0;
        //TODO queue contains the nodes with indegre zero only
        while (!q.isEmpty()) {
            total++;
            int v = q.poll();
            //TODO Find left and right child of the root and insert in the queue only if indegree decremented is zero
            int left = leftChild[v], right = rightChild[v];
            //If left is not -1
            if (left != -1 && --indegree[left] == 0) q.offer(left);
            if (right != -1 && --indegree[right] == 0) q.offer(right);
        }
        //TODO if total number of nodes is equal to count  (means all nodes are connected) then it is the valid tree
        return total == n;
    }


    public static void main(String[] args) {
        _26a_ValidateBinaryTree tree = new _26a_ValidateBinaryTree();

        System.out.println(tree.validateBinaryTreeNodes(4, new int[]{1,-1,3,-1},new int[]{2,-1,-1,-1} ));
    }
}
