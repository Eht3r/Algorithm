/**
 * 프로그래머스 - 노란불 신호등
 *
 * 문제 요약:
 * - 도로에 n개의 차량 신호등이 있다.
 * - 모든 신호등은 초록불 → 노란불 → 빨간불 순서로 반복된다.
 * - 각 신호등의 초록불, 노란불, 빨간불 지속 시간은 signals[i] = [G, Y, R]로 주어진다.
 * - 시간은 1초부터 시작하며, 모든 신호등은 처음에 초록불 상태로 시작한다.
 * - 모든 신호등이 동시에 노란불이 되는 가장 빠른 시각을 구해야 한다.
 * - 그런 시각이 존재하지 않으면 -1을 반환한다.
 *
 * 입력:
 * - int[][] signals
 *   - signals.length는 신호등의 개수 n
 *   - signals[i][0] = i번째 신호등의 초록불 지속 시간 G
 *   - signals[i][1] = i번째 신호등의 노란불 지속 시간 Y
 *   - signals[i][2] = i번째 신호등의 빨간불 지속 시간 R
 *
 * 제한사항:
 * - 2 <= n <= 5
 * - 1 <= G, Y, R <= 18
 * - 3 <= G + Y + R <= 20
 *
 * 반환:
 * - 모든 신호등이 동시에 노란불이 되는 가장 빠른 시각(초)
 * - 존재하지 않으면 -1
 *
 * 입출력 예:
 * - [[2, 1, 2], [5, 1, 1]] -> 13
 * - [[2, 3, 2], [3, 1, 3], [2, 1, 1]] -> 11
 * - [[3, 3, 3], [5, 4, 2], [2, 1, 2]] -> 193
 * - [[1, 1, 4], [2, 1, 3], [3, 1, 2], [4, 1, 1]] -> -1
 */

import java.util.*;

class Solution {
    public int solution(int[][] signals) {
        int answer = 0;
        int limit = 1;
        
        for (int i = 0; i < signals.length; i++) {          
            int cycle = signals[i][0] + signals[i][1] + signals[i][2];
            limit = lcm(limit, cycle);
        }
        
        for (int t = 1; t <= limit; t++) {
            boolean allYellow = true;
            
            for (int i = 0; i < signals.length; i++) {
                int G = signals[i][0];
                int Y = signals[i][1];
                int R = signals[i][2];
                
                int cycle = G + Y + R;
                int pos = (t - 1) % cycle + 1;
                
                boolean isYellow = G < pos && pos <= G + Y;
                
                if (!isYellow) {
                    allYellow = false;
                    break;
                }
            }
            
            if (allYellow) {
                return t;
            }
        }
        
        return -1;
    }
    
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        
        return a;
    }
    
    private int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }
}