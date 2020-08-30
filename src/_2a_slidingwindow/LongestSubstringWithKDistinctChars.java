package _2a_slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKDistinctChars {

	private int longestSubStringwithKDistinct(char[] inputs, int k) {

		Map<Character, Integer> countmap = new HashMap<Character, Integer>();

		int start = 0;

		int maxlength = 0;

		for (int i = 0; i < inputs.length; i++) {
			if (countmap.containsKey(inputs[i])) {
				int count = countmap.get(inputs[i]);
				countmap.put(inputs[i], count++);
				if (maxlength < i - start + 1) {
					maxlength = i - start + 1;
				}
			} else {
				if (countmap.size() < k) {
					countmap.put(inputs[i], 1);
					if (maxlength < i - start + 1) {
						maxlength = i - start + 1;
					}

				}else {
                      while(countmap.size()>=k) {
                    	 if (countmap.get(inputs[start])!=null) {
                    		 if (countmap.get(inputs[start])>0) {
                    			 countmap.put(inputs[start],countmap.get(inputs[start])-1);
							}else {
								countmap.remove(inputs[start]);
							}
                    		 start++;
						 } 	  
                      }	
                    countmap.put(inputs[i], 1);
  					if (maxlength < i - start + 1) {
  						maxlength = i - start + 1;
  					}			
				}	
			}
		}

		return maxlength;
	}

	public static void main(String[] args) {
		LongestSubstringWithKDistinctChars longestSubstringWithDistinctCharacters = new LongestSubstringWithKDistinctChars();
		int maxLen= longestSubstringWithDistinctCharacters.longestSubStringwithKDistinct("aabbcc".toCharArray(), 2);
		
		System.out.println(maxLen);

	}

}
