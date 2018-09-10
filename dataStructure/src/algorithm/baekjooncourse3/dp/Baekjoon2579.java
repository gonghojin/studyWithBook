package algorithm.baekjooncourse3.dp;

import java.util.Scanner;

public class Baekjoon2579 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n+1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        int[] d = new int[n+1];
        d[0] = 0;
        d[1] = a[1];
        d[2] = a[1] + a[2];
        for (int i = 3; i <= n; i++) {
            d[i] = Math.max(a[i] + a[i-1] + d[i-3], a[i] + d[i-2]);
        }
        System.out.println(d[n]);
    }
}
