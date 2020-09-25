package _7_com.ds.binarysearch;

public class SearchInInfiniteSortedArray {
	
	private int searchInInfiniteArray(int[] input, int data) {
		
		if (input[0]==data) {
			return 0;
		}
		
		if (input[1]==data) {
			return 1;
		}
		
		int low=1;
		int high=2;
		
		while (input[high]<=data) {
			if (input[high] == data) {
				return high;
			}
			low=high;
			
			high=high*high>=input.length? input.length-1: high*high;
		}
		
		return binarySearch(input, low, high, data);
		

	}
	
	private int binarySearch(int[] inputs, int low , int high, int data) {
		if (low<high) {
			int mid= (low+high)/2;
			if (inputs[mid]==data) {
				return mid;
			}else if (inputs[mid]> data) {
				return binarySearch(inputs, low, mid-1, data);
			}else {
				return binarySearch(inputs, mid+1,high, data);
			}
		}
		return -1;

	}
	
	
	
	public static void main(String[] args) {
		SearchInInfiniteSortedArray seraInfiniteSortedArray = new SearchInInfiniteSortedArray();
		int data=seraInfiniteSortedArray.searchInInfiniteArray(new int[] {2,3,4,5,6,7,8,9} , 4);
		
		System.out.println(data);
		
		
		
	}

}
