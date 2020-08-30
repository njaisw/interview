package _12_namrata.self.practice_3;
/*
 * Given a binary tree, find the maximum path sum. The path may start and end at any node in the tree.

Example:

Input: Root of below tree
       1
      / \
     2   3
Output: 6

See below diagram for another example.
1+2+3
 */

public class MaximumPath {

	static class Node {

		int data;
		Node left, right;

		public Node(int item) {
			data = item;
			left = right = null;
		}
	}

	class Res {
		public int val;
	}

	Node root;

	// This function returns overall maximum path sum in 'res' And returns max path
	// sum going through root.
	int findMaxUtil(Node node, Res res) {

		if (node == null)
			return 0;

		// l and r store maximum path sum going through left and right child of root
		// respectively
		int l = findMaxUtil(node.left, res);
		int r = findMaxUtil(node.right, res);

		// Max path for parent call of root. path must include at-most one child of root
		int max_single = Math.max(Math.max(l, r) + node.data, node.data);

		// Max Top represents the sum when the Node under consideration is the root of
		// the maxsum path and no ancestors of root are there in max sum path
		int max_top = Math.max(max_single, l + r + node.data);

		// Store the Maximum Result.
		res.val = Math.max(res.val, max_top);

		return max_single;
	}

	int findMaxSum() {
		return findMaxSum(root);
	}

	// Returns maximum path sum in tree with given root
	int findMaxSum(Node node) {

		Res res = new Res();
		res.val = Integer.MIN_VALUE;

		findMaxUtil(node, res);
		return res.val;
	}

	public static void main(String args[]) {
		MaximumPath tree = new MaximumPath();
		tree.root = new Node(10);
		tree.root.left = new Node(2);
		tree.root.right = new Node(10);
		tree.root.left.left = new Node(20);
		tree.root.left.right = new Node(1);
		tree.root.right.right = new Node(-25);
		tree.root.right.right.left = new Node(3);
		tree.root.right.right.right = new Node(4);
		System.out.println("maximum path sum is : " + tree.findMaxSum());
	}
}
