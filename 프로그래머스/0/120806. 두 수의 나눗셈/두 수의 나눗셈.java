class Solution {
    public int solution(int num1, int num2) {
        return (int) ((double) num1 / num2 * 1000);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(3, 2));
        System.out.println(solution.solution(7, 3));
        System.out.println(solution.solution(1, 16));
    }
}