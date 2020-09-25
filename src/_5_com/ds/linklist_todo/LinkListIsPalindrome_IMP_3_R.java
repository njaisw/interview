package _5_com.ds.linklist_todo;

/**
 * http://www.geeksforgeeks.org/function-to-check-if-a-singly-linked-list-is-palindrome/ 
 * Test cases:
 * odd number of nodes
 * even number of nodes
 * 0 1 or more nodes
 * palindrome list
 * non palindrom list
 */
public class LinkListIsPalindrome_IMP_3_R {

    public boolean isPalindrome(NodeRef headref,Node end){
        if(end == null){
            return true;
        }
        boolean r = isPalindrome(headref,end.next);
        if(!r)
            return r;
        //TODO R
        r = r && headref.node.data == end.data;
        headref.next();
        return r;
    }
    
    public static void main(String args[]){
        LinkList_IMP_3 ll = new LinkList_IMP_3();
        Node head = null;
        head = ll.addNode(1, head);
        head = ll.addNode(2, head);
        head = ll.addNode(3, head);
        head = ll.addNode(4, head);
        head = ll.addNode(3, head);
        head = ll.addNode(2, head);
        head = ll.addNode(1, head);
        NodeRef nodeRef = new NodeRef();
        nodeRef.node = head;
        LinkListIsPalindrome_IMP_3_R llp = new LinkListIsPalindrome_IMP_3_R();
        System.out.println(llp.isPalindrome(nodeRef, head));
    }
}
