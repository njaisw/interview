package _9_com.interview.tree;

/**
 * http://www.geeksforgeeks.org/add-greater-values-every-node-given-bst/
 * Test cases:
 * Empty tree
 * One node tree
 * Two node tree
 */

class IntegerRef{
    int val;
}

public class AddGreaterValueNodeToEveryNode_imp_1 {

    public void add(Node root,IntegerRef ref){
        if(root == null){
            return ;
        }
        add(root.right,ref);
        root.data += ref.val;
        ref.val = root.data;
        add(root.left,ref);
    }
    
    public static void main(String args[]){
        BinaryTree bt = new BinaryTree();
        Node root = null;
        root = bt.addNode(10, root);
        root = bt.addNode(5, root);
        root = bt.addNode(20, root);
        root = bt.addNode(15, root);
        root = bt.addNode(25, root);
        AddGreaterValueNodeToEveryNode_imp_1 agv = new AddGreaterValueNodeToEveryNode_imp_1();
        IntegerRef ir = new IntegerRef();
        ir.val = 0;
        agv.add(root, ir);
        TreeTraversals_IMP_2 tt = new TreeTraversals_IMP_2();
        tt.inOrder(root);
    }
}
