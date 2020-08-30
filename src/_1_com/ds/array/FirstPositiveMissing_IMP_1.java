package _1_com.ds.array;

/**
 * Input: [1,2,0] Output: 3
 * 
 * 
 * Input: [3,4,-1,1] Output: 2
 * 
 * https://leetcode.com/problems/first-missing-positive/
 */
public class FirstPositiveMissing_IMP_1 {

	public int firstMissingPositive(int[] nums) {

		int startOfPositive = segregate(nums);
		for (int i = startOfPositive; i < nums.length; i++) {
			int index = Math.abs(nums[i]) + startOfPositive - 1;
			if (index < nums.length) {
				nums[index] = -Math.abs(nums[index]);
			}
		}
		for (int i = startOfPositive; i < nums.length; i++) {
			if (nums[i] > 0) {
				return i - startOfPositive + 1;
			}
		}
		return nums.length - startOfPositive + 1;
	}

	// Arranges negative before positive
	private int segregate(int[] nums) {
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			if (nums[start] <= 0) {
				start++;
			} else if (nums[end] > 0) {
				end--;
			} else {
				swap(nums, start, end);
			}
		}
		return start;
	}

	private void swap(int[] nums, int start, int end) {
		int t = nums[start];
		nums[start] = nums[end];
		nums[end] = t;
	}

	public static void main(String[] args) {
		FirstPositiveMissing_IMP_1 firstPositiveMissing_imp_1  = new FirstPositiveMissing_IMP_1();
		int arr[] ={3,4,-1,1};
		System.out.println(firstPositiveMissing_imp_1.firstMissingPositive(arr));

	}
}
