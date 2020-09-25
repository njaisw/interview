package _5_com.ds.linklist_todo;

/**
 * http://www.geeksforgeeks.org/pairwise-swap-elements-of-a-given-linked-list/
 * Test case
 * odd or even number of k
 * odd or even number of nodes in the list
 */
public class ReverseKNodes_IMP_3 {

    public Node reverse(Node head,int k){
        if(head == null){
            return null;
        }
        Node prev = null;
        Node current = head;
        Node next = null;
        int i=0;
        while(current != null && i < k){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            i++;
        }
        //TODO head next calls recursion
        head.next = reverse(current,k);
        //TODO previous is returned here
        return prev;
    };
    
    
    public static void main(String args[]){
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
        ReverseKNodes_IMP_3 rn = new ReverseKNodes_IMP_3();
        head = rn.reverse(head, 3);
        ll.printList(head);
    }
}
