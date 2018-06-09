package algorithm.baekjooncourse.math;

import java.util.Scanner;

// https://www.acmicpc.net/problem/2089
public class Baekjoon2089 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 0) {
            System.out.println(0);
        } else {
            go(n);
            System.out.println();
        }
    }

    public static void go(int n) {
        if (n == 0) {
            return;
        }
        if (n % 2 == 0) {
            go(-(n / 2));
            System.out.print(0);
        } else {
            if (n > 0) {
                go(-(n / 2));
            } else {
                go((-n + 1) / 2); // -7일 경우, -7 / 2 몫:-4 나머지 : 1
                                    // 나머지는  음수(-1)면 안되기 때문에 + 1을 해줌으로써 나머지 +1 만들기)
                                    // 2 * -4(몫) = -8 즉 나머지 : 1
            }
            System.out.print(1);
        }
    }
}
