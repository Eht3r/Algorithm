class Solution {
    public int solution(int age) {
        return 2022 - age + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(40));
        System.out.println(solution.solution(23));
    }
}
