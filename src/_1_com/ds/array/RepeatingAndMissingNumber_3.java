package _1_com.ds.array;

/**
 * http://www.geeksforgeeks.org/find-a-repeating-and-a-missing-number/ Given an
 * unsorted array of size n. 
 * Array elements are in range from 1 to n. One number
 * from set {1, 2, �n} is missing and one number occurs twice in array. Find
 * these two numbers.
 * 
 * Examples:
 * 
 * arr[] = {3, 1, 3} Output: 2, 3
 */
public class RepeatingAndMissingNumber_3 {

	class Pair {
		int repeating;
		int missing;

		public String toString() {
			return repeating + " " + missing;
		}
	}

	public Pair findNumbers(int input[]) {
		Pair p = new Pair();
		for (int i = 0; i < input.length; i++) {
			if (input[Math.abs(input[i]) - 1] < 0) {
				p.repeating = Math.abs(input[i]);
			} else {
				input[Math.abs(input[i]) - 1] = -input[Math.abs(input[i]) - 1];
			}
		}

		for (int i = 0; i < input.length; i++) {
			if (input[i] < 0) {
				input[i] = -input[i];
			} else {
				p.missing = i + 1;
			}
		}
		return p;
	}

	public static void main(String args[]) {
		RepeatingAndMissingNumber_3 rmn = new RepeatingAndMissingNumber_3();
		int input[] = { 3, 1, 2, 4, 6, 8, 2, 7 };
		System.out.println(rmn.findNumbers(input));
	}
}
