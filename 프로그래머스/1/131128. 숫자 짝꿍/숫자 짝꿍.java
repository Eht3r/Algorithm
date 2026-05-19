class Solution {
    public String solution(String X, String Y) {
        int[] xCount = new int[10];
        int[] yCount = new int[10];
        
        StringBuilder answer = new StringBuilder();
        
        for (char ch : X.toCharArray()) {
            xCount[ch - '0']++;
        }
        
        for (char ch : Y.toCharArray()) {
            yCount[ch - '0']++;
        }
        
        for (int i = 9; i >= 0; i--) {
            int repeat = Math.min(xCount[i], yCount[i]);
            
            for (int j = 0; j < repeat; j++) {
                answer.append(i);
            }
        }
        
        if (answer.length() == 0) {
            return "-1";
        }
        
        if (answer.charAt(0) == '0') {
            return "0";
        }
        
        return answer.toString();
    }
}