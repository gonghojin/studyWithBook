package algorithm.baekjooncourse.divde;

import java.util.Scanner;

//http://mygumi.tistory.com/284
public class Baekjoon1074 {

    static void solve(int n, int r, int c) {
        // 4등분을 해야하는 부분, 2^n으로 증가하니 4등분은 결국 2^(n-1)
        int x = (int) Math.pow(2, n) / 2;
        int y = x;
        int ans = 0;

        while (0 < n--) {
            int temp = (int) Math.pow(2, n) / 2;
            int skip = (int) Math.pow(4, n);

            if (r < y && c < x) {
                // 1
                x -= temp;
                y -= temp;
            } else if (r < y && x <= c) {
                // 2
                x += temp;
                y -= temp;
                ans += skip;
            } else if (y <= r && c < x) {
                // 3
                x -= temp;
                y += temp;
                ans += skip * 2;
            } else {
                // 4
                x += temp;
                y += temp;
                ans += skip * 3;
            }
        }

        System.out.println(ans);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        solve(n, r, c);
    }
}
