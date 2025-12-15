import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static Integer[][] dp;
    static int[] W;
    static int[] V;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        W = new int[N];
        V = new int[N];
        dp = new Integer[N][K + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(String.valueOf(backpack(N - 1, K)));
        bw.flush();
        bw.close();
    }

    static int backpack(int i, int k) {
        if (i < 0) return 0;

        if (dp[i][k] == null) {
            if (W[i] > k) {
                dp[i][k] = backpack(i - 1, k);
            } else {
                dp[i][k] = Math.max(backpack(i - 1, k), backpack(i - 1, k - W[i]) + V[i]);
            }
        }

        return dp[i][k];
    }
}
