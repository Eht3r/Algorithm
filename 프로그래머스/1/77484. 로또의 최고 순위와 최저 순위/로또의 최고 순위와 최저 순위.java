import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        Set<Integer> winningNumbers = new HashSet<>();
        
        for (int num : win_nums) {
            winningNumbers.add(num);
        }
        
        int matchCount = 0;
        int zeroCount = 0;
        
        for (int num : lottos) {
            if (num == 0) {
                zeroCount++;
            } else if (winningNumbers.contains(num)) {
                matchCount++;
            }
        }
        
        return new int[] {calculateRank(matchCount + zeroCount ), calculateRank(matchCount )};
    }
    
    private int calculateRank(int matchCount) {
        return matchCount >= 2 ? 7 - matchCount : 6;
    }
}