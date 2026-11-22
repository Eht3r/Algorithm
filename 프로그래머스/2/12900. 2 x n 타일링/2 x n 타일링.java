class Solution {
    public int solution(int n) {
        int mod = 1_000_000_007;
        
        if (n == 1) {
            return 1;
        }
        
        int prev2 = 1;
        int prev1 = 2;
        
        for (int i = 3; i <= n; i++) {
            int current = (prev1 + prev2) % mod;
            prev2 = prev1;
            prev1 = current;
        }
        
        return prev1;
    }
}