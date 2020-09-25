package _1_com.ds.array;

import java.util.Arrays;

/**
 * Date 03/04/2016
 * 
 * @author Tushar Roy
 *
 *         How to append minimum numbers of characters in front of string to
 *         make it a palindrome.
 *
 *         Idea is to create a new string which is original ttring + $ + reverse
 *         of original string. Get value of suffix which is also prefix using
 *         KMP. This part of string is good. Rest needs to be copied in the
 *         front.
 *
 *         Time complexity is O(n) Space complexity is O(n)
 *
 *         https://leetcode.com/problems/shortest-palindrome/
 */
public class ShortestPalindrome_IMP_3X {

	public String shortestPalindrome(String s) {
		System.out.println(s);
		char[] input = createInput(s);
		System.out.println(Arrays.toString(input));

		int val = kmp(input);

		System.out.println("KMP->" + val);

		StringBuffer sb = new StringBuffer();

		int remaining = s.length() - val;
		int i = s.length() - 1;
		while (remaining > 0) {
			sb.append(s.charAt(i));
			i--;
			remaining--;
		}
		sb.append(s);
		return sb.toString();

	}

	private int kmp(char[] input) {
		int T[] = new int[input.length];

		int i = 1;
		int j = 0;

		T[0] = 0;

		while (i < input.length) {
			if (input[j] == input[i]) {
				//TODO condition
				T[i] = j + 1;
				j++;
			} else {
				while (j != 0) {
					//TODO j= T[j-1]
					j = T[j - 1];
					//TODO same condition repeats
					if (input[i] == input[j]) {
						T[i] = j + 1;
						j++;
						break;
					}
				}
			}
			i++;
		}
		return T[input.length - 1];
	}

	private char[] createInput(String s) {
		char[] input = new char[2 * s.length() + 1];
		int index = 0;
		for (char ch : s.toCharArray()) {
			input[index++] = ch;
		}
		input[index++] = '$';

		for (int i = s.length() - 1; i >= 0; i--) {
			input[index++] = s.charAt(i);
		}
		return input;
	}

	public static void main(String args[]) {
		ShortestPalindrome_IMP_3X sp = new ShortestPalindrome_IMP_3X();
		System.out.print(sp.shortestPalindrome("aacecaaa"));
	}
}
