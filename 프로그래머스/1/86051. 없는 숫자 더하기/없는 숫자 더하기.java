class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        
        for (int number : numbers) {
            answer += number;
        }
        
        return 45 - answer;
    }
}