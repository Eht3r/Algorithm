import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        
        if (arr.length == 1) {
            return new int[] {-1};
        }

        int[] arr1 = arr.clone();
        
        Arrays.sort(arr1);
        int min = arr1[0];
        
       int[] answer = Arrays.stream(arr)
           .filter(item -> item != min)
           .toArray();
        
        return answer;
    }
}