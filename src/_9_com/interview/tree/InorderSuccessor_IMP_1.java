package _9_com.interview.tree;

/**
 * Date 03/27/2016
 * @author Tushar Roy
 *
 * Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
 *
 * Time complexity O(h)
 * Space complexity O(h)
 *
 * https://leetcode.com/problems/inorder-successor-in-bst/
 */
public class InorderSuccessor_IMP_1 {
    public Node inorderSuccessor(Node root, Node p) {
        if (p.right != null) {
            p = p.right;
            while (p.left != null) {
                p = p.left;
            }
            return p;
        } else {
            return succ(root, p.data);
        }
    }

    private Node succ(Node root, int data) {
        if (root.data == data) {
            return null;
        }
        if (root.data < data) {
            //TODO Always return if no left node
            return succ(root.right, data);
        } else {
            Node s = succ(root.left, data);
            //TODO If data found on the left (null) then root is successor
            return s == null ? root : s;
        }
    }
}
