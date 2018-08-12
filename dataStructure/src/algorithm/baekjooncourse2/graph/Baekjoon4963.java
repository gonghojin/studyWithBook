package algorithm.baekjooncourse2.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Baekjoon4963_pair {

    int x;
    int y;

    public Baekjoon4963_pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Baekjoon4963 {
    public static int[] dx = {0, 0, 1, -1, 1, 1, -1, -1};
    public static int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};

    public static void bfs(int[][] a, int[][] check, int x, int y, int limitX, int limitY) {
        Queue<Baekjoon4963_pair> q = new LinkedList<Baekjoon4963_pair>();
        q.add(new Baekjoon4963_pair(x, y));
        check[x][y] = 1;

        while (!q.isEmpty()) {
            Baekjoon4963_pair pair = q.remove();
            int qX =pair.x;
            int qY = pair.y;
            for (int i = 0; i < 8; i++) {
                int nX = qX + dx[i];
                int nY = qY + dy[i];
                if (0 <= nX && nX < limitX && 0 <= nY && nY < limitY) {
                    if (a[nX][nY] == 1 && check[nX][nY] == 0) {
                        q.add(new Baekjoon4963_pair(nX, nY));
                        check[nX][nY] = 1;
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        sc.init();

        while (true) {
            int w = sc.nextInt();
            int h = sc.nextInt();
            if (w == 0 && h == 0) {
                break;
            }
            int[][] a = new int[h][w];
            int[][] check = new int[h][w];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    a[i][j] = sc.nextInt();
                }
            }
            int ans = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                   if (a[i][j] == 1 && check[i][j] == 0) {
                       ans += 1;
                       bfs(a, check, i, j, h, w);
                   }
                }
            }
            System.out.println(ans);
        }
    }

    static class sc {
        private static BufferedReader br;
        private static StringTokenizer st;

        public static void init() {
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

        public static int nextInt() {
            return Integer.parseInt(next());
        }
    }

}
