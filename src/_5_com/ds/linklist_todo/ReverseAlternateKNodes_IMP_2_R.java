package _5_com.ds.linklist_todo;

/**
 * http://www.geeksforgeeks.org/reverse-alternate-k-nodes-in-a-singly-linked-list/
 * Test case
 * k is even odd
 * number of nodes are even odd
 * k is less than or equal to 1.
 */
public class ReverseAlternateKNodes_IMP_2_R {

    public Node reverse(Node head,int k,boolean reverse){
        if(k <= 1){
            return head;
        }
        if(head == null){
            return null;
        }
        if(reverse){
            int i =0;
            Node prev = null;
            Node middle = head;
            Node next = null;
            while(middle != null && i < k){
                next = middle.next;
                middle.next = prev;
                prev = middle;
                middle = next;
                i++;
            }
            //TODO head next calls recursion
            head.next = reverse(middle,k, !reverse);
            //TODO returns previous
            head = prev;
        }else{
            int i=0;
            Node temp = head;
            while(i < k-1 && head != null){
                head = head.next;
                i++;
            }
            if(head != null){
            	//TODO reverse call
                head.next = reverse(head.next,k, !reverse);
            }
            //TODO returns temp
            head = temp;
        }
        return head;
    }
    
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
        //1
        //2
        //3
        //6
        //5
        //4
        //7
        //8
        ReverseAlternateKNodes_IMP_2_R ra = new ReverseAlternateKNodes_IMP_2_R();
        head = ra.reverse(head, 3, false);
        ll.printList(head);
    }
}
