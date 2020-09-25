package _12_namrata.self.practice_done;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Element {
	int value;
	int count = 1;
	
	public Element(int val) {
		this.value=val;
	}
}

public class KLargestElement {

	private void findKMostFrequentElement(int[] input, int k) {

		Map<Integer, Element> map = new HashMap<>();

		PriorityQueue<Element> queue = new PriorityQueue<Element>(new Comparator<Element>() {

			@Override
			public int compare(Element o1, Element o2) {
				return o1.count < o2.count ? 1 : -1;
			}
		});

		for (int i = 0; i < input.length; i++) {
			if (!map.containsKey(input[i])) {
				Element element =new Element(input[i]);
				map.put(input[i], element);
				queue.add(element);
			}else {
			Element element=map.get(input[i]);
			element.count=element.count+1;
			}
		}
		
		for (int i=0; i <k;i++) {
			Element element= queue.poll();
			System.out.println(element.value+" and frequency"+ element.count);
		}
		
	}

	public static void main(String[] args) {
		KLargestElement kLargestElement = new KLargestElement();
		kLargestElement.findKMostFrequentElement(new int[] {9,9,9,9,7,7,7,7,3,4,4,4},2);

	}

}
