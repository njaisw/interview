package _1_com.ds.array;

/**
 * Date 04/16/2016
 * 
 * @author Tushar Roy
 *
 *         Given a sorted array of positive integers, rearrange the array
 *         alternately i.e first element should be maximum value, second minimum
 *         value, third second max, fourth second min and so on.
 * 
 *         Input : arr[] = {1, 2, 3, 4, 5, 6, 7} Output : arr[] = {7, 1, 6, 2,
 *         5, 3, 4}
 * 
 *         Input : arr[] = {1, 2, 3, 4, 5, 6} Output : arr[] = {6, 1, 5, 2, 4,
 *         3}
 *
 *         Time complexity O(n) Space complexity O(1)
 *
 *         http://www.geeksforgeeks.org/rearrange-array-maximum-minimum-form/
 */
public class X_MaximumMinimumArrangement {

	public void rearrange(int[] input) {
		for (int i = 0; i < input.length; i++) {
			int t = input[i];
			if (t < 0) {
				continue;
			}
			int i1 = i;
			while (true) {
				int j = i1 < input.length / 2 ? 2 * i1 + 1 : (input.length - 1 - i1) * 2;
				if (j == i1) {
					break;
				}
				if (input[j] < 0) {
					break;
				}
				int t1 = input[j];
				input[j] = -t;
				t = t1;
				i1 = j;
			}
		}

		for (int i = 0; i < input.length; i++) {
			input[i] = Math.abs(input[i]);
		}
	}
}
