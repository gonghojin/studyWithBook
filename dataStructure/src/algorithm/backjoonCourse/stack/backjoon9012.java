package algorithm.backjoonCourse.stack;

import java.util.Scanner;

public class backjoon9012 {
    public static String isValid(String s) {
        s = s.trim();
        int n = s.length();
        int cnt = 0;

        for (int i = 0; i < n; i++) {

            if (s.charAt(i) == '(') {
                cnt++;
            } else {
                cnt--;
            }
            if (cnt < 0) {
                return "NO";
            }
        }

        if (cnt == 0) {
            return "YES";
        } else {
            return "NO";
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        while (n-- > 0) {
            System.out.println(isValid(sc.nextLine()));
        }
    }
}
