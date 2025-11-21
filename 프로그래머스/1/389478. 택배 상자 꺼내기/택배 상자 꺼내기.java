class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        int numIndex = 0;

        for (int i = num; i <= n; i++) {
            int h = (i % w  == 0) ? i / w : i / w + 1;
            int index = (h % 2 == 1) ? ((i % w == 0) ? w : i % w) : ((i % w == 0) ? 1 : (w + 1) - i % w);

            if (i == num) {
                numIndex = index;
                answer++;
            } else if (index == numIndex) {
                answer++;
            }
        }

        return answer;
    }
}