package algorithm.baekjooncourse.math;

import java.util.Scanner;

// https://www.acmicpc.net/problem/11005
public class Baekjoon11005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();
        StringBuilder ans = new StringBuilder();

        while (n > 0) {
            int r = n % b;
            if (r < 10) {
                ans.append((char)(r + '0'));
            } else {
                ans.append((char)(r - 10 + 'A')); // 숫자 + 문자('A') 시 숫자 우선 즉, (r - 10 + 'A') == 65, 따라서 (char)(65) == 'A'
            }

            n /= b;
        }
        System.out.println(ans.reverse());

    }
}
