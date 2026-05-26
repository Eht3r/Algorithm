import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        Integer[] boxed = Arrays.stream(score)
                .boxed()
                .toArray(Integer[]::new);
        
        Arrays.sort(boxed, Collections.reverseOrder());
        
        for (int i = m - 1; i < boxed.length; i+=m) {
            answer += boxed[i] * m;
        }
        
        return answer;
    }
}