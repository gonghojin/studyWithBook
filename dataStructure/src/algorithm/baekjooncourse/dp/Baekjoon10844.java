package algorithm.baekjooncourse.dp;

import java.util.Scanner;

// https://www.acmicpc.net/problem/10844
public class Baekjoon10844 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        long mod = 1000000000;
        long[][] d = new long[num + 1][10];
        for (int i = 1; i <= 9; i++) { // 길이가 1인 경우는 0으로 시작할 수 없음
            d[1][i] = 1;
        }

        for (int i = 2; i <= num; i++) {
            for (int j = 0; j <= 9; j++) {
                d[i][j] = 0;
                if (j-1 >= 0) {
                    d[i][j] += d[i-1][j-1];
                }
                if (j+1 <= 9) {
                    d[i][j] += d[i-1][j+1];
                }
                d[i][j] %= mod;
            }
        }

        long result = 0;
        for (int i = 0; i <= 9; i++) {
            result += d[num][i];
        }

        result %= mod;
        System.out.println(result);
    }

}
/**
 * 1000000000로 나누라는 것은 정답이 int 범위를 넘어가기 때문입니다.

    마지막에 한 번 나누면 중간에 int 범위를 넘어가서 이상한 값을 저장하게 됩니다. 따라서, 매번 나눠줘야 합니다.

 *
 * **/