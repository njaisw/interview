package _12_namrata.self.practice_3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class SortMapBasedUponValues {

    public Entry<String, Integer>[] sortElementsBasedUponValues(Map<String, Integer> inputMap) {

        Entry<String, Integer>[] array = new Entry[inputMap.size()];
        int i = -1;
        for (Entry<String, Integer> entry : inputMap.entrySet()) {
            array[++i] = entry;
        }

        Arrays.sort(array, (o1, o2) -> {
                    return o1.getValue() < o2.getValue() ? -1 : 1;
                }
        );

        return array;

    }

    public static void main(String[] args) {

        SortMapBasedUponValues sortArrayBasedFrequency = new SortMapBasedUponValues();

        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("dog", 12);
        map.put("cat", 112);
        map.put("rat", 1);
        map.put("cocokroach", 2);

        Entry<String, Integer>[] result = sortArrayBasedFrequency.sortElementsBasedUponValues(map);

        Arrays.stream(result).forEach(System.out::println);

    }

}
