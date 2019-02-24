package algorithm.baekjooncourse.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon2606 {

    private static int n;
    private static int m;
    private static int[][] arr;
    private static boolean[] check;

    private static int bfs(int start) {
        int ans = 0;

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        while (!q.isEmpty()) {
            int x = q.poll();
            check[x] = true;
            for (int i = 1; i <= n; i++) {
                if (arr[x][i] == 1 && !check[i]) {
                    q.offer(i);
                    check[i] = true;
                    ans++;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        SC.init();
        n = SC.nextInt();
        arr = new int[n + 1][n + 1];
        check = new boolean[n + 1];

        m = SC.nextInt();
        for (int i = 0; i < m; i++) {
            int v = SC.nextInt();
            int e = SC.nextInt();
            arr[v][e] = 1;
            arr[e][v] = 1;
        }
        System.out.println(bfs(1));
    }

    static class SC {
        public static BufferedReader br;
        public static StringTokenizer st;

        static void init() {
            br = new BufferedReader(new InputStreamReader(System.in));
            st = new StringTokenizer("");
        }

        static String next() {
            if (!st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            return st.nextToken();
        }

        static int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
