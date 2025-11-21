class Solution {
    /*
     * 프로그래머스. 짝수와 홀수
     * -----------------------
     * 
     * [문제 설명]
     * 짝수/홀수 판별
     * 
     * [입력]
     * int num
     * 
     * [출력]
     * 짝수: "Even"
     * 홀수: "Odd"
     * 
     * [제한사항]
     * 0은 짝수
     */
    public String solution(int n) {
        return n % 2 == 0 ? "Even" : "Odd";
    }
}