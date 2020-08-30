package _1_com.ds.array;

import java.util.Arrays;

/**
 * http://www.geeksforgeeks.org/given-an-array-arr-find-the-maximum-j-i-such-that-arrj-arri/'
 * Given an array arr[], find the maximum j – i such that arr[j] > arr[i]
 */
public class MaximumIminusJSuchThatAiGTAj_IMP_3 {

    class Node{
        int index;
        int size;
    }
    
    public int maximumGeeks(int input[]){
        int lhs[] = new int[input.length];
        int rhs[] = new int[input.length];
        lhs[0] = 0;

        // TODO LeftMin stores only indexes
        for(int i=1; i < lhs.length; i++){
            if(input[lhs[i-1]] < input[i]){
                lhs[i] = lhs[i-1];
            }else{
                lhs[i] = i;
            }

        }
        Arrays.stream(lhs).forEach(i-> System.out.print(i));

        System.out.println();
        rhs[input.length-1] = input.length-1;
        //TODO RightMax and stores only the indexes
        for(int i=input.length-2; i >= 0; i--){
            if(input[rhs[i+1]] > input[i]){
                rhs[i] = rhs[i+1];
            }else{
                rhs[i] = i;
            }
        }
        Arrays.stream(rhs).forEach(i-> System.out.print(i));
        System.out.println();
        int i=0;
        int j=0;
        int max = 0;
        //TODO for loop is from j 0 to end
        for(;j < input.length;){
            if(input[lhs[i]] < input[rhs[j]]){
                // TODO Remembber max is j-i is conputed only when i < j
                max = Math.max(max, j-i);
                j++;
            }else{
                i++;
            }
        }
        return max;
    }
    
    public static void main(String args[]){
        MaximumIminusJSuchThatAiGTAj_IMP_3 mj = new MaximumIminusJSuchThatAiGTAj_IMP_3();
        int input[] = {11,14,13,1,4,13,1,10};
        System.out.println(mj.maximumGeeks(input));
    }

}
