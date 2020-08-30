package _12_namrata.self.practice_3;

//Given a N x N matrix. Write a program to find count of all the distinct elements common to all rows of the matrix. Print count of such elements.

import java.util.Arrays;

public class CountDistinctInAMatrix_IMP_3 {

	public static void sortRows(int mat[][], int n) {
		for (int i = 0; i < n; i++)
			Arrays.sort(mat[i]);
	}

	public static void findAndPrintCommonElements(int mat[][], int n) {
		sortRows(mat, n);
		// current column index of each row is stored from where the element is being
		// searched in that row
		int curr_index[] = new int[n];

		int f = 0;

		for (; curr_index[0] < n; curr_index[0]++) {
			// value present at the current column index of 1st row
			int value = mat[0][curr_index[0]];

			boolean present = true;

			// 'value' is being searched in all the subsequent rows
			for (int i = 1; i < n; i++) {
				// iterate through all the elements of the row from its current column index
				// till an element greater than the 'value' is found or the end of the row is
				// encountered
				while (curr_index[i] < n && mat[i][curr_index[i]] <= value)
					curr_index[i]++;

				// if the element was not present at the column before to the 'curr_index' of
				// row
				if (mat[i][curr_index[i] - 1] != value)
					present = false;

				// if all elements of the row have been traversed
				if (curr_index[i] == n) {
					f = 1;
					break;
				}
			}

			// if the 'value' is common to all the rows
			if (present)
				System.out.print(value + " ");

			// if any row have been completely traversed then no more common elements can be
			// found
			if (f == 1)
				break;
		}
	}

	public static void main(String[] args) {
		int mat[][] = { { 12, 1, 14, 3, 16 }, { 14, 2, 1, 3, 35 }, { 14, 1, 14, 3, 11 }, { 14, 25, 3, 2, 1 },
				{ 1, 18, 3, 21, 14 } };
		int n = 5;
		findAndPrintCommonElements(mat, n);
	}
}
