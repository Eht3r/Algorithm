import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> nicknameMap = new HashMap<>();
        List<String[]> logs = new ArrayList<>();
        
        for (String str : record) {
            String[] arr = str.split(" ");
            String type = arr[0];
            String uuid = arr[1];
            
            switch (type) {
                case "Enter" -> {
                    String name = arr[2];
                    nicknameMap.put(uuid, name);
                    logs.add(new String[] {type, uuid});
                }
                case "Leave" -> logs.add(new String[] {type, uuid});
                case "Change" -> {
                    String name = arr[2];
                    nicknameMap.put(uuid, name);
                }
            }
        }
        
        String[] answer = new String[logs.size()];
        
        for (int i = 0; i < logs.size(); i++) {
            String type = logs.get(i)[0];
            String uuid = logs.get(i)[1];
            String name = nicknameMap.get(uuid);
            
            if (type.equals("Enter")) {
                answer[i] = name + "님이 들어왔습니다.";
            } else {
                answer[i] = name + "님이 나갔습니다.";
            }
        }
        
        return answer;
    }
}