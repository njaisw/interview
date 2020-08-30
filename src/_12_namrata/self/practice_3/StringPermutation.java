package _12_namrata.self.practice_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class StringPermutation {

	private List<String> permutation(char[] input) {
		
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
		
		permutationUtils(str, count,result,results,0);
	    
	    return results;
		

	}

	private void  permutationUtils(char[] str, int[] count, char[] result,List<String> results, int level ) {
		
		if (level == str.length)
			results.add( new String(result));
		
		for (int i = 0; i < result.length; i++) {
			if(count[i]==0) {
				continue;
			}
			
			result[level]= str[i];
			count[i]--;
			permutationUtils(str, count, result, results, level+1);
			count[i]++;
		}
		

	}

	public static void main(String[] args) {
		StringPermutation permutation = new StringPermutation();
		List<String> results= permutation.permutation("abc".toCharArray());
		
		results.stream().forEach(x-> System.out.println(x));

	}

}
