package _11_com.ds.dynamic;
/*
 * Date 09/23/2014
 * @author Tushar Roy
 *
 * Given an array of non negative numbers and a total, is there subset of numbers in this array which adds up
 * to given total.
 *  Another variation is given an array is it possible to split it up into 2 equal
 * sum partitions. Partition need not be equal sized. Just equal sum.
 *
 * Time complexity - O(input.size * total_sum)
 * Space complexity - O(input.size*total_sum)
 *
 * Youtube video - https://youtu.be/s6FhG--P7z0
 */
public class _08_SubsetSum_1 {

    public boolean subsetSum(int input[], int total) {

        boolean T[][] = new boolean[input.length + 1][total + 1];

        // TODO remember the first column is true
        for (int i = 0; i <= input.length; i++) {
            T[i][0] = true;
        }

        for (int i = 1; i <= input.length; i++) {
            for (int j = 1; j <= total; j++) {
                if (j - input[i - 1] >= 0) {
                    T[i][j] = T[i - 1][j] || T[i - 1][j - input[i - 1]];
                } else {
                    T[i][j] = T[i-1][j];
                }
            }
        }
        return T[input.length][total];

    }

    //TODO Split into two equal subset and partition need not be same size
    /*
     *  Another variation is given an array is it possible to split it up into 2 equal
     * sum partitions. Partition need not be equal sized. Just equal sum.
     */
    public boolean partition(int arr[]) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        if (sum % 2 != 0) {
            return false;
        }
        sum = sum / 2;
        boolean[][] T = new boolean[arr.length + 1][sum + 1];

        // TODO remember the first column is true
        for (int i = 0; i <= arr.length; i++) {
            T[i][0] = true;
        }

        for (int i = 1; i <= arr.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j - arr[i - 1] >= 0) {
                    T[i][j] = T[i - 1][j - arr[i - 1]] || T[i - 1][j];
                } else {
                    T[i][j] = T[i-1][j];
                }
            }
        }
        return T[arr.length][sum];
    }

    public static void main(String args[]) {
        _08_SubsetSum_1 ss = new _08_SubsetSum_1();
        int arr[] = {1, 3, 5, 5, 2, 1, 1, 6};
        System.out.println(ss.partition(arr));

        int arr1[] = {2, 3, 7, 8};
        System.out.print(ss.subsetSum(arr1, 11));

    }
}
