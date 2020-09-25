package _12_namrata.self.practice_done;

/*
 Given a Binary Tree,  print the bottom view from left to right. 
 A TreeNode x is there in output if x is the bottommost TreeNode at its horizontal distance from root.
 Horizontal distance of left child of a TreeNode x is equal to horizontal distance of x minus 1, and that of right child is horizontal distance of x plus 1.
                      20
                    /    \
                  8       22
                /   \        \
              5      3       25
                    /   \      
                  10    14
For the above tree the output should be 5, 10, 3, 14, 25.

 */
import java.util.*;
import java.util.Map.Entry;

class BottomViewTree {
	TreeNode root;

	public BottomViewTree(TreeNode TreeNode) {
		root = TreeNode;
	}

	public void bottomView() {
		if (root == null)
			return;

		// Initialize a variable 'hd' with 0 for the root element.
		int hd = 0;

		// TreeMap which stores key value pair sorted on key value
		Map<Integer, Integer> map = new TreeMap<>();

		// Queue to store tree TreeNodes in level order traversal
		Queue<TreeNode> queue = new LinkedList<TreeNode>();

		// Assign initialized horizontal distance value to root TreeNode and add it to
		// the queue.
		root.hd = hd;
		queue.add(root);

		// Loop until the queue is empty (standard level order loop)
		while (!queue.isEmpty()) {
			TreeNode temp = queue.remove();

			// Extract the horizontal distance value from the dequeued tree TreeNode.
			hd = temp.hd;

			// Put the dequeued tree TreeNode to TreeMap having key as horizontal distance.
			// Every time we find a TreeNode having same horizontal distance we need to
			// replace the data in the map.
			map.put(hd, temp.data);

			// If the dequeued TreeNode has a left child add it to the
			// queue with a horizontal distance hd-1.
			if (temp.left != null) {
				temp.left.hd = hd - 1;
				queue.add(temp.left);
			}
			// If the dequeued TreeNode has a left child add it to the
			// queue with a horizontal distance hd+1.
			if (temp.right != null) {
				temp.right.hd = hd + 1;
				queue.add(temp.right);
			}
		}

		Set<Entry<Integer, Integer>> set = map.entrySet();
		Iterator<Entry<Integer, Integer>> iterator = set.iterator();
		while (iterator.hasNext()) {
			Entry<Integer, Integer> me = iterator.next();
			System.out.print(me.getValue() + " ");
		}
	}
}

public class BottomView_IMP_3 {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(20);
		root.left = new TreeNode(8);
		root.right = new TreeNode(22);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(25);
		root.left.right.left = new TreeNode(10);
		root.left.right.right = new TreeNode(14);
		BottomViewTree tree = new BottomViewTree(root);
		System.out.println("Bottom view of the given binary tree:");
		tree.bottomView();
	}
}

class TreeNode {
	int data;
	int hd;
	TreeNode left, right;

	public TreeNode(int key) {
		data = key;
		hd = Integer.MAX_VALUE;
		left = right = null;
	}
}
