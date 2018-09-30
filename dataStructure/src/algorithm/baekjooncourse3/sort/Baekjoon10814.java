package algorithm.baekjooncourse3.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Baekjoon10814 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        String[][] members = new String[n][2];
        for (int i = 0; i < n; i++) {
            members[i][0] = sc.next();
            members[i][1] = sc.next();
        }

        Arrays.sort(members, new Comparator<String[]>() {
            @Override
            public int compare(String[] a, String[] b) {
                return Integer.compare(Integer.parseInt(a[0]), Integer.parseInt(b[0]));
            }
        });

        for (String[] x : members) {
            System.out.println(x[0] + " " + x[1]);
        }
    }
}