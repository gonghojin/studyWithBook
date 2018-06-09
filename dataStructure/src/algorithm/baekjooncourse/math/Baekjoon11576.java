package algorithm.baekjooncourse.math;

import java.util.Scanner;

// https://www.acmicpc.net/problem/11576
public class Baekjoon11576 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(); // A진법 (변환전)
        int b = sc.nextInt(); // B진법 (변환후)
        int m = sc.nextInt(); // A진법으로 나타낸 숫자의 자리 개수
        int ans = 0;

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt(); // 각 자리의 수치
            ans = ans * a + x; // 10진법 만들기
        }

        convert(ans, b);
        System.out.println();
    }

    private static void convert(int num, int base) {
        if (num == 0) {
            return;
        }
        convert(num / base, base);
        System.out.print(num % base + " ");
    }
}

