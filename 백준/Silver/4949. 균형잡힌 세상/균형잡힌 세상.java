import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String str = br.readLine();

            if (".".equals(str)) {
                break;
            }

            Stack<Character> stack = new Stack<>();
            boolean isValid = true;

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                if ((c == '(') || (c == '[')) {
                    stack.push(c);
                } else if ((c == ')') || (c == ']')) {
                    if (stack.empty()) {
                        isValid = false;
                        break;
                    } else {
                        char top = stack.peek();

                        if ((c == ')' && top == '(') || (c == ']' && top == '[')) {
                            stack.pop();
                        } else {
                            isValid = false;
                            break;
                        }
                    }
                }
            }

            if (isValid && stack.empty()){
                bw.write("yes\n");
            } else {
                bw.write("no\n");
            }
        }

        bw.flush();
        bw.close();
    }
}
