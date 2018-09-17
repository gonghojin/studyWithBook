package algorithm.baekjooncourse3.math;

import java.util.Scanner;

public class Baekjoon9613 {

    public static int gcd(int x, int y) {
        if (y == 0) {
            return x;
        } else {
            return gcd(y, x % y);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (0 < t--) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            long ans = 0;
            for (int i = 0; i < n - 1; i++) {
                for (int k = i + 1; k < n; k++) {
                    ans += gcd(arr[i], arr[k]);
                }
            }
            System.out.println(ans);
        }
    }
}
