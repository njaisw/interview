package _10_com.interview.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 150s qs 18.10
 * Given two words of equal length in dictionary convert one word to another one letter at a time
 * in such a way that all intermediate words are int the dictionary
 */
public class _30_ConvertOneWordToAnother {

    public void convert(String word1, String word2, Set<String> dict) {
        //TODO Uses graph BFS approach
        //TODO 1: create a visited set, queue and parent Map/result list
        Set<String> visited = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        Map<String, String> parentMap = new HashMap<String, String>();
        //TODO 2: Insert the first word in the queue and visited set
        queue.add(word1);
        visited.add(word1);
         //TODO 3:Iterate while queue is not empty

        /**
         *  dictionary.add("cat");
         *  dictionary.add("did");
         *  dictionary.add("pat");
         *  dictionary.add("pit");
         *  dictionary.add("pid");
         */
        while (queue.size() != 0) {
            //TODO 4: poll queue and seach the dictionary
            String word = queue.poll();
            if (word.equals(word2)) {
                break;
            }
            for (int i = 0; i < word.length(); i++) {
                for (int ch = 'a'; ch <= 'z'; ch++) {
                    String newWord = replace(word, i, (char) ch);
                    //TODO 5: dictionary matches any word after replacing a character and is not already visited
                    if (dict.contains(newWord)){
                        // TODO 6: put the new word in result set and add it to the queue and visited set
                        if (!visited.contains(newWord)) {
                            parentMap.put(newWord, word);
                            queue.add(newWord);
                            visited.add(newWord);
                        }
                    }
                }
            }
        }
        String word = word2;
        while(word != null){
            System.out.println(word);
            word = parentMap.get(word);
        }

    }

    public String replace(String newWord, int pos, char ch) {
        StringBuffer buffer = new StringBuffer();
        buffer.append(newWord.substring(0, pos));
        buffer.append(ch);
        buffer.append(newWord.substring(pos+1,newWord.length()));
        return buffer.toString();
    }

    
    public static void main(String args[]){
        Set<String> dictionary = new HashSet<String>();
        dictionary.add("cat");
        dictionary.add("did");
        dictionary.add("pat");
        dictionary.add("pit");
        dictionary.add("pid");

        _30_ConvertOneWordToAnother cow = new _30_ConvertOneWordToAnother();
        cow.convert("cat", "did", dictionary);
    }
}
