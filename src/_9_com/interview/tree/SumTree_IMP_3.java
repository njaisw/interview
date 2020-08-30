package _9_com.interview.tree;


class Count{
    int size;
}

/**
 * http://www.geeksforgeeks.org/check-if-a-given-binary-tree-is-sumtree/
 * 
 * A SumTree is a Binary Tree where the value of a node is equal to sum of the nodes present 
 * in its left subtree and right subtree
 */
public class SumTree_IMP_3 {

    public boolean isSumTree(Node root){
        //TODO count passed
        Count count = new Count();
        return isSumTree(root,count);
    }
    
    private boolean isSumTree(Node root,Count count){
        if(root == null){
            return true;
        }
        //TODO important condition
        if(root.left == null && root.right == null){
            //TODO leave node return root data as count size
            count.size = root.data;
            return true;
        }
        Count leftCount = new Count();
        Count rightCount = new Count();
        boolean isLeft = isSumTree(root.left,leftCount);
        boolean isRight = isSumTree(root.right,rightCount);
        //TODO logic
        count.size = root.data + leftCount.size + rightCount.size;
        //TODO remember the checking isLeft and isRight
        return isLeft && isRight && root.data == (leftCount.size + rightCount.size);
    }
    
    public static void main(String args[]){
        ConstructTreeFromInOrderPreOrder_IMP_2 ctf = new ConstructTreeFromInOrderPreOrder_IMP_2();
        int inorder[] = {4,10,6,46,11,13,2};
        int preorder[] = {46,10,4,6,13,11,2};
        Node root = ctf.createTree(inorder, preorder);
        SumTree_IMP_3 st = new SumTree_IMP_3();
        System.out.println(st.isSumTree(root));
    }
}
