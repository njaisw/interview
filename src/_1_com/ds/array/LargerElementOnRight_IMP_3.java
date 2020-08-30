package _1_com.ds.array;

import java.util.Deque;
import java.util.LinkedList;

/**
 * http://www.geeksforgeeks.org/next-greater-element/
 * Find next larger element on right side of a number in array for 
 * all positions in array
 * This is different than finding largest element on right side which can 
 * be done by keeping max while iterating from right
 * It is also different from find next higher number on right side which can
 * be found by keeping AVL tree and finding ceiling.
 */
public class LargerElementOnRight_IMP_3 {

    public int[] larger(int input[]){
        // TODO Deque instead of stack as stack does not have peek method
        Deque<Integer> dequeue = new LinkedList<Integer>();
        int result[] = new int[input.length];
        for(int i=0; i < result.length; i++){
            result[i] = -1;
        }
        
        dequeue.offerFirst(0);
        for(int i=1; i < input.length; i++){
            while(dequeue.size() > 0){
                int t = dequeue.peekFirst();
                if(input[t] < input[i]){
                    result[t] = i;
                    dequeue.pollFirst();
                }else{
                    break;
                }
            }
            dequeue.offerFirst(i);
        }
        return result;
    }
    
    public static void main(String args[]){
        LargerElementOnRight_IMP_3 leo = new LargerElementOnRight_IMP_3();
        int input[] = {4,2,-8,6,0,-3,-1,1,9};
        int result[] = leo.larger(input);
        for(int i=0; i < result.length; i++){
            if(result[i] != -1){
                System.out.print(input[result[i]] + " ");
            }else{
                System.out.print("NIL ");
            }
        }
    }
}
