package algorithm.baekjooncourse3.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon11652 {
    public static void main(String[] args) {
        sc.init();
        int n = sc.nextInt();
        long[] d = new long[n];
        for (int i = 0; i < n; i++) {
            d[i] = sc.nextLong();
        }

        Arrays.sort(d);

        int maxCount = 1;
        int tempCount = 1;
        long ans = d[0];
        for (int i = 1; i < n; i++) {
            if (d[i] == d[i - 1]) {
                tempCount++;
            } else {
                tempCount = 1;
            }
            if (maxCount < tempCount) {
                maxCount = tempCount;
                ans = d[i];
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

        public static String next() {
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
