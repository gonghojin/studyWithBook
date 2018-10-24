package algorithm.baekjooncourse.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon10610 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] c = sc.nextLine().toCharArray();

        Arrays.sort(c);
        int sum = 0;
        for (int i = 0; i < c.length; i++) {
            sum += c[i] - '0';
        }

        if (c[0] == '0' && sum % 3 == 0) {
            for (int i = c.length - 1; 0 <= i; i--) {
                System.out.print(c[i]);
            }
        } else {
            System.out.println(-1);
        }

    }
}
