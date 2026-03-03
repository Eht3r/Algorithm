import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> map = new HashMap<>();
        for (String par : participant) {
            map.put(par, map.getOrDefault(par, 0) + 1);
        }
        
        for (String comp: completion) {
            map.put(comp, map.getOrDefault(comp, 1) - 1);
        }
        
        for (String key : map.keySet()) {
            if (1 == map.get(key)) {
                answer = key;
            }
        }
        
        
        return answer;
    }
}