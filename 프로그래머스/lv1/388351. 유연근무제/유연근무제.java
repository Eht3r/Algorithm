class Solution {
    /*
        Programmers. 유연근무제
        ---------------------------

        [문제 설명]
        출근
        - 출근 희망 시각 + 10분 까지 정시 출근 인정
        - 주말 제외

        시각
        - 모든 시각은 시에 100을 곱하고 분을 더한 정수로 표현

        [입력]
        schedules: 직원 n명이 설정한 출근 희망 시각을 담은 1차원 정수 배열
        timelogs: 직원들이 일주일 동안 출근한 시각을 담은 2차원 정수 배열
        startday: 요일

        [출력]
        꺼래려는 상자를 포함해서 총 꺼내야하는 상자의 수

        [제한사항]
        1 ≤ schedules의 길이 = n ≤ 1,000
        - schedules[i]는 i+1번쨰 직원이 설정한 출근 희망 시각을 의미
        - 700 <= schedules[i] <= 1100
        1 <= timelogs의 길이 = n <= 1,000
        - timelogs[i]의 길이 = 7
        - timelogs[i][j]는 i + 1번째 직원이 이벤트 j + 1일차에 출근한 시각을 의미합니다.
        - 600 <= timelogs[i][j] <= 2359
        1 <= startday <= 7
        - 월 ~ 일
        출근 희망 시각과 실제로 출근한 시각을 100으로 나눈 나머지는 59 이하

        [테스트 케이스 구성]
        - n = 1. 이벤트 시작일이 월요일이고, 출근 희망 시각이 정각으로 된 입력만 주어집니다. (10%)
        - 이벤트 시작일이 월요일이고, 출근 희망 시각이 정각으로 된 입력만 주어집니다. (10%)
        - 출근 희망 시각이 정각으로 된 입력만 주어집니다. (15%)
        - 이벤트 시작일이 월요일인 입력만 주어집니다. (15%)
        - 제한사항 외 추가조건이 없습니다. (50%)
    */

    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;

        for (int i = 0; i < schedules.length; i++) {
            int schedule = schedules[i];
            int hour = schedule / 100;
            int minute = schedule % 100;

            minute += 10;
            if  (minute >= 60) {
                hour += 1;
                minute -= 60;
            }

            int deadline = hour * 100 + minute;

            int currentday = startday;
            boolean check = true;

            for (int time : timelogs[i]) {
                if (currentday >= 1 && currentday <= 5) {
                    if (time > deadline) {
                        check = false;
                        break;
                    }
                }

                currentday++;
                if (currentday > 7) {
                    currentday = 1;
                }
            }

            if (check) {
                answer++;
            }
        }

        return answer;
    }
}