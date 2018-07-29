package algorithm.baekjooncourse2.math;

import java.util.*;

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
        int a = sc.nextInt(); // A진법
        int b = sc.nextInt(); // B진법
        int m = sc.nextInt(); // A진법의 자리 개수

        int temp = 0;
        for (int i = 0; i < m; i++) {
            int n = sc.nextInt(); // A진법 각 자리당 수
            temp = temp *  a + n;
        }
        convert(temp, b);

    }
}
