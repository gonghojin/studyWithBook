package algorithm.baekjooncourse2.datastructure.string;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon11656 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int lineLength = line.length();
        String[] lineArr = new String[lineLength];
        for (int i = 0; i < lineLength; i++) {
            lineArr[i] = line.substring(i);
        }
        Arrays.sort(lineArr);
        for (int i = 0; i < lineLength; i++) {
            System.out.println(lineArr[i]);
        }
    }
}
