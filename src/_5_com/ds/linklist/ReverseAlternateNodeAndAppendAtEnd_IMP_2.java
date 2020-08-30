package _5_com.ds.linklist;

/**
 * http://www.geeksforgeeks.org/given-linked-list-reverse-alternate-nodes-append-end/
 * Given a linked list, reverse alternate nodes and append them to end of list.
 * 
 * Input List: 1->2->3->4->5->6 Output List: 1->3->5->6->4->2 Test case Even and
 * odd number of nodes
 */
public class ReverseAlternateNodeAndAppendAtEnd_IMP_2 {

	public void act(Node head) {

		Node result = null;
		LinkList_IMP_3 ll = new LinkList_IMP_3();
		while (head != null && head.next != null) {
			Node temp = head.next;
			head.next = head.next.next;
			temp.next = null;
			result = ll.addAtFront(temp, result);
			if (head.next == null) {
				break;
			}
			head = head.next;
		}
		head.next = result;
	}

	public static void main(String args[]) {
		LinkList_IMP_3 ll = new LinkList_IMP_3();
		Node head = null;
		head = ll.addNode(1, head);
		head = ll.addNode(2, head);
		head = ll.addNode(3, head);
		head = ll.addNode(4, head);
		head = ll.addNode(5, head);
		head = ll.addNode(6, head);
		ReverseAlternateNodeAndAppendAtEnd_IMP_2 ran = new ReverseAlternateNodeAndAppendAtEnd_IMP_2();
		ran.act(head);
		ll.printList(head);
	}
}
