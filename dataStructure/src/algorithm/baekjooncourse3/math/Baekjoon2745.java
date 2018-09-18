package algorithm.baekjooncourse3.math;

import java.util.Scanner;

public class Baekjoon2745 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().trim().split(" ");
        int arrLeng = line[0].length();
        int b = Integer.parseInt(line[1]);
        int ans = 0;
        for (int i = 0; i < arrLeng; i++) {
            char ch = line[0].charAt(i);
            if ('0' <= ch && ch <= '9') {
                ans = ans * b + (ch - '0');
            } else {
                ans = ans * b + (ch - 'A' + 10);
            }
        }
        System.out.println(ans);
    }
}
