package algorithm.baekjooncourse.dp;

import java.util.Scanner;

// https://www.acmicpc.net/problem/9095
public class Baekjoon9095 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] d = new int[11]; // 인덱스 1부터 시작 11보다 작다니
                                //d[n] = n을 1, 2, 3 조합으로 나타내는 방법의 수
        d[0] = 1;
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 3; j++) {
                if (i >= j) {
                    d[i] += d[i - j]; // d[i] = d[i - 1] + d[i -2] + d[i -3]
                }                     // 마지막 자리가 1인 d[i]의 앞자리 경우의 수는 d[i -1] = d[i]
            }                         // 2의 경우 = d[i - 2], 3 = d[i - 3]
        }

        int tastCase = sc.nextInt();
        while (tastCase-- > 0){
            int num = sc.nextInt();
            System.out.println(d[num]);
        }
    }
}
