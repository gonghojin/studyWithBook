package algorithm.baekjooncourse2.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon1707 {

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

    public static ArrayList<Integer>[] a;
    public static int[] check;

    public static void dfs(int[] color, int x, int c) {
        color[x] = c;
        for (int y : a[x]) {
            if (color[y] == 0) {
                dfs(color, y, 3 - c);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        sc.init();
        int t = sc.nextInt();
        while (t-- > 0) {
            int vC = sc.nextInt();
            int eC = sc.nextInt();
            a = (ArrayList<Integer>[]) new ArrayList[vC + 1];
            for (int i = 1; i <= vC; i++) {
                a[i] = new ArrayList<Integer>();
            }
            for (int i = 0; i < eC; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                a[u].add(v);
                a[v].add(u);
            }
            int[] color = new int[vC + 1];
            boolean ok = true;
            for (int i = 1; i <= vC; i++) {
                if (color[i] == 0) {
                    dfs(color, i, 1);
                }
            }
            for (int i = 1; i <= vC; i++) {
                for (int j : a[i]) {
                    if (color[i] == color[j]) {
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

}
