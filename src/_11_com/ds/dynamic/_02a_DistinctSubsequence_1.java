package _11_com.ds.dynamic;

/**
 * Date 03/20/2016
 * @author Tushar Roy
 *
 * Given a string S and a string T, count the number of distinct subsequences of T in S.
Input: S = "babgbag", T = "bag"
Output: 5
Explanation:

As shown below, there are 5 ways you can generate "bag" from S.
(The caret symbol ^ means the chosen letters)

babgbag
^^ ^
babgbag
^^    ^
babgbag
^    ^^
babgbag
  ^  ^^
babgbag
    ^^^
 *
 * Time complexity O(n^2)
 * Space complexity O(n^2)
 *
 * https://leetcode.com/problems/distinct-subsequences/
 */
public class _02a_DistinctSubsequence_1 {
    public int numDistinct(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return 0;
        }
        int[][] T = new int[t.length() + 1][s.length() + 1];
        //TODO fills entire row 0 with 1 and all col0 with 0
        for (int i = 0; i < T[0].length; i++) {
            T[0][i] = 1;
        }

        for (int i = 1; i < T.length; i++) {
            for (int j = 1; j < T[0].length; j++) {
                if (s.charAt(j - 1) == t.charAt(i - 1)) {
                    T[i] [j] = T[i-1][j-1] + T[i][j-1];
                } else {
                    T[i][j] = T[i][j-1];
                }
            }
        }
        return T[t.length()][s.length()];
    }

    public static void main(String args[]) {
        _02a_DistinctSubsequence_1 ds = new _02a_DistinctSubsequence_1();
       // System.out.println(ds.numDistinct("abdacgblc", "abc"));
        System.out.println(ds.numDistinct("babgbag", "bag"));
    }
}
