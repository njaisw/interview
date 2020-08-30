package _1_com.ds.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Write a function that determines whether a array contains duplicate
 * characters within k indices of each other
 * 
 * Input: k = 3, arr[] = {1, 2, 3, 4, 1, 2, 3, 4} Output: false All duplicates
 * are more than k distance away.
 * 
 * Input: k = 3, arr[] = {1, 2, 3, 1, 4, 5} Output: true 1 is repeated at
 * distance 3.
 */
public class DuplicateWithinkIndices_IMP_1 {

	public boolean duplicate(int arr[], int k) {

		Set<Integer> visited = new HashSet<Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (visited.contains(arr[i])) {
				return true;
			}
			if (i >= k) {
				visited.remove(arr[i - k]);
			}
			visited.add(arr[i]);
		}
		return false;
	}

	public static void main(String args[]) {
		int arr[] = { 1, 2, 3, 11, 2, 5, 6 };
		DuplicateWithinkIndices_IMP_1 dk = new DuplicateWithinkIndices_IMP_1();
		System.out.println(dk.duplicate(arr, 3));
	}
}
