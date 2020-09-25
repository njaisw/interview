package _5_com.ds.linklist_todo;

/**
 * Date 10/10/2016
 * 
 * @author Tushar Roy Given a list, rotate the list to the right by k places,
 *         where k is non-negative. Input: 1->2->3->4->5->NULL, k = 2 Output:
 *         4->5->1->2->3->NULL
 *
 *         Time complexity O(min(n, k))
 *
 *         https://leetcode.com/problems/rotate-list/
 */
public class X_RotateList {
	public Node rotateRight(Node head, int k) {
		if (head == null || k == 0) {
			return head;
		}
		Node slow = head;
		Node fast = head;
		int i = 0;
		while (i < k && fast != null) {
			fast = fast.next;
			i++;
		}

		if (fast == null) {
			return rotateRight(head, k % i);
		}
		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}
		Node next = slow.next;
		slow.next = null;
		fast.next = head;
		return next;
	}
}
