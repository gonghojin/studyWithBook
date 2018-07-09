package algorithm.baekjooncourse2.dynamic;

import java.util.Scanner;

public class Baekjoon11057 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[][] d = new long[n+1][10];
        for (int i = 0; i <= 9; i++) {
            d[1][i] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k <= j; k++) {
                    d[i][j] += d[i - 1][k];
                }
                d[i][j] %= 10007;
            }
        }
        long ans = 0;
        for (int i = 0; i <= 9; i++) {
            ans += d[n][i];
        }
        ans %= 10007;
        System.out.println(ans);
    }
}
