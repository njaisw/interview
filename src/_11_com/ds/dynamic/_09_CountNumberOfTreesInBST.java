package _11_com.ds.dynamic;

/**
 * http://www.geeksforgeeks.org/program-nth-catalan-number/
 * Count number of binary search tree created for array of size n
 */
public class _09_CountNumberOfTreesInBST {

    @Deprecated
    int countTreesRec(int numKeys) {
        if (numKeys <=1) {
            return(1);
        }
        else {
            int sum = 0;
            int left, right, root;
            for (root=1; root<=numKeys; root++) {
                left = countTreesRec(root - 1);
                right = countTreesRec(numKeys - root);
                sum += left*right;
            }
            return(sum);
        }
    }
    
    public int countTrees(int n){
        int T[] = new int[n+1];
        T[0] = 1;
        T[1] = 1;
        for(int i=2; i <= n; i++){
            for(int j=0; j <i; j++){
                T[i] += T[j]*T[i-j-1];
            }
        }
        return T[n];
    }
    public static void main(String args[]){
        _09_CountNumberOfTreesInBST cnt = new _09_CountNumberOfTreesInBST();
        System.out.println(cnt.countTrees(3));
        System.out.println(cnt.countTrees(4));
    }
}
