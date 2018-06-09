package algorithm.baekjooncourse.math;

import java.util.Scanner;

// https://www.acmicpc.net/problem/1676
public class Baekjoon1676 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0;
        for (int i = 5; i <= n; i *= 5) {
            ans += n / i; //  0의 생기는 이유는 2 * 5이기 떄문,
            // 또한 2의 수는 항상 5보다 크기때문에 5개수만 구하면
        }
        System.out.println(ans);
    }
}
