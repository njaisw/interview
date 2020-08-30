package _11_com.ds.dynamic;

import java.util.*;

/**
 * Date 08/01/2014
 * @author tusroy
 * 
 * Given a string and a dictionary, split this string into multiple words such that
 * each word belongs in dictionary.
 * 
 * e.g peanutbutter -> pea nut butter
 * e.g Iliketoplay -> I like to play
 * 
 * Solution 
 * DP solution to this problem
 * if( input[i...j] belongs in dictionary) T[i][j] = i
 * else{
 *     T[i][j] = k if T[i][k-1] != -1 && T[k][j] != -1
 *     
 * Test cases
 * 1) Empty string
 * 2) String where entire string is in dictionary
 * 3) String which cannot be split into words which are in dictionary
 * 3) String which can be split into words which are in dictionary    
 *
 */
public class _37_BreakMultipleWordsWithNoSpaceIntoSpace_3 {

    
    /**
     * Recursive and slow version of breaking word problem.
     * If no words can be formed it returns null
     */
    @Deprecated
    public String breakWord(char[] str,int low,Set<String> dictionary){
        StringBuffer buff = new StringBuffer();
        for(int i= low; i < str.length; i++){
            buff.append(str[i]);
            if(dictionary.contains(buff.toString())){
                String result = breakWord(str, i+1, dictionary);
                if(result != null){
                    return buff.toString() + " " + result;
                }
            }
        }
        if(dictionary.contains(buff.toString())){
            return buff.toString();
        }
        return null;
    }
    
    /**
     * Dynamic programming version for breaking word problem.
     * It returns null string if string cannot be broken into multipe words
     * such that each word is in dictionary.
     * Gives preference to longer words over splits
     * e.g peanutbutter with dict{pea nut butter peanut} it would result in
     * peanut butter instead of pea nut butter.
     */
    public String breakWordDP(String word, Set<String> dict){
        int T[][] = new int[word.length()][word.length()];
        
        for(int i=0; i < T.length; i++){
            for(int j=0; j < T[i].length ; j++){
                T[i][j] = -1; //-1 indicates string between i to j cannot be split
            }
        }
        
        //fill up the matrix in bottom up manner
        for(int l = 1; l <= word.length(); l++){
            for(int row=0; row < word.length() -l + 1 ; row++){
                int col = row + l-1;
                String str = word.substring(row,col+1);
                //if string between row to col is in dictionary T[row][col] is true
                if(dict.contains(str)){
                    //TODO here row goes
                    T[row][col] = row;
                    continue;
                }
                //find a k between row+1 to col such that T[row][k-1] && T[k][col] are both true
                for(int k=row+1; k <= col; k++){
                    if(T[row][k-1] != -1 && T[k][col] != -1){
                        //TODO Here k goes
                        T[row][col] = k;
                        break;
                    }
                }
            }
        }
        if(T[0][word.length()-1] == -1){
            return null;
        }

        for(int i=0; i < T.length; i++){
            for(int j=0; j < T[i].length ; j++){
                System.out.print((T[i][j]<0?" ":"  ")+T[i][j]);
            }
            System.out.println();
        }
/*
       i  h  a  d  l  i  k  e  t  o  p  l  a  y
       0  1  2  3  4  5  6  7  8  9 10 11 12 13
i 0    0 -1 -1  1 -1 -1 -1  1 -1  1 -1 -1 -1 1
h 1  -1 -1 -1  1 -1 -1 -1  4 -1  4 -1 -1 -1  4
a 2  -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1
d 3  -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1
l 4  -1 -1 -1 -1 -1 -1 -1  4 -1  8 -1 -1 -1  8
i 5  -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1
k 6  -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1
e 7  -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1
t 8  -1 -1 -1 -1 -1 -1 -1 -1 -1  8 -1 -1 -1 10
o 9  -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1
p 10 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 10
l 11 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1
a 12 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1
y 13 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1

 */

        //create space separate word from string is possible
        StringBuffer buffer = new StringBuffer();
        int i = 0; int j = word.length() -1;
        while(i < j){
            int k = T[i][j];
            if(i == k){
                buffer.append(word.substring(i, j+1));
                break;
            }
            buffer.append(word.substring(i,k) + " ");
            i = k;
        }
        
        return buffer.toString();
    }

    /**
     * Prints all the words possible instead of just one combination.
     * Reference
     * https://leetcode.com/problems/word-break-ii/
     */
    public List<String> wordBreakTopDown(String s, Set<String> wordDict) {
        Map<Integer, List<String>> dp = new HashMap<>();
        int max = 0;
        for (String s1 : wordDict) {
            max = Math.max(max, s1.length());
        }
        return wordBreakUtil(s, wordDict, dp, 0, max);
    }

    private List<String> wordBreakUtil(String s, Set<String> dict, Map<Integer, List<String>> dp, int start, int max) {
        if (start == s.length()) {
            return Collections.singletonList("");
        }

        if (dp.containsKey(start)) {
            return dp.get(start);
        }

        List<String> words = new ArrayList<>();
        for (int i = start; i < start + max && i < s.length(); i++) {
            String newWord = s.substring(start, i + 1);
            if (!dict.contains(newWord)) {
                continue;
            }
            List<String> result = wordBreakUtil(s, dict, dp, i + 1, max);
            for (String word : result) {
                String extraSpace = word.length() == 0 ? "" : " ";
                words.add(newWord + extraSpace + word);
            }
        }
        dp.put(start, words);
        return words;
    }

    /**
     * Check if any one solution exists.
     * https://leetcode.com/problems/word-break/
     */
    @Deprecated
    public boolean wordBreakTopDownOneSolution(String s, Set<String> wordDict) {
        Map<Integer, Boolean> dp = new HashMap<>();
        int max = 0;
        for (String s1 : wordDict) {
            max = Math.max(max, s1.length());
        }
        return wordBreakTopDownOneSolutionUtil(s, wordDict, 0, max, dp);

    }
    @Deprecated
    private boolean wordBreakTopDownOneSolutionUtil(String s, Set<String> dict, int start, int max, Map<Integer, Boolean> dp) {
        if (start == s.length()) {
            return true;
        }

        if (dp.containsKey(start)) {
            return dp.get(start);
        }

        for (int i = start; i < start + max && i < s.length(); i++) {
            String newWord = s.substring(start, i + 1);
            if (!dict.contains(newWord)) {
                continue;
            }
            if (wordBreakTopDownOneSolutionUtil(s, dict, i + 1, max, dp)) {
                dp.put(start, true);
                return true;
            }
        }
        dp.put(start, false);
        return false;
    }
   //TODO important
    public boolean wordBreakBottomUp(String s, List<String> wordList) {
        boolean[] T = new boolean[s.length() + 1];
        Set<String> set = new HashSet<>();
        for (String word : wordList) {
            set.add(word);
        }
        T[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if(T[j] && set.contains(s.substring(j, i))) {
                    T[i] = true;
                    break;
                }
            }
        }
        return T[s.length()];
    }
    
    public static void main(String args[]){
        Set<String> dictionary = new HashSet<String>();
        dictionary.add("I");
        dictionary.add("like");
        dictionary.add("had");
        dictionary.add("play");
        dictionary.add("to");
        String str = "Ihadliketoplay";
        _37_BreakMultipleWordsWithNoSpaceIntoSpace_3 bmw = new _37_BreakMultipleWordsWithNoSpaceIntoSpace_3();
        String result1 = bmw.breakWordDP(str, dictionary);
        
        System.out.print(result1);
    }
}
