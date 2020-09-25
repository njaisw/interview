package _11_com.ds.dynamic;

/**
 * Date 08/01/2014
 * @author Tushar Roy
 *
 * Given a string find longest palindromic subsequence in this string.
 *
 * Time complexity - O(n2)
 * Space complexity - O(n2
 *
 * Youtube link - https://youtu.be/_nCsPn7_OgI
 *
 * References
 * http://www.geeksforgeeks.org/dynamic-programming-set-12-longest-palindromic-subsequence/
 */
public class _04_LongestPalindromicSubsequence_1 {

    public int calculate1(char []str){
        int T[][] = new int[str.length][str.length];
        for(int i=0; i < str.length; i++){
            T[i][i] = 1;
        }
        for(int l = 2; l <= str.length; l++){
            for(int i = 0; i < str.length-l + 1; i++){
                int j = i + l - 1;
                //TODO if char are equal then it must be 2
                if(l == 2 && str[i] == str[j]){
                    T[i][j] = 2;
                }else if(str[i] == str[j]){
                    //TODO remember t[i][j] is always +2
                    T[i][j] = T[i + 1][j-1] + 2;
                }else{
                    T[i][j] = Math.max(T[i + 1][j], T[i][j - 1]);
                }
            }
        }
        return T[0][str.length-1];
    }


    @Deprecated
    public int calculateRecursive(char str[],int start,int len){
        if(len == 1){
            return 1;
        }
        if(len ==0){
            return 0;
        }
        if(str[start] == str[start+len-1]){
            return 2 + calculateRecursive(str,start+1,len-2);
        }else{
            return Math.max(calculateRecursive(str, start+1, len-1), calculateRecursive(str, start, len-1));
        }
    }
    
    public static void main(String args[]){
        _04_LongestPalindromicSubsequence_1 lps = new _04_LongestPalindromicSubsequence_1();
        String str = "agbdba";
       // int r1 = lps.calculateRecursive(str.toCharArray(), 0, str.length());
        int r2 = lps.calculate1(str.toCharArray());
        System.out.print( r2);
    }
    
}
