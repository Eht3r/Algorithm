import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long nextNum = 0;

        for (int i = 0; i < 3; i++) {
            String input = br.readLine();

            char ch = input.charAt(0);
            if(Character.isDigit(ch)) {
                long num = Long.parseLong(input);
                nextNum = num + (3 - i);
            }
        }

        if (nextNum % 15 == 0) bw.write("FizzBuzz");
        else if(nextNum % 3 == 0) bw.write("Fizz");
        else if(nextNum % 5 == 0) bw.write("Buzz");
        else bw.write(String.valueOf(nextNum));

        bw.flush();
        bw.close();
    }
}
