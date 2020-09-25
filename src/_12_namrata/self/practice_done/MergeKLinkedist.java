package _12_namrata.self.practice_done;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * [ 1->4->5, 
 * 1->3->4, 
 * 2->6 ]
 * 
 * Output: 1->1->2->3->4->4->5->6
 * 
 * @author najaiswa
 *
 */

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class MergeKLinkedist {

	public ListNode mergeKLists(ListNode[] lists) {

		if (lists == null || lists.length == 0) {
			return null;
		}

		PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>( (o1, o2) -> {
				if (o1.val<=o2.val)
					return -1;
				else return 1;
		});
		
		ListNode head=null;
		ListNode currentNode=null;

		//TODO list of linked nodes
		for (ListNode node : lists) {
			queue.offer(node);
		}
		
		while (!queue.isEmpty()) {
			ListNode temp =queue.poll();
			if(head==null) { 
			    head= temp;
			    currentNode=temp;
			}else {
			    currentNode.next=temp;
			    currentNode=currentNode.next;
			}
				if(temp.next!=null) {
					 queue.offer(temp.next);
			}
				
		   
		}
		return head;

	}

	public static void main(String[] args) {
	 ListNode node1 =new ListNode(1);
	 node1.next =new ListNode(4);
	 node1.next.next= new ListNode(5);
	 
	 ListNode node2 =new ListNode(1);
	 node2.next =new ListNode(3);
	 node2.next.next= new ListNode(4);
	 
	 ListNode node3= new ListNode(2);
	 node3.next=new ListNode(6);
	 
	 ListNode[] nodes = new ListNode[]{ node1,node2,node3  };
	 
	 MergeKLinkedist test = new MergeKLinkedist();
	 
	 ListNode list = test.mergeKLists(nodes);
	 
	 while (list.next!=null) {
		 
		 System.out.println(list.val);
		 list=list.next;
		 
	 }
				
	}

}
