import java.util.*;

class Solution {
    private static Map <Character, Integer> map = new HashMap<>();
    
    public String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();
        
        for (int i = 0; i < survey.length; i++) {
            if (choices[i] < 4) {
                char personality = survey[i].charAt(0);
                int score = 4 - choices[i];
                map.put(personality, map.getOrDefault(personality, 0) + score);
            } else if (choices[i] > 4) {
                char personality = survey[i].charAt(1);
                int score = choices[i] - 4;
                map.put(personality, map.getOrDefault(personality, 0) + score);
            }
        }
        
        answer.append(compare('R', 'T'))
            .append(compare('C', 'F'))
            .append(compare('J', 'M'))
            .append(compare('A', 'N'));
        
        return answer.toString();
    }
    
    private Character compare(Character str1, Character str2) {
        int score1 = map.getOrDefault(str1, 0);
        int score2 = map.getOrDefault(str2, 0);
        
        if (score1 > score2) {
            return str1;
        } else if (score1 < score2) {
            return str2;
        } else {
            return str1.compareTo(str2) <= 0 ? str1 : str2;
        }
    }
}