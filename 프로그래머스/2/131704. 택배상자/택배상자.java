import java.util.*;

class Solution {
    public int solution(int[] order) {
        Deque<Integer> stack = new ArrayDeque<>();
        int index = 0;
        
        for (int box = 1; box <= order.length; box++) {
            stack.push(box);
        
            while (!stack.isEmpty() && stack.peek() == order[index]) {
                stack.pop();
                index++;
                
                if (index == order.length) {
                    break;
                }
            }
        }
        
        return index;
    }
}