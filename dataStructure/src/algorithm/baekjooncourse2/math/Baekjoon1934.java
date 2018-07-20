package algorithm.baekjooncourse2.math;

import java.util.Scanner;

public class Baekjoon1934 {
    public static int gcd (int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- >0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int gcd = gcd(a, b);
            System.out.println((a * b) / gcd);
        }
    }
}
