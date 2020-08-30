package _5_com.ds.linklist;

/**
 * http://www.geeksforgeeks.org/delete-nodes-which-have-a-greater-value-on-right-side/
 * 
 * The list 12->15->10->11->5->6->2->3->NULL should be changed to
 * 15->11->6->3->NULL. Note that 12, 10, 5 and 2 have been deleted because there
 * is a greater value on the right side. Test cases Sorted list reverse sorted
 * list 0 1 or more nodes in the list
 */
public class DeleteNodeWithGreaterValueOnRight_IMP_3_R {

	private int maxFound = Integer.MIN_VALUE;

	//TODO recursion
	public Node deleteNodes(Node head) {
		if (head == null) {
			return null;
		}
		Node nextNode = deleteNodes(head.next);
		if (head.data > maxFound) {
			maxFound = head.data;
		}
		if (maxFound > head.data) {
			return nextNode;
		}
		head.next = nextNode;
		return head;
	}

	public static void main(String args[]) {
		DeleteNodeWithGreaterValueOnRight_IMP_3_R dng = new DeleteNodeWithGreaterValueOnRight_IMP_3_R();
		LinkList_IMP_3 ll = new LinkList_IMP_3();
		Node head = null;
		head = ll.addNode(12, head);
		head = ll.addNode(15, head);
		head = ll.addNode(10, head);
		head = ll.addNode(11, head);
		head = ll.addNode(5, head);
		head = ll.addNode(6, head);
		head = ll.addNode(2, head);
		head = ll.addNode(3, head);
		head = dng.deleteNodes(head);
		ll.printList(head);
	}
}
