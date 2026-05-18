import java.util.*;

/**
 * 문제 설명
 * - 달리기 경주에서 선수들은 현재 등수 순서대로 players 배열에 담겨 있다.
 * - 해설진은 어떤 선수가 자기 바로 앞의 선수를 추월할 때마다 그 선수의 이름을 부른다.
 * - callings 배열에는 해설진이 순서대로 부른 선수 이름들이 담겨 있다.
 * - 이름이 불린 선수는 현재 자신의 바로 앞 선수와 위치를 바꾼다.
 * - 모든 callings를 처리한 뒤, 최종 등수 순서대로 선수 이름 배열을 반환해야 한다.
 *
 * 입력
 * - players: 현재 등수 순서대로 담긴 선수 이름 배열
 *   - 선수 이름은 중복되지 않는다.
 * - callings: 해설진이 부른 선수 이름 배열
 *   - callings의 원소는 players에 존재하는 이름이다.
 *   - 경기 중 1등인 선수의 이름은 불리지 않는다.
 *
 * 출력
 * - 경주가 끝난 뒤, 1등부터 마지막 등수까지의 선수 이름 배열
 */
class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }
        
        for (String calling : callings) {
            int calledIndex = map.get(calling);
            String frontPlayer = players[calledIndex - 1];
            
            players[calledIndex - 1] = calling;
            players[calledIndex] = frontPlayer;
            
            map.put(calling, calledIndex - 1);
            map.put(frontPlayer, calledIndex);
        }
        
        return players;
    }
}