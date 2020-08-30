package _7_com.ds.binarysearch;

/**
 * @author Tushar Roy Date 01/17/2107 A peak element is an element that is
 *         greater than its neighbors. Find index of peak element in the array.
 *
 *         Space complexity is O(1) Time complexity is O(n)
 * 
 *         https://www.youtube.com/watch?v=a7D77DdhlFc
 *
 *         https://leetcode.com/problems/find-peak-element/
 */
public class PeakElement_IMP_3 {

	/*
	 * If X(mid) is not a peak element then we have 2 cases:
	 * 
	 * 1: If left neighbor of X is greater than X then we have peak element on left
	 * side of X which is greater than both its neighbors or we have reached the
	 * first element which would be the peak element
	 * 
	 * 2: If right neighbor of X is greater than X, then we have peak element on the
	 * right which is greater than both its neighbors or we have reached the last
	 * elemnt of the which will be the peak element
	 * 
	 * 
	 */

	public int findPeakElement(int[] nums) {
		int low = 0;
		int high = nums.length - 1;
		int middle = 0;
		while (low <= high) {
			middle = (low + high) / 2;
			int before = Integer.MIN_VALUE;
			// TODO IMP check the logic for before and after are both min values
			if (middle > 0) {
				before = nums[middle - 1];
			}
			// TODO  IMP check the logic for after are both min values
			int after = Integer.MIN_VALUE;
			if (middle < nums.length - 1) {
				after = nums[middle + 1];
			}

			if (nums[middle] > before && nums[middle] > after) {
				return middle;
				// TODO before = mid-1 and after = mid+1
			} else if (before > after) {
				high = middle - 1;
			} else {
				low = middle + 1;
			}
		}
		return middle;
	}

	public static void main(String args[]) {
		int arr[] = { 10, 5, 15, 2, 23, 90, 67 };
		PeakElement_IMP_3 pe = new PeakElement_IMP_3();
		System.out.println(pe.findPeakElement(arr));
		int arr1[] = { 10, 20, 30, 40, 50 };
		System.out.println(pe.findPeakElement(arr1));
		int arr2[] = { 100, 90, 80, 70, 60 };
		System.out.println(pe.findPeakElement(arr2));

	}
}
