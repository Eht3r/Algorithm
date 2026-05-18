/**
 * 프로그래머스 - 중요한 단어를 스포 방지
 *
 * 카카오톡 메시지의 일부 구간에 스포 방지 기능이 적용되어 있다.
 * 사용자는 메시지의 왼쪽에서 오른쪽 순서로 스포 방지 구간을 하나씩 클릭하여 공개한다.
 * 이때 공개되는 스포 방지 단어들 중 "중요한 단어"의 개수를 구해야 한다.
 *
 * 단어 정의:
 * - 단어는 공백으로 구분된다.
 * - 단어는 알파벳 소문자와 숫자로만 이루어진 연속 문자열이다.
 * - 공백은 연속해서 등장하지 않는다.
 *
 * 스포 방지 단어 정의:
 * - 어떤 단어를 이루는 문자 중 하나 이상이 스포 방지 구간에 포함되면,
 *   해당 단어 전체를 스포 방지 단어로 본다.
 * - 한 단어가 여러 스포 방지 구간에 걸칠 수 있다.
 * - 하나의 스포 방지 구간에 여러 단어가 포함될 수 있다.
 *
 * 중요한 단어 조건:
 * 스포 방지 구간을 클릭해 어떤 단어의 모든 문자가 공개되었을 때,
 * 그 단어가 아래 조건을 모두 만족하면 중요한 단어이다.
 *
 * 1. 스포 방지 단어여야 한다.
 * 2. 어떤 스포 방지 구간에도 속하지 않는 일반 구간에 등장한 적이 없어야 한다.
 *    - 일반 구간은 스포 방지 구간의 앞, 사이, 뒤를 모두 포함한다.
 * 3. 이전에 공개된 스포 방지 단어와 중복되지 않아야 한다.
 * 4. 여러 단어가 동시에 공개되는 경우, 왼쪽부터 순서대로 판단한다.
 *
 * 입력:
 * - message: 무지가 보낸 메시지 문자열
 * - spoiler_ranges: 스포 방지가 적용된 구간 배열
 *   - spoiler_ranges[i] = [start, end]
 *   - start와 end는 message의 문자 인덱스이다.
 *   - start와 end 모두 스포 방지 구간에 포함된다.
 *
 * 제한사항:
 * - 1 <= message.length() <= 20,000
 * - message는 알파벳 소문자, 숫자, 공백으로만 이루어진다.
 * - message는 하나 이상의 단어로 구성된다.
 * - 공백은 연속해서 등장하지 않는다.
 * - 1 <= spoiler_ranges.length <= 1,000
 * - 0 <= start <= end < message.length()
 * - 스포 방지 구간들은 서로 겹치지 않는다.
 * - spoiler_ranges는 start 기준 오름차순으로 정렬되어 주어진다.
 *
 * 반환:
 * - 스포 방지 단어 중 중요한 단어의 개수
 *
 * 예시:
 * message = "here is muzi here is a secret message"
 * spoiler_ranges = [[0, 3], [23, 28]]
 * result = 1
 *
 * message = "my phone number is 01012345678 and may i have your phone number"
 * spoiler_ranges = [[5, 5], [25, 28], [34, 40], [53, 59]]
 * result = 4
 *
 * @param message 무지가 보낸 메시지
 * @param spoiler_ranges 스포 방지가 적용된 문자 인덱스 구간 배열
 * @return 중요한 스포 방지 단어의 개수
 */
import java.util.*;

class Solution {
    
    static class Word {
        String text;
        int start;
        int end;
        int revealTime = -1; // -1이면 스포일러 구간과 겹치지 않음
        
        Word(String text, int start, int end) {
            this.text = text;
            this.start = start;
            this.end = end;
        }
    }
    
    static boolean isOverlap(int aStart, int aEnd, int bStart, int bEnd) {
        return aStart <= bEnd && bStart <= aEnd;
    }
    
    public int solution(String message, int[][] spoiler_ranges) {
        List<Word> words = new ArrayList<>();
        
        int n = message.length();
        int i = 0;
        
        while(i < n) {
            if (message.charAt(i) == ' ') {
                i++;
                continue;
            }
            
            int start = i;
            
            while (i < n && message.charAt(i) != ' ') {
                i++;
            }
            
            int end = i - 1;
            String text = message.substring(start, end + 1);
            
            words.add(new Word(text, start, end));
        }
        
        for (Word word : words) {
            for (int r = 0; r < spoiler_ranges.length; r++) {
                int rangeStart = spoiler_ranges[r][0];
                int rangeEnd = spoiler_ranges[r][1];
                
                if (isOverlap(word.start, word.end, rangeStart, rangeEnd)) {
                    word.revealTime = r;
                }
            }
        }
        
        Set<String> normalWords = new HashSet<>();
        
        List<List<Word>> revealedAt = new ArrayList<>();
        for (int r = 0; r < spoiler_ranges.length; r++) {
            revealedAt.add(new ArrayList<>());
        }
        
        for (Word word : words) {
            if (word.revealTime  == -1) {
                normalWords.add(word.text);
            } else {
                revealedAt.get(word.revealTime).add(word);
            }
        }
        
        Set<String> revealedSpoilerWords = new HashSet<>();
        int answer = 0;
        
        for (int r = 0; r < spoiler_ranges.length; r++) {
            List<Word> current = revealedAt.get(r);
            
            // 같은 시점에 공개되는 단어는 왼쪽부터 판단해야 함
            current.sort(Comparator.comparingInt(w -> w.start));
            
            for (Word word : current) {
                if (!normalWords.contains(word.text)
                        && !revealedSpoilerWords.contains(word.text)) {
                    answer++;
                }
                
                revealedSpoilerWords.add(word.text);
            }
        }
        
        
        return answer;
    }
}