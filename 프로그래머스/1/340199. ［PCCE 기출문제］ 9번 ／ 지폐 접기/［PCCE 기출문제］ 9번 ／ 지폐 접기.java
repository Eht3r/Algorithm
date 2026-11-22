class Solution {
    /*
        Programmers. 지폐 접기
        ---------------------------

        [문제 설명]
        지폐 접는 규칙
        - 항상 길이가 긴 쪽을 반으로 접음
        - 접기 전 길이가 홀수였다면 접은 후 소수점 이하는 버림
        - 접힌 지폐를 그대로 또는 90도 돌려서 지갑에 넣을 수 있다면 그만 접음

        [입력]
        - wallet: 지갑의 가로, 세로 크기를 담은 정수 리스트
        - bill: 지폐의 가로, 세로 크기를 담은 정수 리스트

        [의사코드]
        1. 지폐를 접은 횟수를 저장할 정수 변수 answer를 만들고 0을 저장합니다.
        2. 반복문을 이용해 bill의 작은 값이 wallet의 작은 값 보다 크거나 bill의 큰 값이 wallet의 큰 값 보다 큰 동안 아래 과정을 반복합니다.
            2-1. bill[0]이 bill[1]보다 크다면 bill[0]을 2로 나누고 나머지는 버립니다.
            2-2. 그렇지 않다면 bill[1]을 2로 나누고 나머지는 버립니다.
            2-3. answer을 1 증가시킵니다.
        3. answer을 return합니다.

        [제한사항]
        - wallet의 길이 = bill의 길이 = 2
        - 10 <= wallet[0], wallet[1] <= 100
        - 10 <= bill[0], bill[1] <= 2,000
     */
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;

        while(Math.min(wallet[0], wallet[1]) < Math.min(bill[0], bill[1]) || Math.max(wallet[0], wallet[1]) < Math.max(bill[0], bill[1])) {
            if(bill[1] < bill[0]) {
                bill[0] /= 2;
            } else {
                bill[1] /= 2;
            }
            answer++;
        }

        return answer;
    }
}