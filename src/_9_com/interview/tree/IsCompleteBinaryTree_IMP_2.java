package _9_com.interview.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * http://www.geeksforgeeks.org/check-if-a-given-binary-tree-is-complete-tree-or-not/
 * 
 * A complete binary tree is a binary tree in which every level, except possibly
 * the last, is completely filled, and all nodes are as far left as possible.
 * See following examples Test cases: A node with only right child A node with
 * only left child A node with both left and right child
 */
public class IsCompleteBinaryTree_IMP_2 {

	public boolean isComplete(Node root) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(root);
		boolean foundFirstNonFull = false;
		while (!queue.isEmpty()) {
			root = queue.poll();
			if (foundFirstNonFull) {
				if (root.left != null || root.right != null) {
					return false;
				}
				continue;
			}
			if (root.left != null && root.right != null) {
				queue.offer(root.left);
				queue.offer(root.right);
			} else if (root.left != null) {
				queue.offer(root.left);
				foundFirstNonFull = true;
			} else if (root.right != null) {
				return false;
			} else {
				foundFirstNonFull = true;
			}
		}
		return true;
	}

	public static void main(String args[]) {
		BinaryTree bt = new BinaryTree();
		Node head = null;
		head = bt.addNode(3, head);
		head = bt.addNode(-6, head);
		head = bt.addNode(7, head);
		head = bt.addNode(-10, head);
		head = bt.addNode(-15, head);
		head = bt.addNode(-4, head);
		head = bt.addNode(4, head);
		head = bt.addNode(11, head);
		head = bt.addNode(-9, head);

		IsCompleteBinaryTree_IMP_2 icbt = new IsCompleteBinaryTree_IMP_2();
		System.out.println(icbt.isComplete(head));
	}
}
