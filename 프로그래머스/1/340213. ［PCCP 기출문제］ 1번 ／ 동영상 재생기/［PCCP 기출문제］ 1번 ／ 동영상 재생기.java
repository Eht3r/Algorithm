import java.util.stream.Stream;

class Solution {
    /*
        Programmers. 동영상 재생기
        ---------------------------

        [문제 설명]
        prev
        - 10초 전으로 이동
        - 현재 재생 위치가 10초 미만 인 경우 처음 워치(0분 0초)로 이동

        next
        - 10초 후로 이동
        - 동영상의 남은 시감이 10초 미만인 경우 영상의 마지막 위치(영상 길이와 동일)로 이동

        오프닝 건너뛰기
        - 현재 재생 위치가 오프닝 구간(op_start <= 현재 재생 위치 <= op_end)인 경우 자동으로 오프닝이 끝나는 위치로 이동

        [입력]
        video_len: 동영상의 길이를 나타내는 문자열
        pos: 기능이 수행되기 직전의 재생위치를 나타내는 문자열
        op_start: 오프닝 시작 시각을 나타내는 문자열
        op_end: 오프닝이 끝나는 시각을 나타내는 문자열
        commands: 사용자의 입력을 나타내는 1차원 배열

        [출력]
        사용자의 입력이 모두 끝난 후 동영상의 위치를 "mm:ss" 형식으로 출력

        [제한사항]
        video_len의 길이 = pos의 길이 = op_start의 길이 = op_end의 길이 = 5
        - video_len, pos, op_start, op_end는 "mm:ss" 형식으로 mm분 ss초를 나타냄
        - 0 <= mm <= 59, 0 <= ss <= 59
        - 분, 초가 한자리일 경우 0을 붙여 두 자리로 나타냄
        1 <= commands의 길이 <= 100
        - commands의 원소는 "prev" 혹은 "next"
    */
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int videoLenSec = toSecond(video_len);
        int posSec = toSecond(pos);
        int opStartSec = toSecond(op_start);
        int opEndSec = toSecond(op_end);

        for (String command : commands) {
            if (opStartSec <= posSec  && posSec <= opEndSec) {
                posSec = opEndSec;
            }

            if ("prev".equals(command)) {
                posSec = (posSec < 10) ? 0 : posSec - 10;
            } else if ("next".equals(command)) {
                posSec = (videoLenSec - posSec < 10) ? videoLenSec : posSec + 10;
            }

            if (opStartSec <= posSec  && posSec <= opEndSec) {
                posSec = opEndSec;
            }
        }

        return toTimeFormat(posSec);
    }

    private int toSecond(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }

    private String toTimeFormat(int second) {
        int minute = second / 60;
        int secs = second % 60;
        return String.format("%02d:%02d", minute, secs);
    }
}