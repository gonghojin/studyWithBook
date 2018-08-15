package algorithm.baekjooncourse2.graph;

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
        int[][] a = new int[n][n];
        int[][] d = new int[n][n];
        int[][] g = new int[n][n];

//        Queue<Baekjoon2146_Pair> q = new LinkedList<Baekjoon2146_Pair>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();

            }
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 1 && g[i][j] == 0) {
                    Queue<Baekjoon2146_Pair> q = new LinkedList<Baekjoon2146_Pair>();
                    q.add(new Baekjoon2146_Pair(i, j));
                    g[i][j] = ++cnt;
                    while (!q.isEmpty()) {
                        Baekjoon2146_Pair p = q.remove();
                        int x = p.x;
                        int y = p.y;
                        for (int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];
                            if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                                if (a[nx][ny] == 1 && g[nx][ny] == 0) {
                                    g[nx][ny] = cnt;
                                    q.add(new Baekjoon2146_Pair(nx, ny));
                                }
                            }
                        }
                    }
                }
            }
        }

        int ans = 0;
        for (int k = 1; k <= cnt; k++) {
            Queue<Baekjoon2146_Pair> q = new LinkedList<Baekjoon2146_Pair>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <n; j++) {
                    d[i][j] = -1;
                    if (g[i][j] == k) {
                        d[i][j] = 0;
                        q.add(new Baekjoon2146_Pair(i, j));
                    }
                }
            }

            while (!q.isEmpty()) {
                Baekjoon2146_Pair pair = q.remove();
                int x = pair.x;
                int y = pair.y;
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                        if (d[nx][ny] == -1) {
                            d[nx][ny] = d[x][y] + 1;
                            q.add(new Baekjoon2146_Pair(nx, ny));
                        }
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (a[i][j] == 1 && g[i][j] != k) {
                        if (ans == 0 || d[i][j] -1 < ans) {
                            ans = d[i][j] - 1;
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

        private static void init() {
            br = new BufferedReader(new InputStreamReader(System.in));
            st = new StringTokenizer("");
        }

        private static String readLine() {
            try {
                return br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        private static String next() {
            while (!st.hasMoreTokens()) {
                st = new StringTokenizer(readLine());
            }
            return st.nextToken();
        }
        private static int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
