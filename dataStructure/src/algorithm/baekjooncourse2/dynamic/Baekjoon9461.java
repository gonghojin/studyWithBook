package algorithm.baekjooncourse2.dynamic;

import java.util.*;

public class Baekjoon9461 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        long[] d = {0, 1, 1, 1, 2, 2, 3, 4, 5, 7, 9};
        d = Arrays.copyOf(d, 101);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            for (int i = 11; i <= n; i++) {
                d[i] = d[i-1] + d[i-5];
            }
            System.out.println(d[n]);
        }
    }
}
