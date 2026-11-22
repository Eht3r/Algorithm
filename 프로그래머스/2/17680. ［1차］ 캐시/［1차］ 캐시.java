import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) return cities.length * 5;
        
        int answer = 0;
        
        Deque<String> cache = new ArrayDeque<>();
        for (String city: cities) {
            String cityLower = city.toLowerCase();
            
            if (cache.remove(cityLower)) { 
                cache.addLast(cityLower);
                answer += 1;
            } else {
                if (cache.size() >= cacheSize) {
                    cache.removeFirst(); 
                }
                cache.addLast(cityLower); 
                answer += 5;
            }
        }
        
        return answer;
    }
}