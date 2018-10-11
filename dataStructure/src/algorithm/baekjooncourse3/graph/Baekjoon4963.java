package algorithm.baekjooncourse3.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon4963 {

    public static void main(String[] args) {
        sc.init();

        while (true) {
            int w = sc.nextInt();
            int h = sc.nextInt();
            if (w == 0 && h == 0) {
                break;
            }

            int[][] land = new int[h][w];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    land[i][j] = sc.nextInt();
                }
            }
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
