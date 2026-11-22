import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int sum = 0;
        int answer = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < tangerine.length; i++) {
            int num = tangerine[i];
            
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        List<Integer> valueList = new ArrayList<>(map.values());
        Collections.sort(valueList, Collections.reverseOrder());
        
        for(int v: valueList) {
            if(sum + v >= k) {
                answer++;
                break;
            } else {
                sum += v;
                answer++;
            }
        }
        
        
        return answer;
    }
}