/**
 * 문제 설명
 * - 스마트폰 전화 키패드에서 왼손과 오른손 엄지손가락만 사용해 숫자를 입력한다.
 * - 처음 왼손 엄지손가락은 '*' 위치에서 시작한다.
 * - 처음 오른손 엄지손가락은 '#' 위치에서 시작한다.
 * - 각 숫자를 누를 때 사용하는 손은 다음 규칙에 따라 결정한다.
 *
 * 규칙
 * - 숫자 1, 4, 7은 항상 왼손으로 누른다.
 * - 숫자 3, 6, 9는 항상 오른손으로 누른다.
 * - 숫자 2, 5, 8, 0은 현재 왼손과 오른손 위치 중 더 가까운 손으로 누른다.
 * - 엄지손가락은 상하좌우로만 이동할 수 있으며, 한 칸 이동 거리는 1이다.
 * - 두 손의 거리가 같으면 hand 값에 따라 결정한다.
 *   - hand가 "left"이면 왼손을 사용한다.
 *   - hand가 "right"이면 오른손을 사용한다.
 *
 * 입력
 * - numbers: 순서대로 눌러야 할 숫자 배열
 *   - 길이는 1 이상 1,000 이하이다.
 *   - 각 원소는 0 이상 9 이하의 정수이다.
 *
 * - hand: 주로 사용하는 손을 나타내는 문자열
 *   - "left" 또는 "right" 중 하나이다.
 *
 * 출력
 * - 각 숫자를 누른 손을 순서대로 이어 붙인 문자열을 반환한다.
 * - 왼손을 사용한 경우 'L'을 붙인다.
 * - 오른손을 사용한 경우 'R'을 붙인다.
 */
class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        int[][] keypad = {
            {3, 1}, // 0
            {0, 0}, // 1
            {0, 1}, // 2
            {0, 2}, // 3
            {1, 0}, // 4
            {1, 1}, // 5
            {1, 2}, // 6
            {2, 0}, // 7
            {2, 1}, // 8
            {2, 2}  // 9
        };
        
        // *
        int leftRow = 3;
        int leftCol = 0;
        
        // #
        int rightRow = 3;
        int rightCol = 2;
        
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            
            switch (num) {
                case 1, 4, 7 -> {
                    leftRow = keypad[num][0];
                    leftCol = keypad[num][1];
                    sb.append("L");
                }
                case 3, 6, 9 -> {
                    rightRow = keypad[num][0];
                    rightCol = keypad[num][1];
                    sb.append("R");
                }
                default -> {
                    int row = keypad[num][0];
                    int col = keypad[num][1];
                    
                    int leftDistance = Math.abs(leftRow - row) + Math.abs(leftCol - col);
                    int rightDistance = Math.abs(rightRow - row) + Math.abs(rightCol - col);
                    
                    if (leftDistance < rightDistance) {
                        sb.append("L");
                        leftRow = row;
                        leftCol = col;
                    } else if (leftDistance > rightDistance) {
                        sb.append("R");
                        rightRow = row;
                        rightCol = col;
                    } else {
                        if (hand.equals("left")) {
                            sb.append("L");
                            leftRow = row;
                            leftCol = col;
                        } else if (hand.equals("right")) {
                            sb.append("R");
                            rightRow = row;
                            rightCol = col;
                        }
                    }
                }
                    
            }
        }
        
        return sb.toString();
    }
}