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
public class _08a_LongestEvenLengthSubstringOfEqualHalf_1 {
    
    public int findMaxLength(int input[]){
        assert input != null;
        int T[][] = new int[input.length][input.length];
        
        for(int i=0; i < T.length; i++){
            T[i][i] = input[i];
        }
        int max = 0;
        for(int len = 2; len <= input.length; len++){
            for(int row=0; row < input.length - len+1; row++){
                //TODO col is column
                int col = row + len-1;
                //todo updating sum for each lenght
                T[row][col] = T[row][col-1] + input[col];

                if(len % 2 == 0){

                    int k = (row + col)/2;
                   // System.out.println(" row->"+row+" col->" +col+ "Value"+ T[row][k]+" len->"+len+" k->" +col+ "Value"+  T[k+1][col]);
                    if(T[row][k] == T[k+1][col]){
                        System.out.println(" row->"+row+" col->" +col+ "Value"+ T[row][k]+" len->"+len+" k->" +k+ "Value"+  T[k+1][col]);
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
        _08a_LongestEvenLengthSubstringOfEqualHalf_1 lel = new _08a_LongestEvenLengthSubstringOfEqualHalf_1();
        System.out.println(lel.findMaxLength(input));
        
    }
}
