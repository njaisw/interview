package _9_com.interview.tree;

/**
 * http://www.geeksforgeeks.org/convert-given-binary-tree-doubly-linked-list-set-3/
 */
public class BinaryTreeToDoubleLinkList_IMP_3 {

    public void toDoubleLL(Node root){
        NodeRef prev = new NodeRef();
        toDoubleLL(root,prev);
    }
    
    private void toDoubleLL(Node root, NodeRef prev){
        if(root == null){
            return;
        }
        toDoubleLL(root.left,prev);
        if(prev.node != null){
            prev.node.right = root;
            root.left = prev.node;
            prev.node = root;
        }else{
            //TODO remember to put root here
            prev.node = root;
        }
        toDoubleLL(root.right,prev);
    }
    
    public void print(Node root){
        Node curr = null;
        while(root != null){
            curr = root;
            System.out.print(root.data + " ");
            root = root.right;
        }
        System.out.println();
        root = curr;
        while(root != null){
            System.out.print(root.data + " ");
            root = root.left;
        }
    }
    
    public static void main(String args[]){
        BinaryTreeToDoubleLinkList_IMP_3 btd = new BinaryTreeToDoubleLinkList_IMP_3();  
        BinaryTree bt = new BinaryTree();
        Node head = null;
        head = bt.addNode(100, head);
        head = bt.addNode(90, head);
        head = bt.addNode(10, head);
        head = bt.addNode(15, head);
        head = bt.addNode(25, head);
        head = bt.addNode(5, head);
        head = bt.addNode(7, head);
        head = bt.addNode(-7, head);
        btd.toDoubleLL(head);
        btd.print(head);
    }
}
