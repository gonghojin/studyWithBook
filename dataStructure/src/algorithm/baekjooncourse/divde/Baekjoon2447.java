package algorithm.baekjooncourse.divde;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon2447 {

    static void solve(char[][] d, int x, int y, int num) {
        if (num == 1) {
            d[x][y] = '*';
            return;
        }

        int m = num / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!(i == 1 && j == 1)) {
                    solve(d, x + m * i, y + m * j, m);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        char[][] d = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(d[i], ' ');
        }

        solve(d, 0, 0, n);


        StringBuilder sb = new StringBuilder();
        for (char[] x : d) {
            for (char y : x) {
                sb.append(y);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}
