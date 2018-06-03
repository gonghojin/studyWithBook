package algorithm.baekjooncourse.dp;

import java.util.Arrays;
import java.util.Scanner;

// https://www.acmicpc.net/problem/9461
public class Baekjoon9461 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long[] d = {0, 1, 1, 1, 2, 2, 3, 4, 5, 7, 9}; // d[1]부터 시작이니, d[0] 껍데기
        d = Arrays.copyOf(d, 101);

        for (int i = 11; i <= 100; i++) {
            d[i] = d[i-1] + d[i-5];
        }
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            System.out.println(d[n]);
        }
    }
}
