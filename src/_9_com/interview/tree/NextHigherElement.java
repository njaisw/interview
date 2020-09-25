package _9_com.interview.tree;

public class NextHigherElement {

	static class Node<T> {

		T data;

		Node<T> left;

		Node<T> right;

		Node<T> parent;

		public Node(T data) {
			this.data = data;
		}
	}

	private <T> Node<T> findNextHighElement(Node<T> node) {

		if (node == null) {
			return null;
		}

		Node<T> current = node;
		if (current.right != null) {
			Node<T> p = current.right;
			while (p.left != null) {
				p = p.left;
			}
			return p;
		} else {
			while (true) {
				Node<T> parent = current.parent;
				if (parent == null) {
					return null;
				}
				if (parent.left == current) {
					return parent;
				} else {
					current = parent;
				}

			}

		}
	}

	public static void main(String[] args) {

		//1: If the node is 25
		//2: node is 45
		//3: node is 80
		
		 Node<Integer> root= new Node<Integer>(50);
		 
		 root.left= new Node<Integer>(25);
		 root.right= new Node<Integer>(75);
		 root.right.right= new Node<Integer>(80);
		 
		 root.left.left= new Node<Integer>(12);
		 root.left.right=new Node<Integer>(40);
		 root.left.right.right=new Node<Integer>(45);
		 root.left.right.right.left=new Node<Integer>(42);
		 
		 root.left.right.left=new Node<Integer>(30);
		 
		 root.left.right.left.left=new Node<Integer>(28);
		 
		 
		 NextHigherElement nextHighElement = new NextHigherElement();
		 Node<Integer> result = nextHighElement.findNextHighElement(root.left.right);
		 
		 System.out.println(result.data);
		 
         result = nextHighElement.findNextHighElement(root.left);
		 
		 System.out.println(result.data); 
		 
		 result = nextHighElement.findNextHighElement(root.right.right);
			 
	     System.out.println(result!=null?result.data: null); 
	     
	     result = nextHighElement.findNextHighElement(root);
		 
	     System.out.println(result!=null?result.data: null); 
		 
		 

	}

}
