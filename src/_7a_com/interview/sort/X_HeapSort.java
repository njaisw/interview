package _7a_com.interview.sort;

import java.util.Arrays;

/**
 * Date 04/03/2015
 * @author tusroy
 * 
 * Heap Sort
 * Given an array sort it using heap sort
 * 
 * Solution :
 * First convert the original array to create the heap out of the array
 * Then move the max element to last position and do heapify to recreate the heap
 * with rest of the array element. Repeat this process
 * 
 * Time complexity
 * O(nlogn)
 * 
 * Test cases
 * Null array
 * 1 element array
 * 2 element array
 * sorted array
 * reverse sorted array
 */
public class X_HeapSort {
    //-8
   //-6
   //-1
   //2
   //5
   //5
   //8
   //11
    public void sort(int arr[]){

        for(int i=1; i < arr.length; i++){
            heapAdd(arr, i);
        }

        Arrays.stream(arr).forEach(System.out::println);

        System.out.println();


        for(int i = arr.length-1; i > 0 ; i--){
            swap(arr, 0, i);
            //Check heafify
            heapify(arr, i-1);
        }
    }
    
    private void heapify(int arr[], int end){
        int i = 0;
        int leftIndex;
        int rightIndex;

        while(i <= end){
            leftIndex = 2*i + 1;
            if(leftIndex > end){
                break;
            }
            rightIndex = 2*i + 2;


            if(rightIndex > end){
                rightIndex = leftIndex;
            }
            if(arr[i]  >= Math.max(arr[leftIndex], arr[rightIndex])){
                break;
            }
            if(arr[leftIndex] >= arr[rightIndex]){
                swap(arr, i, leftIndex);
                i = leftIndex;
            }else{
                swap(arr, i, rightIndex);
                i = rightIndex;
            }
        }
    }
    
    private void swap(int arr[], int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
    
    private void heapAdd(int arr[], int end){
        int i = end;
        while(i > 0){
            if(arr[i] > arr[(i-1)/2]){
                swap(arr, i, (i-1)/2);
                i = (i - 1)/2;
            }else{
                break;
            }
        }
    }
    
    public static void main(String args[]){
        X_HeapSort hs = new X_HeapSort();
        int arr[] = {-1,5,8,2,-6,-8,11,5};
        hs.sort(arr);
        for(int a : arr){
            System.out.println(a);
        }
    }
}
