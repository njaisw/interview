package _1_com.ds.array;

/*
 * 
    1:Say arrays are array1[] and array2[].
    2:Calculate the median of both the arrays, say m1 and m2 for array1[] and array2[].
    3:If m1 == m2 then return m1 or m2 as final result.
    4:If m1 > m2 then median will be present in either of the sub arrays.
       a:Array1[] � from first element to m1.
       b:Array2[] � from m2 to last element.
    5:If m2 > m1 then median will be present in either of the sub arrays.
       a:Array1[] � from m1 to last element.
       b:Array2[] � from first element to m2.
    6:Repeat the steps from 1 to 5 recursively until 2 elements are left in both the arrays.
    7:Then apply the formula to get the median
      Median = (max(array1[0],array2[0]) + min(array1[1],array2[1]))/2

 */
public class MedianOf2SortedArrayOfSameSize_IMP_3 {

	public float find(int[] a, int start_a, int end_a, int[] b, int start_b, int end_b) {

		if (end_a - start_a + 1 == 2 && end_b - start_b + 1 == 2) {
			float x = Math.max(a[start_a], b[start_b]);
			float y = Math.min(a[end_a], b[end_b]);
			return (x + y) / 2;
		}

		float median_a = getMedian(a, start_a, end_a);
		float median_b = getMedian(b, start_b, end_b);

		// TODO Remember calculation of start and mid
		int mid_a = (start_a + end_a) / 2;
		int mid_b = (start_b + end_b) / 2;
		if (median_a > median_b) {
			return find(a, start_a, mid_a, b, mid_b, end_b);
		} else {
			return find(a, mid_a, end_a, b, start_b, mid_b);
		}

	}

	// TODO read the size of each median
	public float getMedian(int[] x, int start, int end) {
		// TODO Remember to add start to avoid overflow
		int size = end - start + 1;
		if (size % 2 == 0) {
			float m = x[start + (size / 2)];
			float n = x[start + (size - 1) / 2];
			return (m + n) / 2;
		} else {
			return x[start + (size - 1) / 2];
		}
	}

	public static void main(String[] args) {
		MedianOf2SortedArrayOfSameSize_IMP_3 m = new MedianOf2SortedArrayOfSameSize_IMP_3();
		int[] a = { 2, 6, 9, 10, 11 };
		int[] b = { 1, 5, 7, 12, 15 };
		float x = m.find(a, 0, a.length - 1, b, 0, b.length - 1);
		System.out.println("Median of combined sorted array is: " + x);
	}
}