package algorithm.baekjooncourse2.math;

import java.util.ArrayList;
import java.util.Scanner;

public class Baekjoon6588 {
    public static final int MAX = 1000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[] check = new boolean[MAX + 1];
        check[0] = check[1] = true;
        ArrayList<Integer> prime = new ArrayList<Integer>();
        for (int i = 2; i * i <= MAX; i++) {
            if (check[i] == true) {
                continue;
            }
            if (i % 2 != 0) {
                prime.add(i);
            }
            for (int j = i * 2; j <= MAX; j += i) {
                check[j] = true;
            }

        }
        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            for (int i = 0; i < prime.size(); i++) {
                int a = prime.get(i);
                if (check[n - a] == false) {
                    System.out.println(n + " = " + a + " + " + (n - a));
                    break;
                }

            }

        }
    }
}
