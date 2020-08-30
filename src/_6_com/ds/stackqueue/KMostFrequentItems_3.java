package _6_com.ds.stackqueue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.PriorityQueue;

public class KMostFrequentItems_3 {

	class Elemet {

		int value;
		int count;

		public Elemet(int val) {
			this.value = val;
		}
	}

	class FrequencyComparator implements Comparator<Elemet> {

		@Override
		public int compare(Elemet o1, Elemet o2) {
			if (o1.count == o2.count)
				return o1.value - o2.value;
			return o1.count > o2.count ? -1 : 1;

		}

	}

	// Root of the minpriority queue should be
	private Optional<List<Elemet>> findmostfrequent(int[] input, int k) {
		List<Elemet> result = new ArrayList<Elemet>();

		if (input == null || input.length == 0 || k <= 0) {
			return Optional.empty();
		}
        //TODO PQ size is k and has frequency Comparator
		PriorityQueue<Elemet> minPriorityQueue = new PriorityQueue<Elemet>(k,
				new FrequencyComparator());

		HashMap<Integer, Elemet> map = new HashMap<Integer, Elemet>();

		for (int ele : input) {
			Elemet element = map.compute(ele, (key, val) -> {
				if (val == null)
					val = new Elemet(key);
				val.count++;

				return val;

			});

			if(minPriorityQueue.size()<k) {
				minPriorityQueue.offer(element);
				//TODO if PQ size is more than k the compare the element count  at the top of the PQ
			}else if (minPriorityQueue.peek().count < element.count) {
				minPriorityQueue.poll();
				minPriorityQueue.offer(element);

			}

		}

		while (!minPriorityQueue.isEmpty()) {
             result.add(minPriorityQueue.poll());
		}

		return Optional.of(result);

	}

	public static void main(String[] args) {
		
		KMostFrequentItems_3 kMostFrequentItems = new KMostFrequentItems_3();
		
		List<Elemet> resulElemets= kMostFrequentItems.findmostfrequent(new int[] {2,2,2,3,3,3,3,3,3,1,2,2,2,2,1,1,1,1,4,4,4,4,4,4,4,4,4}, 2).get();
		
		resulElemets.stream().forEach(x-> System.out.println("value -> "+x.value+ " count->"+x.count));

	}

}
