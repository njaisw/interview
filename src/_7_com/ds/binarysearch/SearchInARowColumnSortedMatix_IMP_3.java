package _7_com.ds.binarysearch;

/*
 * Given an n x n matrix and a number x, find the position of x in the matrix if it is present in it. 
 * Otherwise, print �Not Found�. In the given matrix, every row and column is sorted in increasing order. 
 * The designed algorithm should have linear time complexity.

Example :

Input : mat[4][4] = { {10, 20, 30, 40},
                      {15, 25, 35, 45},
                      {27, 29, 37, 48},
                      {32, 33, 39, 50}};
              x = 29
Output : Found at (2, 1)

 */
public class SearchInARowColumnSortedMatix_IMP_3 {

	/*
	 * Searches the element x in mat[][]. If the element is found, then prints its
	 * position and returns true, otherwise prints "not found" and returns false
	 */
	private static void search(int[][] mat, int n, int x) {

		int row = 0, col = n - 1; // set indexes for top right element

		while (row < n && col >= 0) {
			if (mat[row][col] == x) {
				System.out.print("n Found at " + row + " " + col);
				return;
			}
			if (mat[row][col] > x)
				col--;
			else // if mat[i][j] < x
				row++;
		}
		System.out.print("n Element not found");
		return;
	}

	public static void main(String[] args) {
		int mat[][] = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 }, { 27, 29, 37, 48 }, { 32, 33, 39, 50 } };

		search(mat, 4, 29);
	}

}
