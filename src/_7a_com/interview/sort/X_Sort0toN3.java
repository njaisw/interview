package _7a_com.interview.sort_done;

/**
 * http://www.geeksforgeeks.org/sort-n-numbers-range-0-n2-1-linear-time/
 Given an array of numbers of size n. It is also given that the array elements are in range from 0 to n2 � 1. Sort the given array in linear time.

Examples:
Since there are 5 elements, the elements can be from 0 to 24.
Input: arr[] = {0, 23, 14, 12, 9}
Output: arr[] = {0, 9, 12, 14, 23}

 */
public class X_Sort0toN3 {

    public void sort(int arr[],int n){
        
        sort(arr,n,1);
        sort(arr,n,n);
        sort(arr,n,n*n);
    }
    
    private void sort(int arr[],int n, int exp){
        int count[] = new int[n];
        for(int i=0; i < arr.length;i++){
            count[(arr[i]/exp)%n]++;
        }
        
        for(int i=1; i < arr.length; i++){
            count[i] += count[i-1];
        }
    
        int output[] = new int[n];
        
        for(int i=arr.length-1;i>=0; i--){
            output[count[(arr[i]/exp)%n]-1] = arr[i];
            count[(arr[i]/exp)%n]--;
        }
        for(int i=0; i < arr.length; i++){
            arr[i] = output[i];
        }
    }
    
    public static void main(String args[]){
        int arr[] = {100,2,124,18,36};
        X_Sort0toN3 sn = new X_Sort0toN3();
        sn.sort(arr,arr.length);
        for(int i=0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
    
}
