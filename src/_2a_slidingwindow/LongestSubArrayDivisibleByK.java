package _2a_slidingwindow;

import java.util.Arrays;

public class LongestSubArrayDivisibleByK {

	private int[] longestSubArrayDivBy(int[] inputs, int k) {

		int[] remainders = new int[inputs.length];

		for (int i = 0; i < inputs.length; i++) {
			remainders[i] = inputs[i] % k;
		}

		Arrays.stream(remainders).forEach(System.out::print);

		int[] result = null;

		int start = 0;
		int maxlength = Integer.MIN_VALUE;
		int currentSum = 0;

		for (int i = 0; i < remainders.length; i++) {
			currentSum = currentSum + remainders[i];
			if (currentSum == k) {
				if (maxlength < i - start + 1) {
					maxlength = i - start + 1;
					//TODO Arrays.copyRange
					result = Arrays.copyOfRange(inputs, start, i+1);
				}
			}
			if (currentSum > k) {
				while (start < i && currentSum>=k) {
					currentSum = currentSum - remainders[start];	
					if (maxlength < i - start + 1) {
						maxlength = i - start + 1;
						result = Arrays.copyOfRange(inputs, start, i+1);
					}
					start++;

				}
			}

		}

		System.out.println();
		System.out.println(maxlength);

		return result;

	}

	public static void main(String[] args) {

		LongestSubArrayDivisibleByK longestSubArrayDivisibleByK = new LongestSubArrayDivisibleByK();
		int[] resut = longestSubArrayDivisibleByK.longestSubArrayDivBy(new int[] { 2, 7, 6, 1, 4, 5 }, 3);
		System.out.println();
		Arrays.stream(resut).forEach(System.out::print);

	}

}
