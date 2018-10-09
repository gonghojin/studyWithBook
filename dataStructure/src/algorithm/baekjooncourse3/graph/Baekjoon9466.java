package algorithm.baekjooncourse3.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon9466 {
    private static int[] check, team, d;
    private static int dfs(int teamName, int select, int cnt) {
        if (check[select] != 0) {
            if (teamName != team[select]) {
                return 0;
            }
            return (cnt - check[select]);
        }
        check[select] = cnt;
        team[select] = teamName;
        return dfs(teamName, d[select], ++cnt);
    }
    public static void main(String[] args) {
        sc.init();
        int t = sc.nextInt();
        while (0 < t--) {
            int n = sc.nextInt();
            d = new int[n + 1];
            check = new int[n + 1];
            team = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                d[i] = sc.nextInt();
            }

            int ans = 0;
            for (int i = 1; i <= n; i++) {
                if (check[i] == 0) {
                    ans += dfs(i, i, 1);
                }
            }
            System.out.println(n - ans);
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
