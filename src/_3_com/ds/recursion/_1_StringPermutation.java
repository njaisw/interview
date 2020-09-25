package _3_com.ds.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Date 01/29/2016
 * @author Tushar Roy
 *
 * Generate all permutations of string in lexicographically sorted order where repetitions of
 * character is possible in string.
 */

//TODO go from the left to right and look for first avaiable character on the right side of this character.
//TODO A character is available if its count is greater tha zero

public class _1_StringPermutation {

    public List<String> permute(char input[]) {
        Map<Character, Integer> countMap = new TreeMap<>();
        for (char ch : input) {
            countMap.compute(ch, (key, val) -> {
                if (val == null) {
                    return 1;
                } else {
                    return val + 1;
                }
            });
        }
        char str[] = new char[countMap.size()];
        int count[] = new int[countMap.size()];
        int index = 0;
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            str[index] = entry.getKey();
            count[index] = entry.getValue();
            index++;
        }
        List<String> resultList = new ArrayList<>();
        char result[] = new char[input.length];
        permuteUtil(str, count, result, 0, resultList);
        return resultList;
    }

    public void permuteUtil(char str[], int count[], char result[], int level, List<String> resultList) {
        //TODO 1: prints value if only length is equal to the level
        if (level == result.length) {
            resultList.add(new String(result));
            return;
        }
        // TODO 2: i always starts from 0 to first available character from the left
        for(int i = 0; i < str.length; i++) {
            if(count[i] == 0) {
                continue;
            }
            //TODO otherwise level me put karo
            result[level] = str[i];
            //TODO 3: count is decremented
            count[i]--;
            permuteUtil(str, count, result, level + 1, resultList);
            //TODO count is put back
            count[i]++;
        }
    }

    private void printArray(char input[]) {
        for(char ch : input) {
            System.out.print(ch);
        }
        System.out.println();
    }

    public static void main(String args[]) {
        _1_StringPermutation sp = new _1_StringPermutation();
        sp.permute("AABC".toCharArray()).forEach(s -> System.out.println(s));
    }
}
