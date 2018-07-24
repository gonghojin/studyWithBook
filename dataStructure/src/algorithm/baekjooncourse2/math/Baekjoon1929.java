package algorithm.baekjooncourse2.math;

import java.util.Scanner;

public class Baekjoon1929 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        boolean[] arr = new boolean[n+1];
        arr[0] = arr[1] = true;

        for (int i = 2; i * i <= n; i++) {
            if (arr[i] == true) {
                continue;
            }
            for (int j = i * 2; j <= n; j += i) {
                arr[j] = true;
            }
        }
        for (int i = m; i <= n; i++) {
            if (arr[i] == false) {
                System.out.println(i);
            }
        }
    }
}
