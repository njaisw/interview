package _12_namrata.self.practice_done;

/*
2.	Swapping pairs make sum equal
Given two arrays of integers, write a program to check if a pair of values (one value from each array) exists such that swapping the elements of the pair will make the sum of two arrays equal.
Input : A[] = {4, 1, 2, 1, 1, 2}
        B[] = (3, 6, 3, 3)
Output : {1, 3}
Sum of elements in A[] = 11 Sum of elements in B[] = 15
To get same sum from both arrays, we can swap following values: 1 from A[] and 3 from B[]

Solution: 1: Hashing 2: Sorting
1) Sort the arrays. Calculate target= sum1-sum2
2) Traverse both array simultaneously and do  
   following for every pair.
    a) If difference is too small then,
       make it bigger by moving 'a' to a 
       bigger value.
    b) If it is too big then, make it smaller 
       by moving b to a bigger value.
    c) If it's just right, return this pair.
*/
import java.util.Arrays;

public class _02_PairSwapingMakes2SumSame_IMP_1 {

	static int getSum(int X[], int n) {
		int sum = 0;
		for (int i = 0; i < n; i++)
			sum += X[i];
		return sum;
	}

	// Function to calculate : a - b = (sumA - sumB) / 2
	static int getTarget(int A[], int n, int B[], int m) {
		// Calculation of sums from both arrays
		int sum1 = getSum(A, n);
		int sum2 = getSum(B, m);
		// because that the target must be an integer
		if ((sum1 - sum2) % 2 != 0)
			return 0;
		return ((sum1 - sum2) / 2);
	}

	static void findSwapValues(int A[], int n, int B[], int m) {
		Arrays.sort(A);
		Arrays.sort(B);
		int target = getTarget(A, n, B, m);

		// target 0 means, answer is not possible
		if (target == 0)
			return;

		int i = 0, j = 0;
		while (i < n && j < m) {
			// TODO target difference
			int diff = A[i] - B[j];
			if (diff == target) {
				System.out.println(A[i] + " " + B[i]);
				return;
			} // Look for a greater value in A[]
			else if (diff < target)
				i++;
			// Look for a greater value in B[]
			else
				j++;
		}
	}

	public static void main(String[] args) {
		int A[] = { 4, 1, 2, 1, 1, 2 };
		int n = A.length;
		int B[] = { 3, 6, 3, 3 };
		int m = B.length;
		findSwapValues(A, n, B, m);
	}
}
