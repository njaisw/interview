package _5_com.ds.linklist_todo;

public class DeleteDuplicateNodes {

	private static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}
	}

	// 1->1->1->2->2->3 then output should 3
	private Node deleteDuplicateNode(Node head) {

		Node prev=head;
		Node curr = head;
		Node start=null;
		
		if (head == null) {
			return null;
		}
		
		while (curr!=null) {
			
			while (curr.next!=null&& curr.data== curr.next.data) {
				curr= curr.next;
			}
			
			prev= prev.data==curr.data?curr.next:curr;
			if(start==null  &&( prev.next != null && prev.data!=prev.next.data ))  start= prev;
			curr= curr.next;	
			
		}

		return start;
		
	}
	
	private void printNode(Node head) {
		while (head!=null) {
			System.out.println(head.data);
			head= head.next;
		}

	}
	

	public static void main(String[] args) {
		
		Node head = new Node(1);
		head.next = new Node(1);
		head.next.next= new Node(1);
		head.next.next.next= new Node(2);
		head.next.next.next.next= new Node(2);
		head.next.next.next.next.next = new Node(3);
		
		DeleteDuplicateNodes deleteDuplicateNodes = new DeleteDuplicateNodes();
		
		Node node = deleteDuplicateNodes.deleteDuplicateNode(head);
		
		deleteDuplicateNodes.printNode(node);
		
		
	}

}
