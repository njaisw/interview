package _11_com.ds.dynamic;

/**
 * http://www.geeksforgeeks.org/count-possible-paths-top-left-bottom-right-nxm-matrix/
 * 
 * The problem is to count all the possible paths from top left to bottom right
 * of a mXn matrix with the constraints that from each cell you can either move
 * only to right or down
 * 
 * Examples :
 * 
 * Input : m = 2, n = 2; Output : 2 There are two paths (0, 0) -> (0, 1) -> (1,
 * 1) (0, 0) -> (1, 0) -> (1, 1)
 * 
 * Input : m = 2, n = 3; Output : 3 There are three paths (0, 0) -> (0, 1) ->
 * (0, 2) -> (1, 2) (0, 0) -> (0, 1) -> (1, 1) -> (1, 2) (0, 0) -> (1, 0) -> (1,
 * 1) -> (1, 2)
 * 
 */
public class _20_NumberOfPathsInMxNMatrix {

	@Deprecated
	public int countPathsRecursive(int n, int m) {
		if (n == 1 || m == 1) {
			return 1;
		}
		return countPathsRecursive(n - 1, m) + countPathsRecursive(n, m - 1);
	}

	public int countPaths(int n, int m) {
		int T[][] = new int[n][m];
		for (int i = 0; i < n; i++) {
			T[i][0] = 1;
		}

		for (int i = 0; i < m; i++) {
			T[0][i] = 1;
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				T[i][j] = T[i - 1][j] + T[i][j - 1];
			}
		}
		return T[n - 1][m - 1];
	}

	public static void main(String args[]) {
		_20_NumberOfPathsInMxNMatrix nop = new _20_NumberOfPathsInMxNMatrix();
		System.out.print(nop.countPathsRecursive(3, 3));
	}

}
