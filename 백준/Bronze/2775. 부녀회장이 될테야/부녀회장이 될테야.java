import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] apt = new int[15][15];

        for (int i = 1; i < 15; i++) {
            apt[0][i] = i;
        }

        for (int i = 1; i < 15; i++) {
            for (int j = 1; j < 15; j++) {
                apt[i][j] = apt[i][j - 1] + apt[i - 1][j];
            }
        }

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++){
            int K = Integer.parseInt(br.readLine());
            int N = Integer.parseInt(br.readLine());
            
            bw.write(String.valueOf(apt[K][N]));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
