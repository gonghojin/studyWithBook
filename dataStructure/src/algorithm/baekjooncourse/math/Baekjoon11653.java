package algorithm.baekjooncourse.math;

import java.util.Scanner;

// https://www.acmicpc.net/problem/11653
public class Baekjoon11653 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                System.out.println(i);
                n /= i;
            }
        }

        if (n > 1) { // 어떤 수가 루트n보다 큰 수는 단 하나 존재(예: 7)
            System.out.println(n);
        }
    }
}
