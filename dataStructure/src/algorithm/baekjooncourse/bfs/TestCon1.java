package algorithm.baekjooncourse.bfs;


import java.util.Scanner;

public class TestCon1 {

    static int solve(int[] a, int x, int cnt) {
        if (x == -1) {
            return cnt;
        }
        cnt++;
        int index = a[x];
        return solve(a, index, cnt);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = new int[n];
        for(int i = 0; i < n; i++) {
            d[i] = sc.nextInt();
        }
        solve(d, 0, 0);
    }
}
