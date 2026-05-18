class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        int count_0 = 0;
        int count_binary = 0;
        
        while (!s.equals("1")) {
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);

                if (ch == '0') {
                    count++;
                }
            }
        
            s = Integer.toBinaryString(s.length() - count);
            count_binary++;
            count_0 += count;
        }
        
        return new int[]{count_binary, count_0};
    }
}