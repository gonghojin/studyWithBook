package algorithm.baekjooncourse3.graph;

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

    public static int[][] land;
    public static boolean[][] check;

    public static void bfs(int x, int y, int w, int h) {
        Queue<Baekjoon4963_pair> queue = new LinkedList<>();
        queue.add(new Baekjoon4963_pair(x, y));
        check[y][x] = true;

        while(!queue.isEmpty()) {
            Baekjoon4963_pair pair = queue.poll();
            int pX = pair.x;
            int pY = pair.y;
            for (int i = 0; i < 8; i++) {
                int nX = pX + dx[i];
                int nY = pY + dy[i];
                if (0 <= nX && nX < w && 0 <= nY && nY < h) {
                    if (land[nY][nX] == 1 && check[nY][nX] == false) {
                        queue.add(new Baekjoon4963_pair(nX, nY));
                        check[nY][nX] = true;
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

            land = new int[h][w];
            check = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    land[i][j] = sc.nextInt();
                }
            }

            int cnt = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (check[i][j] == false && land[i][j] == 1) {
                        cnt++;
                        bfs(j, i, w, h);
                    }
                }
            }
            System.out.println(cnt);
        }
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

        public static int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
