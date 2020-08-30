package _4_com.interview.string;

import java.util.HashSet;
import java.util.Set;

/**
 * References
 * http://www.geeksforgeeks.org/length-of-the-longest-substring-without-repeating-characters/
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstringWithoutRepetingCharacter_IMP_3 {

    public int lengthOfLongestSubstring(String s) {
        // Set of Character
        Set<Character> uniqueSet = new HashSet<>();
        int maxSize = 0;
        int start = 0;
        for(int i = 0; i < s.length(); i++) {
            if(!uniqueSet.contains(s.charAt(i))) {
                uniqueSet.add(s.charAt(i));
                if(uniqueSet.size() > maxSize) {
                    maxSize = uniqueSet.size();
                }
            } else {
                //TODO check while
                while (s.charAt(start) != s.charAt(i)) {
                    //TODO removes unque set  from the begining
                    uniqueSet.remove(s.charAt(start));
                    start++;
                }
                start++;
            }
        }
        return maxSize;
    }
    
    public static void main(String args[]){
        LongestSubstringWithoutRepetingCharacter_IMP_3 lsw = new LongestSubstringWithoutRepetingCharacter_IMP_3();
        System.out.println(lsw.lengthOfLongestSubstring("ABCDECAMNCZB"));
    }
}
