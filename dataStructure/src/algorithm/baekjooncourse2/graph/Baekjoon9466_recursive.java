package algorithm.baekjooncourse2.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon9466_recursive {

    public static int[] a, d, s;

    public static int dfs(int x, int cnt, int step) {
        if (d[x] != 0) {
            if (step != s[x]) {
                return 0;
            }
            return cnt - d[x];
        }
        d[x] = cnt;
        s[x] = step;

        return dfs(a[x], ++cnt, step);
    }

    public static void main(String[] args) {
        sc.init();

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            a = new int[n+1];
            d = new int[n+1];
            s = new int[n+1];
            for (int i = 1; i <= n; i++) {
                a[i] = sc.nextInt();
                d[i] = 0;
                s[i] = 0;
            }
            int ans = 0;
            for (int i = 1; i <= n; i++) {
                if (d[i] == 0) {
                    ans += dfs(i, 1, i);
                }
            }
            System.out.println(n - ans);
        }
    }

    static class sc {
        private static BufferedReader br;
        private static StringTokenizer st;

        static void init() {
            br = new BufferedReader(new InputStreamReader(System.in));
            st = new StringTokenizer("");
        }

        static String readLine() {
            try {
                return br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        static String next() {
            while (!st.hasMoreTokens()) {
                st = new StringTokenizer(readLine());
            }
            return st.nextToken();
        }

        static int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
