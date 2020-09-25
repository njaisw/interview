package _12_namrata.self.practice_done;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.PriorityQueue;

//Find k most frequent element in the array

public class X_KMostFrequentItems {

    class Element {

        int value;
        volatile int count;

        public Element(int val) {
            this.value = val;
            this.count = 1;
        }
    }


    //TODO  Root of the minpriority queue should be
    private Optional<List<Element>> findmostfrequent(int[] input, int k) {
        List<Element> result = new ArrayList<Element>();

        if (input == null || input.length == 0 || k <= 0) {
            return Optional.empty();
        }

        PriorityQueue<Element> minPriorityQueue = new PriorityQueue<Element>(k, ((o1, o2) -> {
            return o1.count <= o2.count ? -1 : 1;
        }));

        HashMap<Integer, Element> map = new HashMap<Integer, Element>();

        for (int ele : input) {
            if (!map.containsKey(ele)) {
                Element element = new Element(ele);
                map.put(ele, element);
                if(minPriorityQueue.size()< k) {
                    minPriorityQueue.add(element);
                }
            } else {
                Element element1= map.get(ele);
                element1.count= element1.count+1;
                if (minPriorityQueue.peek().value!=ele && minPriorityQueue.peek().count< element1.count){
                    minPriorityQueue.poll();
                    minPriorityQueue.add(element1);
                }
            }
        }

        while (!minPriorityQueue.isEmpty()) {
            Element ele = minPriorityQueue.poll();
            System.out.println("value -> " + ele.value + " count->" + ele.count);
            result.add(ele);
        }

        return Optional.of(result);

    }

    public static void main(String[] args) {

        X_KMostFrequentItems kMostFrequentItems = new X_KMostFrequentItems();

        List<Element> resulElemets = kMostFrequentItems.findmostfrequent(new int[]{2, 2, 2, 3, 3, 3, 3, 3, 3, 1, 2, 2, 2, 2, 1, 1, 1, 1, 4, 4, 4, 4, 4, 4, 4, 4, 4}, 4).get();



    }

}
