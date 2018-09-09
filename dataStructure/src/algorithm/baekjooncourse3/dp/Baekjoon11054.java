package algorithm.baekjooncourse3.dp;

import java.util.Scanner;

public class Baekjoon11054 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = 1;
            for (int k = 0; k < i; k++) {
                if (a[k] < a[i] && d[i] < d[k] + 1) {
                    d[i] = d[k] + 1;
                }
            }
        }

        int[] d2 = new int[n];
        for (int i = n - 1; 0 <= i; i--) {
            d2[i] = 1;
            for (int k = i + 1; k < n; k++) {
                if (a[k] < a[i] && d2[i] < d2[k] + 1) {
                    d2[i] = d2[k] + 1;
                }
            }
        }

        int ans = d[0] + d2[0] - 1;
        for (int i = 1; i < n; i++) {
            int compare = d[i] + d2[i] - 1;
            if (ans < compare) {
                ans = compare;
            }
        }
        System.out.println(ans);
    }
}
