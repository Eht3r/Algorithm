class Solution {
    public int solution(int n) {
        
        int mod = 1234567;
        
        int prev = 0; // F(0)
        int curr = 1; // F(1)
        
        for (int i = 2; i <= n; i++) {
            int next = (prev + curr) % mod;
            prev = curr;
            curr = next;
        }
        
        return curr;
        
          // n이 커질 경우 시간초과 가능성 있음 
         // return fibonacci(n) % 1234567;
    }
    
    public int fibonacci(int n) {
        if (n == 0) return 0;
        else if (n == 1) return 1;
        
        return fibonacci(n -1) + fibonacci(n - 2);
    }
}