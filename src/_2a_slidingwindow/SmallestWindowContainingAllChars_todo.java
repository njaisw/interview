package _2a_slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class SmallestWindowContainingAllChars_todo {

	private int smallestWindowContainingAllChars(char[] inputs, char[] pat) {

		int minLength = Integer.MIN_VALUE;

		Map<Character, Integer> countMap = new HashMap<Character, Integer>();

		for (char input : pat) {
			countMap.compute(input, (key, val) -> {
				if (key == null) {
					return 1;
				} else {
					val = val + 1;
					return val;
				}
			});
		}

		countMap.entrySet().stream().forEach(System.out::println);

		int start = 0;
		int currlength = 0;

		for (int i = 0; i < inputs.length; i++) {
			
			if (currlength==pat.length&& minLength> i-start+1) {
				minLength=i-start+1;
			}
			
			if (currlength < pat.length) {
				if (countMap.containsKey(inputs[i])) {
					int count = countMap.get(inputs[i]);
					if (count > 0) {
						currlength++;
						countMap.put(inputs[i], count - 1);
					}
				}
			} else {
				while (currlength==pat.length) {
					if(countMap.containsKey(start)) {
						//countMap.remove(key)
					}
				}
				
			}
		}

		return minLength;
	}

	public static void main(String[] args) {

	}

}
