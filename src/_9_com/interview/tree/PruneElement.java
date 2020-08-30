package _9_com.interview.tree;

public class PruneElement {

	static class BST {


		public Node addNode(Node root, int data) {
			if (root == null) {
				return new Node(data);
			}
			if (data < root.data)
				root.left = addNode(root.left, data);
			else
				root.right = addNode(root.right, data);
			return root;

		}
	}

		static class Node {

			int data;
			Node left;
			Node right;
			public Node(int data) {
				this.data=data;
			}
		}




		private Node pruneElement(Node root, int a, int b) {
		if (root == null) {
			return null;
		}
		if (root.data > a)
			root.left = pruneElement(root.left, a, b);
		else
			root.right = pruneElement(root.right, a, b);

		if (root.data > a && root.data < b)
			return root;
		else if (root.data < a) {
			return root.right;
		} else
			return root.left;

	}
	
	private void printPreOrder(Node root) {
		if (root==null) {
			return;
		}
		System.out.println(root.data);
		printPreOrder(root.left);
		printPreOrder(root.right);

	}

	public static void main(String[] args) {
		
		BST tree= new BST();
		Node root= tree.addNode(null, 11);
		tree.addNode(root, 12);
		tree.addNode(root, 13);
		tree.addNode(root, 3);
		tree.addNode(root, 2);
		tree.addNode(root, 1);
		
		PruneElement pruneElement = new PruneElement();
		pruneElement.printPreOrder(root);
		pruneElement.pruneElement(root, 1, 3);
		System.out.println();
		pruneElement.printPreOrder(root);
		

	}

}
