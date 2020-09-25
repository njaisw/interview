package _1_com.ds.array;

import java.util.Arrays;

/**
 * References
 * https://oj.leetcode.com/problems/trapping-rain-water/
 * https://leetcode.com/problems/trapping-rain-water/
 */
public class TrappingWater_IMP_3 {

    public int trap(int[] height) {
       if(height == null || height.length == 0) {
            return 0;
        }
        int len = height.length;
        int leftMax[] = new int[len];
        int rightMax[] = new int[len];
        leftMax[0] = height[0];
        rightMax[len-1] = height[len -1];

        for (int i = 1; i < len; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
            rightMax[len - i - 1] = Math.max(height[len- i - 1], rightMax[len-i]);
        }
        System.out.println(Arrays.toString(leftMax));
        System.out.println(Arrays.toString(rightMax));
        
        int maxWaterTrapped = 0;
        //TODO Remember i goes from 1
        for (int i = 1; i < len - 1; i++) {
            int min = Math.min(leftMax[i], rightMax[i]);
            if (height[i] < min) {
                maxWaterTrapped += min - height[i];
            }
        }
        return maxWaterTrapped;
    }

    public static void main(String args[]){
        int input[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        TrappingWater_IMP_3 tw = new TrappingWater_IMP_3();
        System.out.println(tw.trap(input));
    }
}
