package _9_com.interview.tree;

public class SumTree {

	private static class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
		}

	}

	private boolean isSum(Node root) {
		if (root == null)
			return true;
		if (root.left == null & root.right == null) {
			return true;
		}

		boolean isleftSum = isSum(root.left);
		boolean isrightSum = isSum(root.right);

		return isleftSum && isrightSum
				&& root.data == (root.left != null ? root.left.data : 0) + (root.right != null ? root.right.data : 0);

	}

	public static void main(String[] args) {
		
		Node node = new Node(10);
	    node.left=new Node(5);
	    node.right= new Node(5);
	    node.left.left=new Node(2);
	    node.left.right= new Node(3);
	    node.right.left=new Node(7);
	    node.right.right= new Node(4);
		
		
		SumTree sumTree = new SumTree();
		System.out.println(sumTree.isSum(node));

	}

}
