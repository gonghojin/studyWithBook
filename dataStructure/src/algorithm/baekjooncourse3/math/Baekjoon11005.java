package algorithm.baekjooncourse3.math;

import java.util.Scanner;

public class Baekjoon11005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        while (0 < n) {
            int r = n % b;
            if (r < 10) {
                sb.append((char)(r + '0'));
            } else {
                sb.append((char)(r - 10 + 'A'));
            }
            n /= b;
        }
        System.out.println(sb.reverse());
    }
}
