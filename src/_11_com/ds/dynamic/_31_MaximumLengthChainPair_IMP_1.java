package _11_com.ds.dynamic;

import java.util.Arrays;

/**
 * http://www.geeksforgeeks.org/dynamic-programming-set-20-maximum-length-chain-of-pairs/
 * 
 * You are given n pairs of numbers. In every pair, the first number is always
 * smaller than the second number. A pair (c, d) can follow another pair (a, b)
 * if b < c. Chain of pairs can be formed in this fashion. Find the longest
 * chain which can be formed from a given set of pairs. Source: Amazon Interview
 * | Set 2
 * 
 * For example, if the given pairs are {{5, 24}, {39, 60}, {15, 28}, {27, 40},
 * {50, 90} }, then the longest chain that can be formed is of length 3, and the
 * chain is {{5, 24}, {27, 40}, {50, 90}}
 */
public class _31_MaximumLengthChainPair_IMP_1 {

	//TODO Comparable with Pair
	static class Pair implements Comparable<Pair> {
		public Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}

		int a;
		int b;

		@Override
		public int compareTo(Pair o) {
			if (this.a <= o.a) {
				return -1;
			} else {
				return 1;
			}
		}
	}

	public int maxLength(Pair[] arr) {
		//TODO Sort chain based upon first pair
		Arrays.sort(arr);

		Arrays.stream(arr).forEach(System.out::println);

		int T[] = new int[arr.length + 1];
		for (int i = 0; i < T.length; i++) {
			T[i] = 1;
		}
		for (int i = 2; i < T.length; i++) {
			for (int j = 1; j < i; j++) {
				if (arr[j - 1].b < arr[i - 1].a) {
					T[i] = Math.max(T[j] + 1, T[i]);
				}
			}
		}

		int max = 0;
		for (int i = 1; i < T.length; i++) {
			if (max < T[i]) {
				max = T[i];
			}
		}
		return max;
	}

	public static void main(String args[]) {
		Pair p = new Pair(5, 7);
		Pair p1 = new Pair(2, 3);
		Pair p2 = new Pair(2, 6);
		Pair p3 = new Pair(9, 11);
		Pair p4 = new Pair(8, 10);
		Pair p5 = new Pair(11, 14);

		Pair[] arr = { p, p1, p2, p3, p4, p5 };
		_31_MaximumLengthChainPair_IMP_1 mlcp = new _31_MaximumLengthChainPair_IMP_1();
		int r = mlcp.maxLength(arr);
		System.out.print(r);
	}
}
