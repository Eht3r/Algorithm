import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        
        for (int num : topping) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        for (int num : topping) {
            set.add(num);
            map.put(num, map.getOrDefault(num, 0) - 1);
            if (map.get(num) == 0) {
                map.remove(num);
            }
            
            if (set.size() == map.size()) {
                answer++;
            }
        }
        
        return answer;
    }
}