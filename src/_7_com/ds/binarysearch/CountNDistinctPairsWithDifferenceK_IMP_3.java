package _7_com.ds.binarysearch;

import java.util.Arrays;

/**
 * http://www.geeksforgeeks.org/count-pairs-difference-equal-k/
 * 
 * Given an integer array and a positive integer k, count all distinct pairs
 * with difference equal to k.
 * 
 * Examples:
 * 
 * Input: arr[] = {1, 5, 3, 4, 2}, k = 3 Output: 2 There are 2 pairs with
 * difference 3, the pairs are {1, 4} and {5, 2}
 */
public class CountNDistinctPairsWithDifferenceK_IMP_3 {

	public int count(int arr[], int k) {
		Arrays.sort(arr);
		int count = 0;
		// TODO remember the logic
		for (int i = 0; i < arr.length; i++) {
			boolean result = binarySearch(arr, i + 1, arr.length - 1, arr[i] + k);
			if (result) {
				count++;
			}
		}
		return count;
	}

	private boolean binarySearch(int arr[], int start, int end, int num) {
		if (start > end) {
			return false;
		}
		int mid = (start + end) / 2;
		if (arr[mid] == num) {
			return true;
		} else if (arr[mid] > num) {
			return binarySearch(arr, start, mid - 1, num);
		} else {
			return binarySearch(arr, mid + 1, end, num);
		}
	}

	public static void main(String args[]) {
		CountNDistinctPairsWithDifferenceK_IMP_3 cn = new CountNDistinctPairsWithDifferenceK_IMP_3();
		int arr[] = { 1, 2, 3, 4, 5, 7, 9 };
		System.out.print(cn.count(arr, 3));
	}
}
