import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {      
         Set<Character> skipSet = new HashSet<>();

        for (char c : skip.toCharArray()) {
            skipSet.add(c);
        }
        
        StringBuilder answer = new StringBuilder();
        
        for (char ch : s.toCharArray()) {
            int count = 0;
            
            while (count < index) {
                ch = ch == 'z' ? 'a' : (char) (ch + 1);
                
                if (!skipSet.contains(ch)) {
                    count++;
                }
            }
            
            answer.append(ch);
        }
        
        return answer.toString();
    }
}