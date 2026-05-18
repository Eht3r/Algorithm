import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        Deque<Integer> dequeue = new LinkedList<>();
        for (int num : arr) {
            if(dequeue.isEmpty() || dequeue.peekLast() != num) {
                dequeue.add(num);
            }
        }
        
        int[] answer = new int[dequeue.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = dequeue.remove();
        }

        return answer;
    }
}