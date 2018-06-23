package algorithm.baekjooncourse.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// https://www.acmicpc.net/problem/7576
public class Baekjoon7576 {

    public static final int[] dx = {0, 0, 1, -1};
    public static final int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(); // 열
        int n = sc.nextInt(); // 행
        int[][] a = new int[n][m];
        int[][] dist = new int[n][m];
        Queue<Pair4> q = new LinkedList<Pair4>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
                dist[i][j] = -1; // int는 defalut 값이 0인데, 이 문제에서는 0은 첫번째 들어있는 토마토를 위한 값으로 써야함
                if (a[i][j] == 1) {
                    q.add(new Pair4(i, j)); // 토마토가 있는 자리만
                    dist[i][j] = 0; // 있는 자리 = 0
                }
            }
        }

        while (!q.isEmpty()) {
            Pair4 p = q.remove();
            int x = p.x;
            int y = p.y;
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (a[nx][ny] == 0 && dist[nx][ny] == -1) { // 토마토가 존재하고 && 아직 익지 않은
                        q.add(new Pair4(nx, ny));
                        dist[nx][ny] = dist[x][y] + 1;
                    }
                }
            }
        }

        int ans = 0; // 토마토가 처음부터 모두 익은 상황
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (ans < dist[i][j]) { // 토마토가 모두 익은 상황(0)이면 if문 모두 false
                    ans = dist[i][j];
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 0 && dist[i][j] == -1) {
                    ans = -1;
                }
            }
        }
        System.out.println(ans);
    }
}

class Pair4 {
    int x;
    int y;

    public Pair4(int x, int y) {
        this.x = x;
        this.y = y;
    }
}