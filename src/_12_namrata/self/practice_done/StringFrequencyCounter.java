package _12_namrata.self.practice_done;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;



public class StringFrequencyCounter {

	class FrequencyComparator implements Comparator<Entry<String, Integer>>{

		Map<String, Integer> entry;

		public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {

			return o1.getValue()>o2.getValue()?-1:1;


		}
	}
	
	private void  sortByFrequency(List<String> input) {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		for (Iterator iterator = input.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			if (map.containsKey(string)) {
				int count = map.get(string);
				map.put(string, count+1);
			}else {
				map.put(string,1);
			}
		}
		
	     Set<Entry<String,Integer>> set= map.entrySet();

		//TODO sorting based on entryset
	     List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(set);
	    
	    Collections.sort(list, new FrequencyComparator());
	    
	    list.forEach(x-> System.out.println(x));

	}
	
	
	public static void main(String[] args) {
		
		StringFrequencyCounter stringFrequencyCounter = new StringFrequencyCounter();
		
		List<String> inputs= new ArrayList<String>();
		inputs.add("cat");
		inputs.add("cat");
		
		inputs.add("cat");
		inputs.add("cat");
		inputs.add("cat");
		inputs.add("dog");
		inputs.add("cat");
		inputs.add("dog");
		
		
	   stringFrequencyCounter.sortByFrequency(inputs);
		
		
		
		
		
	}

}
