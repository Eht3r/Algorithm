/**
 * 문제 설명
 * - 컴퓨터 바탕화면은 각 칸이 정사각형인 격자판이다.
 * - wallpaper 배열은 현재 바탕화면의 상태를 나타낸다.
 * - "."은 빈칸을 의미하고, "#"은 파일이 있는 칸을 의미한다.
 * - 파일들은 바탕화면의 격자칸에 위치한다.
 * - 격자점의 좌표는 가장 왼쪽 위를 (0, 0)으로 하며,
 *   (세로 좌표, 가로 좌표) 형태로 표현한다.
 *
 * - 사용자는 한 번의 드래그로 모든 파일을 선택해서 삭제하려고 한다.
 * - 드래그는 시작 격자점 S(lux, luy)에서
 *   끝 격자점 E(rdx, rdy)까지 이동하는 행동이다.
 * - S와 E를 각각 직사각형의 왼쪽 위, 오른쪽 아래 격자점으로 보았을 때,
 *   그 직사각형 내부에 포함된 모든 파일이 선택된다.
 *
 * - 드래그 거리는 다음과 같이 계산한다.
 *   |rdx - lux| + |rdy - luy|
 *
 * - 모든 파일을 선택할 수 있는 드래그 중,
 *   이동거리가 최소가 되는 시작점과 끝점을 구해야 한다.
 *
 * 입력
 * - wallpaper: 바탕화면의 상태를 나타내는 문자열 배열
 *   - wallpaper[i][j] == "."이면 빈칸
 *   - wallpaper[i][j] == "#"이면 파일이 있는 칸
 *
 * 출력
 * - 모든 파일을 한 번에 선택할 수 있는 최소 드래그 영역의 좌표를 담은 정수 배열
 * - 드래그 시작점이 (lux, luy), 끝점이 (rdx, rdy)라면
 *   [lux, luy, rdx, rdy]를 return한다.
 *
 * 제한사항
 * - 1 <= wallpaper.length <= 50
 * - 1 <= wallpaper[i].length() <= 50
 * - wallpaper의 모든 원소 길이는 같다.
 * - wallpaper[i][j]는 "#" 또는 "."이다.
 * - 바탕화면에는 적어도 하나의 파일이 있다.
 * - lux < rdx, luy < rdy를 만족해야 한다.
 */
class Solution {
    public int[] solution(String[] wallpaper) {
        int minRow = 50;
        int minCol = 50;
        int maxRow = 0;
        int maxCol = 0;
        
        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    minRow = Math.min(minRow, i);
                    minCol = Math.min(minCol, j);
                    maxRow = Math.max(maxRow, i);
                    maxCol = Math.max(maxCol, j);
                }
            }
        }
        
        return new int[] {minRow, minCol, maxRow + 1, maxCol + 1};
    }
}