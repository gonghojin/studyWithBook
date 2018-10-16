package algorithm.baekjooncourse3.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Baekjoon2146_Pair {
    int x;
    int y;

    public Baekjoon2146_Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Baekjoon2146 {

    public static final int[] dx = {0, 0, 1, -1};
    public static final int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        sc.init();
        int n = sc.nextInt();
        int[][] d = new int[n][n];
        int[][] check = new int[n][n];
        int[][] gorup = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                d[i][j] = sc.nextInt();
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (d[i][j] == 1 && gorup[i][j] == 0) {
                    Queue<Baekjoon2146_Pair> queue = new LinkedList<>();
                    queue.add(new Baekjoon2146_Pair(i, j));

                    gorup[i][j] = ++cnt;
                    while (!queue.isEmpty()) {
                        Baekjoon2146_Pair pair = queue.poll();
                        int x = pair.x;
                        int y = pair.y;
                        for (int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];
                            if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                                if (d[nx][ny] == 1 && gorup[nx][ny] == 0) {
                                    gorup[nx][ny] = cnt;
                                    queue.add(new Baekjoon2146_Pair(nx, ny));
                                }
                            }
                        }
                    }
                }
            }
        }

        int ans = 0;
        for (int k = 1; k <= cnt; k++) {
         Queue<Baekjoon2146_Pair> queue = new LinkedList<>();
         for (int i = 0; i < n; i++) {
             for (int j = 0; j < n; j++) {
                 check[i][j] = -1;
                 if (gorup[i][j] == k) {
                     check[i][j] = 0;
                     queue.add(new Baekjoon2146_Pair(i, j));
                 }
             }
         }

         while (!queue.isEmpty()) {
             Baekjoon2146_Pair pair = queue.poll();
             int x = pair.x;
             int y = pair.y;
             for (int i = 0; i < 4; i++) {
                 int nx = x + dx[i];
                 int ny = y + dy[i];
                 if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                     if (check[nx][ny] == -1) {
                         check[nx][ny] = check[x][y] + 1;
                         queue.add(new Baekjoon2146_Pair(nx, ny));
                     }
                 }
             }
         }

         for (int i = 0; i < n; i++) {
             for (int j = 0; j < n; j++) {
                 if (d[i][j] == 1 && gorup[i][j] != k) {
                     if (ans == 0 || check[i][j] - 1 < ans) {
                         ans = check [i][j] - 1;
                     }
                 }
             }
         }
        }
        System.out.println(ans);
    }

    static class sc {
        private static BufferedReader br;
        private static StringTokenizer st;

        public static void init() {
            br = new BufferedReader(new InputStreamReader(System.in));
            st = new StringTokenizer("");
        }

        private static String next() {
            if (!st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        private static int nextInt() {
            return Integer.parseInt(next());
        }
    }

}
