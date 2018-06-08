package algorithm.baekjooncourse.math;

import java.util.Scanner;

// https://www.acmicpc.net/problem/1212
public class Baekjoon1212 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] eight = {"000","001","010","011","100","101","110","111"};
        boolean start = true; // 8진수 첫번째 수
        if (s.length() == 1 && s.charAt(0) == '0') {
            System.out.println(0);
        }

        for (int i = 0; i < s.length(); i++) {
            int n = s.charAt(i) - '0';
            if (start == true && n < 4) { // 4보다 작은 수는 3자리의 2진수가 아님
                if (n == 0) {
                    continue;
                } else if (n == 1) {
                    System.out.print("1");
                } else if (n == 2) {
                    System.out.print("10");
                } else if (n == 3) {
                    System.out.print("11");
                }
                start = false; //  두번째 8진수
            } else {
                System.out.print(eight[n]);
                start = false;
            }
        }
        System.out.println();
    }
}
