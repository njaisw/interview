package _12_namrata.self.practice_done;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class Element1 {
    int index = -1;
    int value = -1;
    int count = 0;

    public Element1(int val, int ind) {
        this.value = val;
        this.index = ind;
        this.count = 1;
    }

}

class FrequencyComparator implements Comparator<Integer> {

    Map<Integer, Element1> map = null;

    public FrequencyComparator(Map<Integer, Element1> map) {
        this.map = map;
    }

    @Override
    public int compare(Integer o1, Integer o2) {

        Element1 ele1 = map.get(o1);
        Element1 ele2 = map.get(o2);
        if (ele1.count == ele2.count)
            return ele1.index < ele2.index ? -1 : 1;
        return ele1.count < ele2.count ? 1 : -1;
    }


}

public class SortArrayBasedFrequency {

    private void sortWithFrequency(Integer[] inputs) {

        HashMap<Integer, Element1> map = new HashMap<Integer, Element1>();

        for (int i = 0; i < inputs.length; i++) {
            if (!map.containsKey(inputs[i])) {
                Element1 element = new Element1(inputs[i], i);
                map.put(inputs[i], element);

            } else {
                map.get(inputs[i]).count++;
            }
        }
        Arrays.sort(inputs, new FrequencyComparator(map));

        Arrays.stream(inputs).forEach(x -> System.out.println(x));

    }

    public static void main(String[] args) {
        SortArrayBasedFrequency sortArrayBasedFrequency = new SortArrayBasedFrequency();
        sortArrayBasedFrequency.sortWithFrequency(new Integer[]{2, 3, 4, 4, 4, 4, 4, 3});

    }

}
