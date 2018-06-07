package algorithm.baekjooncourse.math;

import java.util.Scanner;

// https://www.acmicpc.net/problem/2745
public class Baekjoon2745 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split(" ");
        String s = line[0];
        int b = Integer.valueOf(line[1]);
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if ('0' <= c && c <= '9') {
                ans = ans * b  + (c - '0');
            } else {
                ans = ans * b + (c - 'A' + 10);
            }

        }
        System.out.println(ans);
    }
}
