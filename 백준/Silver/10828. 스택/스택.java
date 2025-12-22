import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

       Stack<Integer> stack = new Stack<>();
       int N = Integer.parseInt(br.readLine());

       for (int i = 0; i < N; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());

        String str = st.nextToken();
        switch (str) {
            case "push":
                int num = Integer.parseInt(st.nextToken());
                stack.push(num);
                break;
            case "pop":
                bw.write(String.valueOf(stack.isEmpty() ? -1 : stack.pop()) + "\n");
                break;
            case "size":
                bw.write(String.valueOf(stack.size()) + "\n");
                break;
            case "empty":
                bw.write(String.valueOf(stack.empty() ? 1 : 0) + "\n");;
                break;
            case "top":
                bw.write(String.valueOf(stack.empty() ? -1 : stack.peek()) + "\n");
            default:
                break;
        }
       }

        bw.flush();
        bw.close();
    }
}
