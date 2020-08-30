package _12_namrata.self.practice_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class StringCombination {
	
	private List<String> combination(char[] input) {
		
		Map<Character, Integer> map = new TreeMap<Character, Integer>();
		
		for (char ch: input) {
			map.compute(ch, (key, value) -> {
				if (value == null)
					return value=1;
				else
					return value=value+1;
				
			});	
		}
		
		char[] str = new char[input.length];
		int[] count = new int[input.length];
		char[] result = new char[input.length];
		
		int i=0;
		
		for(Map.Entry<Character, Integer> entry: map.entrySet()) {
			str[i] = entry.getKey();
			count[i] = entry.getValue();
			i++;
		}
		
		
		List<String> results= new ArrayList<String>();
		
		combinationUtils(str, count,result,results,0,0);
	    
	    return results;
		

	}

	private void  combinationUtils(char[] str, int[] count, char[] result,List<String> results, int level, int postion ) {
	
		results.add( new String(result, 0, postion));
		
		for (int i = postion; i < result.length; i++) {
			if(count[i]==0) {
				continue;
			}
			
			result[level]= str[i];
			count[i]--;
			combinationUtils(str, count, result, results, level+1, i);
			count[i]++;
		}
		

	}
	
	public static void main(String[] args) {
		
		StringCombination combination = new StringCombination();
		List<String> results= combination.combination("abc".toCharArray());
		
		results.stream().forEach(System.out::println);
		
	}

}
