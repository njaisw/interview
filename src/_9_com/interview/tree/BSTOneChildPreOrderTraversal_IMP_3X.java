package _9_com.interview.tree;

/**
 * http://www.geeksforgeeks.org/check-if-each-internal-node-of-a-bst-has-exactly-one-child/
 * 
Input: pre[] = {20, 10, 11, 13, 12}
Output: Yes
The give array represents following BST. In the following BST, every internal
node has exactly 1 child. Therefor, the output is true.

In Preorder traversal, descendants (or Preorder successors) of every node appear after the node. 
In the above example, 20 is the first node in preorder and all descendants of 20 appear after it. 
All descendants of 20 are smaller than it. For 10, all descendants are greater than it. 
In general, we can say, if all internal nodes have only one child in a BST, then all the descendants of every node are either smaller or larger than the node.
The reason is simple, since the tree is BST and every node has only one child, all descendants of a node will either be on left side or right side, means all descendants will either 
be smaller or greater.
        20
       /
      10 [INF to 20]
       \
        11 [10-20]
          \
           13 [11-20]
           /
         12 [11-13]
 */
public class BSTOneChildPreOrderTraversal_IMP_3X {

    public boolean isBST(int input[]){
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        for(int i = 0; i < input.length-1; i++){
            //TODO isBST between min and max
            if(input[i] > min && input[i] < max){
                if(input[i+1] < input[i]){
                    max = input[i];
                }else{
                    min = input[i];
                }
            }else{
                return false;
            }
        }
        //TODO check the last element
        if(input[input.length-1] < max && input[input.length-1] > min){
            return true;
        }else{
            return false;
        }
    }
    
    public static void main(String args[]){
    	// After final execution min=15 and max=20
        int input[] = {20,10,14,15,17};
        BSTOneChildPreOrderTraversal_IMP_3X boc = new BSTOneChildPreOrderTraversal_IMP_3X();
        System.out.println(boc.isBST(input));
    }
}
