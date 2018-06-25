package algorithm.baekjooncourse.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// https://www.acmicpc.net/problem/2146
public class Baekjoon2146 {
    public static final int[] dx = {0, 0, 1, -1};
    public static final int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][n]; // 섬을 담을 배열
        int[][] d = new int[n][n];
        int[][] g = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) { // 섬 만들기 + 섬 구분하기
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 1 && g[i][j] == 0) {
                    Queue<Pair5> q = new LinkedList<Pair5>();
                    g[i][j] = ++cnt; // 섬 구분
                    q.add(new Pair5(i, j));
                    while (!q.isEmpty()) {
                        Pair5 p = q.remove();
                        int x = p.x;
                        int y = p.y;
                        for (int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];
                            if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                                if (a[nx][ny] == 1 && g[nx][ny] == 0) {
                                    q.add(new Pair5(nx, ny));
                                    g[nx][ny] = cnt;
                                }

                            }
                        }
                    }
                }
            }
        }
        // 최소 거리의 다리 찾기
        int ans = -1;
        for (int z = 1; z <= cnt; z++) {
            Queue<Pair5> q = new LinkedList<Pair5>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    d[i][j] = -1;
                    if (g[i][j] == z) { // 각 섬 출발점
                        q.add(new Pair5(i, j));
                        d[i][j] = 0;
                    }
                }
            }
            while (!q.isEmpty()) {
                Pair5 p = q.remove();
                int x = p.x;
                int y = p.y;
                for (int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                        if (d[nx][ny] == -1) { // 비어있는 섬
                            d[nx][ny] = d[x][y] + 1;
                            q.add(new Pair5(nx, ny));
                        }
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (a[i][j] == 1 && g[i][j] != z) {
                        if (ans == -1 || d[i][j] - 1 < ans) {
                            ans = d[i][j] - 1;
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }

}

class Pair5 {
    int x;
    int y;

    public Pair5(int x, int y) {
        this.x = x;
        this.y = y;
    }
}