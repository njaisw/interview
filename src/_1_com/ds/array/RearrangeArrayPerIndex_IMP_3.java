package _1_com.ds.array;

import java.util.Arrays;

/**
 * Date 12/30/2015
 *
 * Given an array of size n where elements are in range 0 to n-1. Rearrange elements of array
 * such that if arr[i] = j then arr[j] becomes i.
 * 
Input: arr[]  = {1, 3, 0, 2};
Output: arr[] = {2, 0, 3, 1};
Explanation for the above output.
Since arr[0] is 1, arr[1] is changed to 0
Since arr[1] is 3, arr[3] is changed to 1
Since arr[2] is 0, arr[0] is changed to 2
Since arr[3] is 2, arr[2] is changed to 3

Example 2:
Input: arr[]  = {2, 0, 1, 4, 5, 3};
Output: arr[] = {1, 2, 0, 5, 3, 4};
 arr[2]->0
 arr[0]->1

Example 3:
Input: arr[]  = {0, 1, 2, 3};
Output: arr[] = {0, 1, 2, 3};

Example 4:
Input: arr[]  = {3, 2, 1, 0};
Output: arr[] = {3, 2, 1, 0};
 *
 * Time complexity O(n)
 * Space complexity O(1)
 *
 * http://www.geeksforgeeks.org/rearrange-array-arrj-becomes-arri-j/
 */
public class RearrangeArrayPerIndex_IMP_3 {

    public void rearrange(int input[]) {

        for (int i = 0; i < input.length; i++) {
            input[i]++;
        }

        for (int i = 0; i < input.length; i++) {
            if (input[i] > 0) {
                rearrangeUtil(input, i);
            }
        }

        for (int i = 0; i < input.length; i++) {
            input[i] = -input[i] - 1;
        }
    }

    private void rearrangeUtil(int input[], int start) {
        int i = start + 1;
        int v = input[start];
        // TODO Negation with swaping
        while (v > 0) {
            int t = input[v - 1];
            input[v - 1] = -i;
            i = v;
            v = t;
        }
    }

    public static void main(String args[]) {
        RearrangeArrayPerIndex_IMP_3 rai = new RearrangeArrayPerIndex_IMP_3();
        int input[] = {1, 2, 0, 5, 3, 4};
        rai.rearrange(input);
        Arrays.stream(input).forEach(i -> System.out.print(i + " "));
    }

}
