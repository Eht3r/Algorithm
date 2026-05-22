import java.util.*;
import java.util.regex.*;

class Solution {
    private static final Pattern FILE_PATTERN =
        Pattern.compile("^(\\D+)(\\d{1,5}).*");
    
    public String[] solution(String[] files) {
        FileInfo[] infos = new FileInfo[files.length];
        
        for (int i = 0; i < files.length; i++) {
            infos[i] = new FileInfo(files[i], i);
        }
        
        Arrays.sort(infos,
                   Comparator.comparing((FileInfo file) -> file.head)
                                       .thenComparingInt(file -> file.number)
                                       .thenComparingInt(file -> file.index)
       );
                    
        String[] answer = new String[files.length];
        
        for (int i = 0; i < infos.length; i++) {
            answer[i] = infos[i].original;
        }
        
        return answer;
    }
    
    private static class FileInfo {
        String original; // 원본 파일명
        String head;     // 소문자로 변환한 HEAD
        int number;      // 숫자로 변환한 NUMBER
        int index;       // 원래 입력 순서

        FileInfo(String original, int index) {
            this.original = original;
            this.index = index;

            Matcher matcher = FILE_PATTERN.matcher(original);

            if (matcher.matches()) {
                this.head = matcher.group(1).toLowerCase();
                this.number = Integer.parseInt(matcher.group(2));
            }
        }
    }
}