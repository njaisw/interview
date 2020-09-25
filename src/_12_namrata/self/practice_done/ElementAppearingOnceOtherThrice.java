package _12_namrata.self.practice_done;

import java.util.Arrays;

/**
 * Better Approach – O(n) time and O(1) space:
 *
 *     Doing XOR will not help here since all the elements are appear odd number of times.
 *     Sum all the bits in same positions for all the elements and take modulus with 3.
 *     If remainder is 0 i.e if sum is multiple of 3 means that bit is set by elements appearing thrice.
 *     If remainder is not 0 i.e sum is not multiple of 3, it means that bit is set in element appears once for sure. (not sure if that bit is set or unset in elements appearing thrice.)
 *     So if we repeat step 2,3,4 for all the elements for all the positions then we will get the element appearing once. See the example below
 *
 * Say arr[] = {6, 6, 6, 3}
 *
 * 1 1 0
 * 1 1 0
 * 1 1 0
 * 0 1 1
 * __________+
 * 3 4 1
 *
 * Now modulus with 3
 *
 * 3mod3  4mod3 1mod3 => 0 1 1 => 3 element appearing once.
 */

public class ElementAppearingOnceOtherThrice {


        public static void find (int [] arrA){

            int singleElement =0;

            for (int i = 0; i <32 ; i++) { //this is for calculating for every position in 32 bit integer
                int y = (1 << i);
                int tempSum = 0;
                for (int j = 0; j <arrA.length ; j++) {
                    if((arrA[j] & y)>=1) //if that particular bit is set for the ith position, add 1 to sum (w.r.t that bit)
                        tempSum = tempSum +1;
                }
                //if bits are not multiple of 3 then that bit belongs to the element appearing single time
                if((tempSum%3)==1) {
                    singleElement = singleElement | y;
                }
            }
            System.out.println("Element appearing once is: " + singleElement);
        }

        public static void main(String[] args) {
            int arrA [] = {1, 4, 5, 6, 1, 4, 6, 1, 4, 6};
            System.out.print(Arrays.toString(arrA));
            find(arrA);
        }


}
