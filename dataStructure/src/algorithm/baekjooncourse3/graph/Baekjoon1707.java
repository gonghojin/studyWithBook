package algorithm.baekjooncourse3.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon1707 {
    private static ArrayList<Integer>[] d;
    private static int[] check;

    private static void dfs(int[] color, int x, int c) {
        color[x] = c;
        for (int y : d[x]) {
            if (color[y] == 0) {
                dfs(color, y, 3 - c);
            }
        }
    }
    public static void main(String[] args) {
        sc.init();
        int t = sc.nextInt();
        while (0 < t--) {
            int v = sc.nextInt();
            int e = sc.nextInt();
            d = (ArrayList<Integer>[]) new ArrayList[v + 1];
            for (int i = 1; i <= v; i++) {
                d[i] = new ArrayList<Integer>();
            }

            for (int i = 0; i < e; i++) {
                int uI = sc.nextInt();
                int vI = sc.nextInt();
                d[uI].add(vI);
                d[vI].add(uI);
            }

            int[] color = new int[v + 1];
            for (int i = 1; i <= v; i++) {
                if (color[i] == 0) {
                    dfs(color, i, 1);
                }
            }

            boolean ok = true;
            for (int i = 1; i <= v; i++) {
                for (int x : d[i]) {
                    if (color[x] == color[i]) {
                        ok = false;
                    }
                }
            }

            if (ok) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
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
