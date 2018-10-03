package algorithm.baekjooncourse3.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon11004 {

    public static void main(String[] args) {
        sc.init();

        int n = sc.nextInt();
        int k = sc.nextInt();
/*
    이렇게 하면 틀리네... 왜 그럴까?

        long[] d = new long[n+1];
        d[0] = 0;
        for (int i = 1; i <= n; i++) {
            d[i] = sc.nextLong();
        }

        Arrays.sort(d);
        System.out.println(d[k]);

*/
        long[] d = new long[n];
        for (int i = 0; i < n; i++) {
            d[i] = sc.nextLong();
        }

        Arrays.sort(d);
        System.out.println(d[k - 1]);
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

        public static long nextLong() {
            return Long.parseLong(next());
        }
    }
}
