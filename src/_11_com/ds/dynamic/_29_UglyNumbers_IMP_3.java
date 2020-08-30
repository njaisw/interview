package _11_com.ds.dynamic;

import java.util.PriorityQueue;

/**
 * Date 03/08/2016
 * 
 * @author Tushar Roy
 *
 *         Find nth ugly number.
 *
 *         https://leetcode.com/problems/ugly-number-ii/
 *         https://leetcode.com/problems/super-ugly-number/
 *         http://www.geeksforgeeks.org/ugly-numbers/
 * 
 *         Ugly numbers are numbers whose only prime factors are 2, 3 or 5. The
 *         sequence 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, � shows the first 11
 *         ugly numbers. By convention, 1 is included.
 * 
 *         Given a number n, the task is to find n�th Ugly number.
 * 
 *         Examples:
 * 
 *         Input : n = 7 Output : 8
 * 
 *         Input : n = 10 Output : 12
 * 
 *         Input : n = 15 Output : 24
 * 
 *         Input : n = 150 Output : 5832
 * 
 */
public class _29_UglyNumbers_IMP_3 {

	static class Node implements Comparable<Node> {
		int inputIndex;
		int index;
		int val;

		Node(int inputIndex, int index, int val) {
			this.index = index;
			this.val = val;
			this.inputIndex = inputIndex;
		}

		@Override
		public int compareTo(Node other) {
			return this.val - other.val;
		}
	}

	/*
	 * Write a program to find the nth super ugly number.
	 * 
	 * Super ugly numbers are positive numbers whose all prime factors are in the
	 * given prime list primes of size k.
	 * 
	 * Input: n = 12, primes = [2,7,13,19] Output: 32 Explanation:
	 * [1,2,4,7,8,13,14,16,19,26,28,32] is the sequence of the first 12 super ugly
	 * numbers given primes = [2,7,13,19] of size 4.
	 *
	 * https://www.youtube.com/watch?v=78Yx7oLA43s
	 */

	public int nthSuperUglyNumber1(int n, int[] primes) {

		PriorityQueue<Node> pq = new PriorityQueue<>();
		for (int i = 0; i < primes.length; i++) {
			pq.offer(new Node(i, 0, primes[i]));
		}
		int[] val = new int[n];
		val[0] = 1;
		for (int i = 1; i < n;) {
			Node node = pq.poll();
			//TODO removing duplicates
			if (val[i - 1] != node.val) {
				val[i] = node.val;
				i++;
			}
			node.index = node.index + 1;
            //todo value= prime * previouus value
			node.val = primes[node.inputIndex] * val[node.index];
			pq.offer(node);
		}
		return val[n - 1];
	}

	@Deprecated
	int ugly(int n) {
		int arr[] = new int[n];
		int count = 1;
		arr[0] = 1;
		int i2 = 0;
		int i3 = 0;
		int i5 = 0;
		while (count < n) {
			int minNumber = min(arr[i2] * 2, arr[i3] * 3, arr[i5] * 5);
			if (minNumber == arr[i2] * 2) {
				i2++;
			}
			if (minNumber == arr[i3] * 3) {
				i3++;
			}
			if (minNumber == arr[i5] * 5) {
				i5++;
			}
			arr[count++] = minNumber;
		}

		return arr[n - 1];
	}

	private int min(int a, int b, int c) {
		int l = Math.min(a, b);
		return Math.min(l, c);
	}

	public static void main(String args[]) {
		_29_UglyNumbers_IMP_3 ugly = new _29_UglyNumbers_IMP_3();
		int result = ugly.ugly(150);
		System.out.println(result);
		int[] primes = { 2, 7,13, 19 };

		System.out.print(ugly.nthSuperUglyNumber1(17, primes));
	}

}
