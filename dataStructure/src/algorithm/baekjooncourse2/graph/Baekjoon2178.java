package algorithm.baekjooncourse2.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Baekjoon2178_Pair {

    int x;
    int y;

    public Baekjoon2178_Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Baekjoon2178 {
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};


    private static void bfs(int[][] a, int[][] check, int x, int y) {
        Queue<Baekjoon2178_Pair> q = new LinkedList<Baekjoon2178_Pair>();
        q.add(new Baekjoon2178_Pair(0, 0));
        while (!q.isEmpty()) {
            Baekjoon2178_Pair pair = q.remove();
            int startX = pair.x;
            int startY = pair.y;
            for (int i = 0; i < 4; i++) {
                int nx = startX + dx[i];
                int ny = startY + dy[i];
                if (0 <= nx && nx < x && 0 <= ny && ny < y) {
                    if (a[nx][ny] == 1 && check[nx][ny] == 0) {
                        q.add(new Baekjoon2178_Pair(nx, ny));
                        check[nx][ny] = check[startX][startY] + 1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < m; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }
        int[][] check = new int[n][m];
        check[0][0] = 1;
        /*for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

            }
        }*/
        bfs(a, check, n, m);
        System.out.println(check[n-1][m-1]);
    }
}
