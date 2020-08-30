package _5_com.ds.linklist;

/**
 * Date 04/17/2016
 * 
 * @author tusroy
 *
 *         Given a linked list, determine if it has a cycle in it.
 *
 *         Time complexity O(n) Space complexity O(1)
 *
 *         https://leetcode.com/problems/linked-list-cycle/
 */
public class LoopInLinkList_IMP_3 {

	public boolean hasCycle(Node head) {
		if (head == null) {
			return false;
		}
		// TODO Fast pointer starts head.next and slow pointer starts from head
		Node slow = head;
		Node fast = head.next;
		while (fast != null) {
			//https://stackoverflow.com/questions/1536944/detecting-the-start-of-a-loop-in-a-singly-linked-link-list
			// TODO check condition if slow is fast or fast.next=slow
			if (slow == fast || fast.next == slow) {
				return true;
			}
			slow = slow.next;
			if (fast.next != null) {
				fast = fast.next.next;
			} else {
				break;
			}
		}
		return false;
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
		head = ll.addNode(7, head);
		head = ll.addNode(8, head);
		Node node1 = ll.find(head, 8);
		Node node2 = ll.find(head, 4);
		node1.next = node2;
		LoopInLinkList_IMP_3 lll = new LoopInLinkList_IMP_3();
		System.out.println(lll.hasCycle(head));

		node2.next = null;
		System.out.println(lll.hasCycle(head));

		node1 = ll.find(head, 3);
		node2.next = node1;
		System.out.println(lll.hasCycle(head));
	}
}
