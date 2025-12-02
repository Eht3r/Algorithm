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

public class Main {
    /*
     * 백준. 2628번: 종이자르기
     * ----------------------
     *  
     * [문제 설명]
     * 가로 점선을 따라 자르는 경우는 종이의 왼쪽 끝에서 오른쪽 끝까지, 세로 점선인 경우는 위쪽 끝에서 아래쪽 끝까지 한 번에 자른다
     * 
     * [입력]
     * 첫줄에는 종이의 가로와 세로의 길이가 차례로 자연수로 주어짐
     * 둘째 줄에는 칼로 잘라야하는 점선의 개수가 주어짐
     * 셋째 줄부터 마지막 줄까지 한 줄에 점선이 하나씩 아래와 같은 방법으로 입력됨
     * 가로로 자르는 점선은 0과 점선 번호가 차례로 주어지고, 세로로 자르는 점선은 1과 점선 번호가 주어짐
     * 입력되는 두 숫자 사이에는 빈 칸이 하나씩 있음
     * 
     * [출력]
     * 첫째 줄에 가장 큰 종이 조각의 넓이를 출력
     * 단위 생략
     * 
     * [제한사항]
     * 가로와 세로의 길이는 최대 100cm
     */
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int cnt = Integer.parseInt(br.readLine());

        List<Integer> wList = new ArrayList<>();
        List<Integer> hList = new ArrayList<>();

        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            
            switch (dir) {
                case 0:
                    wList.add(num);
                    break;
                case 1:
                    hList.add(num);
                    break;
            }
        }

        wList.add(h);
        wList.add(0);
        hList.add(w);
        hList.add(0);

        Collections.sort(wList, Collections.reverseOrder());
        Collections.sort(hList, Collections.reverseOrder());

        int wLastIndex = wList.size() - 1;
        int hLastIndex = hList.size() - 1;

        int hLength = 0;
        int maxHLength = 0;

        for (int i = 0; i < wLastIndex; i++) {
            hLength = wList.get(i) - wList.get(i + 1);
            if (maxHLength < hLength) {
                maxHLength = hLength;
            }
        }

        int wLength = 0;
        int maxWLength = 0;
        for (int i = 0; i < hLastIndex; i++) {
            wLength = hList.get(i) - hList.get(i + 1);

            if (maxWLength < wLength) {
                maxWLength = wLength;
            }
        }

        bw.write(String.valueOf(maxHLength * maxWLength));
        bw.flush();
        bw.close();
    }
}
