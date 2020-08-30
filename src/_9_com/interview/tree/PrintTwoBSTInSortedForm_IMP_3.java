package _9_com.interview.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * http://www.geeksforgeeks.org/merge-two-bsts-with-limited-extra-space/ Test
 * cases Both tree are null One of the tree is null All elements of one tree
 * occur before other tree All elements of one tree occur after other tree
 * Elements are mixed All same elements
 */
public class PrintTwoBSTInSortedForm_IMP_3 {

	public void print(Node root1, Node root2) {
		Deque<Node> stack1 = new LinkedList<Node>();
		Deque<Node> stack2 = new LinkedList<Node>();

		while (true) {
			//TODO remember to check root is not equal to null
			if (root1 != null) {
				//TODO adds root first
				stack1.addFirst(root1);
				root1 = root1.left;
				continue;
			}
			if (root2 != null) {
				// TODO adds root first
				stack2.addFirst(root2);
				root2 = root2.left;
				continue;
			}
			if (!stack1.isEmpty()) {
				root1 = stack1.peekFirst();
			}
			if (!stack2.isEmpty()) {
				root2 = stack2.peekFirst();
			}
			if (root1 != null && root2 != null) {
				// TODO Logic
				if (root1.data <= root2.data) {
					System.out.println(root1.data);
					root1 = stack1.pollFirst();
					root1 = root1.right;
					// TODO Remember root2 is null as dont need to run the while loop again
					root2 = null;
				} else {
					System.out.println(root2.data);
					root2 = stack2.pollFirst();
					root2 = root2.right;
					root1 = null;
				}
			} else if (root1 != null) {
				System.out.println(root1.data);
				root1 = stack1.pollFirst();
				root1 = root1.right;

			} else if (root2 != null) {
				System.out.println(root2.data);
				root2 = stack2.pollFirst();
				root2 = root2.right;
			}
			//TODO check the break condition
			if (root1 == null && root2 == null && stack1.isEmpty() && stack2.isEmpty()) {
				break;
			}
		}
	}

	public static void main(String args[]) {
		PrintTwoBSTInSortedForm_IMP_3 ptb = new PrintTwoBSTInSortedForm_IMP_3();
		BinaryTree bt = new BinaryTree();
		Node head = null;
		head = bt.addNode(10, head);
		head = bt.addNode(15, head);
		head = bt.addNode(5, head);
		head = bt.addNode(7, head);
		head = bt.addNode(19, head);
		head = bt.addNode(20, head);
		head = bt.addNode(-1, head);

		Node head1 = null;
		head1 = bt.addNode(-4, head1);
		head1 = bt.addNode(-3, head1);
		head1 = bt.addNode(6, head1);
		head1 = bt.addNode(11, head1);
		head1 = bt.addNode(22, head1);
		head1 = bt.addNode(26, head1);

		ptb.print(head, head1);
	}
}
