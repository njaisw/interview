package _1_com.ds.array;

/**
 * https://leetcode.com/problems/product-of-array-except-self/
 Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]

Note: Please solve it without division and in O(n).
 */
public class X_MultiplyAllFieldsExceptOwnPosition {

    public int[] multiply(int nums[]) {
        if (nums.length == 0) {
            return new int[0];
        }
        int[] output = new int[nums.length];
        output[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            output[i] = output[i - 1] * nums[i - 1];
        }

        int mult = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            output[i] *= mult;
            mult *= nums[i];
        }
        return output;
    }
}
