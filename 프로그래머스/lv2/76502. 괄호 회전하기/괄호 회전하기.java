import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for (int i = 0; i < s.length(); i++) {
            Stack<Character> stack = new Stack<>();
            boolean check = true;
            
            String rotated = s.substring(i) + s.substring(0, i);
            
            for(int j = 0; j < rotated.length(); j++) {
                char ch1 = rotated.charAt(j);

               if(ch1 == '[' || ch1 == '(' || ch1 == '{') {
                   stack.push(ch1);
               } else {
                   if(stack.empty()) {
                       check = false;
                       break;
                   } else {
                       char ch = stack.peek();
                       
                       if(ch == '[' && ch1 == ']') {
                           stack.pop();
                       } else if(ch == '(' && ch1 == ')') {
                           stack.pop();
                       } else if(ch == '{' && ch1 == '}') {
                           stack.pop();
                       } else {
                           check = false;
                           break;
                       }
                   }
               }
            }
            
            if(check && stack.empty()) {
                answer++;
            }
        }
        return answer;
    }
}