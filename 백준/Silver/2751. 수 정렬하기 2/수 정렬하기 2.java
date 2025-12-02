import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    /*
     * 백준. 2751번: 수 정렬하기 2
     * -------------------------
     *  
     * [문제 설명]
     * N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
     * 
     * [입력]
     * 첫째 줄에 수의 개수 N아 주어짐
     * 둘째 줄부터 N개의 줄에는 수가 주어짐
     * 
     * [출력]
     * 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
     * 
     * [제한사항]
     * 1 ≤ N ≤ 1,000,000
     * 주어지는 수는 절댓값이 1,000,000보다 작거나 같은 정수
     */
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            bw.write(String.valueOf(arr[i]));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
