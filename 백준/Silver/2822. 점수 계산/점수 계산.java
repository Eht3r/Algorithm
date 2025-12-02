import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    /*
     * 백준. 2822번: 점수 계산
     * ---------------------
     *  
     * [문제 설명]
     * 퀴즈쇼의 참가자는 총 8개 문제를 푼다
     * 참가자는 각 문제를 풀고, 그 문제를 풀었을 때 얻는 점수는 문제를 풀기 시작한 시간부터 경과한 시간과 난이도로 결정
     * 문제를 풀지 못한 경우에는 0점
     * 참가자의 총 점수는 가장 높은 점수 5개의 합
     * 
     * [입력]
     * 8개 줄에 걸쳐서 각 문제에 대한 참가자의 점수가 주어짐
     * 둘째 줄부터 N개의 줄에는 수가 주어짐
     * 입력으로 주어지는 순서대로 1번 문제, 2번 문제, ... 8번 문제
     * 
     * [출력]
     * 첫째 줄에 참가자의 총점을 출력
     * 둘째 줄에는 어떤 문제가 최종 점수에 포함되는지를 공백으로 구분하여 출력
     * 출력은 문제 번호가 증가하는 순서
     * 
     * [제한사항]
     * 점수는 0보다 크거나 같고, 150보다 작거나 같음
     * 모든 문제에 대한 점수는 서로 다름
     */
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] scores = new int[8];
        for (int i = 0; i < 8; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }

        Integer[] sortedScores = Arrays.stream(scores.clone()).boxed().toArray(Integer[]::new);
        Arrays.sort(sortedScores, Collections.reverseOrder());

        int sum = 0;
        int[] problemNo = new int[5];
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 8; j++) {
                if (sortedScores[i] == scores[j]) {
                    sum += sortedScores[i];
                    problemNo[i] = ++j;
                    break;
                }
            }
        }

        Arrays.sort(problemNo);

        bw.write(String.valueOf(sum));
        bw.newLine();
        for (int num : problemNo) {
            bw.write(String.valueOf(num + " "));
        }

        bw.flush();
        bw.close();
    }
}
