import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
    
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            int left = 100 - progresses[i];
            int day = left % speeds[i] == 0 ? left / speeds[i] : (left / speeds[i]) + 1;
            
            queue.offer(day);
        }
        
        int max = queue.poll();
        int count = 1;
        List<Integer> answer = new ArrayList<>();
        while (queue.size() > 0) {
            
            if (max >= queue.peek()) {
                count++;
                queue.poll();
            } else {
                answer.add(count);
                count = 1;
                max = queue.poll();
            }
        }
        
        answer.add(count);
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}