package algorithm.baekjooncourse3.dp;

import java.util.Scanner;

public class Baekjoon9095 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] d = new int[11];
        d[0] = 1;
        for (int i = 1; i <= 10; i++) {
            for (int k = 1; k <= 3; k++) {
                if (i - k >= 0) {
                    d[i] += d[i - k];
                }
            }
        }
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            System.out.println(d[n]);
        }

    }
}
