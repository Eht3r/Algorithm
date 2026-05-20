import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        
        List<Character> charList = new ArrayList<>();

        for (char c : skip.toCharArray()) {
            charList.add(c);
        }
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            int count = 0;
            while (count < index) {
                ch++;
                
                if (ch > 'z') {
                    ch = 'a';
                }
                
                if (!charList.contains(ch)) {
                    count++;
                }
            }
            
            answer.append(ch);
        }
        
        return answer.toString();
    }
}