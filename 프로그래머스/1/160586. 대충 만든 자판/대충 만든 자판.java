import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        int[] minCount = new int[26];
        Arrays.fill(minCount, Integer.MAX_VALUE);
        
        for(String str : keymap) {
            for (int i = 0; i < str.length(); i++){
                char ch = str.charAt(i);
                minCount[ch - 'A'] = Math.min(minCount[ch - 'A'], i + 1);
            }
        }
        
        for (int i = 0; i < targets.length; i++) {
            int count = 0;
            boolean possible = true;
            
            for (char ch : targets[i].toCharArray()) {
                int index = ch - 'A';
                
                if (minCount[index] == Integer.MAX_VALUE) {
                    possible = false;
                    break;
                }
                count += minCount[index];
            }
            
            answer[i] = possible ? count : -1;
        }
        
        
        return answer;
    }
}