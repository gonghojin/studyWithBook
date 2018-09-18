package algorithm.baekjooncourse3.math;

import java.util.Scanner;

public class Baekjoon1373 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine().trim();
        int lineLength = line.length();
        StringBuffer sb = new StringBuffer();
        if (lineLength % 3 == 1) {
            sb.append(line.charAt(0));
        } else if (lineLength % 3 == 2) {
            sb.append((line.charAt(0) - '0') * 2 +(line.charAt(1) - '0'));
        }
        for (int i = lineLength % 3; i < lineLength; i+= 3) {
            sb.append((line.charAt(i) - '0') * 4 + (line.charAt(i + 1) - '0') * 2 + (line.charAt(i + 2) - '0'));
        }
        System.out.println(sb);
    }
}
