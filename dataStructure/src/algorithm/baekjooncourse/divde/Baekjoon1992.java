package algorithm.baekjooncourse.divde;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1992 {

    static int[][] map;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = (int)(line.charAt(j) - 48);
            }
        }
        sb = new StringBuilder();
        solve(0, 0, n);
        System.out.println(sb);
    }

    static boolean check(int x, int y, int n) {
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (map[x][y] != map[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    static void solve(int x, int y, int n){
        if (check(x, y, n)) {
            sb.append(map[x][y]);
            return;
        }

        sb.append("(");
        int m = n / 2;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                solve(x + i * m, y + j * m, m);
            }
        }
        sb.append(")");
    }
}
