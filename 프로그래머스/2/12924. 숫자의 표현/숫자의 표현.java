class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for (int i = 1; i * (i + 1) <= 2 * n ; i++) {
            if ((2 * n) % i != 0) continue;
            
            int t = (2 * n) / i - (i - 1);
            if ((t & 1) != 0) continue;
            
            int a = t / 2;
            if (a >= 1) answer++;
        }
        
        return answer;
    }
}