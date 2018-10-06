package algorithm.baekjooncourse3.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon11724_BFS {

    private static ArrayList<Integer>[] d;

     private static void bfs(boolean[] check, int u) {
         Queue<Integer> queue = new LinkedList<Integer>();
         queue.add(u);
         check[u] = true;
         while (!queue.isEmpty()) {
             int pollU = queue.poll();
             for (int x : d[pollU]) {
                 if (check[x] == false) {
                     check[x] = true;
                     queue.add(x);
                 }
             }

         }
     }

    public static void main(String[] args) {

        sc.init();

        int n = sc.nextInt();
        int m = sc.nextInt();
        d = (ArrayList<Integer>[]) new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            d[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            d[u].add(v);
            d[v].add(u);
        }

        boolean[] check = new boolean[n + 1];
        int component = 0;
        for (int i = 1; i <= n; i++) {
            if (check[i] == false) {
                component++;
                bfs(check, i);
            }
        }

        System.out.println(component);
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

