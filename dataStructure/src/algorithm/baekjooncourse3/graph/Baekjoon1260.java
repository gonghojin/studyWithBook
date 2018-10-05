package algorithm.baekjooncourse3.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon1260 {
    private static ArrayList<Integer>[] a;
    private static boolean[] check;

    private static void dfs(int u) {
        if (check[u]) {
            return;
        }

        System.out.print(u + " ");

        check[u] = true;

        for (int x : a[u]) {
            if (check[x] == false) {
                dfs(x);
            }
        }
    }

    private static void bfs (int u) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(u);
        check[u] = true;

        while (!queue.isEmpty()) {
            int x = queue.poll();

            System.out.print(x + " ");

            for (int y : a[x]) {
                if (check[y] == false) {
                    check[y] = true;
                    queue.add(y);
                }
            }
        }

    }
    public static void main(String[] args) {
        sc.init();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int start = sc.nextInt();

        a = (ArrayList<Integer>[]) new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            a[u].add(v);
            a[v].add(u);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(a[i]);
        }

        check = new boolean[n + 1];
        dfs(start);
        System.out.println();

        check = new boolean[n + 1];
        bfs(start);

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
