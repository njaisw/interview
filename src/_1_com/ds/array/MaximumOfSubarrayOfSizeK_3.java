package _1_com.ds.array;

/**
 * http://www.geeksforgeeks.org/maximum-of-all-subarrays-of-size-k/
 * Test cases
 * input containg neg and pos values
 * val of k is neg 0 or pos
 * val of k is larger than size of input
 * val of k is same as size of input
 */
import java.util.Deque;
import java.util.LinkedList;

public class MaximumOfSubarrayOfSizeK_3 {

    //TODO Sliding window + deque
    public int[] maxSubArray(int input[], int k) {
        //TODO Deque is a linkedlist
        Deque<Integer> queue = new LinkedList<Integer>();
        //TODO check the size
        int max[] = new int[input.length - k + 1];
        int maxVal = Integer.MIN_VALUE;
        //TODO first find max of first k values and make it 0th element of max array
        // Stored index
        for (int i = 0; i < k; i++) {
            if(maxVal < input[i]){
                maxVal = input[i];
            }
            if (queue.isEmpty()) {
                queue.offerLast(i);
            } else {
                while (!queue.isEmpty() && input[queue.peekLast()] <= input[i]) {
                    queue.pollLast();
                }
                queue.offerLast(i);
            }
            
        }
        max[0] = maxVal;
        int index=1;
        //continue from k till end of the input array
        for (int i = k; i < input.length; i++) {
            //TODO if index of peek is k distance from i then its no value to us throw it away
            if (i - k + 1 > queue.peekFirst()) {
                queue.pollFirst();
            }
            while (!queue.isEmpty() && input[queue.peekLast()] <= input[i]) {
                queue.pollLast();
            }
            queue.offerLast(i);
            //TODO Only reason first element survived was because it was biggest element.
            //TODO make it the max value for this k
            max[index] = input[queue.peekFirst()];
            index++;
        }
        return max;
    }
    
    public static void main(String args[]){
        int input[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
        MaximumOfSubarrayOfSizeK_3 msa = new MaximumOfSubarrayOfSizeK_3();
        int max[] = msa.maxSubArray(input, 4);
        for(int i : max){
            System.out.print(i + " ");
        }
    }
}
