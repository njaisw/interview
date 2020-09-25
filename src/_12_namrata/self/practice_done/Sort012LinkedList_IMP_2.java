package _12_namrata.self.practice_done;

//Java Program to sort a linked list 0s, 1s or 2s by changing links 
public class Sort012LinkedList_IMP_2 {

	// Sort a linked list of 0s, 1s and 2s by changing pointers.
	public static Node sortList(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		// Create three dummy nodes to point to beginning of three linked lists. These
		// dummy nodes are created to avoid many null checks.
		Node zeroD = new Node(0);
		Node oneD = new Node(0);
		Node twoD = new Node(0);

		// Initialize current pointers for three lists and whole list.
		Node zero = zeroD, one = oneD, two = twoD;
		// Traverse list
		Node curr = head;
		while (curr != null) {
			if (curr.data == 0) {
				zero.next = curr;
				zero = zero.next;
				curr = curr.next;
			} else if (curr.data == 1) {
				one.next = curr;
				one = one.next;
				curr = curr.next;
			} else {
				two.next = curr;
				two = two.next;
				curr = curr.next;
			}
		}
		// Attach three lists
		zero.next = (oneD.next != null) ? (oneD.next) : (twoD.next);
		one.next = twoD.next;
		two.next = null;
		// Updated head
		head = zeroD.next;
		return head;
	}

	// function to create and return a node
	public static Node newNode(int data) {
		// allocating space
		Node newNode = new Node(data);
		newNode.next = null;
		return newNode;
	}

	public static void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	public static void main(String args[]) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(0);
		head.next.next.next = new Node(1);
		System.out.println("Linked List Before Sorting");
		printList(head);
		head = sortList(head);
		System.out.println("\nLinked List After Sorting");
		printList(head);
	}
}

class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
	}
}
