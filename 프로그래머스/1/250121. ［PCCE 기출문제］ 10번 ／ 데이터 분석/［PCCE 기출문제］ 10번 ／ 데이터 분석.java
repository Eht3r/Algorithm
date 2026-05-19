import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> list = new ArrayList<>();
        int extIndex = getIndex(ext);
        int sortIndex = getIndex(sort_by);
        
        for (int[] arr : data) {
            if (arr[extIndex] < val_ext) {
                list.add(arr);
            }
        }
        
        int answer[][] = list.toArray(new int[list.size()][]);
        
        Arrays.sort(answer, (o1, o2) -> {
            return o1[sortIndex]-o2[sortIndex];
        });
        
        return answer;
    }
    
    private int getIndex(String str) {
        return switch (str) {
            case "code" -> 0;
            case "date" -> 1;
            case "maximum" -> 2;
            case "remain" -> 3;
            default -> -1;
        };
    }
}