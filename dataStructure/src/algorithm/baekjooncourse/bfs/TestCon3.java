package algorithm.baekjooncourse.bfs;

import java.util.Scanner;

public class TestCon3 {

    static int temp_a;
    static int temp_b;
    static int ans;


    static void calc(int cnt) {
        if (ans < cnt) {
            ans = cnt;
        }
    }

    static void solve(int[] a) {
        int size = a.length;
        int cnt = 0;
        for (int i = 0; i < size; i++) {
            if (a[i] == temp_a) {
                temp_a = temp_b; //temp_a == old값 temp_b == new 값
                temp_b = a[i];
                calc(cnt); // 보완 밑에 지우고 ++cnt
                cnt++;
            } else if (a[i] == temp_b) {
                calc(cnt);
                cnt++;
            } else {
                temp_a = temp_b;
                temp_b = a[i];
                calc(cnt);
                cnt = 2;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = sc.nextInt();
        }
        solve(d);
        System.out.println(ans);
    }
}
