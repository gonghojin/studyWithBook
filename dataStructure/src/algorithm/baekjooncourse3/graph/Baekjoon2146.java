package algorithm.baekjooncourse3.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2146 {

    public static void main(String[] args) {
        sc.init();
        int n = sc.nextInt();
        int[][] d = new int[n][n];
        int[][] check = new int[n][n];
        int[][] gorup = new int[n][n];
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
