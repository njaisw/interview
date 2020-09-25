package _12_namrata.self.practice_done;

/*
 * Method 1 (By making elements negative)
The idea is to traverse the given array, use elements as index and store their counts at the index. For example, when we see element 7, we go to index 6 and store the count. There are few problems to handle, one is the counts can get mixed with the elements, this is handled by storing the counts as negative. Other problem is loosing the element which is replaced by count, this is handled by first storing the element to be replaced at current index.

Algorithm:
1) Initialize i as 0
2) Do following while i < n

   // If this element is already processed,
   // then nothing to do
   a) If arr[i]  0)
         (i) arr[i] = arr[elementIndex];

         // After storing arr[elementIndex], change it
         // to store initial count of 'arr[i]'
         (ii) arr[elementIndex] = -1;

     d) else       
            // If this is NOT first occurrence of arr[i],
            // then increment its count.
          (i) arr[elementIndex]--;

            // And initialize arr[i] as 0 means the element
            // 'i+1' is not seen so far
          (ii) arr[i] = 0;
          (iii) i++;

3) Now -arr[i] stores count of i+1. 
 */

public class CountFrequencyUsingNegation_IMP_2 
{ 
	// Function to find counts of all elements present in 
	// arr[0..n-1]. The array elements must be range from 
	// 1 to n 
	void findCounts(int arr[], int n) 
	{ 
		// Traverse all array elements 
		int i = 0; 
		while (i < n) 
		{ 
			// If this element is already processed, 
			// then nothing to do 
			if (arr[i] <= 0) 
			{ 
				i++; 
				continue; 
			} 

			// Find index corresponding to this element 
			// For example, index for 5 is 4 
			int elementIndex = arr[i] - 1; 

			// If the elementIndex has an element that is not 
			// processed yet, then first store that element 
			// to arr[i] so that we don't loose anything. 
			if (arr[elementIndex] > 0) 
			{ 
				arr[i] = arr[elementIndex]; 

				// After storing arr[elementIndex], change it 
				// to store initial count of 'arr[i]' 
				arr[elementIndex] = -1; 
			} 
			else
			{ 
				// If this is NOT first occurrence of arr[i], 
				// then increment its count. 
				arr[elementIndex]--; 

				// And initialize arr[i] as 0 means the element 
				// 'i+1' is not seen so far 
				arr[i] = 0; 
				i++; 
			} 
		} 

		System.out.println("Below are counts of all elements"); 
		for (int j = 0; j < n; j++) 
			System.out.println(j+1 + "->" + Math.abs(arr[j])); 
	} 

	// Driver program to test above functions 
	public static void main(String[] args) 
	{ 
		CountFrequencyUsingNegation_IMP_2 count = new CountFrequencyUsingNegation_IMP_2(); 
		int arr[] = {2, 3, 3, 2, 5}; 
		count.findCounts(arr, arr.length); 

		int arr1[] = {1}; 
		count.findCounts(arr1, arr1.length); 

		int arr3[] = {4, 4, 4, 4}; 
		count.findCounts(arr3, arr3.length); 

		int arr2[] = {1, 3, 5, 7, 9, 1, 3, 5, 7, 9, 1}; 
		count.findCounts(arr2, arr2.length); 

		int arr4[] = {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}; 
		count.findCounts(arr4, arr4.length); 

		int arr5[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}; 
		count.findCounts(arr5, arr5.length); 

		int arr6[] = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1}; 
		count.findCounts(arr6, arr6.length); 
	} 
} 

//This code has been contributed by Mayank Jaiswal(mayank_24) 
