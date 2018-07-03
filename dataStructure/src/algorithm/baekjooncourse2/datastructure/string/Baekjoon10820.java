package algorithm.baekjooncourse2.datastructure.string;

import java.util.Scanner;

public class Baekjoon10820 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            int lower = 0;
            int upper = 0;
            int digit = 0;
            int space = 0;
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                if ('a' <= c && c <= 'z') {
                    lower += 1;
                } else if ('A' <= c && c <= 'Z') {
                    upper += 1;
                } else if ('0' <= c && c <= '9') {
                    digit += 1;
                } else if (c == ' ') {
                    space += 1;
                }
            }
            System.out.println(lower + " " + upper + " " + digit + " " + space);
        }
    }
}
