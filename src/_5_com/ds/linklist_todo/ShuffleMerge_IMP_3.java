package _5_com.ds.linklist_todo;

/**
 * http://www.geeksforgeeks.org/merge-a-linked-list-into-another-linked-list-at-alternate-positions/
 * Given two linklist shuffle merge them.
 * e.g head1 = {1->3->5}
 * head2 = {2->4}
 * result = {1->2->3->4->5}i
 * 
 *  if the first list is 1->2->3 and second list is 4->5->6->7->8, then first list should become 1->4->2->5->3->6 and second list to 7->8.
 * 
 * Test cases
 * head1 is null and head2 is not
 * head2 is null and head1 is not
 * both are null
 * more nodes in head1 than head2
 * more nodes in head2 than head1
 * @author tusroy
 *
 */
public class ShuffleMerge_IMP_3 {

    public Node shuffleMergeRecursive(Node head1, Node head2){
    	//TODO Remember head2 is returned first here
        if(head1 == null){
            return head2;
        }
        
        if(head2 == null){
            return head1;
        }

        head2.next = shuffleMergeRecursive(head1.next, head2.next);
        
        head1.next = head2;

        return head1;
    }
    /**
    Size of list 1 is smaller, equal and larger than list 2
    */
    @Deprecated
    public Node shuffleMerge(Node head1, Node head2){
        if(head1 == null || head2 == null){
            return head2;
        }
        
        Node tempHead = head1;
        Node prev = null;
        while(head1 != null && head2 != null){
            Node temp = head1.next;
            Node temp1 = head2.next;
            head1.next = head2;
            head2.next = temp;
            prev = head2;
            head2 = temp1;
            head1 = temp;
        }
        if(head2 != null){
            prev.next = head2;
        }
        return tempHead;
    }
 
    
    public static void main(String args[]){
        LinkList_IMP_3 ll = new LinkList_IMP_3();
        Node head1 = null;
        Node head2 = null;
        
        head1 = ll.addNode(1, head1);
        head1 = ll.addNode(3, head1);
        head1 = ll.addNode(5, head1);
        head1 = ll.addNode(7, head1);
        head1 = ll.addNode(9, head1);
        
        head2 = ll.addNode(2, head2);
        head2 = ll.addNode(4, head2);
        head2 = ll.addNode(6, head2);
        head2 = ll.addNode(8, head2);
        head2 = ll.addNode(10, head2);
        head2 = ll.addNode(12, head2);
        head2 = ll.addNode(14, head2);
        ShuffleMerge_IMP_3 sm = new ShuffleMerge_IMP_3();
        Node result = sm.shuffleMergeRecursive(head1, head2);
        ll.printList(result);
    }
}
