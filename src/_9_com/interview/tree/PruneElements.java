package _9_com.interview.tree;

public class PruneElements {
	
	Node root;
	
	public PruneElements(Node root) {
		this.root= root;
	}
	
	static class Node{
		
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
		
		if(root.data > data) {
			root.left=addNode(root.left, data);	
		}else{
			root.right=addNode(root.right, data);
		}
        return root;
	}
	
	
	private Node pruneElements(Node root, int a, int b) {
		if (root==null) {
			return null;
		}
		
		if (root.data> a) {
			root.left=pruneElements(root.left, a, b);
		}
		
		if (root.data<b) {
			root.right= pruneElements(root.right, a, b);
		}
		
		if (root.data>=a && root.data<=b) {
			return root;
		}else if(root.data<a){
			return root.right;
		}else 
			return root.left;
		
		
	}
	
	private void printInOrder(Node root) {
		if (root==null) {
			return;
		}
		printInOrder(root.left);
        System.out.println(root.data);
        printInOrder(root.right);
	}
	

	public static void main(String[] args) {
		
		Node root = new Node(11);
		PruneElements pruneElements = new PruneElements(root);
		pruneElements.addNode(root, 3);
		pruneElements.addNode(root, 1);
		pruneElements.addNode(root, 4);
		pruneElements.addNode(root, 7);
		pruneElements.addNode(root, 9);
		pruneElements.addNode(root, 19);
		pruneElements.addNode(root, 21);
		pruneElements.addNode(root, 24);
		pruneElements.addNode(root, 26);
		pruneElements.addNode(root, 29);
		
		pruneElements.printInOrder(root);
		
		Node puned= pruneElements.pruneElements(root,1, 9);
		
		System.out.println();
		
		pruneElements.printInOrder(puned);
		
		

	}

}
