/**
 * 문제: 공원 산책
 *
 * 직사각형 격자 형태의 공원에서 로봇 강아지가 주어진 명령에 따라 이동한다.
 *
 * 공원은 문자열 배열 park로 주어진다.
 * 각 문자는 다음 의미를 가진다.
 *
 * - 'S' : 시작 위치
 * - 'O' : 이동 가능한 길
 * - 'X' : 장애물
 *
 * 명령은 문자열 배열 routes로 주어지며, 각 명령은 "방향 거리" 형식이다.
 * 예를 들어 "E 2"는 현재 위치에서 동쪽으로 2칸 이동하라는 의미이다.
 *
 * 방향은 다음 네 가지 중 하나이다.
 *
 * - N : 북쪽, 즉 행 감소
 * - S : 남쪽, 즉 행 증가
 * - W : 서쪽, 즉 열 감소
 * - E : 동쪽, 즉 열 증가
 *
 * 로봇 강아지는 각 명령을 수행하기 전에 이동 경로를 확인한다.
 *
 * 다음 중 하나라도 해당하면 해당 명령은 무시하고 다음 명령으로 넘어간다.
 *
 * 1. 이동 중 공원 범위를 벗어나는 경우
 * 2. 이동 중 장애물 'X'를 만나는 경우
 *
 * 모든 명령을 처리한 뒤 로봇 강아지의 최종 위치를
 * [세로 좌표, 가로 좌표] 형태의 int 배열로 반환한다.
 *
 * 좌표는 공원의 좌측 상단을 [0, 0]으로 본다.
 * 즉, park[row][col]에서 row가 세로 좌표, col이 가로 좌표이다.
 *
 * 제한사항:
 * - park의 세로 길이는 3 이상 50 이하
 * - park의 가로 길이는 3 이상 50 이하
 * - park는 직사각형 형태
 * - 시작 지점 'S'는 정확히 하나
 * - routes의 길이는 1 이상 50 이하
 * - 이동 거리는 1 이상 9 이하
 */

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        int maxHeight = park.length;
        int maxWidth = park[0].length();
        
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                if (park[i].charAt(j) == 'S') {
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }
        
        for (String route : routes) {
            String[] arr = route.split(" ");
            
            String direction = arr[0];
            int distance = Integer.parseInt(arr[1]);
            
            int nextRow = answer[0];
            int nextCol = answer[1];
            boolean canMove = true;
            
            for (int i = 0; i < distance; i++) {
                switch(direction) {
                    case "E":
                        nextCol += 1;
                        break;
                    case "W":
                        nextCol -= 1;
                        break;
                    case "S":
                        nextRow += 1;
                        break;
                    case "N":
                        nextRow -= 1;
                        break;
                }
                if (nextRow < 0 || nextRow >= maxHeight || nextCol < 0 || nextCol >= maxWidth) {
                    canMove = false;
                    break;
                }

                if (park[nextRow].charAt(nextCol) == 'X') {
                    canMove = false;
                    break;
                }
            }
            
            if (canMove) {
                answer[0] = nextRow;
                answer[1] = nextCol;
            }
        }
        
        return answer;
    }
}