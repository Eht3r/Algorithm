import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input = 0;
        while ((input = Integer.parseInt(br.readLine())) != 0) {
            int low = 1;
            int high = 50;

            while (true) {
                int mid = (low + high) / 2;
                bw.write(String.valueOf(mid + " "));

                if (mid == input) {
                    break;
                } else if (mid < input) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            bw.newLine();
            bw.flush();
        }
        bw.close();
    }
}

