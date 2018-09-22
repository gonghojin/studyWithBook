package algorithm.baekjooncourse3.math;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Baekjoon6588 {

    public static final int MAX = 1000000;

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        boolean[] check = new boolean[MAX + 1];
        check[0] = check[1] = true;

        for (int i = 2; i * i <= MAX; i++) {
            if (check[i] == true) {
                continue;
            }

            list.add(i);
            for (int k = i + i; k <= MAX; k += i) {
                check[k] = true;
            }
        }

        Scanner sc = new Scanner(System.in);

        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }

            for (int i = 0; i < list.size(); i++) {
                int a = list.get(i);
                int b = n - a;
                if (check[b] == false) {
                    System.out.println(n + " = " + a + " + " + b);
                    break;
                }
                if (n <= a) {
                    System.out.println("Goldbach's conjecture is wrong.");
                    break;
                }
            }
        }
    }

}
