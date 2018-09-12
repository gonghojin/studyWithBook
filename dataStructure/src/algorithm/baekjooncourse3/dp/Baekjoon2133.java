package algorithm.baekjooncourse3.dp;

import java.util.Scanner;

public class Baekjoon2133 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] d = new int[n+1];
        d[0] = 1;
        for (int i = 2; i <= n; i += 2) {
            d[i] = d[i-2] * 3;
            for (int k = i - 4; 0 <= k; k -= 2) {
                d[i] += d[k] * 2;
            }
        }

        /*if (2 <= n) {
            d[2] = 3;
        }
        for (int i = 4; i <= n; i+= 2) {
            d[i] = d[i - 2] * 3;
            if (n % 4 == 0) {
                d[n] += 2;
            }
        }*/
        System.out.println(d[n]);
    }
}
