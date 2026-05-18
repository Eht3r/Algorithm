import java.util.HashMap;
import java.util.Map;

public class Solution {
    /*
        Programmers. 가장 많이 받은 선물
        ---------------------------

        [문제 설명]
        두 사람이 선물을 주고받은 기록이 있다면, 이번 달까지 두 사람 사이에 더 많은 선물을 준 사람이 다음 달에 선물을 하나 받음
        - 예를 들어 A -> B 5번, B -> A 3번 이면,  A -> B에게 선물을 하나 받음
        두 사람이 선물을 주고받은 기록이 하나도 없거나 주고받은 수가 같다면, 선물 지수가 더 큰 사람이 선물 지수가 더 작은 사람에게 선물을 하나 받음
        - 선물 지수: 이번 달까지 자신이 친구들에게 준 선물의 수에서 받은 선물의 수를 뺀 값
        - 예를 들어 A가 준 선물이 3개, 받은 선물이 10개면 A의 선물 지수는 -7, B가 준 선물이 3개, 받은 선물이 2개면 B의 선물지수는 1. 이때, A와 B가 선물을 주고 받지 않았거나 정ㄴ확히 같은 수로 선물을 주고 받았다면 담달에 B가 A에게 선물 하나를 받음
        - 두 사람의 선물 지수도 같다면 다음 달에 선물을 서로 주고 받지 않음

        [입력]
        - friends: 친구들의 이름을 담은 1차원 문자열 배열
        - gifts: 친구들이 주고받은 선물 기록을 담은 1차원 문자열 배열

        [출력]
        - 다음달에 가장 많은 성물을 받는 친구가 받을 선물의 수

        [제한사항]
        2 <= friends의 길이 = 친구들의 수 <= 50
        - friends의 원소는 친구의 이름을 의미하는 알파벳 소문자로 이루어진 길이가 10 이하인 문자열
        - 이름이 같은 친구는 없습니다.
        1 <= gifts의 길이 <= 10,000
        - gifts의 원소는 "A B"형태의 문자열. A는 선물을 준 친구의 이름을 B는 선물을 받은 친구의 이름을 의미하며 공백 하나로 구분.
        - A와 B는 friends의 원소이며 A와 B가 같은 이름인 경우는 존재하지 않음.
     */
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        
        Map<String, Integer> friendIndexMap = new HashMap<>();
        for (int i = 0; i < friends.length; i++) {
            friendIndexMap.put(friends[i], i);
        }

        int[][] giftTable = new int[friends.length][friends.length];
        int[] giftIndexes = new int[friends.length];

        for (String giftRecord: gifts) {
            String[] parts = giftRecord.split(" ");
            int giverIndex = friendIndexMap.get(parts[0]);
            int receiverIndex = friendIndexMap.get(parts[1]);

            giftTable[giverIndex][receiverIndex]++;
        }

        for (int i = 0; i < friends.length; i++) {
            int totaleGiven = 0;
            int totalReceived = 0;

            for (int j = 0; j < friends.length; j++) {
                totaleGiven += giftTable[i][j];
            }

            for (int j = 0; j < friends.length; j++) {
                totalReceived += giftTable[j][i];
            }

            giftIndexes[i] = totaleGiven - totalReceived;
        }

        int[] nextMonthGifts = new int[friends.length];
        for (int i = 0; i < friends.length; i++) {
            for (int j = i + 1; j < friends.length; j++) {
                int giftsFromIToJ = giftTable[i][j];
                int giftsFromJToI = giftTable[j][i];

                if (giftsFromIToJ > giftsFromJToI) {
                    nextMonthGifts[i]++;
                } else if (giftsFromJToI > giftsFromIToJ) {
                    nextMonthGifts[j]++;
                } else {
                    if (giftIndexes[i] > giftIndexes[j]) {
                        nextMonthGifts[i]++;
                    } else if (giftIndexes[j] > giftIndexes[i]) {
                        nextMonthGifts[j]++;
                    }
                }
            }
        }

        for (int num: nextMonthGifts) {
            if (num > answer) {
                answer = num;
            }
        }

        return answer;
    }
}
