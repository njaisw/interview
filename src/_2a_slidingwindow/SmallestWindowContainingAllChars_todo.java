package _2a_slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class SmallestWindowContainingAllChars_todo {

	private String smallestWindowContainingAllChars(char[] inputs, char[] pat) {

		int minLength = Integer.MAX_VALUE;

		Map<Character, Integer> countMap = new HashMap<Character, Integer>();

		for (char input : pat) {
			countMap.compute(input, (key, val) -> {
				if (val == null) {
					return 1;
				} else {
					val = val + 1;
					return val;
				}
			});
		}

		countMap.entrySet().stream().forEach(System.out::println);

		int start = 0;

        int currlength=0;
		int i=0;

		for (  ;i < inputs.length; i++) {
			
			if (currlength==pat.length && minLength> i-start+1) {
				minLength=i-start-1;
			}
			if (currlength < pat.length) {
				if (countMap.containsKey(inputs[i])) {
					int count = countMap.get(inputs[i]);
					if (count > 0) {
						currlength++;
					}
					countMap.put(inputs[i], count - 1);
				}
			} else {
				while (start<i) {
					if(countMap.containsKey(inputs[start])) {
						int count = countMap.get(inputs[start]);
						     if (count < 0) {
							countMap.put(inputs[start], count + 1);
						}else{
								break;
						     }
					}
					start++;
					minLength= Math.min(minLength,i-start-1);
				}
			}
		}

		return new String(inputs,start,minLength+1);
	}

	public static void main(String[] args) {

		String str = "Tsuaosyogrlmnsluuorjkoruost";
		String subString = "soor";

		SmallestWindowContainingAllChars_todo smallestWindowContainingAllChars_todo = new SmallestWindowContainingAllChars_todo();
		String res = smallestWindowContainingAllChars_todo.smallestWindowContainingAllChars(str.toCharArray(),subString.toCharArray());

		System.out.println(res);

	}

}
