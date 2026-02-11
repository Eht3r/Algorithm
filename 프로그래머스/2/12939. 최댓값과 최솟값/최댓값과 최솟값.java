class Solution {
    public String solution(String s) {       
        String[] strs = s.split(" ");
        
        int min = Integer.parseInt(strs[0]);
        int max = Integer.parseInt(strs[0]);
        
        for (int i = 1; i < strs.length; i++ ) {
            int num = Integer.parseInt(strs[i]);
            if (num < min) {
                min = num;
            } else if (max < num) {
                max = num;
            }
        }
        
        return min + " " + max;
    }
}