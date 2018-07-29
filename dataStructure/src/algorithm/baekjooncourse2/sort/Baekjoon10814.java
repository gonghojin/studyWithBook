package algorithm.baekjooncourse2.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Baekjoon10814 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[][] d = new String[n][2];
        for (int i = 0; i < n; i++) {
            d[i][0] = sc.next();
            d[i][1] = sc.next();
        }

        Arrays.sort(d, new Comparator<String[]>() {
            @Override
            public int compare(String[] a, String[] b) {
               /* int x = Integer.parseInt(a[0]);
                int y = Integer.parseInt(b[0]);*/
                return Integer.compare( Integer.parseInt(a[0]),  Integer.parseInt(b[0]));
            }
        });

        for (int i = 0; i < n; i++) {
            System.out.println(d[i][0] + " " + d[i][1]);
        }
    }
}
