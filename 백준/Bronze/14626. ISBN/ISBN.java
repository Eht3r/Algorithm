import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();

        int currentSum = 0;
        int starWeight = 0;

        for (int i = 0; i < 13; i++) {
            char ch = input.charAt(i);
            int weight = (i % 2 == 0) ? 1 : 3;

            if(ch == '*') {
                starWeight = weight;
            } else {
                currentSum += (ch - '0') * weight;
            }
        }

        
        for (int i = 0; i <= 9; i++){
            if((currentSum + (i * starWeight)) % 10 == 0) {
                bw.write(String.valueOf(i));
                break;
            }
        }
        bw.flush();
        bw.close();
    }
}
