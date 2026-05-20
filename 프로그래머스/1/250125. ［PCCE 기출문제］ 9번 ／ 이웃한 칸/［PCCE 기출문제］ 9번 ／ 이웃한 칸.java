class Solution {
    private int[] dh = {0, 1, -1, 0};
    private int[] dw = {1, 0, 0, -1};
    
    public int solution(String[][] board, int h, int w) {
        int n = board.length;
        int count = 0;
        
        for (int i = 0; i < dh.length; i++) {
            int hCheck = h + dh[i];
            int wCheck = w + dw[i];
            
            if ((0 <= hCheck && hCheck < n) && (0 <= wCheck && wCheck < n)) {
                if (board[h][w].equals(board[hCheck][wCheck])) {
                    count++;
                }
            }
        }
        
        return count;
    }
}