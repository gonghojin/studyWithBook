package algorithm.baekjooncourse2.datastructure;

import java.util.Scanner;

// https://www.acmicpc.net/problem/9012
public class Baekjoon9012 {

    private static String isValid(String s) {
        int count = 0;
        s = s.trim();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else {
                count--;
            }

            if (count < 0) {
                return "NO";
            }
        }
        if (count == 0) {
            return "YES";
        } else {
            return "NO";
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            System.out.println(isValid(sc.nextLine()));
        }
    }


}
