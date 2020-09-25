package _7_com.ds.binarysearch;

/**
 * http://www.careercup.com/question?id=4798365246160896
 * 1,3,7,9,11,13 Find the missing which would be 5
 */
public class ArithmeticProgressionSearch_IMP_3_done {

    public int search(int input[]){
        int low =0;
        int high = input.length-1;

        //TODO calculate ap in binary search
        int ap = (input[high] - input[low])/(input.length);

        int middle = -1;
        while(low <= high){
            middle = (low + high)/2;
            if(input[middle] == input[0] + (middle)*ap){
                low = middle+1;
                //TODO check condition
            }else if((input[middle] > input[0] + (middle)*ap) && 
                    input[middle-1] == input[0] + (middle-1)*ap){
                return input[0] + (middle)*ap;
            }else{
                high = middle-1;
            }
        }
        return -1;
    }
    public static void main(String args[]){
        int input[] = {1,7,10,13,16,19,22};
        ArithmeticProgressionSearch_IMP_3_done aps = new ArithmeticProgressionSearch_IMP_3_done();
        System.out.println(aps.search(input));
    }
}
