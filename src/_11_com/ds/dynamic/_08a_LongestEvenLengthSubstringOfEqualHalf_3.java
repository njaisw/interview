package _11_com.ds.dynamic;

/**
 * http://www.geeksforgeeks.org/longest-even-length-substring-sum-first-second-half/
 * Input: str = "123123"
 * Output: 6
 * The complete string is of even length and sum of first and second
 * half digits is same
 *
 * Input: str = "1538023"
 * Output: 4
 * The longest substring with same first and second half sum is "5380"
 *
 * Given a string ‘str’ of digits, find the length of the longest substring of ‘str’,
 * such that the length of the substring is 2k digits and sum of left k digits is equal to the sum of right k digits.
 *
 * Test cases
 * Even length string
 * odd length string
 * 0 length string
 */
public class     _08a_LongestEvenLengthSubstringOfEqualHalf_3 {
    
    public int findMaxLength(int input[]){
        assert input != null;
        int T[][] = new int[input.length][input.length];
        
        for(int i=0; i < T.length; i++){
            T[i][i] = input[i];
        }
        int max = 0;
        for(int len = 2; len <= input.length; len++){
            for(int i=0; i < input.length - len+1; i++){
                //TODO j is column
                int j = i + len-1;
                //todo updating sum for each lenght
                T[i][j] = T[i][j-1] + input[j];

                if(len % 2 == 0){

                    int k = (i + j)/2;
                   // System.out.println(" i->"+i+" j->" +j+ "Value"+ T[i][k]+" len->"+len+" k->" +j+ "Value"+  T[k+1][j]);
                    if(T[i][k] == T[k+1][j]){
                        System.out.println(" i->"+i+" j->" +j+ "Value"+ T[i][k]+" len->"+len+" k->" +k+ "Value"+  T[k+1][j]);
                        if(max < len){
                            max = len;
                        }
                    }
                }
            }
        }
        return max;
    }

    public static void main(String args[]){
        int input[] = {1,5,3,8,0,2,14,9};
        _08a_LongestEvenLengthSubstringOfEqualHalf_3 lel = new _08a_LongestEvenLengthSubstringOfEqualHalf_3();
        System.out.println(lel.findMaxLength(input));
        
    }
}
