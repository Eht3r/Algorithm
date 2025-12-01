import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    /*
     * 백준. 1015번: 수열 정렬
     * ---------------------
     * 
     * [문제 설명]
     * P[0], P[1], ...., P[N-1]은 0부터 N-1까지(포함)의 수를 한 번씩 포함하고 있는 수열
     * 수열 P를 길이가 N인 배열 A에 적용하면 길이가 N인 배열 B가 됨
     * 적용하는 방법은 B[P[i]] = A[i]
     * 
     * 배열 A가 주어졌을 때, 수열 P를 적용한 결과가 비내림차순이 되는 수열을 찾는 프로그램을 작성
     * 비내림차순 = 오름차순
     * 만약, 이러한 수열이 여러개면 사전순
     * 
     * [입력]
     * 첫째 줄에 배열 A의 크기 N이 주어짐
     * 둘째 줄에는 배열 A의 원소가 0번부터 차례대로 주어짐
     * 
     * [출력]
     * 첫째 줄에 비내림차순으로 만드는 수열 P를 출력한다.
     * 
     * [제한사항]
     * N은 50보다 작거나 같은 자연수
     * 배열의 원소는 1,000보다 작거나 같은 자연수
     */

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        int[] sortedArr = new int[N];
        
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sortedArr = arr.clone();

        Arrays.sort(sortedArr);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i] == sortedArr[j]) {
                    sortedArr[j] = -1;
                    bw.write(String.valueOf(j + " "));
                    break;
                }
            }
        }

        bw.flush();
        bw.close();
    }
}
