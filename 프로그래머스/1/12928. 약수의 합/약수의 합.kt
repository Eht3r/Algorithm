class Solution {
    fun solution(n: Int): Int {
        var answer = 0
        var i = 1
        
        while (i * i <= n) {
            if (n % i == 0) {
                answer += i
                
                if (i != n / i) answer += n / i
            }
            i++
        }
        
        return answer
    }
}