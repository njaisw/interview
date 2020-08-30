package _9_com.interview.tree;

/**
 * Date 11/01/2015
 * @author Tushar Roy
 *
 * Given an array reprsentation of binary tree where index is data while value at index is
 * parent create the binary tree. Value of -1 indicates root node.
 * 
 * References:
 * http://www.geeksforgeeks.org/construct-a-binary-tree-from-parent-array-representation/
 */
public class BinaryTreeFromParentRepresentation_IMP_3 {

    public Node create(int input[]) {
        Node t[] = new Node[input.length];

        for(int i = 0; i < input.length; i++) {
            t[i] = new Node();
            t[i].data = i;
        }
        //TODO remember parent is input[i] value and child is index
        Node root = null;
        for(int i = 0; i < input.length; i++) {
            int parentIndex = input[i];
            if(parentIndex == -1) {
                root = t[i];
                continue;
            }
            Node parent = t[parentIndex];
            if(parent.left == null) {
                //TODO check the logic
                parent.left = t[i];
            } else {
                parent.right = t[i];
            }
        }
        return root;
     }

     public static void main(String args[]) {
         BinaryTreeFromParentRepresentation_IMP_3 btpp = new BinaryTreeFromParentRepresentation_IMP_3();
         int input[] =  {1, 5, 5, 2, 2, -1, 3};
         Node root = btpp.create(input);
         TreeTraversals_IMP_2 tt = new TreeTraversals_IMP_2();
         tt.inOrder(root);
         System.out.println();
         tt.preOrder(root);
     }
}

