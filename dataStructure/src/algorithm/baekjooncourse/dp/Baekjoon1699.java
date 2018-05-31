package algorithm.baekjooncourse.dp;

import java.util.Scanner;

// https://www.acmicpc.net/status/?user_id=yolip&problem_id=1699&from_mine=1
public class Baekjoon1699 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = new int[n+1];
        for (int i = 1; i <= n; i++) {
            d[i] = i;
            for (int k = 1; k * k <= i; k++) {
                if (d[i] > d[i-k*k] + 1) {
                    d[i] = d[i-k*k] + 1;
                }
            }
        }

        System.out.println(d[n]);
    }
}
