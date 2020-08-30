package _5_com.ds.linklist;

/**
 * http://www.geeksforgeeks.org/merge-sort-for-linked-list/
 * Test cases
 * 0 nodes
 * 1 nodes
 * 2 nodes
 * 3 nodes
 * fully sorted
 * reverse sorted
 */
public class MergeSortLinkList_IMP_3_R {

    public Node sort(Node head, boolean isAscending){
         // 10->7->5->3
        //TODO remeber that head.next is also null, partition the list till there is only one element, If only element in the ll then  return
        if(head == null || head.next == null){
            return head;
        }
        //TODO mergesort linked list based upon the middle element
        //TODO return the head of the element after middle element
        // 10->7 returns 7 and 10->null
        Node middleNode = findMiddleNode(head);
        // TODO With only one element it returns head
        head = sort(head,isAscending);
        middleNode = sort(middleNode,isAscending);
        return sortedMerge(head, middleNode, isAscending);
    }
    
    private Node sortedMerge(Node head1, Node head2, boolean isAscending){
        if(head1 == null){
            return head2;
        }
        if(head2 == null){
            return head1;
        }
        if(isAscending){
            if(head1.data <= head2.data){
                head1.next = sortedMerge(head1.next, head2, isAscending);
                return head1;
            }else{
                head2.next = sortedMerge(head1,head2.next, isAscending);
                return head2;
            }
        }else{
            //TODO remember only differe is greater than
            if(head1.data >= head2.data){
                head1.next = sortedMerge(head1.next, head2, isAscending);
                return head1;
            }else{
                head2.next = sortedMerge(head1,head2.next, isAscending);
                return head2;
            }
        }
    }
    //TODO remenber if there is only one element then it returns null
    private Node findMiddleNode(Node head){
        if(head == null){
            return null;
        }
        //TODO slow is head and fast is head.next
        Node slow = head;
        Node fast = head.next;
        //TODO check if fast and fast.next are not null
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //TODO return the element after middle element
        Node newHead = slow.next;
        slow.next = null;
        return newHead;
    }
    
    public static void main(String args[]){
        MergeSortLinkList_IMP_3_R msll = new MergeSortLinkList_IMP_3_R();
        LinkList_IMP_3 ll = new LinkList_IMP_3();
        Node head = null;
        head = ll.addNode(11, head);
        head = ll.addNode(12, head);
        head = ll.addNode(-3, head);
        head = ll.addNode(45, head);
        head = ll.addNode(5, head);
        head = msll.sort(head, false);
        ll.printList(head);
    }
}
