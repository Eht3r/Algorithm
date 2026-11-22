class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        long current = x;
        long step = x;
        
        for (int i = 0; i < n; i++) {
            answer[i] = current;
            
            current += step;
        }
        
        return answer;
    }
}