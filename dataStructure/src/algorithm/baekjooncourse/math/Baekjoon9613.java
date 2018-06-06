package algorithm.baekjooncourse.math;

import java.util.Scanner;

// https://www.acmicpc.net/problem/9613
public class Baekjoon9613 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // 테스트 케이스
        while (t-- > 0) {
            int n = sc.nextInt(); // 각 케이스의 수 개수
            int[] a = new int[n];
            for (int i = 0 ; i < n; i++) {
                a[i] = sc.nextInt();
            }

            long ans = 0;
            for (int i =0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    ans += gcd(a[i], a[j]);
                }
            }
            System.out.println(ans);
        }
    }

    private static long gcd(int i, int j) {
        if (j == 0) {
            return i;
        } else {
            return gcd(j, i % j);
        }
    }
}
