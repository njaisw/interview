package _3_com.ds.recursion;

/**
 * Generate all combination of size k and less of adjacent numbers
 * e.g 1,2,3,4 k = 2
 * 1 2 3 4
 * 12 3 4
 * 1 23 4
 * 1 2 3 34
 * 12 34
 * @author tusroy
 *
 * https://www.youtube.com/watch?v=7IQHYbmuoVU
 *
 * https://drive.google.com/file/d/1upjiOWM20ytxrxuqoaZNsYX_pF9sFUsG/view
 *
 */
public class _3_AllAdjacentCombination {
        /*
        1 2 3 4
        1 2 34
        1 23 4
        12 3 4
        12 34
         */

    public void combination(int input[],int result[],int k,int pos,int r){
        
        if(pos == input.length){
            //TODO prints till the recursion
            for(int i=0; i < r ; i++){
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }
        // TODO i goes to max of postion k
        for(int i=pos; i < pos + k && i < input.length; i++ ){
            //
            result[r] = formNumber(input,pos,i);
            //TODO i+1 is the position
            combination(input,result,k,i+1,r+1);
        }
    }
    
    private int formNumber(int input[], int start, int end){
        int num = 0;
        for(int i=start; i <=end; i++){
            num = num*10 + input[i];
        }
        return num;
    }
    /*

    1 2 3 4 5
    1 2 3 45
    1 2 34 5
    1 2 345
    1 23 4 5
    1 23 45
    1 234 5
    12 3 4 5
    12 3 45
    12 34 5
    12 345
    123 4 5
    123 45
     */
     
    public static void main(String args[]){
        _3_AllAdjacentCombination adc = new _3_AllAdjacentCombination();
        //int input[] = {1,2,3,4,5};
        //int result[] = new int[input.length];
       // adc.combination(input,result,3,0,0);


        int input[] = {1,2,3,4};
        int result[] = new int[input.length];
        adc.combination(input,result,2,0,0);
    }
}
