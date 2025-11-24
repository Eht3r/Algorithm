import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    /*
     * 백준. 9953번: Paula's search
     * -----------------------
     * 
     * [문제 설명]
     * 무도회에 입고갈 완벽한 드레스를 파는 상점 찾기
     * 거리에 100개의 상점이 길 양쪽으로 고르게 분포됨
     * 한쪽에는 홀수, 다른 한쪽은 짝수 번호의 상점
     * 
     * 항상 짝수 번 도로 한가운데의 50번 가게부터 탐색을 시작하여 아래의 정보들로 가게를 찾음
     * 
     * 1. 네, 당신에게 딱 맞는 드레스가 있어요!
     * 2. 당신은 도로의 잘못된 쪽에 있습니다. 건너세요.
     * 3. 거리의 이쪽(번호가 낮은 상점들 사이)을 살펴보세요.
     * 4. 길의 이쪽(번호가 높은 상점들 사이)을 찾아보셔야 합니다.
     * 
     * 1번 답을 얻으면 드레스 구매 후 집으로 복귀.
     * 2 ~ 4번 답을 얻으면, 항상 찾아야 할 상점 블록의 중간 지점으로 이동(상점의 수가 짝수이면 가운데 두 상점 중 번호가 낮은 곳으로)
     * 
     * [입력]
     * 입력은 여러 시나리오로 구성되며, 각 시나리오는 완벽한 분홍색 볼 드레스를 찾을 수 있는 가게의 번호를 나타내는 1에서 100 사이의
     * 정수로 한 줄에 하나씩 표시.
     * 입력은 0으로 끝나므로, 이 줄은 처리되지 않음.
     * 
     * [출력]
     * 출력은 각 줄에 대해 하나의 정수(한 줄에 하나씩)로 출력. 이 정수는 Paula가 드레스를 사기 위해 방문해야 했던 상점의 수.
     * 
     */

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Integer> oddArr = new ArrayList<>();
        List<Integer> evenArr = new ArrayList<>();

        for (int i = 1; i < 101; i++) {
            if (i % 2 != 0) {
                oddArr.add(i);
            } else {
                evenArr.add(i);
            }
        }


        int input = -1;
        while ((input = Integer.parseInt(br.readLine())) != 0) {

            List <Integer> arr;
            int count = 1;

            if (input % 2 == 0) {
                arr = evenArr;
            } else {
                arr = oddArr;
                count++;
            }

            int start = 0;
            int end = arr.size() - 1;

            while (start <= end) {
                int mid = (start + end) / 2;
                int stop = arr.get(mid);

                if (stop == input) {
                    bw.write(String.valueOf(count));
                    bw.newLine();
                    bw.flush();
                    break;
                } else {
                    if (stop > input) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                    count++;
                }
            }
        }
    }
}
