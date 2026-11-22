class Solution {
    public String solution(String X, String Y) {
        int[] xCount = countDigits(X);
        int[] yCount = countDigits(Y);
        
        StringBuilder answer = new StringBuilder();
        
        for (int i = 9; i >= 0; i--) {
            int repeat = Math.min(xCount[i], yCount[i]);
            
            for (int j = 0; j < repeat; j++) {
                answer.append(i);
            }
        }
        
        return formatAnswer(answer);
    }
    
    private int[] countDigits(String number) {
        int[] count = new int[10];
        
        for (int i = 0; i < number.length(); i++) {
            count[number.charAt(i) - '0']++;
        }
        
        return count;
    }
    
    private String formatAnswer(StringBuilder answer) {
        if (answer.length() == 0) {
            return "-1";
        }
        
        if (answer.charAt(0) == '0') {
            return "0";
        }
        
        return answer.toString();
    }
}