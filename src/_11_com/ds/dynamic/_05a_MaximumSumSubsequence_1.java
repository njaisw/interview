package _11_com.ds.dynamic;

public class _05a_MaximumSumSubsequence_1 {

   private int maximumValueContiguousSequence( int[] input){
       int maximum=0;
       int  maximumSoFar=0;
       for (int in: input) {

           if (maximumSoFar+in>0)
            maximumSoFar= maximumSoFar+in;
           else
               maximumSoFar=0;


           maximum = Math.max(maximum,maximumSoFar);

       }
       return maximum;
    }


    public static void main(String[] args) {
       int[] in = new int[]{-2,11,-4,13,-5,2};
       int[] in1= new int[]{1,-3,4,-2,-1,6};

        _05a_MaximumSumSubsequence_1 maximumSumSubsequence = new _05a_MaximumSumSubsequence_1();
        System.out.println( maximumSumSubsequence.maximumValueContiguousSequence(in));
        System.out.println( maximumSumSubsequence.maximumValueContiguousSequence(in1));


    }
}
