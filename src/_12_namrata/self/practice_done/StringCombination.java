package _12_namrata.self.practice_done;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class StringCombination {

    //TODO At every level of the recursion, it fills the level index from the input array to output array,
    // Difference from permutation, permutation starts from it left most charater looking for the first available charater
    // whereas here we start from looking where we left last in the recursion
    private List<String> combination(char[] input) {

        Map<Character, Integer> map = new TreeMap<Character, Integer>();

        for (char ch : input) {
            map.compute(ch, (key, value) -> {
                if (value == null)
                    return value = 1;
                else
                    return value = value + 1;

            });
        }

        char[] str = new char[map.size()];
        int[] count = new int[map.size()];
        char[] result = new char[input.length];

        int i = 0;

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            str[i] = entry.getKey();
            count[i] = entry.getValue();
            i++;
        }


        List<String> results = new ArrayList<String>();

        combinationUtils(str, count, result, results, 0, 0);

        return results;


    }

    private void combinationUtils(char[] str, int[] count, char[] result, List<String> results, int level, int position) {

        for (int i = position; i < result.length; i++) {
            if (count[i] == 0) {
                continue;
            }
            result[level] = str[i];
            results.add(new String(result, 0, level+1));
            count[i]--;
            combinationUtils(str, count, result, results, level + 1, i);
            //TODO remember count++
            count[i]++;
        }


    }

    public static void main(String[] args) {

        StringCombination combination = new StringCombination();
        List<String> results = combination.combination("abc".toCharArray());

        results.stream().forEach(System.out::println);

    }

}
