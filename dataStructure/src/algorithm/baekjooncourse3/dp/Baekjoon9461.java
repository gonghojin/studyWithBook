package algorithm.baekjooncourse3.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon9461 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*int t = sc.nextInt();

        int[] d = new int[101];
        int dLength = d.length;
        d[1] = 1;
        d[2] = 1;
        d[3] = 1;
        for (int i = 4 ; i < dLength; i++) {
            d[i] = d[i - 2] + d[i - 3];
        }
        while (0 < t--) {
            int p = sc.nextInt();
            System.out.println(d[p]);
        }*/
        long[] d = {0, 1, 1, 1, 2, 2, 3, 4, 5, 7, 9};
        d = Arrays.copyOf(d, 101);
        int t = sc.nextInt();
        while (0 < t--) {
            int n = sc.nextInt();
            for (int i = 11; i <= n; i++) {
                d[i] = d[i - 1] + d[i - 5];
            }
            System.out.println(d[n]);
        }
    }
}
