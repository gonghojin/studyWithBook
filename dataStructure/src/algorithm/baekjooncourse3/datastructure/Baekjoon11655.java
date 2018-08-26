package algorithm.baekjooncourse3.datastructure;

import java.util.Scanner;

public class Baekjoon11655 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int sLength = s.length();
        char[] cArr = s.toCharArray();
        for (int i = 0; i < sLength; i++) {
            char c = cArr[i];
            if ('a' <= c && c <= 'z') {
                int cint = c - 'a';
                if (cint < 13) {
                    c += 13;
                } else {
                    c -= 13;
                }
            } else if ('A' <= c && c <= 'Z') {
                int cint = c - 'A';
                if (cint < 13) {
                    c += 13;
                } else {
                    c -= 13;
                }
            }
            System.out.print(c);
        }

    }
}

