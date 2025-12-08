import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    /*
     * 백준. 1931번: 회의실 배정
     * ---------------------
     *  
     * [문제 설명]
     * 한 개의 회의실에 대해 이를 사용하고자 하는 N개의 회의에 대한 회의실 사용표 작성
     * 각 회의 I에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 회의의 최대 개수를 찾자
     * 
     * [입력]
     * 첫째 줄에 회의의 수 N이 주어짐
     * 둘째 줄부터 N+1 줄까지 각 회의의 정보가 주어짐
     * 공백을 사이에 두고 회의의 시작시간과 끝나느 시간이 주어짐
     * 
     * [출력]
     * 첫째 줄에 최대 사용할 수 있는 회의의 최대 개수를 출력
     * 
     * [제한사항]
     * 1 ≤ N ≤ 100,000
     * 시작 시간과 끝나는 시간은 231-1보다 작거나 같은 자연수 또는 0
     */
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] schedule = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            schedule[i][0] = Integer.parseInt(st.nextToken());
            schedule[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(schedule, (o1, o2) -> {
            if (o1[1] == o2[1]) return o1[0] - o2[0];
            else return o1[1] - o2[1];
        });

        int prev_end_time = 0;
        int count = 0;

        for (int i = 0; i < N; i++) {
            if (prev_end_time <= schedule[i][0]) {
                prev_end_time = schedule[i][1];
                count++;
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}
