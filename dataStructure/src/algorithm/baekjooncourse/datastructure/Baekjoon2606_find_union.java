package algorithm.baekjooncourse.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2606_find_union {
    private static int[] parent;

    private static int find(int x) {
        if (x == parent[x]) {
            return x;
        } else {
            return parent[x] = find(parent[x]);
        }


    }
    private static void union(int a, int b) {
        a =  find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        }
    }
    public static void main(String[] args) {
        SC.init();
        int m = SC.nextInt();
        int n = SC.nextInt();

        parent = new int[m + 1];
        
        for (int i = 1; i <= m; i++) {
            parent[i] = i;
        }
        while (0 < n--) {
            int a = SC.nextInt();
            int b = SC.nextInt();
            union(a, b);
        }

        int cnt = 0;
        int root = find(1);
        for (int i = 2; i <= m; i++) {
            if (find(i) == root) {
                cnt++;
            }
        }
        System.out.println(cnt);
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

