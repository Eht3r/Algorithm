import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int extIndex = getIndex(ext);
        int sortIndex = getIndex(sort_by);
        
        return Arrays.stream(data)
            .filter(row -> row[extIndex] < val_ext)
            .sorted(Comparator.comparingInt(row -> row[sortIndex]))
            .toArray(int[][]::new);
    }
    
    private int getIndex(String column) {
        return switch (column) {
            case "code" -> 0;
            case "date" -> 1;
            case "maximum" -> 2;
            case "remain" -> 3;
            default -> -1;
        };
    }
}