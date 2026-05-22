import java.util.*;

class Solution {
    public long solution(long n) {
        String str = String.valueOf(n);
        char[] nums = str.toCharArray();

        Arrays.sort(nums);
        StringBuilder sb = new StringBuilder();
        
        for (int i = nums.length - 1; i >= 0; i--) {
            sb.append(nums[i]);
        }
        
        return Long.parseLong(sb.toString());
    }
}