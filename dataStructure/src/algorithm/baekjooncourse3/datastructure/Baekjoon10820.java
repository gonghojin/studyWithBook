package algorithm.baekjooncourse3.datastructure;

import java.util.Scanner;

public class Baekjoon10820 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            int lower = 0;
            int upper = 0;
            int digit = 0;
            int space = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if ('A' <= c && c <= 'Z') {
                    upper += 1;
                } else if ('a' <= c && c <= 'z') {
                    lower += 1;
                } else if ('0' <= c && c <= '9') {
                    digit += 1;
                } else if (' ' == c) {
                    space += 1;
                }
            }
            System.out.println(lower + " " + upper + " " + digit + " " + space);
        }
    }
}


