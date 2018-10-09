package algorithm.baekjooncourse3.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2331 {
    private static final int[] check = new int[1000000];


    private static int pow(int su, int P) {
        int ans = 1;
        for (int i = 0; i < P; i++) {
            ans *= su;
        }

        return ans;
    }

    private static int newSu(int su, int P) {
        int ans = 0;
        while (0 < su) {
            ans += pow(su % 10, P);
            su /= 10;
        }

        return ans;
    }

    private static int dfs(int su, int P, int count) {
        if (0 < check[su]) {
            return check[su] - 1;
        }
        check[su] = count;
        int newSu = newSu(su, P);
        return dfs(newSu, P, ++count);
    }

    public static void main(String[] args) {
        sc.init();
        int A = sc.nextInt();
        int P = sc.nextInt();
        System.out.println(dfs(A, P, 1));
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
