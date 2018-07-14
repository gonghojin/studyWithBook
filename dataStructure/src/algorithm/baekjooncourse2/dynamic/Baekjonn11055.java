package algorithm.baekjooncourse2.dynamic;

import java.util.Scanner;

public class Baekjonn11055 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int[] d = new int[n];
        d[0] = a[0];
        for (int i = 1; i < n; i++) {
            d[i] = a[i];
            for (int j = 0; j < i; j++) {
                if (d[j] > d[i] - a[i] && a[j] < a[i]) {
                    d[i] = d[j] + a[i];
                }
            }
        }
        int ans = d[0];
        for (int i = 1; i < n; i++) {
            if (ans < d[i]) {
                ans = d[i];
            }
        }
        System.out.println(ans);
    }

}
