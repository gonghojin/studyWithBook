package algorithm.baekjooncourse3.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon2667_DFS {

    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {-1, 1, 0, 0};
    private static int[][] d;
    private static int[][] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        d = new int[n][n];
        for (int x = 0; x < n; x++) {
            String line = br.readLine();
            for (int y = 0; y < n; y++) {
                d[x][y] = line.charAt(y) - '0';
            }
        }

        check = new int[n][n];
        int cnt = 0;
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (check[x][y] == 0 && d[x][y] == 1) {
                    dfs(n, x, y, ++cnt);
                }
            }
        }

        int[] as = new int[cnt];
        for (int[] x: check) {
            for (int y : x) {
                if (0 < y) {
                    as[y - 1]++;
                }
            }
        }
        Arrays.sort(as);

        System.out.println(cnt);
        for (int x : as) {
            System.out.println(x);
        }
    }

    public static void dfs(int n, int x, int y, int cnt) {
        if (check[x][y] != 0) {
            return;
        }
        check[x][y] = cnt;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                if (check[nx][ny] == 0 && d[nx][ny] == 1) {
                    dfs(n, nx, ny, cnt);
                }
            }
        }
    }
}
