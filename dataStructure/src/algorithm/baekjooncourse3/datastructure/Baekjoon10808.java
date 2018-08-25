package algorithm.baekjooncourse3.datastructure;

import java.util.Scanner;

public class Baekjoon10808 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int sLength = s.length();
        int[] a = new int[26];
        for (int i = 0; i < 26; i++) {
            a[i] = -1;
        }
        for (int i = 0; i < sLength; i++) {
            char c = s.charAt(i);
            int cInt = c - 'a';
            if (a[cInt] == -1) {
                a[cInt] = i;
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 26; i++) {
            sb.append(a[i] + " ");
        }
        System.out.println(sb);
    }
}
