package algorithm.baekjooncourse.bfs;

import java.util.Scanner;

public class Baekjoon10973_1 {

    static boolean prev_permutation(int[] d) {
        int i = d.length - 1;
        while (0 < i && d[i - 1] < d[i]) {
            i -= 1;
        }

        if (i == 0) {
            return false;
        }

        int j = d.length - 1;
        while (d[i - 1] < d[j]) {
            j -= 1;
        }

        int temp = d[j];
        d[j] = d[i - 1];
        d[i - 1] = temp;

        j = d.length -1;
        while (i < j) {
            temp = d[i];
            d[i] = d[j];
            d[j] = temp;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = sc.nextInt();
        }

        StringBuilder sb = new StringBuilder();

        if (!prev_permutation(d)) {
            sb.append("-1");
        } else {
            for (int ans : d) {
                sb.append(ans + " ");
            }
        }

        System.out.println(sb);
    }
}
