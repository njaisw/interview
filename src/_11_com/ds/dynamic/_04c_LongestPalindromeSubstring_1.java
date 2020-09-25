package _11_com.ds.dynamic;

public class _04c_LongestPalindromeSubstring_1 {

	private int findLongestCommonSubstring(String str) {

		int[][] matrix = new int[str.length()][str.length()];

		for (int i = 0; i < matrix.length; i++) {
			matrix[i][i] = 1;
		}

		int maxlen = 0;
		for (int len = 2; len <= matrix.length; len++) {
			for (int row = 0; row < matrix.length - len; row++) {
				int col = row + len - 1;
				if (len == 2 && str.charAt(row) == str.charAt(col)) {
					matrix[row][col] = 2;
				} else if (str.charAt(row) == str.charAt(col) && matrix[row + 1][col - 1] > 0) {
					matrix[row][col] = matrix[row + 1][col - 1] + 2;
				} else {
					matrix[row][col] = Math.max(matrix[row + 1][col], matrix[row][col - 1]);
				}
				maxlen = Math.max(maxlen, matrix[row][col]);
			}
		}
		return maxlen;
	}

	public static void main(String[] args) {

		_04c_LongestPalindromeSubstring_1 longestPalindromeSubstring = new _04c_LongestPalindromeSubstring_1();
		int max= longestPalindromeSubstring.findLongestCommonSubstring("GEEKEG");
		System.out.println(max);
		
	}

}
