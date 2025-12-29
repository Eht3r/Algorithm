import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Queue<int[]> queue = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());

                queue.add(new int[] {j, num});
            }

            int cnt = 0;
            while (true) {
                int[] cur = queue.poll();
                boolean check = true;

                for (int[] curQ: queue) {
                    if (curQ[1] > cur[1]) {
                        check = false;
                        break;
                    }
                }
                if (check) {
                    cnt++;
                    if (cur[0] == M) break;
                } else {
                    queue.add(cur);
                }
            }
            bw.write(String.valueOf(cnt) + "\n");
        }
        
        bw.flush();
        bw.close();
    }
}
