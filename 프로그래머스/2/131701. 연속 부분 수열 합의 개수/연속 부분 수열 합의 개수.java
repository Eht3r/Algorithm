import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int n = elements.length;
        
        for(int i = 0; i < n; i++) {
            int currentSum = 0;
            
            for(int j = 0; j < n; j++) {
                currentSum += elements[(i + j) % n];
                set.add(currentSum);
            }
        }
        
        return set.size();
    }
}