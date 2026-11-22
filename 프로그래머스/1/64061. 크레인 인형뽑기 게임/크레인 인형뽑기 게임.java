import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        List<Integer> basket = new ArrayList<>();
        
        for (int num : moves) {
            int col = num - 1;
            
            for (int row = 0; row < board.length; row++) {
                if (board[row][col] != 0) {
                    int size = basket.size();
                    int pick = board[row][col];
                    
                    board[row][col] = 0;
                    
                    if (size > 0 && basket.get(size - 1) == pick) {
                        basket.remove(size - 1);
                        answer += 2;
                    } else {
                        basket.add(pick);
                    }
                    
                    break;
                }
            }
        }
        
        return answer;
    }
}