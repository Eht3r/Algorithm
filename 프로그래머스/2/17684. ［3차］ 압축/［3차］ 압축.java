import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> dictionary = new HashMap<>();
        
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            dictionary.put(String.valueOf(ch), ch - 'A' + 1);
        }
        
        int nextIndex = 27;
        List<Integer> answer = new ArrayList<>();
        
        int i = 0;
        while (i < msg.length()) {
            String w = String.valueOf(msg.charAt(i));
            int end = i + 1;
            
            while (end <= msg.length()) {
                String current = msg.substring(i, end);
                
                if (!dictionary.containsKey(current)) {
                    break;
                }
                
                w = current;
                end++;
            }
            
            answer.add(dictionary.get(w));
            
            if ( i + w.length() < msg.length()) {
                String newWord = msg.substring(i, i + w.length() + 1);
                dictionary.put(newWord, nextIndex++);
            }
            
            i += w.length();
        }
        
        return answer.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}