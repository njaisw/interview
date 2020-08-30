package _1_com.ds.array;

/**
 * Date 12/29/15
 * 
 * @author Tushar Roy
 *
 *         Given input array find number of inversions where i < j < k and
 *         input[i] > input[j] > input[k]
 *
 *         http://www.geeksforgeeks.org/count-inversions-of-size-three-in-a-give-array/
 * 
 *         Input: {8, 4, 2, 1} Output: 4 The four inversions are (8,4,2),
 *         (8,4,1), (4,2,1) and (8,2,1).
 * 
 *         Input: {9, 6, 4, 5, 8} Output: 2 The two inversions are {9, 6, 4} and
 *         {9, 6, 5}
 * 
 *         We can reduce the complexity if we consider every element arr[i] as
 *         middle element of inversion, find all the numbers greater than a[i]
 *         whose index is less than i, find all the numbers which are smaller
 *         than a[i] and index is more than i. We multiply the number of
 *         elements greater than a[i] to the number of elements smaller than
 *         a[i] and add it to the result.
 */
public class CountInversionOfSize3_IMP_3X {

	/**
	 * Time complexity of this method is O(n^2) Space complexity is O(1)
	 */
	public int findInversions(int input[]) {
		int inversion = 0;
		for (int i = 1; i < input.length - 1; i++) {
			int larger = 0;
			for (int k = 0; k < i; k++) {
				if (input[k] > input[i]) {
					larger++;
				}
			}
			int smaller = 0;
			for (int k = i + 1; k < input.length; k++) {
				if (input[k] < input[i]) {
					smaller++;
				}
			}
			inversion += smaller * larger;
		}
		return inversion;
	}

	public static void main(String args[]) {
		int input[] = { 9, 6, 4, 5, 8 };
		CountInversionOfSize3_IMP_3X ci = new CountInversionOfSize3_IMP_3X();
		System.out.print(ci.findInversions(input));
	}
}
