package algorithm.baekjooncourse.dp;

import java.util.Scanner;

// https://www.acmicpc.net/submit/2579
public class Baekjoon2579_2arr {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 계단 개수
        int[] a = new int[n+1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }

        int[][]d = new int[n+1][3];
        d[1][1] = a[1]; // 첫번쨰 계단은 연속 2개 존재 x
        for (int i = 2; i <= n; i++) {
            d[i][2] = d[i-1][1] + a[i]; // 연속 2계단
            d[i][1] = Math.max(d[i-2][1], d[i-2][2]) + a[i]; // 한 계단만
        }

        System.out.println(Math.max(d[n][1], d[n][2]));
    }
}
