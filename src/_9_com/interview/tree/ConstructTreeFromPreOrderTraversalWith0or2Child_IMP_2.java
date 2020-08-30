package _9_com.interview.tree;

/**
 * http://www.geeksforgeeks.org/construct-a-special-tree-from-given-preorder-traversal/
 * Given an array �pre[]� that represents Preorder traversal of a spacial binary
 * tree where every node has either 0 or 2 children. One more array �preLN[]� is
 * given which has only two possible values �L� and �N�. The value �L� in
 * �preLN[]� indicates that the corresponding node in Binary Tree is a leaf node
 * and value �N� indicates that the corresponding node is non-leaf node. Write a
 * function to construct the tree from the given two arrays. Test cases: Length
 * of pre and val is not same val contains values other than N or L
 */
class PreIndex {
	int index;
}

public class ConstructTreeFromPreOrderTraversalWith0or2Child_IMP_2 {

	public Node createTree(int pre[], char val[]) {
		PreIndex pi = new PreIndex();
		pi.index = 0;
		return createTree(pre, val, pi);
	}

	private Node createTree(int pre[], char val[], PreIndex ind) {

		if (ind.index >= pre.length) {
			return null;
		}
		Node root = Node.newNode(pre[ind.index]);

		if (val[ind.index] == 'L') {
			ind.index++;
		} else {
			ind.index++;
			root.left = createTree(pre, val, ind);
			root.right = createTree(pre, val, ind);
		}
		return root;
	}

	public static void main(String args[]) {
		int pre[] = { 10, 20, 30, 40, 50, 60, 70, 80, 90 };
		char val[] ={'N', 'N', 'N', 'L', 'L', 'L', 'N', 'L', 'L' };
		ConstructTreeFromPreOrderTraversalWith0or2Child_IMP_2 tfp = new ConstructTreeFromPreOrderTraversalWith0or2Child_IMP_2();
		Node root = tfp.createTree(pre, val);
		TreeTraversals_IMP_2 tt = new TreeTraversals_IMP_2();
		tt.preOrder(root);
		System.out.println();
		tt.inOrder(root);
	}
}
