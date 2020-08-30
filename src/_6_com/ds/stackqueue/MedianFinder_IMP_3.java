package _6_com.ds.stackqueue;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Date 03/03/2016
 * 
 * @author Tushar Roy
 *
 *         Find median in stream of numbers
 * 
 *         https://leetcode.com/problems/find-median-from-data-stream/
 */
public class MedianFinder_IMP_3 {

	PriorityQueue<Integer> minPq = new PriorityQueue<>();
	PriorityQueue<Integer> maxPq = new PriorityQueue<>();
     //TODO size of max priority queue is greater than the min priority queue by 1
	 //TODO root of max priority queue is always less than min prio
	public MedianFinder_IMP_3() {
		minPq = new PriorityQueue<>();
		// TODO Remember the logic collections reverseorder
		maxPq = new PriorityQueue<>(20, Collections.reverseOrder());
	}

	// Adds a number into the data structure.
	public void addNum(int num) {
		if (maxPq.size() == 0) {
			maxPq.add(num);
			return;
		}
		// TODO check the two conditions here
		if (maxPq.size() == minPq.size()) {
			if (minPq.peek() < num) {
				maxPq.offer(minPq.poll());
				minPq.offer(num);
			} else {
				maxPq.offer(num);
			}
		} else {
			int toBeOffered = 0;
			if (num >= maxPq.peek()) {
				toBeOffered = num;
			} else {
				toBeOffered = maxPq.poll();
				maxPq.offer(num);
			}
			minPq.offer(toBeOffered);
		}
	}

	// Returns the median of current data stream
	public double findMedian() {
		if (minPq.size() == maxPq.size()) {
			return ((double) minPq.peek() + (double) maxPq.peek()) / 2;
		} else {
			return maxPq.peek();
		}
	}

	public static void main(String args[]) {
		MedianFinder_IMP_3 mf = new MedianFinder_IMP_3();
		mf.addNum(4);
		System.out.println(mf.findMedian());
		mf.addNum(8);
		System.out.println(mf.findMedian());
		mf.addNum(2);
		System.out.println(mf.findMedian());
		mf.addNum(11);
		System.out.println(mf.findMedian());
		mf.addNum(13);
		System.out.println(mf.findMedian());
		mf.addNum(14);
		System.out.println(mf.findMedian());
		mf.addNum(-1);
		System.out.println(mf.findMedian());

	}
}
