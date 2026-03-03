import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        Map<String, Integer> genres_map = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            genres_map.put(genres[i], genres_map.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        List<String> keySet = new ArrayList(genres_map.keySet());
        keySet.sort((o1, o2) -> genres_map.get(o2).compareTo(genres_map.get(o1)));
        
        List<Integer> answerList = new ArrayList<>();
        for(int i = 0; i < keySet.size(); i++) {
            Map<Integer, Integer> plays_map = new HashMap<>();
            String genre = keySet.get(i);
            for (int j = 0; j < genres.length; j++) {
                if (genre.equals(genres[j])) {
                    plays_map.put(j, plays[j]);
                }
            }
            
            List<Integer> keySet1 = new ArrayList(plays_map.keySet());
            keySet1.sort((o1, o2) -> {
                if (plays_map.get(o2).equals(plays_map.get(o1))) {
                    return o1.compareTo(o2);
                }
                return plays_map.get(o2).compareTo(plays_map.get(o1));
            });
            
            int limit = Math.min(keySet1.size(), 2);
            for (int k = 0; k < limit; k++) {
                int num = keySet1.get(k);
                answerList.add(num);
            }
        }
        
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        
        
        
        return answer;
    }
}