package algorithm.baekjooncourse.math;

import java.util.ArrayList;
import java.util.Scanner;

// https://www.acmicpc.net/problem/6588
public class Baekjoon6588 {

    public static final int MAX = 1000000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[] check = new boolean[MAX+1];
        ArrayList<Integer> prime = new ArrayList<Integer>();

        check[0] = check[1] = true; // 0 , 1 소수 x
        for (int i = 2; i * i <= MAX; i++) { // 루트 이용
            if (check[i] == true) {
                continue;
            }
            prime.add(i);

            for (int j = i + i; j <= MAX; j += i) {
                check[j] = true;
            }
        }

        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }

            for (int i = 1; i < prime.size(); i++) {// list(0) == 2 따라서 굳이 확인 필요 없음
              int p = prime.get(i);
              if (check[n-p] == false) {
                  System.out.println(n + " = " + p + " + " + (n - p));
                  break; // n(-p) - p 값이 가장 큰 수를 원했기 떄문에 바로 break;
              }
            }
        }

    }
}
