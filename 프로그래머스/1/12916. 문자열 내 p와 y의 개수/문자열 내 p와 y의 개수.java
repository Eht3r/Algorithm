import java.util.Arrays;

class Solution {
    boolean solution(String s) {
       s = s.toLowerCase();
        char[] charArr = s.toCharArray();
        
        int cnt_p = 0;
        int cnt_y = 0;
        
        for(char ch : charArr) {
            if (ch == 'p') {
                cnt_p ++;
            }
            
            if (ch == 'y') {
                cnt_y ++;
            }
        }
        

        return cnt_y == cnt_p ? true : false;
    }
}