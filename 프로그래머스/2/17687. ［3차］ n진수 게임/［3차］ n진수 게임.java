class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        StringBuilder fullString = new StringBuilder();
        
        int num = 0;
        while (fullString.length() < t * m) {
            fullString.append(Integer.toString(num++, n));
        }
        
        String str = fullString.toString().toUpperCase();
        
        for (int i = 0; i < t; i++) {
            answer.append(str.charAt((p - 1) + (i * m)));
        }
        
        return answer.toString();
    }
}