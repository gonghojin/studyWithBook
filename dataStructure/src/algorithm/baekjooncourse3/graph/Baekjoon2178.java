package algorithm.baekjooncourse3.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Baekjoon2178_Pair {
    int x;
    int y;

    public Baekjoon2178_Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Baekjoon2178 {
    public static final int[] dx = {0, 0, -1, 1};
    public static final int[] dy = {-1, 1, 0, 0};

    public static int[][] d;
    public static int[][] check;

    public static void bfs(final int x, final int y) {
        Queue<Baekjoon2178_Pair> queue = new LinkedList<>();
        queue.add(new Baekjoon2178_Pair(0, 0));
        while (!queue.isEmpty()) {
            Baekjoon2178_Pair pair = queue.poll();
            int cx = pair.x;
            int cy = pair.y;
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (0 <= nx && nx < x && 0 <= ny && ny < y) {
                    if (d[nx][ny] == 1 && check[nx][ny] == 0) {
                        queue.add(new Baekjoon2178_Pair(nx, ny));
                        check[nx][ny] = check[cx][cy] + 1;
                    }
                }

            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String lineOutter = br.readLine();
        int n = lineOutter.charAt(0) - '0';
        int m = lineOutter.charAt(2) - '0';

        d = new int[n][m];
        for (int i = 0; i < n; i++) {
            String lineInner = br.readLine();
            for (int j = 0; j < m; j++) {
                d[i][j] = lineInner.charAt(j) - '0';
            }
        }

        check = new int[n][m];
        check[0][0] = 1;
        bfs(n, m);

        System.out.println(check[n - 1][m - 1]);
    }

}
