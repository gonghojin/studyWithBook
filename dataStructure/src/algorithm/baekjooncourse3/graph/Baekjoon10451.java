package algorithm.baekjooncourse3.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon10451 {
    private static ArrayList<Integer>[] d;
    private static boolean[] check;

    public static void dfs(int v) {
        if (check[v]) {
            return;
        }
        check[v] = true;
        for (int x : d[v]) {
            dfs(x);
        }
    }
    public static void main(String[] args) {
        sc.init();
        int t = sc.nextInt();
        while (0 < t--) {
            int n = sc.nextInt();
            d = (ArrayList<Integer>[]) new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                d[i] = new ArrayList<>();
            }
            for (int i = 1; i <= n; i++) {
                int v = sc.nextInt();
                d[i].add(v);
                d[v].add(i);
            }

            check = new boolean[n + 1];
            int ans = 0;
            for (int i = 1; i <=n; i++) {
                if (check[i] == false) {
                    ans++;
                    dfs(i);
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

