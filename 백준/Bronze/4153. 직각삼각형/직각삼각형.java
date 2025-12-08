import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main { // 직각삼각형
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            long[] side = new long[3];
            side[0] = Long.parseLong(st.nextToken());
            side[1] = Long.parseLong(st.nextToken());
            side[2] = Long.parseLong(st.nextToken());

            if (side[0] == 0 && side[1] == 0 & side[2] == 0) {
                break;
            }

            Arrays.sort(side);
            if (side[0] * side[0] + side[1] * side[1] == side[2] * side[2]) {
                bw.write("right\n");
            } else {
                bw.write("wrong\n");
            }
        }

        bw.flush();
        bw.close();
    }
}
