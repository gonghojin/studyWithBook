package algorithm.baekjooncourse2.dynamic;

import java.util.Scanner;

public class Baekjoon10844 {
    public static long mod = 1000000000L;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[][] arr = new long[n+1][10];
        for(int i = 1; i <= 9; i++) {
            arr[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                arr[i][j] = 0;
                if (0 <= j - 1) {
                    arr[i][j] += arr[i-1][j-1];
                }
                if (j + 1 <= 9) {
                    arr[i][j] += arr[i-1][j+1];
                }
                arr[i][j] %= mod;
            }
        }
        long dap = 0;
        for (int i = 0; i <= 9; i++) {
            dap += arr[n][i];
        }
        dap %= mod;
        System.out.println(dap);
    }
}
