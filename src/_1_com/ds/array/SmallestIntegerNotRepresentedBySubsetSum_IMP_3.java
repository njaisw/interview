package _1_com.ds.array;

/**
 * Date 12/31/2015
 * @author Tushar Roy
 *
 * Given array in non decreasing order find smallest integer which cannot be represented by
 * subset sum of these integers.
 *
 * Time complexity is O(n)
 *
 * http://www.geeksforgeeks.org/find-smallest-value-represented-sum-subset-given-array/
 * Given a sorted array (sorted in non-decreasing order) of positive numbers, find the smallest positive integer value that cannot be represented as sum of
 * elements of any subset of given set.
 * Expected time complexity is O(n).
 *
 * Examples:
 *
 * Input:  arr[] = {1, 3, 6, 10, 11, 15};
 * Output: 2
 *
 * Input:  arr[] = {1, 1, 1, 1};
 * Output: 5
 *
 * Input:  arr[] = {1, 1, 3, 4};
 * Output: 10
 *
 * Input:  arr[] = {1, 2, 5, 10, 20, 40};
 * Output: 4
 *
 * Input:  arr[] = {1, 2, 3, 4, 5, 6};
 * Output: 22
 */
public class SmallestIntegerNotRepresentedBySubsetSum_IMP_3 {

    public int findSmallestInteger(int input[]) {
        int result = 1;
        for (int i = 0; i < input.length; i++) {
            if (input[i] <= result) {
                result += input[i];
            } else {
                break;
            }
        }
        return result;
    }

    /**
     * Leetcode variation https://leetcode.com/problems/patching-array/
     * Given a sorted positive integer array nums and an integer n, add/patch elements to the array such that any number in range [1, n]
     * inclusive can be formed by the sum of some elements in the array. Return the minimum number of patches required.
     *
     * Example 1:
     *
     * Input: nums = [1,3], n = 6
     * Output: 1
     * Explanation:
     * Combinations of nums are [1], [3], [1,3], which form possible sums of: 1, 3, 4.
     * Now if we add/patch 2 to nums, the combinations are: [1], [2], [3], [1,3], [2,3], [1,2,3].
     * Possible sums are 1, 2, 3, 4, 5, 6, which now covers the range [1, 6].
     * So we only need 1 patch.
     */
    public int minPatches(int[] nums, int n) {
        int patch = 0;
        long t = 1;
        int i = 0;
        while(t <= n) {
            if (i == nums.length || t < nums[i]) {
                patch++;
                t += t;
            } else {
                t = nums[i] + t;
                i++;
            }
        }
        return patch;
    }


    public static void main(String args[]) {
        int input[] = {1, 2, 3, 8};
        SmallestIntegerNotRepresentedBySubsetSum_IMP_3 ss = new SmallestIntegerNotRepresentedBySubsetSum_IMP_3();
        System.out.println(ss.findSmallestInteger(input));

        int input1[] = {};
        System.out.println(ss.minPatches(input1, 7));
    }
}
