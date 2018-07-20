package algorithm.baekjooncourse2.math;

import java.util.Scanner;

public class Baekjoon2609 {
    public static int gcd(int x, int y) {
        if (y == 0) {
            System.out.println(x);
            return x;
        } else {
            return gcd(y, x % y );
        }
    }
    public static void lcm(int x, int y, int gcd) {
        System.out.println((x * y) / gcd);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        lcm(x, y, gcd(x, y));
    }
}
