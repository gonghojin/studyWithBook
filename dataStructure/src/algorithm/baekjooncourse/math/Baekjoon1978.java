package algorithm.baekjooncourse.math;

import java.util.Scanner;

// https://www.acmicpc.net/problem/1978
public class Baekjoon1978 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0;

        while (n-- > 0) {
            if (is_prime(sc.nextInt())) {
                ans += 1;
            }
        }

        System.out.println(ans);
    }

    private static boolean is_prime(int x) {
        if (x <= 1) {
            return false;
        } else if (x == 2) {
            return true;
        }

        for (int i = 2; i * i <= x; i++) { // 일반적인 방식으로는 루트방식을 이용한 방법이 가장 빠름
            if (x % i == 0) {               //그러나 루트방식 + 아레토스테네스의 체를 적용하면 훨씬 빨라짐(1919문제)
                return false;
            }
        }
        return true;
    }
}
