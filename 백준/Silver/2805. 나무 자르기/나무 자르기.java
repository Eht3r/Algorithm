import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] trees = new int[N];
        int max = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            if (trees[i] > max) {
                max = trees[i];
            }
        }

        long low = 0;
        long high = max;
        long result = 0;

        while (low <= high) {
            long mid = (low + high) / 2;
            long sum = 0;

            for (int tree: trees) {
                if (tree > mid) {
                    sum += (tree - mid);
                }
            }

            if (sum >= M) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
