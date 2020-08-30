package _5_com.ds.linklist;

/**
 * http://www.geeksforgeeks.org/given-linked-list-line-segments-remove-middle-points/
 * @author tusroy
 * Test cases:
 * 0 or more nodes
Given a linked list of co-ordinates where adjacent points either form a vertical line or a horizontal line. Delete points from the linked list which are in the middle of a horizontal or vertical line.

Examples:

Input:  (0,10)->(1,10)->(5,10)->(7,10)
                                  |
                                (7,5)->(20,5)->(40,5)
Output: Linked List should be changed to following
        (0,10)->(7,10)
                  |
                (7,5)->(40,5) 
The given linked list represents a horizontal line from (0,10) 
to (7, 10) followed by a vertical line from (7, 10) to (7, 5), 
followed by a horizontal line from (7, 5) to (40, 5).

Input:     (2,3)->(4,3)->(6,3)->(10,3)->(12,3)
Output: Linked List should be changed to following
    (2,3)->(12,3) 
There is only one vertical line, so all middle points are removed.

 *
 */

class Point{
    int x;
    int y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class RemoveMiddleElementsOfLineSegment_IMP_1 {

    public void remove(Node head){
        if(head == null || head.next == null){
            return;
        }
        Node curr = head;
        Node next = head.next;
        Node nextNext = head.next.next;
        while(nextNext != null){
            //TODO compare between current and nextnext
            Point pcurr = (Point)curr.obj;
            Point pnext = (Point)nextNext.obj;
            if(pcurr.x == pnext.x || pcurr.y == pnext.y){
                curr.next = nextNext;
                next = nextNext;
                nextNext = nextNext.next;
            }else{
                curr = curr.next;
                next = next.next;
                nextNext = nextNext.next;
            }
            
        }
    }
    
    public static void main(String args[]){
        Node head1 = null;
      
      LinkList_IMP_3 ll = new LinkList_IMP_3();
      head1 = ll.addNode(1, head1, new Point(0,10));
      head1 = ll.addNode(2, head1, new Point(1,10));
      head1 = ll.addNode(3, head1, new Point(5,10));
      head1 = ll.addNode(4, head1, new Point(7,10));
      head1 = ll.addNode(5, head1, new Point(7,5));
      head1 = ll.addNode(6, head1, new Point(20,5));
      head1 = ll.addNode(7, head1, new Point(40,5));
      head1 = ll.addNode(8, head1, new Point(40,8));
           
      RemoveMiddleElementsOfLineSegment_IMP_1 rme = new RemoveMiddleElementsOfLineSegment_IMP_1();
      rme.remove(head1);
      ll.printList(head1);
    }
}
