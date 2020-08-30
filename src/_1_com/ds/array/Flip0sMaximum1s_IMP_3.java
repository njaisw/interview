package _1_com.ds.array;

/**
 * Date 12/29/2015
 * @author Tushar Roy
 *
 * Given input array of 0s and 1s and number of flips allowed from 0 to 1, what is maximum consecutive 1s we can have
 * in array
 *
 * Time complexity - O(n)
 * Space complexity - O(1)
 *
 * http://www.geeksforgeeks.org/find-zeroes-to-be-flipped-so-that-number-of-consecutive-1s-is-maximized/
 The main steps are:
- While nZero is no more than m: expand the window to the right (wR++) and update the count nZero;
- While nZero exceeds m, shrink the window from left (wL++), update nZero;
- Update the widest window along the way. The positions of must-flip zeros are inside the best window.

 */
public class Flip0sMaximum1s_IMP_3 {

    public int flip0sToMaximizeConsecutive1s(int input[], int flipsAllowed) {

        int windowStart = 0;
        int countZero = 0;
        int result = 0;
        for (int i = 0 ; i < input.length; i++) {
            if (input[i] == 1) {
                result = Math.max(result, i - windowStart + 1);
            } else {
                if (countZero < flipsAllowed) {
                    countZero++;
                    result = Math.max(result, i - windowStart + 1);
                } else {
                    // TODO remember while true
                    while(true) {
                        //TODO not max calulation
                        if (input[windowStart] == 0) {
                            windowStart++;
                            break;
                        }
                        windowStart++;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String args[]) {
        int input[] = {0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1};
        Flip0sMaximum1s_IMP_3 fm = new Flip0sMaximum1s_IMP_3();
        System.out.print(fm.flip0sToMaximizeConsecutive1s(input, 1));
    }
}
