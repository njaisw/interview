package _9_com.interview.tree;

public class CountInRange {

	private int CountInBST(Node root, int low, int high) {
		if(root==null) return 0;
		
		if (root.data>=low && root.data<=high) {
			return CountInBST(root.left, low, high)+CountInBST(root.right, low, high)+1;
			
		}else if (root.data<=low){
			return CountInBST(root.right, low, high);
		}else
			return CountInBST(root.left, low, high);
		
	}
	


}
