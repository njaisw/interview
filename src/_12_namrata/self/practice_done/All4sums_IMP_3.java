package _12_namrata.self.practice_done;

import java.util.HashMap;

/*
 * Loop i = 0 to n-2 :
 Loop j = i + 1 to n-1  
   calculate sum = arr[i] + arr[j]
     If (k-sum) exist in hash 
      a) Check in hash table for all pairs of indexes which form (k-sum).
      b) If there is any pair with no  no common indexes.
           return true 
    Else  update hash table
    EndLoop;
EndLoop;
 */

public class All4sums_IMP_3 {

	static class Pair {
		int row;
		int col;

		public Pair(int r, int c) {
			this.row = r;
			this.col = c;
		}
	}

// The function finds four elements with given sum X
	static void findFourElements(int arr[], int n, int X) {
		// Store sums of all pairs in a hash table
		HashMap<Integer, Pair> map = new HashMap<>();
		for (int i = 0; i < n - 1; i++)
			for (int j = i + 1; j < n; j++)
				map.put(arr[i] + arr[j], new Pair(i, j));

		// Traverse through all pairs and search for X - (current pair sum).
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				int sum = arr[i] + arr[j];

				// If X - sum is present in hash table,
				if (map.get(X - sum) != null) {
					// Making sure that all elements are distinct array elements and an element
					// is not considered more than once.
					Pair p = map.get(X - sum);
					if (p.row != i && p.col != j && p.row != j && p.col != i) {
						System.out.println("## " + arr[p.row] + p.col + i + j);
						return;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		int arr[] = { 10, 20, 30, 40, 1, 2 };
		int X = 91;
		findFourElements(arr, arr.length, X);
	}

}
