package _7_com.ds.binarysearch;

/*
 * Given a sorted array in which all elements appear twice (one after one) and one element appears only once. Find that element in O(log n) complexity.
 Input:   arr[] = {1, 1, 3, 3, 4, 5, 5, 7, 7, 8, 8}
 Output:  4

 An Efficient Solution can find the required element in O(Log n) time. The idea is to use Binary Search. Below is an observation in input array.
 All elements before the required have first occurrence at even index (0, 2, ..) and next occurrence at odd index (1, 3, �). 
 And all elements after the required element have first occurrence at odd index and next occurrence at even index.
 1) Find the middle index, say �mid�.
 2) If �mid� is even, then compare arr[mid] and arr[mid + 1]. If both are same, then the required element after �mid� else before mid.
 3) If �mid� is odd, then compare arr[mid] and arr[mid � 1]. If both are same, then the required element after �mid� else before mid.
 */

public class ElementAppearingOnce_IMP_3 {
	// A Binary Search based method to find the element that appears only once
	public static void search(int[] arr, int low, int high) {
		if (low > high)
			return;
		if (low == high) {
			System.out.println("The required element is " + arr[low]);
			return;
		}

		// Find the middle point
		int mid = (low + high) / 2;

		// If mid is even and element next to mid is same as mid, then output element
		// lies on right side, else on left side

		if (mid % 2 == 0) {
			// If both are same, it means till this point there is no discrepancy in
			// series and element that appeared only once is at Right side of mid
			// index, so check on Right side of mid.
			if (arr[mid] == arr[mid + 1])
				search(arr, mid + 2, high);
			else
				search(arr, low, mid);
		}
		// If mid is odd
		else if (mid % 2 == 1) {
			// If mid index is Odd, it means Mid is pointing to second element of
			// some pair and if we check (mid-1), we can get first element of that
			// pair to see both are same or not.
			if (arr[mid] == arr[mid - 1])
				search(arr, mid + 1, high);
			else
				search(arr, low, mid - 1);
		}
	}

	public static void main(String[] args) {
		int[] arr = { 1, 1, 2, 4, 4, 5, 5, 6, 6 };
		search(arr, 0, arr.length - 1);
	}
}
