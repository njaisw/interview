package _7_com.ds.binarysearch;

/**
 * Find missing number in consecutive numbers.
 */
public class MissingNumberInConsecutiveNumbers_IMP_3 {

	public Integer findMissing(int arr[]) {

		int lowNum = arr[0];
		int low = 0;
		int high = arr.length - 1;
		int middle = (low + high) / 2;
		while (low <= high) {
			middle = (low + high) / 2;
			// TODO middle sum, middle is one extra than expected
			if (arr[middle] == (middle + 1 + lowNum) && middle - 1 >= 0 && arr[middle - 1] == (middle + lowNum - 1)) {
				return middle + lowNum;
				// TODO All elements are consequetive on left
			} else if ((middle + lowNum) == arr[middle]) {
				low = middle + 1;
			} else {
				high = middle - 1;
			}
		}
		return null;
	}

	public static void main(String args[]) {
		// int arr[] = {3,4,5,6,7,8,9,10,11,12};
		int arr1[] = { -5, -4, -3, -1, 0, 1, 2, 3 };
		MissingNumberInConsecutiveNumbers_IMP_3 mn = new MissingNumberInConsecutiveNumbers_IMP_3();
		System.out.println(mn.findMissing(arr1));
	}
}
