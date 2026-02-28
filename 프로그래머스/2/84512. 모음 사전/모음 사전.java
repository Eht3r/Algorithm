class Solution {
    public int solution(String word) {
        int answer = 0;
        
        int[] multiplier = {781, 156, 31, 6, 1};
        char[] chars = {'A', 'E', 'I', 'O', 'U'};
        
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
        
            for (int j = 0; j < chars.length; j++) {
                if (ch == chars[j]) {
                    answer += j * multiplier[i] + 1;
                }
            }
            
        }
        return answer;
    }
}