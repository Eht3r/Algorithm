class Solution {
    public int solution(String s) {
        int answer = 0;

        char first = s.charAt(0);
        int matchCount = 0;
        int noMatchCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if (matchCount == 0 && noMatchCount == 0) {
                first = s.charAt(i);
            }

            if (s.charAt(i) == first) {
                matchCount++;
            } else {
                noMatchCount++;
            }

            if (matchCount == noMatchCount) {
                answer++;
                matchCount = 0;
                noMatchCount = 0;
            }
        }

        if (matchCount != 0 || noMatchCount != 0) {
            answer++;
        }
        
        return answer;
    }
}