package algorithm.baekjooncourse2.math;

import java.util.Scanner;

public class Baekjoon2004 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        long m = sc.nextInt();

        long e = 0;
        long o = 0;
        // 분자
        for (long i = 2; i <= n; i *= 2) {
            e += n / i;
        }
        for (long i = 5; i <= n; i *= 5) {
            o += n / i;
        }

        // 분모
        for (long i = 2; i <= m; i *= 2) {
            e -= m / i;
        }
        for (long i = 5; i <= m; i *= 5) {
            o -= m / i;
        }
        for (long i = 2; i <= (n - m); i *= 2) {
            e -= (n - m) / i;
        }
        for (long i = 5; i <= (n - m); i *= 5) {
            o -= (n - m) / i;
        }
        System.out.println(Math.min(e, o));

    }
}
