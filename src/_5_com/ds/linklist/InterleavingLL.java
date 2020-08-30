package _5_com.ds.linklist;


public class InterleavingLL {

	static class SingleLLNode {

		int data;
		SingleLLNode next;


		public SingleLLNode addNode(SingleLLNode node, int data) {

			SingleLLNode newNode= new SingleLLNode();
			newNode.data=data;
			if (node ==null)
				return newNode;

			while (node.next != null) {
				node = node.next;
			}

			node.next = newNode;

			return node;
		}

		public void print(SingleLLNode node) {
			if (node == null)
				return;
			System.out.println(node.data);
			print(node.next);

		}
	}
	
	
	
	//1->2->3->4->5->6->7->8->9->10
	
	//1->10->2->9
	// 1->2->3->4->5 && 6->7->8->9->10
	
	private SingleLLNode interleaveNode(SingleLLNode head1, SingleLLNode head2) {
		
		SingleLLNode head= head1;
	      
	     while (head1!=null & head2!=null) {
			SingleLLNode nexthead1=head1.next;
			SingleLLNode nexthead2=head2.next;
			head1.next=head2;
			head2.next=nexthead1;
			head1= nexthead1;
			head2=nexthead2;
			
		}
	     
	     return head;

	}
	
	
	public static void main(String[] args) {
		//1->10->2->9->
		
		SingleLLNode ll = new SingleLLNode();
		SingleLLNode head1 = ll.addNode(null, 1);
		ll.addNode(head1, 2);
		ll.addNode(head1, 3);
		ll.addNode(head1, 4);
		ll.addNode(head1, 5);
		
		SingleLLNode head2 = ll.addNode(null, 6);
		ll.addNode(head2, 7);
		ll.addNode(head2, 8);
		ll.addNode(head2, 9);
		ll.addNode(head2, 10);
		
		InterleavingLL interleavingLL = new InterleavingLL();
		SingleLLNode node= interleavingLL.interleaveNode(head1, head2);
		
		while (node!=null) {
			System.out.println(node.data);
			node= node.next;
			
		}
		
		
		
	}

}
