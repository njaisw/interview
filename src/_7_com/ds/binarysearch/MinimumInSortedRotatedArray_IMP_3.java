package _7_com.ds.binarysearch;

/**
 * https://www.youtube.com/watch?v=IrraEhe9xIQ
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class MinimumInSortedRotatedArray_IMP_3 {

    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int middle = (low + high)/2;
            //TODO Only minimum element will have previous greater than itself
            if ((middle == 0 && nums[middle]  < nums[middle + 1]) || (middle > 0 && nums[middle] < nums[middle - 1])) {
                return nums[middle];
            }
            // TODO Always look in the sorted array
            else if (nums[middle] > nums[high]) {
                // 5,6,7,8,1,2,3,4 mid=1 and high= 7
                low = middle + 1;
            } else {
                // mid=1 and high=3
                high = middle - 1;
            }
        }
        //TODO retruns the num[0] when array is not rotated
        //TODO low == high, only one element
        return nums[low];
    }


}
