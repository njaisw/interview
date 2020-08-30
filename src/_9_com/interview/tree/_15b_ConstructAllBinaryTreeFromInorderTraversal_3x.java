package _9_com.interview.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Date 11/07/2015
 * @author Tushar Roy
 *
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 * Total number of binary search tree possible is Catalan number.
 *
 * https://leetcode.com/problems/unique-binary-search-trees-ii/
 */
public class _15b_ConstructAllBinaryTreeFromInorderTraversal_3x {

    public List<Node> generateTrees(int n) {
        if (n == 0) {
            return Collections.emptyList();
        }
        return construct(1, n);
    }

    private List<Node> construct(int start, int end) {
        if (start > end) {
            return Collections.singletonList(null);
        }
        List<Node> allTrees = new ArrayList<>();
        for (int root = start; root <= end; root++) {
            //TODO get all subtrees from left and right side.
            List<Node> allLeftSubstrees = construct(start, root - 1);
            List<Node> allRightSubstrees = construct(root + 1, end);
            //iterate through them in all combination and them connect them to root
            //and add to allTrees.
            for (Node left : allLeftSubstrees) {
                for (Node right : allRightSubstrees) {
                    Node node = Node.newNode(root);
                    node.left = left;
                    node.right = right;
                    allTrees.add(node);
                }
            }
        }
        return allTrees;
    }

    public void printAllTrees(List<Node> allTrees) {
        TreeTraversals_IMP_2 tt = new TreeTraversals_IMP_2();
        System.out.println("Total number of trees " + allTrees.size());
        for(Node node : allTrees) {
            tt.inOrder(node);
            System.out.println();
            tt.preOrder(node);
            System.out.print("\n\n");
        }
    }

    public static void main(String args[]) {
        _15b_ConstructAllBinaryTreeFromInorderTraversal_3x ct = new _15b_ConstructAllBinaryTreeFromInorderTraversal_3x();
        List<Node> allTrees = ct.generateTrees(3);
        ct.printAllTrees(allTrees);
    }
}
