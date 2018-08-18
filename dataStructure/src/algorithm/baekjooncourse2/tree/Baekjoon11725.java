package algorithm.baekjooncourse2.tree;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon11725 {
    private static void bfs(ArrayList<Integer>[] a, boolean[] check, int[] parent) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(1);
        check[1] = true;
        while (!q.isEmpty()) {
            int x = q.remove();
            for (int y : a[x]) {
                if (check[y] == false) {
                    check[y] = true;
                    parent[y] = x;
                    q.add(y);
                }
            }
        }
    }

    public static void main(String[] args) {
        sc.init();
        int n = sc.nextInt();
        ArrayList<Integer>[] a = (ArrayList<Integer>[]) new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            a[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < n -1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            a[u].add(v);
            a[v].add(u);
        }

        boolean[] check = new boolean[n+1];
        int[] parent = new int[n+1];
        bfs(a, check, parent);
        for (int i = 2; i <= n; i++) {
            System.out.println(parent[i]);
        }
    }

    static class sc {
        private static BufferedReader br;
        private static StringTokenizer st;

        static void init() {
            br = new BufferedReader(new InputStreamReader(System.in));
            st = new StringTokenizer("");
        }

        private static String readLine() {
            try {
                return br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        private static String next() {
            while (!st.hasMoreTokens()) {
                st = new StringTokenizer(readLine());
            }
            return st.nextToken();
        }

        public static int nextInt() {
            return Integer.parseInt(next());
        }
    }

}
