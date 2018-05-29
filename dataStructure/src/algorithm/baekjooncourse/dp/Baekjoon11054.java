package algorithm.baekjooncourse.dp;

import java.util.Scanner;

// https://www.acmicpc.net/problem/11054
public class Baekjoon11054 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int[] d = new int[n];
        for (int i = 0; i < n; i++) { // 증가 수열
            d[i] = 1;
            for (int k = 0; k < i; k++) {
                if (a[k] < a[i] && d[i] < d[k] + 1) {
                    d[i] = d[k] + 1;
                }
            }
        }

        int[] d2 = new int[n];
        for (int i = n - 1; i >= 0; i--) { // 감소 수열
            d2[i] = 1;
            for (int k = i + 1; k < n; k++) {
                if (a[k] < a[i]   && d2[i] < d2[k] + 1) {
                    d2[i] = d2[k] + 1;
                }
            }
        }

        int ans = d[0] + d2[0] - 1;
        for (int i = 0; i < n; i++) {
            if (ans < d[i] + d2[i] -1) {
                ans = d[i] + d2[i] -1;
            }
        }

        System.out.println(ans);
    }
}
