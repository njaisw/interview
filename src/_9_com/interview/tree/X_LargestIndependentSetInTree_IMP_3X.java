package _9_com.interview.tree;

/**
 * http://www.geeksforgeeks.org/largest-independent-set-problem/
 * Given a Binary Tree, find size of the Largest Independent Set(LIS) in it. A subset of all
 * tree nodes is an independent set if there is no edge between any two nodes of
 * the subset.
 */
public class X_LargestIndependentSetInTree_IMP_3X {

	public int largestSet(Node root) {
		if (root == null) {
			return 0;
		}

		if (root.lis != -1) {
			return root.lis;
		}
		int excl = 0;
		int left_excl = 0;
		if (root.left != null) {
			left_excl = largestSet(root.left.left) + largestSet(root.left.right);
			excl += largestSet(root.left);
		}
		int right_excl = 0;
		if (root.right != null) {
			right_excl = largestSet(root.right.left) + largestSet(root.right.right);
			excl += largestSet(root.right);
		}

		int incl = left_excl + right_excl + root.data;
		root.lis = incl;

		return incl > excl ? incl : excl;
	}

	public static void main(String args[]) {
		int inorder[] = { 4, 13, 1, 7, 6, 3, 19 };
		int preorder[] = { 13, 4, 6, 7, 1, 3, 19 };
		ConstructTreeFromInOrderPreOrder_IMP_2 ctf = new ConstructTreeFromInOrderPreOrder_IMP_2();
		Node root = ctf.createTree(inorder, preorder);
		X_LargestIndependentSetInTree_IMP_3X lis = new X_LargestIndependentSetInTree_IMP_3X();
		System.out.println(lis.largestSet(root));
	}
}
