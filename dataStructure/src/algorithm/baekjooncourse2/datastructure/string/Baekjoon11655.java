package algorithm.baekjooncourse2.datastructure.string;

import java.util.Scanner;

public class Baekjoon11655 {
    public static String rot13(String line) {
        String ans = "";
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if ('A' <= c && c <= 'M') {
                c += 13;
            } else if ('N' <= c && c <= 'Z') {
                c -= 13;
            } else if ('a' <= c && c <= 'm') {
                c += 13;
            } else if ('n' <= c && c <= 'z') {
                c -= 13;
            }
            ans += c;
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        System.out.println(rot13(line));

    }

}
