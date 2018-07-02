package algorithm.baekjooncourse2.datastructure.string;

import java.util.Scanner;

public class Baekjoon10808 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] alphabet = new int[26]; // 알파벳 개수
        for (int i = 0; i < s.length(); i++) {
           alphabet[s.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < 26; i++) {
            System.out.print(alphabet[i] + " ");
        }
        System.out.println();
    }
}
