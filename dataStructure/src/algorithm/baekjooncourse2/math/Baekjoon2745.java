package algorithm.baekjooncourse2.math;

import java.util.Scanner;

public class Baekjoon2745 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split(" ");
        String n = line[0];
        int b  = Integer.parseInt(line[1]);
        int ans = 0;
        for (int i = 0; i < n.length(); i++) {
            char c = n.charAt(i);
            if ('0' <= c && c <= '9') {
                ans = ans * b + (c - '0');
            } else {
                ans = ans * b + (c - 'A' + 10);
            }
        }
        System.out.println(ans);
    }
}
