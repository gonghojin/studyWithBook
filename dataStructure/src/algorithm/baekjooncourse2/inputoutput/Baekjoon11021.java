package algorithm.baekjooncourse2.inputoutput;

import java.util.Scanner;

// https://www.acmicpc.net/problem/11021
public class Baekjoon11021 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            System.out.println("Case #" + i + ": " + (x+y));
        }
    }
}
