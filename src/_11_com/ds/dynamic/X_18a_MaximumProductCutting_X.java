package _11_com.ds.dynamic;

/**
 * http://www.geeksforgeeks.org/dynamic-programming-set-36-cut-a-rope-to-maximize-product/
 * 
 * Given a rope of length n meters, cut the rope in different parts of integer
 * lengths in a way that maximizes product of lengths of all parts. You must
 * make at least one cut. Assume that the length of rope is more than 2 meters.
 * 
 * Examples:
 * 
 * Input: n = 2 Output: 1 (Maximum obtainable product is 1*1)
 * 
 * Input: n = 3 Output: 2 (Maximum obtainable product is 1*2)
 * 
 * Input: n = 4 Output: 4 (Maximum obtainable product is 2*2)
 * 
 * Input: n = 5 Output: 6 (Maximum obtainable product is 2*3)
 * 
 * Input: n = 10 Output: 36 (Maximum obtainable product is 3*3*4)
 */
public class X_18a_MaximumProductCutting_X {

	public int maxProduct(int num) {
		int T[] = new int[num + 1];
		T[0] = 1;
		for (int i = 1; i <= num; i++) {
			T[i] = i;
		}
		for (int i = 2; i <= num; i++) {
			for (int j = 1; j <= i; j++) {
				T[i] = Math.max(T[i], T[j] * T[i - j]);
			}
		}
		return T[num];
	}

	public static void main(String args[]) {
		X_18a_MaximumProductCutting_X mpc = new X_18a_MaximumProductCutting_X();
		System.out.println(mpc.maxProduct(13));
	}
}
