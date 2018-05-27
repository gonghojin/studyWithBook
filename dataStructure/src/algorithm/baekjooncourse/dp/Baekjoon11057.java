package algorithm.baekjooncourse.dp;

import java.util.Scanner;

// https://www.acmicpc.net/problem/11057
public class Baekjoon11057 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt(); //계단의 길이
        long[][] arr = new long[num+1][10];
        long mod = 10007;

        for (int i = 0; i <= 9; i++) {
            arr[1][i] = 1; // 계단길이가 1일 때는
        }

        for (int i = 2; i <= num; i++) { // 계단길이 for
            for (int j = 0; j <= 9; j++) { // 계단 층 for
                for (int k = 0; k <= j; k++) { // 해당 계단 층의 앞 층 가능 범위//범위가 필요한 경우는 다른 변수로 k
                    arr[i][j] += arr[i-1][k];
                    arr[i][j] %= mod;
                }

            }
        }

        long result = 0;
        for (int i = 0; i <= 9; i++) {
            result += arr[num][i];
        }
        result %= mod;

        System.out.println(result);

    }
}


