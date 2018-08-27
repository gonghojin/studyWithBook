package algorithm.baekjooncourse3.datastructure;

import java.util.Scanner;

public class Baekjoon10824 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        String aa = String.valueOf(a);
        String bb = String.valueOf(b);
        String cc = String.valueOf(c);
        String dd = String.valueOf(d);
        aa += bb;
        cc += dd;
        long ans1 = Long.parseLong(aa);
        long ans2 = Long.parseLong(cc);
        long ans = ans1 + ans2;
        System.out.println(ans);
    }

}

