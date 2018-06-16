package algorithm.graph;

import java.util.Scanner;

// https://www.acmicpc.net/problem/2331
public class Baekjoon2331 {
    public static int[] check = new int[1000000];

    private static int pow(int x, int p) {
        int ans = 1;
        for (int i = 0; i < p; i++) {
            ans *= x;
        }

        return ans;
    }
    private static int next(int a, int p) {
        int ans = 0;
        while (a > 0) {
            ans += pow(a % 10, p);
            a /= 10;
        }

        return ans;
    }



    private static int length(int a, int p, int cnt) {
        if (check[a] != 0) { // 0이 아니라는 것은 사이클이라는 뜻
            return check[a] - 1; // 따라서 사이클 앞 자리까지가 문제가 요하는 답
        }
        check[a] = cnt;
        int b = next(a, p);

        return length(b, p, ++cnt);
    }

    public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     int a = sc.nextInt();
     int p = sc.nextInt();
     System.out.println(length(a, p, 1)); // cnt == 정점 순서
    }


}
