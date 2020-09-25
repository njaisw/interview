package _12_namrata.self.practice_done;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLinkedList {

	class Triplet implements Comparable<Triplet> {

		int index;
		int listIndex;

		int value;

		public Triplet(int index, int listIndex, int value) {
			this.index = index;
			this.listIndex = listIndex;
			this.value = value;
		}

		@Override
		public int compareTo(Triplet o) {
			return this.value - o.value;
		}

	}

	private List<Integer> mergeksortedlikedlist(List<List<Integer>> lists) {

		List<Integer> result = new LinkedList<Integer>();

		PriorityQueue<Triplet> queue = new PriorityQueue<Triplet>();

		int i = 0;
		for (List<Integer> list : lists) {
			queue.add(new Triplet(0, i++, list.get(0)));
		}

		//TODO
		while (!queue.isEmpty()) {
			Triplet node = queue.poll();

			result.add(node.value);

			if (node.index != lists.get(node.listIndex).size() - 1) {
				node.index++;
				node.value = lists.get(node.listIndex).get(node.index);
				queue.add(node);

			}

		}

		return result;
	}

	public static void main(String[] args) {
		
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(1);
		list1.add(4);
		list1.add(17);
		list1.add(19);
		list1.add(21);
		
		
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(2);
		list2.add(3);
		list2.add(13);
		list2.add(15);
		list2.add(23);
		
		
		
		List<List<Integer>> input = new ArrayList<List<Integer>>();
		input.add(list1);
		input.add(list2);
		
		MergeKSortedLinkedList mergeKSortedLinkedList = new MergeKSortedLinkedList();
		List<Integer> result= mergeKSortedLinkedList.mergeksortedlikedlist(input);
		
		result.stream().forEach(System.out::println);

	}

}
