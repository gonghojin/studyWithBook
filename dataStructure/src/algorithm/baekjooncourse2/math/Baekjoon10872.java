package algorithm.baekjooncourse2.math;

import java.util.Scanner;

public class Baekjoon10872 {

    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * factorial(n -1);
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(factorial(n));

        int ans = 1;
        for (int i = 2; i <= n; i++) {
            ans *= i;
        }
        System.out.println(ans);

    }
}
