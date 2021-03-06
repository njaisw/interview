package _2_com.ds.multiarray;

/**
 * Date 07/31/2016
 * @author Tushar Roy
 *
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 *
 * https://leetcode.com/problems/rotate-image/
 *
 * Given input matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * rotate the input matrix in-place such that it becomes:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 */
public class RotateImage_3X {


    public void rotate(int[][] matrix) {
        int length = matrix.length-1;
        int row=0;
        //TODO row runs from 0 to matrix.length/2
        while(row < matrix.length/2){
            //TODO i from row to length-row
            for(int col=row; col < length-row; col++){
                int temp = matrix[row][col];
                matrix[row][col] = matrix[length-col][row];
                matrix[length-col][row] = matrix[length-row][length-col];
                matrix[length-row][length-col] = matrix[col][length-row];
                matrix[col][length-row] = temp;
            }
            row++;
        }
    }

    private void print(int arr[][]){
        for(int i=0; i < arr.length; i++){
            for(int j=0; j < arr.length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.print("\n");
        }
    }


    /**
     * 21 13 9 5 1
     * 22 14 10 6 2
     * 23 15 11 7 3
     * 24 16 12 8 4
     * 25 50 40 30 20
     */
    public static void main(String args[]){

        int matrix[][] = {{1,2,3,4,20},{5,6,7,8,30},{9,10,11,12,40},{13,14,15,16,50},{21,22,23,24,25}};
        RotateImage_3X ti = new RotateImage_3X();
        ti.rotate(matrix);
        ti.print(matrix);
    }
}
