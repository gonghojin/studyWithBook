package algorithm.baekjooncourse.greedy;

import java.util.Scanner;

public class Baekjoon1783 {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int height = sc.nextInt();
       int width = sc.nextInt();

       if (height == 1) { // 이동 못함
           System.out.println(1);
       } else if(height == 2) {
           System.out.println(Math.min(4, (width + 1) / 2));
       } else if (3 <= height) {
           if (7 <= width) {
               System.out.println(width - 2);
           } else {
               System.out.println(Math.min(4, width));
           }
       }
    }
}
