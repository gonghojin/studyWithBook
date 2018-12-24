package algorithm.baekjooncourse.bfs;

import java.util.Scanner;

public class Baekjoon10972_1 {
    static boolean next_permutation(int[] d) {
        int i = d.length - 1; // 기준점
        while (0 < i && d[i] <= d[i - 1]) {
            i -= 1;
        }

        if (i <= 0) {
            return false; // 마지막 순열
        }

        int j = d.length - 1;
        while (d[j] < d[i - 1]) {
            j -= 1;
        }

        int temp = d[i - 1];
        d[i - 1] = d[j];
        d[j] = temp;

        j = d.length - 1;
        while (i < j) {
            temp = d[i];
            d[i] = d[j];
            d[j] = temp;
            i += 1;
            j -= 1;
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
        if (next_permutation(d)) {

          /*  for (int i = 0; i < n; i++) {
                sb.append(d[i] + " ");
            }
            System.out.println(sb); 27144KB	304ms
            */
            for (int x : d) {
             /*System.out.print(x + " "); 29132KB	380ms*/
                sb.append(x + " ");
            }
            System.out.println(sb); // 	27244KB	284ms
        } else {
            System.out.println("-1");
        }
    }
}
