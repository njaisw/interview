package _3_com.ds.recursion;

import java.util.*;

public class _X2a_Combination {

   public void combination(char input[]){
       Map<Character, Integer> countMap = new TreeMap<>();
       for (char ch : input) {
           //TODO check the map compute logic here
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
       char[] output = new char[input.length];
       combination(str, count, 0, output, 0);
    }

    //TODO 1: position is extra here
    private void combination(char input[],int count[],int pos, char output[],int len){
       //TODO 2: Always print the content from 0 till len
        print(output, len);
        // TODO 3: i start from last travereses position to the input length
        for(int i=pos; i < input.length; i++){
            if (count[i] == 0) {
                continue;
            }
            output[len] = input[i];
            count[i]--;
            //TODO start i
            combination(input, count, i, output, len + 1);
            count[i]++;
        }
    }

    private void print(char result[],int pos){

        for(int i=0; i < pos; i++){
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }

    @Deprecated
    public void combinationEasy(char[] input) {
        List<Character> r = new ArrayList<>();
        Arrays.sort(input);
        combinationEasy(input, 0, r);
    }

    @Deprecated
    private void combinationEasy(char[] input, int pos, List<Character> r) {

        r.forEach(r1 -> System.out.print(r1 + " "));
        System.out.println();
        for (int i = pos; i < input.length; i++) {
            if (i != pos && input[i] == input[i-1]) {
                continue;
            }
            r.add(input[i]);
            combinationEasy(input, i + 1, r);
            r.remove(r.size() - 1);
        }
    }

    public static void main(String args[]){
        _X2a_Combination c = new _X2a_Combination();
        c.combination("abc".toCharArray());
        //c.combinationEasy("aabbc".toCharArray());

    }
    
}
