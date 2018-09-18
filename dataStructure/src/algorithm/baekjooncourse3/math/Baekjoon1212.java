package algorithm.baekjooncourse3.math;

import java.util.Scanner;

public class Baekjoon1212 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine().trim();
        StringBuffer sb = new StringBuffer();
        int lineLength = line.length();
        if (lineLength == 1 && line.charAt(0) == '0') {
            sb.append('0');
        }
        String[] arr = {"000","001","010","011","100","101","110","111"};
        for (int i = 0; i < lineLength; i++) {
            int n = line.charAt(i) - '0';
            if (i == 0 && n < 4) {
                if (n == 0) {
                    continue;
                } else if (n == 1) {
                    sb.append('1');
                } else if (n == 2) {
                    sb.append("10");
                } else if (n == 3) {
                    sb.append("11");
                }
            } else {
                sb.append(arr[n]);
            }
        }
        System.out.println(sb);
    }
}
