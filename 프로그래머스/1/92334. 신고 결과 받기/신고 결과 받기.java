/**
 * 문제: 신고 결과 받기
 *
 * 게시판 이용자들이 다른 이용자를 신고했을 때,
 * 신고 누적 결과에 따라 이용 정지 대상자를 정하고,
 * 각 이용자가 몇 번의 처리 결과 메일을 받는지 계산하는 문제이다.
 *
 * 규칙:
 * 1. 각 유저는 한 번에 한 명의 유저를 신고할 수 있다.
 * 2. 신고 횟수 자체에는 제한이 없다.
 * 3. 같은 유저가 같은 유저를 여러 번 신고한 경우,
 *    해당 신고는 1회만 인정된다.
 * 4. 어떤 유저가 k번 이상 신고당하면 게시판 이용이 정지된다.
 * 5. 이용 정지된 유저를 신고한 모든 유저에게 처리 결과 메일이 발송된다.
 * 6. 모든 신고 내용을 한꺼번에 취합한 뒤,
 *    최종적으로 정지 대상자를 결정하고 메일을 발송한다.
 *
 * @param id_list 전체 이용자 ID 목록
 * @param report 신고 기록 목록.
 *               각 원소는 "신고한유저 신고당한유저" 형태의 문자열이다.
 * @param k 이용 정지 기준 신고 횟수
 * @return id_list에 담긴 ID 순서대로,
 *         각 유저가 받은 처리 결과 메일 수를 담은 int 배열
 */

import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Integer> idIndex = new HashMap<>();
        Map<String, Set<String>> reportedUsersMap = new HashMap<>();

        int[] answer = new int[id_list.length];

        for (int i = 0; i < id_list.length; i++) {
            idIndex.put(id_list[i], i);
        }

        for (String r : report) {
            String[] split = r.split(" ");
            String reporter = split[0];
            String reported = split[1];

            reportedUsersMap
                .computeIfAbsent(reported, key -> new HashSet<>())
                .add(reporter);
        }

        for (Set<String> reporters : reportedUsersMap.values()) {
            if (reporters.size() >= k) {
                for (String reporter : reporters) {
                    answer[idIndex.get(reporter)]++;
                }
            }
        }

        return answer;
    }
}