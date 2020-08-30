package _1_com.ds.array;

import java.util.Arrays;

/**
 * http://www.geeksforgeeks.org/find-number-of-triangles-possible/
 *
 * Given an unsorted array of positive integers, find the number of triangles that can be formed with three different array elements as three sides of triangles.
 * For a triangle to be possible from 3 values, the sum of any of the two values (or sides) must be greater than the third value (or third side).
 *
 * Examples:
 *
 * Input: arr= {4, 6, 3, 7}
 * Output: 3
 *
 * Explanation: There are three triangles
 * possible {3, 4, 6}, {4, 6, 7} and {3, 6, 7}.
 * Note that {3, 4, 7} is not a possible triangle.
 *
 * Input: arr= {10, 21, 22, 100, 101, 200, 300}.
 * Output: 6
 *
 * Explanation: There can be 6 possible triangles:
 * {10, 21, 22}, {21, 100, 101}, {22, 100, 101},
 * {10, 100, 101}, {100, 101, 200} and {101, 200, 300}
 */
public class NumberOfTrianglesInUnsortedArray {

    public int numberOfTriangles(int input[]){

        Arrays.sort(input);
        
        int count = 0;
        for(int i=0; i < input.length-2; i++){
            int k = i+2;
            for(int j=i+1; j < input.length; j++){
                //TODO For a triangle to be possible from 3 values, the sum of any of the two values (or sides) must be greater than the third value (or third side).
                while(k < input.length && input[i] + input[j] > input[k]){
                    k++;
                }
                count += k - j -1;
            }
        }
        return count;
        
    }
    
    public static void main(String args[]){
        int input[] = {3, 4, 5, 6, 8, 9, 15};
        NumberOfTrianglesInUnsortedArray not = new NumberOfTrianglesInUnsortedArray();
        System.out.println(not.numberOfTriangles(input));
    }
}
