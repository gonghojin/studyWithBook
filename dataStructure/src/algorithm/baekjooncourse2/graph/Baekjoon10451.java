package algorithm.baekjooncourse2.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon10451 {

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

    public static void dfs(ArrayList<Integer>[] a, int v, boolean[] check) {
        if (check[v]) {
            return;
        }
        check[v] = true;
        dfs(a, a[v].get(0), check);
    }

    public static void main(String[] args) {
        sc.init();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            ArrayList<Integer>[] a = (ArrayList<Integer>[]) new ArrayList[n + 1];
            boolean[] check = new boolean[n + 1];
            for (int i = 0; i <= n; i++) {
                a[i] = new ArrayList<Integer>();
                if (0 < i) {
                    a[i].add(sc.nextInt());
                }
            }
            int ans = 0;
            for (int i = 1; i <= n; i++) {
                if (check[i] == false) {
                    dfs(a, i, check);
                    ans++;
                }
            }
            System.out.println(ans);
        }
    }
}
