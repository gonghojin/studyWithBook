package algorithm.baekjooncourse3.math;

import java.util.Scanner;

public class Baekjoon11576 {

    public static void convert(int x, int y) {
        if (x == 0) {
            return;
        }
        convert(x / y, y);
        System.out.print(x % y + " ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int m = sc.nextInt();

        int temp = 0;
        for (int i = 0; i < m; i++) {
            int n = sc.nextInt();
            temp = temp *  a + n;
        }
        convert(temp, b);
    }
}
