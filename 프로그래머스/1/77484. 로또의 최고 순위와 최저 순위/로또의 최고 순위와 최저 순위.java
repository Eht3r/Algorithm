import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {      
        
        int count = (int) Arrays.stream(lottos)
            .filter(num -> Arrays.stream(win_nums).anyMatch(val -> val == num))
            .count();
        int blindCount = (int) Arrays.stream(lottos)
            .filter(num -> num == 0)
            .count();
        
        return new int[] {calculateRank(count + blindCount), calculateRank(count)};
    }
    
    private int calculateRank(int count) {
        return switch(count) {
            case 6 -> 1;
            case 5 -> 2;
            case 4 -> 3;
            case 3 -> 4;
            case 2 -> 5;
            default -> 6;
        };
    }
}