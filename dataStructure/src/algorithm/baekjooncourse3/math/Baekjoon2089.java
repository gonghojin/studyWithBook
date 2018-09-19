package algorithm.baekjooncourse3.math;

import java.util.Scanner;

public class Baekjoon2089 {
    private static void go(int n) {
        if (n == 0) {
            return;
        }
        if (n % 2 == 0) {
            go(-(n / 2));
            System.out.print(0);
        } else {
            if (0 < n) {
                go(-(n / 2));
            } else {
                go(((-n + 1) / 2));
            }
            System.out.print(1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        if (n == 0) {
            System.out.println(0);
        } else {
            go(n);
            System.out.println();
        }
    }
}
