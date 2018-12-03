package algorithm.baekjooncourse.divde;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1780_1 {

    public static boolean same(int[][] a, int x, int y, int n) {
        for (int i = x; i < x + n; i++) {
            for (int k = y; k < y + n; k++) {
                if (a[x][y] != a[i][k]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void solve(int[][] a, int[] cnt, int x, int y, int n) {
        if (same(a, x, y, n)) {
            cnt[a[x][y] + 1] += 1;
            return;
        }
        int m = n / 3;
        for (int i = 0; i < 3; i++) {
            for (int k = 0; k < 3; k++) {
                solve(a, cnt, x + i * m, y + k * m, m);
            }
        }
    }

    public static void main(String[] args) {
        sc.init();
        int n = sc.nextInt();
        int[][] a = new int[n][n];
        int[] cnt = new int[3];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        solve(a, cnt, 0, 0, n);
        for (int i = 0; i < 3; i++) {
            System.out.println(cnt[i]);
        }
    }

    static class sc {
        static BufferedReader br;
        static StringTokenizer st;

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
