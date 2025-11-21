import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
    /*
     * 백준. 1012번: 유기농 배추
     * -----------------------
     * 
     * [문제 설명]
     * 서로 인접한 배추 마다 배추흰지렁이 1마리씩 필요
     * 
     * [입력]
     * 첫줄
     * T:테스트 케이스의 개수
     * 
     * 각 테스트 케이스에 대해서
     * M: 배추를 심은 배추밭의 가로길이
     * N: 배추를 심은 배추밭의 세로길이
     * K: 배추가 심어져 있는 위치의 개수
     * 이후 K 줄에는 배추의 위치 (X, Y)가 주어짐
     * (0 <= X <= M-1, 0 <= Y <= N-1)
     * 
     * [출력]
     * 각 테스트 케이스에 대해 필요한 최소의 배추흰지렁이 마리 수를 출력
     */

    static int M, N, K;
    static int[][] field;
    static boolean[][] visited;

    // 4방향 백터
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String[] input = br.readLine().split(" ");

            M = Integer.parseInt(input[0]);
            N = Integer.parseInt(input[1]);
            K = Integer.parseInt(input[2]);

            // 배추가 심어져 있으면 1, 없으면 0
            field = new int[N][M];
            visited = new boolean[N][M];

            // 최종 배추흰지렁이 개수
            int count = 0;

            for (int j = 0; j < K; j++) {
                String[] position = br.readLine().split(" ");

                int x = Integer.parseInt(position[0]);
                int y = Integer.parseInt(position[1]);
                field[y][x] = 1;
            }

            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if (field[y][x] == 1 && !visited[y][x]) {
                        dfs(y, x);
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

    static void dfs(int y, int x) {
        visited[y][x] = true;

        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];

            if (0 <= ny && ny < N &&
                    0 <= nx && nx < M &&
                    field[ny][nx] == 1 &&
                    !visited[ny][nx]) {
                dfs(ny, nx);
            }
        }
    }
}