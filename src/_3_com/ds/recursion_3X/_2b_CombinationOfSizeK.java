package _3_com.ds.recursion_3X;

/**
 * http://www.geeksforgeeks.org/print-all-possible-combinations-of-r-elements-in-a-given-array-of-size-n/
 */
public class _2b_CombinationOfSizeK {

    public void combination(int arr[],int k){
        int result[] = new int[k];
        combinationUtil(arr,k,0,result,0);
    }

    private void combinationUtil(int arr[],int k, int pos,int result[],int start){
        if(pos == k){
            for(int i=0; i < k; i++){
                System.out.print(result[i] + " ");
            }
            System.out.print("\n");
            return;
        }
        for(int i=start; i < arr.length; i++){
            result[pos] = arr[i];
            combinationUtil(arr,k,pos+1,result,i+1);
        }
    }
    
    public static void main(String args[]){
        _2b_CombinationOfSizeK kk = new _2b_CombinationOfSizeK();
        int arr[] = {1,2,3,4};
        kk.combination(arr, 2);
    }
}
