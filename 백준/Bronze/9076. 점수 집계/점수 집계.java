import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    /*
     * 백준. 9076번: 점수 집계
     * ---------------------
     * 
     * [문제 설명]
     * 5명의 심판의 점수 중 최고점과 최저점을 뺀 나머지 3명의 점수에서
     * 최고점 - 최저점 >= 4인 경우 점수 조정
     * 
     * [입력]
     * 첫 줄에는 테스트 케이스의 개수 T가 주어짐
     * 각 테스트 케이스에는 한 줄에 다섯 심판이 준 5개의 정수가 하나의 공백을 두고 주어짐
     * 
     * [출력]
     * 각 테스트 케이스에 대해서 총점을 한 줄씩 출력
     * 만일 점수 조정을 거쳐서 다시 점수를 매기려는 경우에는 'KIN'을 출력
     * 
     * [제한사항]
     * 1 <= T <= 10
     * 각 심판의 점수는 10점 이하의 양의 정수
     */

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] scores = new int[5];

            for (int j = 0; j < 5; j++) {
                scores[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(scores);

            if (scores[3] - scores[1] > 3) {
                bw.write("KIN");
            } else {
                int sum = scores[1] + scores[2] + scores[3];
                bw.write(String.valueOf(sum));
            }

            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}