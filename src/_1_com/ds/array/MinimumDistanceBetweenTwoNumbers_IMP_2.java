package _1_com.ds.array;

/**
 * http://www.geeksforgeeks.org/find-the-minimum-distance-between-two-numbers/
 * Given an unsorted array arr[] and two numbers x and y, find the minimum
 * distance between x and y in arr[]. The array might also contain duplicates.
 * You may assume that both x and y are different and present in arr[].
 * 
 * Examples: Input: arr[] = {1, 2}, x = 1, y = 2 Output: Minimum distance
 * between 1 and 2 is 1.
 * 
 * Input: arr[] = {3, 4, 5}, x = 3, y = 5 Output: Minimum distance between 3 and
 * 5 is 2.
 * 
 * Input: arr[] = {3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3}, x = 3, y = 6 Output:
 * Minimum distance between 3 and 6 is 4.
 * 
 * Input: arr[] = {2, 5, 3, 5, 4, 4, 2, 3}, x = 3, y = 2 Output: Minimum
 * distance between 3 and 2 is 1.
 */
public class MinimumDistanceBetweenTwoNumbers_IMP_2 {

	public int minDistance(int input[], int x, int y) {
		int prev = -1;
		int prevFound = -1;
		int min = 10000;
		for (int i = 0; i < input.length; i++) {
			if (input[i] == x) {
				if (prevFound == -1) {
					prevFound = x;
					prev = i;
				} else if (prevFound == x) {
					prev = i;
				} else {
					min = min > i - prev ? i - prev : min;
					prev = i;
					prevFound = x;
				}
			} else if (input[i] == y) {
				if (prevFound == -1) {
					prevFound = y;
					prev = i;
				} else if (prevFound == y) {
					prev = i;
				} else {
					min = min > i - prev ? i - prev : min;
					prevFound = y;
					prev = i;
				}
			}
		}
		return min;
	}

	public static void main(String args[]) {
		MinimumDistanceBetweenTwoNumbers_IMP_2 mdb = new MinimumDistanceBetweenTwoNumbers_IMP_2();
		int input[] = { 6 , 4, 1, 5, 6, 9, 10, 4, 6, 6 };
		System.out.println(mdb.minDistance(input, 5, 6));
	}
}
