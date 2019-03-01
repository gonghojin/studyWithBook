package algorithm.baekjooncourse.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1717 {
    static int[] parent;

    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        } else {
            return parent[x] = find(parent[x]);
        }
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            parent[y] = x;
        }
    }

    public static void main(String[] args) {
        SC.init();

        int n = SC.nextInt();
        int m = SC.nextInt();

        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        StringBuilder sb = new StringBuilder();
        while (0 < m--) {
            int distinguishFindAndUnion = SC.nextInt();
            int x = SC.nextInt();
            int y = SC.nextInt();

            if (distinguishFindAndUnion == 0) {
                union(x, y);
            } else {
                x = find(x);
                y = find(y);
                if (x == y) {
                    sb.append("YES\n");
                } else {
                    sb.append("NO\n");
                }
            }
        }

        System.out.println(sb);
    }


    static class SC {
        private static BufferedReader br;
        private static StringTokenizer st;

        private static void init() {
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

        private static int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
