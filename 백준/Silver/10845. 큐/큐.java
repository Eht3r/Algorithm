import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Deque<Integer> queue = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String str = st.nextToken();
            switch (str) {
                case "push":
                    int num = Integer.parseInt(st.nextToken());
                    queue.addLast(num);
                    break;
                case "pop":
                    bw.write(String.valueOf(queue.isEmpty() ? -1 : queue.pollFirst()) + "\n");
                    break;
                case "size":
                    bw.write(String.valueOf(queue.size()) + "\n");
                    break;
                case "empty":
                    bw.write(String.valueOf(queue.isEmpty() ? 1 : 0) + "\n");
                    ;
                    break;
                case "top":
                    bw.write(String.valueOf(queue.isEmpty() ? -1 : queue.peek()) + "\n");
                    break;
                case "front":
                    bw.write(String.valueOf(queue.isEmpty() ? -1 : queue.peekFirst()) + "\n");
                    break;
                case "back":
                    bw.write(String.valueOf(queue.isEmpty() ? -1 : queue.peekLast()) + "\n");
                    break;
                default:
                    break;
            }
        }

        bw.flush();
        bw.close();
    }
}
