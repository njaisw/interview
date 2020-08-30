package _1_com.ds.array;

/**
 * Date 03/04/2016
 * 
 * @author Tushar Roy
 *
 *         Given an array of size n + 1 with elements from 1 to n. One element
 *         is duplicated mulitiple times. Find that element in O(1) space. Array
 *         cannot be changed.
 * 
 *         Input: [1,3,4,2,2] Output: 2
 *
 *         Reference https://leetcode.com/problems/find-the-duplicate-number/
 */
public class X_DuplicateNumberDetection_IMP_3X {
	public int findDuplicate(int[] nums) {
		if (nums.length == 0 || nums.length == 1) {
			return -1;
		}

		int slow = nums[0];
		int fast = nums[nums[0]];
		while (slow != fast) {
			slow = nums[slow];
			fast = nums[nums[fast]];
		}
		fast = 0;
		while (slow != fast) {
			slow = nums[slow];
			fast = nums[fast];
		}

		return fast;
	}

	public static void main(String args[]) {
		int[] input = { 2, 1, 3, 4, 3 };
		X_DuplicateNumberDetection_IMP_3X dd = new X_DuplicateNumberDetection_IMP_3X();
		System.out.println(dd.findDuplicate(input));
	}
}
