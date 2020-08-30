package _1_com.ds.array;

import java.util.Arrays;

/**
 * http://www.geeksforgeeks.org/find-the-maximum-repeating-number-in-ok-time/
 * Given an array of size n, the array contains numbers in range from 0 to k-1 
 * where k is a positive integer and k <= n.
 * Find the maximum repeating number in this array
 */
public class MaxRepeatingNumber_IMP_2 {

    public int maxRepeatingNumber(int arr[], int k){
        int len = k;
        for(int i=0;  i < arr.length; i++){
            arr[arr[i]%len] += len;
        }
        Arrays.stream(arr).forEach((x)-> System.out.println(x));

        System.out.println();
        int maxRepeating = 0;
        int maxRepeatingIndex =0;
        for(int i=0; i < len; i++){
            if(maxRepeating < arr[i]){
                maxRepeating = arr[i];
                maxRepeatingIndex = i;
            }
        }
        for(int i=0; i < len; i++){
            arr[i] = arr[i] % len;
        }
        return maxRepeatingIndex;
    }
    
    public static void main(String args[]){
        MaxRepeatingNumber_IMP_2 mrn = new MaxRepeatingNumber_IMP_2();
       // int arr[] = {2,2,1,3,1,2,0,3,0,0,0,4,5,4,4,4,4};
        int arr[] = {2,2,1,3,1,2};
        System.out.println(mrn.maxRepeatingNumber(arr, 6));
    }
}
