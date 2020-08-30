package _9_com.interview.tree;

/**
 * Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that
 * shares the same parent node) or empty, flip it upside down and turn it into a tree where the original
 * right nodes turned into left leaf nodes. Return the new root.

Given a binary tree {1,2,3,4,5},

    1
   / \
  2   3
 / \
4   5

return the root of the binary tree [4,5,2,#,#,3,1].

   4
  / \
 5   2
    / \
   3   1  
 *
 * https://leetcode.com/problems/binary-tree-upside-down/
 */
public class UpsidedownBinaryTree_IMP_3 {
    public Node upsideDownBinaryTree(Node root) {
        if (root == null) {
            return null;
        }
        return upsideDownBinaryTree(root, null, null);
    }

    public Node upsideDownBinaryTree(Node root, Node parent, Node rightChild) {
        if (root == null) {
            return parent;
        }
        Node left = root.left;
        Node right = root.right;

        root.right = parent;
        root.left = rightChild;

        return upsideDownBinaryTree(left, root, right);
    }
}
