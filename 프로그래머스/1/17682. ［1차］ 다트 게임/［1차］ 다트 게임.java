import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int[] scores = new int[3];
        
        int index = 0;
        int number = 0;
        
        for (int i = 0; i < dartResult.length(); i++) {
            char ch = dartResult.charAt(i);
            
            if (Character.isDigit(ch)) {
                if (ch == '1' && i + 1 < dartResult.length() && dartResult.charAt(i + 1) == '0') {
                    number = 10;
                    i++;
                } else {
                    number = ch - '0';
                }
            } else if (isBouns(ch)) {
                scores[index++] = caculateScore(number, ch);
            } else {
                applyOption(scores, index, ch);
            }
        }
        
        return Arrays.stream(scores).sum();
    }
    
    private boolean isBouns(char ch) {
        return ch == 'S' || ch == 'D' || ch == 'T';
    }
    
    private int caculateScore(int number, char bouns) {
        return switch (bouns) {
            case 'S' -> number;
            case 'D' -> number * number;
            case 'T' -> number * number * number;
            default -> 0;
        };
    }
    
    private void applyOption(int[] scores, int index, char option) {
        if (option == '*') {
            scores[index - 1] *= 2;
            
            if (index - 2 >= 0) {
                scores[index - 2] *= 2;
            }
        } else if (option == '#') {
            scores[index - 1] *= -1;
        }
    }
}