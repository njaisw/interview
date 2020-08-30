package _4_com.interview.string;

import java.util.*;

/**
 * https://leetcode.com/problems/group-anagrams/
 */
public class GroupAnagramsTogether_IMP_3 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0)
            return new ArrayList<List<String>>();
        
        int listIndex = 0;
        List<List<String>> result = new ArrayList<>();
        Map<String, Integer> anagramMap = new HashMap<>();
        
        for (String str : strs) {
            char[] chars = str.toCharArray();
            //TODO Arrays sorts chars
            Arrays.sort(chars);
            //TODO convert that char to string
            String sorted = new String(chars);
            if (anagramMap.containsKey(sorted)) {
                int index = anagramMap.get(sorted);
                List<String> listResult = result.get(index);    
                listResult.add(str);
            } else {
                List<String> resultList = new ArrayList<>();
                resultList.add(str);
                result.add(listIndex, resultList);
                anagramMap.put(sorted, listIndex);
                listIndex++;
            }
        }
        return result;
    }
}
