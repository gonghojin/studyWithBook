package algorithm.baekjooncourse.dp;

import java.util.Scanner;

// https://www.acmicpc.net/problem/2133
public class Baekjoon2133 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] d = new long[n+1];
        d[0] = 1;

        for (int i =2; i <= n; i += 2) {
            d[i] = d[i-2] * 3;
            for (int j = i - 4; j >= 0; j -= 2) {
                d[i] += d[j] * 2; // 첫번째 4, 6 길이는 +지만
            }                     // 두번쨰이상부터는 4개 또는 6개가 두개씩 가능 따라서 *
        }
        System.out.println(d[n]);
    }
}
