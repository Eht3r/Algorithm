class Solution {
    public String solution(String s) {       
        String[] strs = s.split(" ");
        
        int min = Integer.parseInt(strs[0]);
        int max = Integer.parseInt(strs[0]);
        
        for (int i = 1; i < strs.length; i++ ) {
            int num = Integer.parseInt(strs[i]);
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
                
        return min + " " + max;
    }
}