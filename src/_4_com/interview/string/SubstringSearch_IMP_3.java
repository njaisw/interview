package _4_com.interview.string;

/**
 * Date 09/22/2014
 * @author tusroy
 * 
 * Do pattern matching using KMP algorithm
 * 
 * Runtime complexity - O(m + n) where m is length of text and n is length of pattern
 * Space complexity - O(n)
 */
public class SubstringSearch_IMP_3 {

    /**
     * Slow method of pattern matching
     */
	@Deprecated
    public boolean hasSubstring(char[] text, char[] pattern){
        int i=0;
        int j=0;
        int k = 0;
        while(i < text.length && j < pattern.length){
            if(text[i] == pattern[j]){
                i++;
                j++;
            }else{
                j=0;
                k++;
                i = k;
            }
        }
        if(j == pattern.length){
            return true;
        }
        return false;
    }
    
    /**
     * Compute temporary array to maintain size of suffix which is same as prefix
     * Time/space complexity is O(size of pattern)
     */
    private int[] computePrefixTable(char pattern[]){
        int [] lps = new int[pattern.length];
        int j =0;
        for(int i=1; i < pattern.length;){
            if(pattern[i] == pattern[j]){
                // todo lps is  j+1
                lps[i] = j + 1;
                j++;
                i++;
            }else{
                if(j != 0){
                    //TODO j decrements to lps[j-1]
                    j = lps[j-1];
                }else{
                    lps[i] =0;
                    i++;
                }
            }
        }
        return lps;
    }
    
    /**
     * KMP algorithm of pattern matching.
     */
    public boolean KMP(char []text, char []pattern){
        
        int lps[] = computePrefixTable(pattern);
        int i=0;
        int j=0;
        //TODO while loop
        while(i < text.length && j < pattern.length){
            if(text[i] == pattern[j]){
                i++;
                j++;
            }else{
                if(j!=0){
                    j = lps[j-1];
                }else{
                    i++;
                }
            }
        }
        // TODO check the return
        if(j == pattern.length){
            return true;
        }
        return false;
    }
        
    public static void main(String args[]){
        
        String str = "abcxabcdabcdabcy";
        String subString = "abcdabcy";
        SubstringSearch_IMP_3 ss = new SubstringSearch_IMP_3();
        boolean result = ss.KMP(str.toCharArray(), subString.toCharArray());
        System.out.print(result);
        
    }
}
