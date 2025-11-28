import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    /*
     * 백준. 4963번: 섬의 개수
     * ---------------------
     * 
     * [문제 설명]
     * 정사각형으로 이루어진 섬과 바다 지도가 주어질 때, 섬의 개수는?
     * 
     * 한 정사각형과 가로, 세로 또는 대각선으로 연결되어 있는 사각형은 걸어갈 수 있는 사각형
     * 두 정사각형이 같은 섬에 있으려면 한 정사각형에서 다른 정사각형으로 걸어서 갈 수 있는 경로가 있어야 함
     * 지도 밖으로는 못 나감
     * 
     * [입력]
     * 입력은 여러 테스트 케이스로 이루어짐
     * 
     * 각 테스트 케이스의 첫째 줄에는 지도의 너비 w와 h가 주어짐
     * 둘째 줄부터 h개 줄에는 지도가 주어짐. 1은 땅, 0은 바다
     * 입력의 마지막 줄에는 0이 두개 주어짐
     * 
     * [출력]
     * 각각 테스트 케이스에 대해서, 섬의 개수 출력
     * 
     * [제한사항]
     * 0 <= w, h <= 50
     */

    static int w, h;
    static int[][] map;
    static boolean[][] visited;

    // 8방향 백터
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) break;

            map = new int[h][w];
            visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        dfs(i ,j);
                        count++;
                    }
                }
            }
            bw.write(String.valueOf(count));
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < h && ny >= 0 && ny < w) {
                if (map[nx][ny] == 1 && !visited[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }
}
