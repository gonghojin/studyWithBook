package algorithm.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// https://www.acmicpc.net/problem/2178
public class Baekjoon2178 {

    public static final int[] dx = {0, 0, 1, -1};
    public static final int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 행 수
        int m = sc.nextInt(); // 열 수
        int[][] a = new int[n][m];
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < m; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }

        int[][] dist = new int[n][m];
        boolean[][] check = new boolean[n][m];
        Queue<Pair3> q = new LinkedList<Pair3>();
        q.add(new Pair3(0, 0));
        check[0][0] = true;
        dist[0][0] = 1;

        while (!q.isEmpty()) {
            Pair3 p = q.remove();
            int x = p.x;
            int y = p.y;
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (check[nx][ny] == false && a[nx][ny] == 1) {
                        q.add(new Pair3(nx, ny));
                        check[nx][ny] = true;
                        dist[nx][ny] = dist[x][y] + 1; // 기준 a[x][y] 의 상하좌우이니
                    }
                }
            }
        }
        /**
         * Queue는 FIFO이므로 먼저 들어간 Pair 객체에 의해서 만들어진, dist[n-1][n-1이 최단 거리가 됨
         * 따라서, 별도의 거리 구분 코드가 필요하지 않음
         */
        System.out.println(dist[n-1][m-1]);
    }
}
class Pair3{

    int x;
    int y;

    public Pair3(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
