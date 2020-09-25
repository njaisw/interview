package _5_com.ds.linklist_todo;

/**
 * http://www.geeksforgeeks.org/sorted-linked-list-to-balanced-bst/ Test cases
 * empty list 0 1 or more node lists
 * 
 * Input: Linked List 1->2->3->4->5->6 Output: A Balanced BST 4 / \ 2 6 / \ / 1
 * 3 5
 */
public class SortedDLLToBalancedBST_IMP_3 {
    //TODO Single linkedlist to BST use size
	public Node toBalancedBST(Node head) {
		LinkList_IMP_3 ll = new LinkList_IMP_3();
		int size = ll.size(head);
		NodeRef headRef = new NodeRef();
		headRef.node = head;
		return toBalancedBST(headRef, size);
	}

	private Node toBalancedBST(NodeRef headRef, int size) {
		System.out.println(
				"Head->" + ((headRef == null || headRef.node == null) ? null : headRef.node.data) + " size->" + size);
		if (size <= 0) {
			return null;
		}
		// TODO left  Inorder traversal
		Node left = toBalancedBST(headRef, size / 2);

		//TODO *********remember head holder is always the ref
		Node head = headRef.node;

		//TODO ref is incremented to next node
		headRef.next();
		Node right = toBalancedBST(headRef, size - size / 2 - 1);
		//TODO  Before-> left and next->right
		head.before = left;
		head.next = right;
		return head;
	}

	public void printTreeInOrder(Node head) {
		if (head == null) {
			return;
		}
		printTreeInOrder(head.before);
		System.out.println(head.data);
		printTreeInOrder(head.next);
	}

	public void printTreePreOrder(Node head) {
		if (head == null) {
			return;
		}
		System.out.println(head.data);
		printTreePreOrder(head.before);
		printTreePreOrder(head.next);
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
		SortedDLLToBalancedBST_IMP_3 sll = new SortedDLLToBalancedBST_IMP_3();
		head = sll.toBalancedBST(head);
		sll.printTreeInOrder(head);
		System.out.println("###");
		sll.printTreePreOrder(head);
	}
}
