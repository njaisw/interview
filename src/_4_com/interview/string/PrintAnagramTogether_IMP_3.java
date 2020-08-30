package _4_com.interview.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class PrintAnagramTogether_IMP_3 {

    public void print(String[] string){
        Map<String,List<Integer>> invertedIndex = new HashMap<String,List<Integer>>();
        int index = 0;
        for(String str : string){
            //TODO char storting
            char [] charArray = str.toCharArray();
            Arrays.sort(charArray);
            //TODO String from sorted char
            String newString = new String(charArray);
            if(invertedIndex.containsKey(newString)){
                List<Integer> pos = invertedIndex.get(newString);
                pos.add(index);
            }else{
                List<Integer> pos = new ArrayList<Integer>();
                pos.add(index);
                invertedIndex.put(newString, pos);
            }
            index++;
        }
        //TODO iterate with list values
        for(List<Integer> result  : invertedIndex.values()){
            for(Integer i : result){
                System.out.println(string[i]);
            }
        }
    }
    
    public static void main(String args[]){
        String str[] = {"cat","dog","tac","god","act"};
        PrintAnagramTogether_IMP_3 pat = new PrintAnagramTogether_IMP_3();
        pat.print(str);
    }
    
}
