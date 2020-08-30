package _1_com.ds.array;

/**
 * http://www.geeksforgeeks.org/find-subarray-with-given-sum/
 */
public class SubarrayWithGivenSum_IMP_3 {

    class Pair{
        int start;
        int end;
        
        public String toString(){
            return start + " " + end;
        }
    }
    //Sliding window
    public Pair findSubArray(int input[],int sum){
        int currentSum = 0;
        Pair p = new Pair();
        p.start = 0;
        for(int i=0; i < input.length; i++){
            currentSum += input[i];
            p.end = i;
            if(currentSum == sum){
                return p;
            }else if(currentSum > sum){
                int s = p.start;
                while(currentSum  > sum){
                    currentSum -= input[s];
                    s++;
                }
                p.start = s;
                //TODO check for currentsum again
                if(currentSum == sum){
                    return p;
                }
            }
        }
        return null;
    }
    
    public static void main(String args[]){
        SubarrayWithGivenSum_IMP_3 sgs = new SubarrayWithGivenSum_IMP_3();
        int input[] = {6,3,9,11,1,3,5};
        System.out.println(sgs.findSubArray(input,15));
    }
}
