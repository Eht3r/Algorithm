import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        Map<String, Integer> phone_map = new HashMap<>();
        for (int i = 0; i < phone_book.length; i++) {
            phone_map.put(phone_book[i], i);
        }
        
        for (int i = 0; i < phone_book.length; i++) {
            String phone = phone_book[i];
            for (int j = 1; j < phone.length(); j++) {
                if (phone_map.containsKey(phone.substring(0, j))) {
                    return false;
                }
            }
        }
        return true;
    }
}