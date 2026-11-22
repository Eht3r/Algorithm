import java.util.*;

class Solution {
    public List<Integer> solution(String s) {
        s = s.substring(2, s.length() - 2).replace("},{", "-");
        String[] arr = s.split("-");
        
        Arrays.sort(arr, (a, b) -> a.length() - b.length());
        List<Integer> answer = new ArrayList<>();
        for (String str : arr) {
            String[] arr1 = str.split(",");
            
            for (String str1 : arr1) {
                int num = Integer.parseInt(str1);
                
                if (!answer.contains(num)) {
                    answer.add(num);
                }
            }
        }
        
        return answer;
    }
}