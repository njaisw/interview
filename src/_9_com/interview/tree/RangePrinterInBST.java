package _9_com.interview.tree;

public class RangePrinterInBST {
	
	class Node{
		
		int data;
		
		Node left;
		
		Node right;
		
		public Node(int data) {
			this.data=data;
		}
		
	}
	
	private Node addNode(Node root, int data) {
		if (root==null) {
			return new Node(data);
		}
		if (root.data>data) {
			root.left= addNode(root.left, data);
		}else
			root.right= addNode(root.right, data);
		return root;
	}
	
	private void printInOrder(Node root) {
		if (root==null) {
			return;
		}
		printInOrder(root.left);
		System.out.println(root.data);
        printInOrder(root.right);
	}
	
	private void printRange(Node root, int a, int b) {
		if (root==null) {
			return ;
		}
			
		if (root.data>=a && root.data<=b) {
			System.out.println(root.data);
			printRange(root.left,a,b);
			printRange(root.right,a,b);
		}else if (root.data>b) {
			printRange(root.left,a,b);
		}else {
			printRange(root.right,a,b);
		}

	}

	public static void main(String[] args) {
		
		RangePrinterInBST rangePrinterInBST = new RangePrinterInBST();
		Node root = rangePrinterInBST.addNode(null, 11);
		rangePrinterInBST.addNode(root, 3);
		rangePrinterInBST.addNode(root, 1);
		rangePrinterInBST.addNode(root, 4);
		rangePrinterInBST.addNode(root, 7);
		rangePrinterInBST.addNode(root, 9);
		rangePrinterInBST.addNode(root, 19);
		rangePrinterInBST.addNode(root, 21);
		rangePrinterInBST.addNode(root, 24);
		rangePrinterInBST.addNode(root, 26);
		rangePrinterInBST.addNode(root, 29);
		
		rangePrinterInBST.printInOrder(root);
		
		System.out.println();
		
		rangePrinterInBST.printRange(root, 1, 9);
       
	}

}
