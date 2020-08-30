package _12_namrata.self.practice_3;

/*
 * Given two arrays A1[] and A2[], sort A1 in such a way that the relative order among the elements will be same as those are in A2. 
 * For the elements not present in A2, append them at last in sorted order. 
Input: A1[] = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8}
       A2[] = {2, 1, 8, 3}
Output: A1[] = {2, 2, 1, 1, 8, 8, 3, 5, 6, 7, 9}
We can also customize compare method of a sorting algorithm to solve the above problem. For example qsort() in C allows us to pass our own customized compare method.
1. If num1 and num2 both are in A2 then number with lower index in A2 will be treated smaller than other.
2. If only one of num1 or num2 present in A2, then that number will be treated smaller than the other which doesn�t present in A2.
3. If both are not in A2, then natural ordering will be taken.
https://www.geeksforgeeks.org/sort-array-according-order-defined-another-array/

 */

/*
 * TODO A better approcah is to use comparator
 * Steps: 
 * 1: Pass the second array which is relative to comparator constructor 
 * 2: In the compare method compare search a and b in relative array return based on the indexes found
 * 
 * 
 */

import java.util.Arrays;

public class _11_RelativeSorting {

	static int first(int arr[], int low, int high, int x) {
		if (high >= low) {
			/* (low + high)/2; */
			int mid = low + (high - low) / 2;

			if ((mid == 0 || x > arr[mid - 1]) && arr[mid] == x)
				return mid;
			if (x > arr[mid])
				return first(arr, (mid + 1), high, x);
			return first(arr, low, (mid - 1), x);
		}
		return -1;
	}

	// Sort A1[0..m-1] according to the order defined by A2[0..n-1].
	static void sortAccording(int A1[], int A2[], int m, int n) {
		// The temp array is used to store a copy of A1[] and visited[] is used to mark
		// the visited elements in temp[].
		int temp[] = new int[m], visited[] = new int[m];
		for (int i = 0; i < m; i++) {
			temp[i] = A1[i];
			visited[i] = 0;
		}

		// Sort elements in temp
		Arrays.sort(temp);

		// for index of output which is sorted A1[]
		int ind = 0;

		// Consider all elements of A2[], find them in temp[] and copy to A1[] in order.
		for (int i = 0; i < n; i++) {
			// Find index of the first occurrence of A2[i] in temp
			int f = first(temp, 0, m - 1, A2[i]);

			// If not present, no need to proceed
			if (f == -1)
				continue;

			// Copy all occurrences of A2[i] to A1[]
			for (int j = f; (j < m && temp[j] == A2[i]); j++) {
				A1[ind++] = temp[j];
				visited[j] = 1;
			}
		}

		// Now copy all items of temp[] which are not present in A2[]
		for (int i = 0; i < m; i++)
			if (visited[i] == 0)
				A1[ind++] = temp[i];
	}

	// Utility function to print an array
	static void printArray(int arr[], int n) {
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static void main(String args[]) {
		int A1[] = { 2, 1, 2, 5, 7, 1, 9, 3, 6 };
		int A2[] = { 2, 1, 8, 3 };
		int m = A1.length;
		int n = A2.length;
		System.out.println("Sorted array is ");
		sortAccording(A1, A2, m, n);
		printArray(A1, m);
	}
}
