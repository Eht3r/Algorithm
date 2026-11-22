import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Set<String> set = new HashSet<>();
        set.add(words[0]);
        
        
        for(int i = 1; i < words.length; i++) {
            String s1 = words[i - 1];
            String s2 = words[i];
            
            char last = s1.charAt(s1.length() - 1);
            char first = s2.charAt(0);
            
            if (set.contains(s2) || last != first) {
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                
                return answer;
            }
            
            set.add(s2);
        }

        return answer;
    }
}