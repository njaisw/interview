package _7_com.ds.binarysearch;

/**
 * https://www.youtube.com/watch?v=IrraEhe9xIQ
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 *
 */
public class MinimumInSortedRotatedArray_IMP_3 {

//TODO https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/solution/

    /**
     * TODO All the elements to the left of inflection point > first element of the array.
     * TODO All the elements to the right of inflection point < first element of the array.
     *
     * his happens because the array was initially [2, 3 ,4 ,5 ,6 ,7]. But after the rotation the smaller elements[2,3] go at the back. i.e. [4, 5, 6, 7, 2, 3].
     * Because of this the first element [4] in the rotated array becomes greater than the last element.
     */


    /**
     *
     * Find the mid element of the array.
     * If mid element > first element of array this means that we need to look for the inflection point on the right of mid.
     * If mid element < first element of array this that we need to look for the inflection point on the left of mid.
     *
     *

      Find the mid element of the array.

     If mid element > first element of array this means that we need to look for the inflection point on the right of mid.

     If mid element < first element of array this that we need to look for the inflection point on the left of mid.

     *
     * 4 . We stop our search when we find the inflection point, when either of the two conditions is satisfied:
     *
     * nums[mid] > nums[mid + 1] Hence, mid+1 is the smallest.
     *
     * nums[mid - 1] > nums[mid] Hence, mid is the smallest.
     */
        public int findMin(int[] nums) {
            // If the list has just one element then return that element.
            if (nums.length == 1) {
                return nums[0];
            }

            // initializing low and high pointers.
            int low = 0, high = nums.length - 1;

            // if the last element is greater than the first element then there is no rotation.
            // e.g. 1 < 2 < 3 < 4 < 5 < 7. Already sorted array.
            // Hence the smallest element is first element. A[0]
            if (nums[high] > nums[0]) {
                return nums[0];
            }

            // Binary search way
            while (high >= low) {
                // Find the mid element
                int mid = low + (high - low) / 2;

                // if the mid element is greater than its next element then mid+1 element is the smallest
                // This point would be the point of change. From higher to lower value.
                if (nums[mid] > nums[mid + 1]) {
                    return nums[mid + 1];
                }

                // if the mid element is lesser than its previous element then mid element is the smallest
                if (nums[mid - 1] > nums[mid]) {
                    return nums[mid];
                }

                // if the mid elements value is greater than the 0th element this means
                // the least value is still somewhere to the high as we are still dealing with elements
                // greater than nums[0]
                if (nums[mid] > nums[0]) {
                    low = mid + 1;
                } else {
                    // if nums[0] is greater than the mid value then this means the smallest value is somewhere to
                    // the low
                    high = mid - 1;
                }
            }
            return -1;
        }





}
