package _12_namrata.self.practice_3;

import java.util.PriorityQueue;

//Find kth largest element in the array

public class FindkLargestElement {
	
	
	public int findKthLargest(int[] nums, int k) {
		
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
		
		for (int i=0; i<k; i++) {
			priorityQueue.add(nums[i]);
		}
		int j=k;
        
		while (j< nums.length ) {
			if(nums[j] > priorityQueue.peek()) {
			 priorityQueue.poll();
			 priorityQueue.offer(nums[j]);
			}
            j++;
		}
		
		return priorityQueue.poll();
	    }
	
	
	public static void main(String[] args) {
		FindkLargestElement heap = new FindkLargestElement();
		System.out.println(heap.findKthLargest(new int[]{3,2,1,5,6,4}, 2));
		
	}

}
