import java.util.*;

public class Solution {
    /*
     * 프로그래머스. 자릿수 더하기
     * -----------------------
     * 
     * [문제 설명]
     * 자연수 N의 각 자릿수의 합을 구해서 return하는 solutoin 작성
     * 
     * [입력]
     * 자연수 N
     * 
     * [출력]
     * 자연수 N에 대한 각 자릿수의 합
     * 
     * [제한사항]
     * N은 100,000,000 이하의 자연수
     */
    public int solution(int n) {
        int answer = 0;

        while (n > 0) {
            answer += n % 10;
            n /= 10;
        }

        return answer;
    }
}