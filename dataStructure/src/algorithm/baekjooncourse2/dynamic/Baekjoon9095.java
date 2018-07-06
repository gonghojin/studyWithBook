package algorithm.baekjooncourse2.dynamic;

import java.util.Scanner;

public class Baekjoon9095 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*int t = sc.nextInt();
        int[] d = new int[11];
        d[0] = 1;
        d[1] = 1;
        d[2] = 2;
        d[3] = 4;
        while (t-- > 0) {
            int n = sc.nextInt();
            for (int i = 4; i <= n; i++) {
                d[i] = d[i-1] + d[i-2] + d[i-3];
                d[i] %= 10007;
            }
            System.out.println(d[n]);
        }*/
        int[] d = new int[11];
        d[0] = 1;
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 3; j++) {
                if (i - j >= 0) {
                    d[i] += d[i-j];
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
