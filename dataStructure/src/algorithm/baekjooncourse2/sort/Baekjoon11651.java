package algorithm.baekjooncourse2.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Baekjoon11651 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] d = new int[n][2];
        for (int i = 0; i < n; i++) {
            d[i][0] = sc.nextInt();
            d[i][1] = sc.nextInt();
        }

        Arrays.sort(d, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[1] == b[1]) {
                    return Integer.compare(a[0], b[0]);
                } else {
                    return  Integer.compare(a[1], b[1]);
                }
            }
        });

        for (int i = 0; i < n; i++) {
            System.out.println(d[i][0] + " " + d[i][1]);
        }
    }
}
