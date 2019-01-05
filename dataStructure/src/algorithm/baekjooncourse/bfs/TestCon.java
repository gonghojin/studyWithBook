package algorithm.baekjooncourse.bfs;

import java.util.Scanner;

public class TestCon {

    static int ans = 0;

    static void calc(int n) {
        ans += n * (n - 1) / 2;
    }

    static void solve(int[] a, int x, int diff, int cnt) {
        int temp = a[x] - a[x - 1];

        if (diff == temp) {
            if (x == a.length - 1) {
                calc(++cnt);
                return;
            }
            solve(a, ++x, temp, ++cnt);
        } else if (diff != temp) {
            if (x == a.length - 1) {
                calc(cnt);
                return;
            }
            calc(cnt);
            solve(a, ++x, temp, 1);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = sc.nextInt();
        }
        solve(d, 1, 0, 1);
        System.out.println(ans);
    }
}
