package algorithm.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// https://www.acmicpc.net/problem/4963
public class Baekjoon4963 {

    public static final int[] dx = {0, 0, 1, -1, 1, 1, -1, -1};
    public static final int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};

    private static void bfs(int[][] a, int[][] group, int x, int y, int cnt, int n, int m) {
        Queue<Pair2> q = new LinkedList<Pair2>();
        q.add(new Pair2(x, y));
        while (!q.isEmpty()) {
            Pair2 p = q.remove();
            x = p.x;
            y = p.y;

            for (int i = 0; i < 8; i++) { // 상하좌우 대각선 총 8번
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (a[nx][ny] == 1 && group[nx][ny] == 0) {
                        q.add(new Pair2(nx, ny));
                        group[nx][ny] = cnt;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int m = sc.nextInt(); //  너비
            int n = sc.nextInt(); // 높이
            if (m == 0 && n == 0) { // 종료
                break;
            }
            int[][] a = new int[n][m]; // 섬 크기
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    a[i][j] = sc.nextInt();
                }
            }
            int cnt = 0; // 섬 개수
            int[][] group = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (a[i][j] == 1 && group[i][j] == 0) {
                        bfs(a, group, i, j, ++cnt, n, m);
                    }
                }
            }
            System.out.println(cnt);
        }
    }

}

class Pair2 {
    int x;
    int y;

    public Pair2(int x, int y) {
        this.x = x;
        this.y = y;
    }
}