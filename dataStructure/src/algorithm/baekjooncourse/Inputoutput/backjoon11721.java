package algorithm.baekjooncourse.Inputoutput;

import java.util.Scanner;

public class backjoon11721 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        sc.close();

        for (int i = 0; i < line.length(); i++) {
            if (i % 10 == 0 && i != 0) {
                System.out.println();
            }
            System.out.print(line.charAt(i));

        }
    }
}
