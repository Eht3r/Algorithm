import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr_A;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        arr_A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr_A[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] arr_B = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr_B[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr_A);

        for (int i = 0; i < M; i++) {
            int key = arr_B[i];
            bw.write(String.valueOf(find(key, 0, N -1)));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    static int find(int key, int low, int high) {
        int mid;

        if(low <= high) {
            mid = (low + high) / 2;

            if (key == arr_A[mid]) {
                return 1;
            } else if (key < arr_A[mid]) {
                return find(key, low, mid - 1);
            } else {
                return find(key, mid + 1, high);
            }
        }

        return 0;
    }
}
