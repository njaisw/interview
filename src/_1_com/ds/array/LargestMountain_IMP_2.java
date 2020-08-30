package _1_com.ds.array;

/**
 * https://leetcode.com/problems/longest-mountain-in-array/description/ Let's
 * call any (contiguous) subarray B (of A) a mountain if the following
 * properties hold:
 * 
 * B.length >= 3 There exists some 0 < i < B.length - 1 such that B[0] < B[1] <
 * ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
 * 
 * (Note that B could be any subarray of A, including the entire array A.)
 * 
 * Given an array A of integers, return the length of the longest mountain.
 * 
 * Return 0 if there is no mountain.
 * 
 * Example 1:
 * 
 * Input: [2,1,4,7,3,2,5] Output: 5 Explanation: The largest mountain is
 * [1,4,7,3,2] which has length 5.
 * 
 * Example 2:
 * 
 * Input: [2,2,2] Output: 0 Explanation: There is no mountain.
 * 
 */
public class LargestMountain_IMP_2 {

	public int longestMountain(int[] nums) {
		int start = 0;
		int max = 0;
		State state = State.STARTED;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1]) {
				start = i;
				state = State.STARTED;
			} else if (nums[i] > nums[i - 1]) {
				if (state == State.DECREASING || state == State.STARTED) {
					start = i - 1;
					state = State.INCREASING;
				}
			} else {
				if (state == State.INCREASING || state == State.DECREASING) {
					state = State.DECREASING;
					max = Math.max(max, i - start + 1);
				} else {
					start = i;
				}
			}
		}
		return max;
	}

	enum State {
		STARTED, INCREASING, DECREASING;
	}

	public static void main(String[] args) {
		LargestMountain_IMP_2 lm = new LargestMountain_IMP_2();
		int[] nums = { 2, 1, 4, 7, 3, 2, 5 };
		System.out.println(lm.longestMountain(nums));
	}
}
