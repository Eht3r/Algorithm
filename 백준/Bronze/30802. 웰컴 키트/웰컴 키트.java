import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    /*
     * 백준. 30802번: 웰컴 키트
     * ----------------------
     * 
     * [문제 설명]
     * 온사이트 그랜드 아레나에서는 참가자들에게 티셔츠 한 장과 펜 한 자루가 포함된 웰컴 키트를 나눠줄 예정
     * 아래의 조건으로만 키트 제작 업체에 주문 가능
     * 티셔츠는 S, M, L, XL, XXL, 그리고 XXXL의 6가지 사이즈가 있음.
     * 티셔츠는 같은 사이즈의 T장 묶음으로만 주문할 수 있음
     * 펜은 한 종류로, P자루씩 묶음으로 주문하거나 한 자루씩 주문할 수 있음
     * 
     * 총 N명의 참가자 중 S, M, L, XL, XXL, XXXL 사이즈의 티셔츠를 신청한 사람은 각각 S, M, L, XL, XXL,
     * XXXL명
     * 티셔츠는 남아도 되지만 부족해서는 안 되고 신청한 사이즈대로 나눠주어야 함
     * 펜은 남거나 부족해서는 안 되고 정확히 참가자 수만큼 준비되어야 함
     * 
     * 티셔츠를 T장씩 최소 몇 묶음 주문해야 하는지, 그리고 펜을 P자루씩 최대 몇 묶음 주문할 수 있고, 그 때 펜을 한 자루씩 몇 개
     * 주문하는지 구해야 함
     * 
     * [입력]
     * 첫 줄에 참가자의 수 N이 주어짐
     * 둘째 줄에 티셔츠 사이즈별 신청자의 수 S, M, L, XL, XXL, XXXL이 공백으로 구분되어 주어짐
     * 셋째 줄에 정수 티셔츠와 펜의 묶음 수를 의미하는 정수 T와 P가 공백으로 구분되어 주어짐
     * 
     * [출력]
     * 첫 줄에 티셔츠를 T장씩 최소 몇 묶음 주문해야 하는지 출력
     * 다음 줄에 펜을 P자루씩 최대 몇 묶음 주문할 수 있는지와, 그 때 펜을 한 자루씩 몇 개 주문하는지 구해서 출력
     * 
     * [제한사항]
     * 1 <= N <= 10^9
     * 0 <= S, M, L, XL, XXL, XXXL <= N
     * S + M + L + XL + XXL + XXXL = N
     * 2 <= T, P <= 10^9
     */
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[6];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 6; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int countT = 0;
        for (int i = 0; i < 6; i++) {
            countT += (arr[i] % T == 0) ? arr[i] / T : arr[i] / T + 1;
        }

        bw.write(String.valueOf(countT));
        bw.newLine();
        bw.write(String.valueOf(N / P) + " " + String.valueOf(N % P));

        bw.flush();
        bw.close();
    }
}
