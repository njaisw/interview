package _1_com.ds.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * http://www.geeksforgeeks.org/largest-subarray-with-equal-number-of-0s-and-1s/
 * Test cases
 * Starting with either 0 or 1
 * Maximum length of 0 1 2 or more
 * 
 * Let input array be arr[] of size n and maxsize be the size of output subarray.
1) Consider all 0 values as -1. The problem now reduces to find out the maximum length subarray with sum = 0.
2) Create a temporary array sumleft[] of size n. Store the sum of all elements from arr[0] to arr[i] in sumleft[i]. This can be done in O(n) time.
3) There are two cases, the output subarray may start from 0th index or may start from some other index. We will return the max of the values obtained by two cases.
4) To find the maximum length subarray starting from 0th index, scan the sumleft[] and find the maximum i where sumleft[i] = 0.
5) Now, we need to find the subarray where subarray sum is 0 and start index is not 0. This problem is equivalent to finding two indexes i & j in sumleft[] such that sumleft[i] = sumleft[j] and j-i is maximum. To solve this, we can create a hash table with size = max-min+1 where min is the minimum value in the sumleft[] and max is the maximum value in the sumleft[]. The idea is to hash the leftmost occurrences of all different values in sumleft[]. The size of hash is chosen as max-min+1 because there can be these many different possible values in sumleft[]. Initialize all values in hash as -1
6) To fill and use hash[], traverse sumleft[] from 0 to n-1. If a value is not present in hash[], then store its index in hash. If the value is present, then calculate the difference of current index of sumleft[] and previously stored value in hash[]. If this difference is more than maxsize, then update the maxsize.
7) To handle corner cases (all 1s and all 0s), we initialize maxsize as -1. If the maxsize remains -1, then print there is no such subarray.
 * 
*/
public class LargestSubArrayWithEqual0sAnd1s_IMP_3 {

    public int equalNumber(int arr[]){

        int sum[] = new int[arr.length];
       // only first element
        sum[0] = arr[0] == 0? -1 : 1;

        //TODO remember it converts 0 to -1 and computes prefix sum in the array
        for(int i=1; i < sum.length; i++){
            sum[i] = sum[i-1] + (arr[i] == 0? -1 : 1);
        }

        Arrays.stream(sum).forEach(x->System.out.println(x));

        System.out.println();
        
        Map<Integer,Integer> pos = new HashMap<Integer,Integer>();
        int maxLen = 0;
        int i = 0;
        for(int s : sum){
            if(s == 0){
                maxLen = Math.max(maxLen, i+1);
            }
            if(pos.containsKey(s)){
                maxLen = Math.max(maxLen, i-pos.get(s));
            }else{
                pos.put(s, i);
            }
            i++;
        }
        return maxLen;
    }
    
    public static void main(String args[]){
        int arr[] = {0,0,0,1,0,1,0,0,1,0,0,0};
        LargestSubArrayWithEqual0sAnd1s_IMP_3 mse = new LargestSubArrayWithEqual0sAnd1s_IMP_3();
        System.out.println(mse.equalNumber(arr));
    }
    
}
