import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

class Student implements Comparable<Student> {
    int countryCode;
    int studentId;
    int score;

    public Student(int countryCode, int studentId, int score) {
        this.countryCode = countryCode;
        this.studentId = studentId;
        this.score = score;
    }

    @Override
    public int compareTo(Student other) {
        return other.score - this.score;
    }
}

public class Main {
    /*
     * 백준. 2535번: 아시아 정보올림피아드
     * --------------------------------
     * 
     * [문제 설명]
     * 참여한 학생들의 성적순서대로 세 명에게만 금, 은, 동메달을 수여
     * 단, 동점자는 없다고 가정
     * 나라별 메달 수는 최대 두 개
     * 
     * [입력]
     * 첫 번째 줄에는 대회참가 학생 수를 나타내는 N이 주어짐
     * 두 번째 줄부터 N개의 줄에는 각 줄마다 한 학생의 소속 국가 번호, 학생 번호, 그리고 성적이 하나의 빈칸을 사이에 두고 주어짐
     * 입력으로 제공되는 국가는 적어도 두 나라 이상
     * 
     * [출력]
     * 메달을 받는 학생들을 금, 은, 동메달 순서대로 한 줄에 한 명씩 출력
     * 즉, 첫 번째 줄에는 금메달 수상자를, 두 번째 줄에는 은메달 수상자를, 세 번째 줄에는 동메달 수상자를 출력
     * 하나의 줄에는 소속국가 번호와 학생 번호를 하나의 빈칸을 사이에 두고 출력 
     * 
     * [제한사항]
     * 3 ≤ N ≤ 10
     * 국가 번호는 1부터 순서대로 하나의 정수
     * 각 학생번호는 각 나라별로 1부터 순서대로 하나의 정수
     * 점수는 0 이상 1000 이하의 정수
     */
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        List<Student> list = new ArrayList<>();

        for (int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int countryCode = Integer.parseInt(st.nextToken());
            int studentId = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());

            list.add(new Student(countryCode, studentId, score));
        }

        Collections.sort(list);

        int medalsGiven = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (Student s : list) {
            if (medalsGiven > 2) break;

            int currentCnt = map.getOrDefault(s.countryCode, 0);

            if (currentCnt < 2){
                String result = s.countryCode + " " + s.studentId + "\n";

                bw.write(result);
                map.put(s.countryCode, currentCnt + 1);
                medalsGiven++;
            }
        }

        bw.flush();
        bw.close();
    }
}
