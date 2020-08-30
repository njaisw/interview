package _2a_slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithDistinctCharacters {

	private int longestSumWithDistictChar(char[] inputs) {


		Set<Character> sets = new HashSet<Character>();
		int start = 0;
		int maxLength = 0;

		for (int i = 0; i < inputs.length; i++) {
			if (!sets.contains(inputs[i])) {
				sets.add(inputs[i]);
				if (maxLength < i - start + 1) {
					maxLength = i - start + 1;
				}
			} else {
				while (start < i && sets.contains(inputs[i])) {
					start++;
				}
				sets.add(inputs[i]);
				if (maxLength < i - start + 1) {
					maxLength = i - start + 1;
				}

			}

		}

		return maxLength;

	}

	public static void main(String[] args) {
		LongestSubstringWithDistinctCharacters longestSubArrayDivisibleByK = new LongestSubstringWithDistinctCharacters();
		int max = longestSubArrayDivisibleByK.longestSumWithDistictChar("aaabcd".toCharArray());
		System.out.println(max);

	}

}
