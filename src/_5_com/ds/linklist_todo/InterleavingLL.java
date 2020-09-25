package _5_com.ds.linklist_todo;


public class InterleavingLL {

    static class Node {

        int data;
        Node next;

        public Node addNode(Node node, int data) {

            Node newNode = new Node();
            newNode.data = data;
            if (node == null)
                return newNode;
            while (node.next != null) {
                node = node.next;
            }
            node.next = newNode;
            return node;
        }

        public void print(Node node) {
            if (node == null)
                return;
            System.out.println(node.data);
            print(node.next);
        }
    }

    private Node interleaveNode(Node head1, Node head2) {

        Node head = head1;

        while (head1 != null & head2 != null) {
            Node nexthead1 = head1.next;
            Node nexthead2 = head2.next;
            head1.next = head2;
            head2.next = nexthead1;
            head1 = nexthead1;
            head2 = nexthead2;

        }

        return head;

    }


    public static void main(String[] args) {
        //1->10->2->9->

        Node ll = new Node();
        Node head1 = ll.addNode(null, 1);
        ll.addNode(head1, 2);
        ll.addNode(head1, 3);
        ll.addNode(head1, 4);
        ll.addNode(head1, 5);

        Node head2 = ll.addNode(null, 6);
        ll.addNode(head2, 7);
        ll.addNode(head2, 8);
        ll.addNode(head2, 9);
        ll.addNode(head2, 10);

        InterleavingLL interleavingLL = new InterleavingLL();
        Node node = interleavingLL.interleaveNode(head1, head2);

        while (node != null) {
            System.out.println(node.data);
            node = node.next;

        }


    }

}
