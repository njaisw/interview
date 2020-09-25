package _9_com.interview.tree;

import java.util.ArrayList;
import java.util.List;

public class SumPathBT {

	static class Node {

		int data;
		Node left;
		Node right;
		public Node(int data) {
			this.data=data;
		}
	}

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


		List<List<Integer>> results = new ArrayList<List<Integer>>();

	private void findSumPath(Node root, List<Integer> currentList, int sum) {
		if (root == null)
			return;

		currentList.add(root.data);
		findSumPath(root.left, currentList, sum);
		findSumPath(root.right, currentList, sum);

		int currentsum = 0;
		for (int i = currentList.size() - 1; i >= 0; i--) {
			currentsum = currentsum + currentList.get(i);
			if (currentsum == sum) {
				System.out.println(currentList.subList(i, currentList.size()));
				results.add(currentList.subList(i, currentList.size() - 1));
			}
		}
		currentList.remove(currentList.size() - 1);

	}

	public static void main(String[] args) {

		BST tree = new BST();
		Node root = tree.addNode(null, 6);
		tree.addNode(root, 5);
		tree.addNode(root, 6);
		tree.addNode(root, 10);
		tree.addNode(root, 10);

		SumPathBT sumPathBT = new SumPathBT();
		sumPathBT.findSumPath(root, new ArrayList<Integer>(), 26);

	}

}
