package algorithm.baekjooncourse2.datastructure.string;

import java.util.Scanner;

public class Baekjoon10824 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        String ab = String.valueOf(a) + String.valueOf(b);
        String cd = String.valueOf(c) + String.valueOf(d);
        long abcd = Long.valueOf(ab) + Long.valueOf(cd);
        System.out.println(abcd);
    }
}
