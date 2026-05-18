import java.util.*;

/**
 * 문제 설명
 * - 개인정보마다 수집 날짜와 약관 종류가 주어진다.
 * - 각 약관 종류마다 개인정보를 보관할 수 있는 유효기간이 개월 수로 정해져 있다.
 * - 개인정보는 수집 날짜로부터 해당 약관의 유효기간 전까지만 보관할 수 있다.
 * - 유효기간이 지난 개인정보는 오늘 날짜 기준으로 반드시 파기해야 한다.
 * - 모든 달은 28일까지 있다고 가정한다.
 *
 * 입력
 * - today: 오늘 날짜를 나타내는 문자열
 *   - 형식: "YYYY.MM.DD"
 *
 * - terms: 약관 종류와 유효기간을 담은 문자열 배열
 *   - 형식: "약관종류 유효기간"
 *   - 예: "A 6"은 A 약관의 유효기간이 6개월이라는 뜻이다.
 *
 * - privacies: 개인정보 수집 날짜와 약관 종류를 담은 문자열 배열
 *   - 형식: "수집날짜 약관종류"
 *   - 예: "2021.05.02 A"는 2021년 5월 2일에 A 약관으로 수집된 개인정보라는 뜻이다.
 *   - privacies[i]는 i + 1번 개인정보를 의미한다.
 *
 * 출력
 * - 오늘 날짜 기준으로 유효기간이 지나 파기해야 하는 개인정보 번호들을
 *   오름차순으로 담은 int 배열을 반환한다.
 *
 * 핵심 조건
 * - 모든 달은 28일까지 있다고 가정한다.
 * - 개인정보가 보관 가능한 마지막 날짜는
 *   수집 날짜 + 약관 유효기간 - 1일 이다.
 * - 오늘 날짜가 보관 가능 마지막 날짜보다 크면 파기 대상이다.
 */
class Solution {    
    public int[] solution(String today, String[] terms, String[] privacies) {
        HashMap<String, Integer> termsMap = new HashMap<>();
        ArrayList<Integer> answer = new ArrayList<>();
        
        int todayDays = toDays(today);
        
        for (String term : terms) {
            String[] arr = term.split(" ");
            termsMap.put(arr[0], Integer.parseInt(arr[1]));
        }
        
        for (int i = 0; i < privacies.length; i++) {
            String[] arr = privacies[i].split(" ");
            
            String date = arr[0];
            String term = arr[1];
            
            int startDays = toDays(date);
            int range = termsMap.get(term);
            
            int expireDays = startDays + range * 28;
            
            if (expireDays <= todayDays) {
                answer.add(i + 1);
            }
        }
        
        return answer.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
    
    private int toDays(String date) {
        int[] arr = Arrays.stream(date.split("\\."))
            .mapToInt(Integer::parseInt)
            .toArray();
        
        int year = arr[0];
        int month = arr[1];
        int day = arr[2];
        
        return year * 12 * 28 + month * 28 + day;
    }
}