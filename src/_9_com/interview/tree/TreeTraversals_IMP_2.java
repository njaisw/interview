package _9_com.interview.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Youtube link - https://youtu.be/nzmtCFNae9k
 * Youtube link - https://youtu.be/elQcrJrfObg
 * Youtube link - https://youtu.be/qT65HltK2uE
 * Youtube link - https://youtu.be/ZM-sV9zQPEs
 * 
 * http://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion/
 * http://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and-without-stack/
 * http://www.geeksforgeeks.org/iterative-preorder-traversal/
 */
public class TreeTraversals_IMP_2 {

    public void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }
    
    public void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    
    public void postOrder(Node root){
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public void inorderItr(Node root){
    	//TODO Used Deque Linkedlist for stack
        Deque<Node> stack = new LinkedList<>();
        Node node = root;
        //TODO Remember the loops
        while(true){
            if(node != null){
                stack.addFirst(node);
                node = node.left;
            }
            else{
                if(stack.isEmpty()){
                    break;
                }
                node = stack.pollFirst();
                System.out.println(node.data);
                node = node.right;
            }
        }
    }
    
    public void preOrderItr(Node root){
        Deque<Node> stack = new LinkedList<Node>();
        stack.addFirst(root);
        while(!stack.isEmpty()){
            root = stack.pollFirst();
            System.out.print(root.data + " ");
            //TODO right node goes in first
            if(root.right != null){
                stack.addFirst(root.right);
            }
            //TODO left gets pushed next
            if(root.left!= null){
                stack.addFirst(root.left);
            }
        }
    }
    @Deprecated
    public void postOrderItr(Node root){
        Deque<Node> stack1 = new LinkedList<Node>();
        Deque<Node> stack2 = new LinkedList<Node>();
        stack1.addFirst(root);
        while(!stack1.isEmpty()){
            root = stack1.pollFirst();
            if(root.left != null){
                stack1.addFirst(root.left);
            }
            if(root.right != null){
                stack1.addFirst(root.right);
            }
            stack2.addFirst(root);
        }
        while(!stack2.isEmpty()){
            System.out.print(stack2.pollFirst().data + " ");
        }
    }
    
    //TODO Check the logic Post means -> Right,Left,Data
    public void postOrderItrOneStack(Node root){
        Node current = root;
        Deque<Node> stack = new LinkedList<>();
        while(current != null || !stack.isEmpty()){
            if(current != null){
                stack.addFirst(current);
                //TODO push left on the stack
                current = current.left;
            }else{
                Node temp = stack.peek().right;
                //TODO if right is null then print the data
                if (temp == null) {
                    temp = stack.poll();
                    System.out.print(temp.data + " ");
                    //TODO which means the stack peek points to parent node and temp is right node
                    while (!stack.isEmpty() && temp == stack.peek().right) {
                        temp = stack.poll();
                        System.out.print(temp.data + " ");
                    }
                } else {
                    //TODO else current is right node
                    current = temp;
                }
            }
        }
    }
    
    public static void main(String args[]){
        BinaryTree bt = new BinaryTree();
        Node head = null;
        head = bt.addNode(10, head);
        head = bt.addNode(15, head);
        head = bt.addNode(19, head);
        head = bt.addNode(17, head);
        head = bt.addNode(11, head);

        head = bt.addNode(-11, head);


        TreeTraversals_IMP_2 tt = new TreeTraversals_IMP_2();
        tt.postOrder(head);
        System.out.println();
       // tt.postOrderItr(head);
        //System.out.println();
        tt.postOrderItrOneStack(head);
    }
}
