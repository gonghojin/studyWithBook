package algorithm.baekjooncourse3.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon11725 {

    public static void main(String[] args) {
        sc.init();
        int n = sc.nextInt();
        ArrayList<Integer>[] d = (ArrayList<Integer>[]) new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            d[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            d[x].add(y);
            d[y].add(x);
        }

        int[] parent = new int[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        parent[1] = 1;
        while (!queue.isEmpty()) {
            int q = queue.poll();
            for (int x : d[q]) {
                if (parent[x] == 0) {
                    parent[x] = q;
                    queue.add(x);
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            System.out.println(parent[i]);
        }
    }

    static class sc {
        private static BufferedReader br;
        private static StringTokenizer st;

        public  static void init() {
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
    }
}
