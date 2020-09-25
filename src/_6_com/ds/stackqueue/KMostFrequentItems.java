package _6_com.ds.stackqueue;

import java.util.*;

public class KMostFrequentItems {


    public int[] topKFrequent(int[] nums, int k) {
        // O(1) time
        if (k == nums.length) {
            return nums;
        }

        // 1. build hash map : character and how often it appears
        // O(N) time
        Map<Integer, Integer> count = new HashMap();
        for (int n: nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        // init heap 'the less frequent element first'
        //TODO how cout map used in comparator without reference??????????
        Queue<Integer> heap = new PriorityQueue<>((n1, n2) -> count.get(n1) - count.get(n2));

        // 2. keep k top frequent elements in the heap
        // O(N log k) < O(N log N) time
        for (int n: count.keySet()) {
            heap.add(n);
            //TODO compares heap size
            if (heap.size() > k) heap.poll();
        }

        // 3. build an output array
        // O(k log k) time
        int[] top = new int[k];
        for(int i = k - 1; i >= 0; --i) {
            top[i] = heap.poll();
        }
        return top;
    }


    public static void main(String[] args) {
        KMostFrequentItems kLargestElement = new KMostFrequentItems();
        int [] result =kLargestElement.topKFrequent(new int[] {9,9,9,9,7,7,7,7,7,3,4,4,4,4,4,4,44,4,4,2,4,4,4,4,4},3);

        for ( int res: result) {
            System.out.println(res);
        }
        System.out.println();

    }

}
