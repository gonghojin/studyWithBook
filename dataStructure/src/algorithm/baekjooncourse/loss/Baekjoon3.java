package algorithm.baekjooncourse.loss;

import java.util.Scanner;

public class Baekjoon3 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a'] += 1;
        }

        for (int i = 0; i < 26; i++) {
            System.out.print(cnt[i] + " ");
        }

        System.out.println();
    }
}
