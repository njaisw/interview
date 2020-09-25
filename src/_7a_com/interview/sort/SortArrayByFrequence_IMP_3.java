package _7a_com.interview.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * http://www.geeksforgeeks.org/sort-elements-by-frequency/
 * Print the elements of an array in the decreasing frequency if 2 numbers have same frequency then print the one which came first.
 */
public class SortArrayByFrequence_IMP_3 {

    class SortNode{
        int count;
        int firstIndex;
    }

    //TODO it takes Interger as Comparator type
    class FrequenceComparator implements Comparator<Integer>{

        private Map<Integer,SortNode> countMap = null;
        FrequenceComparator(Map<Integer,SortNode> countMap){
            this.countMap = countMap;
        }
        @Override
        public int compare(Integer i1, Integer i2) {
            SortNode n1 = countMap.get(i1);
            SortNode n2 = countMap.get(i2);
           //TODO a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than thesecond
            if(n1.count > n2.count){
                return -1;
            }else if(n1.count < n2.count){
                return 1;
            }else{
                return n1.firstIndex < n2.firstIndex ? -1 : 1;
            }
        }
        
    }
    
    public void sortByFrequence(Integer arr[]){
        Map<Integer,SortNode> countMap = new HashMap<Integer,SortNode>();
        int index = 0;
        for(int a : arr){

            if(countMap.containsKey(a)){
                SortNode s = countMap.get(a);
                s.count++;
            }else{
                SortNode s = new SortNode();
                s.count = 1;
                s.firstIndex = index;
                countMap.put(a, s);
            }
            index++;
        }
        
        FrequenceComparator freqComparator = new FrequenceComparator(countMap);

        //TODO remember arrays sort which takes T[] and frequencyComparator
        Arrays.sort(arr,freqComparator);

    }
    
    public static void main(String args[]){
        Integer input[] = {5,2,8,9,9,9,2};
        SortArrayByFrequence_IMP_3 saf = new SortArrayByFrequence_IMP_3();
        saf.sortByFrequence(input);
        for(int i : input){
            System.out.println(i + " ");
        }
    }
    
}
