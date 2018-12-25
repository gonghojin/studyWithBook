package algorithm.baekjooncourse.bfs;

import java.util.Scanner;

public class Baekjoon10974 {
  /*  static StringBuilder sb = new StringBuilder();

    static void next_permutation(int[] d) {
        int i = d.length - 1;
        while (0 < i && d[i] < d[i - 1]) {
            i--;
        }

        if (i == 0) {
            return;
        }

        int j = d.length - 1;
        while (d[j] < d[i - 1]) {
            j--;
        }

        int temp = d[j];
        d[j] = d[i - 1];
        d[i - 1] = temp;

        j = d.length - 1;
        while (i < j) {
            temp = d[i];
            d[i] = d[j];
            d[j] = temp;
            i++;
            j--;
        }
        for (int ans : d) {
            sb.append(ans + " ");
        }
        sb.append("\n");
        next_permutation(d);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = i + 1;
            sb.append(d[i] + " ");
        }
        sb.append("\n");
        next_permutation(d);
        System.out.println(sb);
    }*/

    // better than me
    static boolean next_permutation(int[] d) {
        int i = d.length - 1;
        while (0 < i && d[i] < d[i - 1]) {
            i--;
        }

        if (i == 0) {
            return false;
        }

        int j = d.length - 1;
        while (d[j] < d[i - 1]) {
            j--;
        }

        int temp = d[j];
        d[j] = d[i - 1];
        d[i - 1] = temp;

        j = d.length - 1;
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
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            d[i] = i + 1;
        }
        do {
            for (int i = 0; i < n; i++) {
                sb.append(d[i] + " ");
                        }
                        sb.append("\n");
                        } while (next_permutation(d));
                        System.out.println(sb);
                        }
                        }
