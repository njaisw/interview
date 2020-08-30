package _5_com.ds.linklist;

import java.util.PriorityQueue;

public class SortNearlySortedLL {

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

	private SingleLLNode mergeNearlySortedLL(SingleLLNode head) {
		if (head == null) {
			return head;

		}
		SingleLLNode result = null;

		SingleLLNode start = head;

		while (head != null && head.next != null) {
			if (head.data < head.next.data) {
				head = head.next;
			} else {
				SingleLLNode nextNode = head.next;
				head.next = null;
				result = merge(result, start);
				start = nextNode;
				head = nextNode;
			}
		}
		
		result = merge(result, start);
		return result;

	}

	private SingleLLNode merge(SingleLLNode head1, SingleLLNode head2) {
		if (head1 == null)
			return head2;
		if (head2 == null)
			return head1;

		if (head1.data < head2.data) {
			head1.next = merge(head1.next, head2);
			return head1;
		}
		head2.next = merge(head1, head2.next);
		return head2;

	}
	
	private void print(SingleLLNode node) {
      while (node!=null) {
		System.out.println(node.data);
		node=node.next;
	  }

	}

	public static void main(String[] args) {
		SingleLLNode singleLLNode = new SingleLLNode();

		SingleLLNode head = singleLLNode.addNode(null, 1);
		singleLLNode.addNode(head, 4);
		singleLLNode.addNode(head, 7);

		singleLLNode.addNode(head, 3);
		singleLLNode.addNode(head, 9);
		singleLLNode.addNode(head, 12);

		singleLLNode.addNode(head, 5);
		singleLLNode.addNode(head, 6);
		singleLLNode.addNode(head, 8);
		
		singleLLNode.print(head);
		
		System.out.println();
		
		SortNearlySortedLL sortedDLLtoBST = new SortNearlySortedLL();
		SingleLLNode result = sortedDLLtoBST.mergeNearlySortedLL(head);
		
		singleLLNode.print(result);
		
		
		

	}

}
