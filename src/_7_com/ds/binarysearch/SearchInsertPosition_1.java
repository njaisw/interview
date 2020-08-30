package _7_com.ds.binarysearch;

/**
 * https://leetcode.com/problems/search-insert-position/
 * 
 * Given a sorted array and a target value, return the index if the target is
 * found. If not, return the index where it would be if it were inserted in
 * order.
 * 
 * You may assume no duplicates in the array.
 * 
 * Example 1:
 * 
 * Input: [1,3,5,6], 5 Output: 2
 * 
 */
public class SearchInsertPosition_1 {
	public int searchInsert(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;
		while (low <= high) {
			int middle = (low + high) / 2;
			if (nums[middle] == target) {
				return middle;
			}
			// TODO Always remember to compare with first and last element
			//TODO middle = low??
			if (nums[middle] < target && (middle == nums.length - 1 || nums[middle + 1] > target)) {
				return middle + 1;
			}
			if (nums[middle] < target) {
				low = middle + 1;
			} else {
				high = middle - 1;
			}
		}
		return 0;
	}
}
