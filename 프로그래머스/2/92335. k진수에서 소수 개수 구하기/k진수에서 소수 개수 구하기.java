import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String str = Integer.toString(n, k);
        String[] arr = str.split("0");
        
        for (String number : arr) {
            if (!(number.isEmpty() || number.equals("1"))) {
                long num = Long.parseLong(number);

                boolean check = true;
                for (int i = 2; i <= Math.sqrt(num); i++) {
                    if (num % i == 0) {
                        check = false;
                        break;
                    }
                }

                if (check) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}