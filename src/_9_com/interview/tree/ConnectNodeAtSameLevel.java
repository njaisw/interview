package _9_com.interview.tree;


public class ConnectNodeAtSameLevel {

	class Node {
		int data;
		Node left;
		Node right;
		Node next;

		public Node(int data) {
			this.data = data;
		}
	}

	private void connectNode(Node root) {
		if (root == null) {
			return;

		}

		root.left = root.left != null ? root.right : null;
		root.right = root.next != null ? root.next.left : null;

		connectNode(root.left);
		connectNode(root.right);
	}

}
