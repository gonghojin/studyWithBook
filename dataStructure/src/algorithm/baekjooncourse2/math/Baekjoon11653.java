package algorithm.baekjooncourse2.math;

import java.util.Scanner;

public class Baekjoon11653 {

    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                n /= i;
                System.out.println(i);
            }
        }
        if (n > 1) {
            System.out.println(n);
        }
    }
}
