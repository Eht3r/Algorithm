class Solution {
    public int solution(int n) {
        boolean[] isNotPrime = new boolean[n + 1];

        isNotPrime[0] = true;
        isNotPrime[1] = true;
        
        for (int i = 2; i * i <= n; i++) {
            if (isNotPrime[i]) {
                continue;
            }
            
            for (int j = i * i; j <= n; j += i) {
                isNotPrime[j] = true;
            }
        }
        
        int count = 0;
        
        for (int i = 2; i <= n; i++) {
            if (!isNotPrime[i]) {
                count++;
            }
        }
        
        return count;
    }
}