package algorithm.baekjooncourse2.graph;

import java.util.Scanner;

public class Baekjoon2331 {
    public static int[] check = new int[1000000];

    public static int pow(int x, int p) {
        int ans = 1;
        for (int i = 0; i < p; i++) {
            ans = ans * x;
        }
        return ans;
    }

    public static int next(int a, int p) {
        int ans = 0;
        while (a > 0) {
            ans += pow(a % 10, p);
            a /= 10;
        }
        return ans;
    }

    public static int length(int a, int p, int cnt) {
        if (check[a] != 0) {
            return check[a] - 1;
        }
        check[a] = cnt;
        int b = next(a, p);
        return length(b, p, ++cnt);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int p = sc.nextInt();
        System.out.println(length(a, p, 1));
    }
}
