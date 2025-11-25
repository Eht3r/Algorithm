import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    /*
     * 백준. 10815번: 숫자 카드
     * -----------------------
     * 
     * [문제 설명]
     * 숫자 카드: 정수 하나가 적힌 카드
     * 상근이는 숫자 카드 N개를 가짐
     * 정수 M개가 주어졌을 때, 이 숫자 카드가 상근이가 가지고 있는지 아닌지를 구하는 문제
     * 
     * [입력]
     * 첫째 줄에 상근이가 가지고 있는 숫자 카드의 개수 N이 주어짐
     * 둘째 줄에는 숫자카드에 적혀있는 정수가 주어짐
     * 두 숫자 카드에 같은 수가 적혀 있는 경우는 없음
     * 
     * 셋째 줄에는 M이 주어짐
     * 넷째 줄에는 상근이가 가지고 있는 숫자 카드인지 아닌지를 구해야할 M개의 정수가 주어짐
     * M개의 정수는 공백으로 구분
     * 
     * [출력]
     * 첫째 줄에 입력으로 주어진 M개의 수에 개해서, 각 수가 적힌 숫자 카드를 상근이가 가지고 있으면 1, 아니면 0
     * 
     * [제한사항]
     * -1 <= N <= 500,000
     * 1 <= M <= 500,000
     * 
     * 숫자 카드에 적힌 정수는 -10,000,000보다 크거나 같고 10,000,000보다 작거나 같음
     */

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] Ncards = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            Ncards[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] Mcards = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            Mcards[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(Ncards);

        for (int i = 0; i < M; i++) {
            bw.write(String.valueOf(binarySearch(Ncards, 0, Ncards.length - 1, Mcards[i])) + " ");
        }

        bw.flush();
        bw.close();
    }

    private static int binarySearch(int[] arr, int start, int end, int target) {

        if (start > end) {
            return 0;
        } else {
            int mid = (start + end) / 2;

            if (arr[mid] == target) {
                return 1;
            } else if (arr[mid] > target) {
                return binarySearch(arr, start, mid - 1, target);
            } else {
                return binarySearch(arr, mid + 1, end, target);
            }
        }
    }
}
