import java.util.Arrays;
import java.util.Collections;

public class Solution {
    /*
        [문제]
        - 지민이가 깔 수 있는 가장 큰 돗자리의 한 변 길이를 반환
        - 아무것도 깔 수 없으면 -1 반환

        [입력]
        - mats:  지민이가 가진 정사각형 모양의 돗자리들의 한 변의 길이들이 담긴 정수 리스트
        - park: 현재 공원의 자리 배치도를 의미하는 2차원 문자열 리스트

        [제한사항]
        1 <= mats의 길이 <= 10
        - 1 <= mats의 원소 <= 20
        - mats는 중복된 원솔르 가지지 않음
        1 <= park의 길이 <= 50
        - 1<= park[i]의 길이 <= 50
        - park[i][j]의 원소는 문자열
        - park[i][j]에 돗자리를 깐 사람이 없다면 "-1", 사람이 있다면 알파벳 한 글자로 된 값을 가짐
     */
    public int solution(int[] mats, String[][] park) {
        Integer[] matsInteger = Arrays.stream(mats).boxed().toArray(Integer[]::new);
        Arrays.sort(matsInteger, Collections.reverseOrder());

        int parkHeight = park.length;
        int parkWidth = park[0].length;

        for (int matSize : matsInteger) {
            if (matSize > parkHeight || matSize > parkWidth) {
                continue;
            }

            for (int i = 0; i <= parkHeight - matSize; i++) {
                for (int j = 0; j <= parkWidth - matSize; j++) {
                    if (canPlace(park, i, j, matSize)) {
                        return matSize;
                    }
                }
            }
        }

        return -1;
    }

    private boolean canPlace(String[][] park, int startRow, int startCol, int size) {
        for (int i = startRow; i < startRow + size; i++) {
            for (int j = startCol; j < startCol + size; j++) {
                if (!park[i][j].equals("-1")) {
                    return false;
                }
            }
        }
        return true;
    }
}