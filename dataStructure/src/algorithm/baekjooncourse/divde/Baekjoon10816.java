package algorithm.baekjooncourse.divde;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Baekjoon10816 {
    static int[] d = new int[20000001];
    static int startZero = 10000000;

    public static void main(String[] args) {
        sc.init();
        int n = sc.nextInt();
        for (int i = 0 ; i < n; i++) {
            int orgIndex = sc.nextInt();
            d[orgIndex+startZero]++;
        }

        int m = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int orgIndex = sc.nextInt();
            int cnt = d[orgIndex+startZero];
            sb.append(cnt + " ");        }
        System.out.println(sb);
    }

    static class sc {
        static BufferedReader br;
        static StringTokenizer st;

        static void init() {
            br = new BufferedReader(new InputStreamReader(System.in));
            st = new StringTokenizer("");
        }

        static String next() {
            if (!st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        static int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
