package algorithm.baekjooncourse.dp;

import java.util.Scanner;

// https://www.acmicpc.net/problem/11052
public class Baekjoon11052 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 붕어빵 개수
        int[] p = new int[n + 1]; // 1번 인덱스부터 시작
        for (int i = 1; i <= n; i++) {
            p[i] = sc.nextInt();
        }

        int[] d = new int[n + 1]; // n개의 붕어빵 팔 시 최대 수익
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (d[i] < d[i - j] + p[j]) { // 기존 값보다 더 큰 수익일 경우만
                    d[i] = d[i - j] + p[j];
                }
            }
        }

        System.out.println(d[n]);
    }
}
