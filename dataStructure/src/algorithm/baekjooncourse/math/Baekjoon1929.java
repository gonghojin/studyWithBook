package algorithm.baekjooncourse.math;

import java.util.Scanner;

// https://www.acmicpc.net/problem/1929 - 아레토스테네스의 체를 적용한 소수
public class Baekjoon1929 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean[] check = new boolean[m+1]; // false == 소수
        check[0] = check[1] = true;// 0과 1은 소수 x

        for (int i = 2; i * i <= m; i++) {  // 루트 적용하여 반복문 횟수 줄이기
            if (check[i] == true) {
                continue;
            }
            for (int j = i + i; j <= m; j+=i) { // 아레토스테네스의 체 적용
                check[j] = true;
            }
        }

        for (int i = n; i <= m; i++) {
            if (check[i] == false) {
                System.out.println(i);
            }
        }
    }
}
