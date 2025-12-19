import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int count = -1;

        for (int i = 0; i <= N / 3; i++) {
            int num = N - (3 * i);
            if (num % 5 == 0){
                count = i + (num / 5);
                break;
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}
