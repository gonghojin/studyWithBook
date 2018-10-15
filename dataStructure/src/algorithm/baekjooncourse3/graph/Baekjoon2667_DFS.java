package algorithm.baekjooncourse3.graph;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon2667_DFS {

    public static final int[] dx = {0, 0, -1, 1};
    public static final int[] dy = {-1, 1, 0, 0};

    public static void dfs(int[][] a, int[][] group, int x, int y, int cnt, int n) {
        if (group[x][y] > 0) {
            return;
        }
        group[x][y] = cnt;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                if (a[nx][ny] == 1) {
                    dfs(a, group, nx, ny, cnt, n);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < n; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }

        int[][] group = new int[n][n];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 1 && group[i][j] == 0) {
                    dfs(a, group, i, j, ++cnt, n);
                }
            }
        }

        int[] ans = new int[cnt];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int su = group[i][j];
                if (su > 0) {
                    ans[su-1] += 1;
                }
            }
        }

        Arrays.sort(ans);
        System.out.println(cnt);
        for (int x : ans) {
            System.out.println(x);
        }
    }
}


