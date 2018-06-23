package algorithm.baekjooncourse.graph;

import java.util.ArrayList;
import java.util.Scanner;

// https://www.acmicpc.net/problem/11724
// 연결리스트 활용
public class Baekjoon11724 {
    public static ArrayList<Integer>[] a;
    public static boolean[] check;

    private static void dfs(int x) {
        if (check[x]) {
            return;
        }
        check[x] = true;
        for (int y : a[x]) {
            dfs(y);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 정점 개수
        int m = sc.nextInt(); // 간선 개수
        a = (ArrayList<Integer>[]) new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            a[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) { // 정점 u와 v의 간선
            int u = sc.nextInt();
            int v = sc.nextInt();
            // 양방향 간선
            a[u].add(v);
            a[v].add(u);
        }
        check = new boolean[n + 1];
        int ans = 0; // 연결요소
        for (int i = 1; i <= n; i++) {
            if (check[i] == false) {
                dfs(i);
                ans += 1;
            }
        }

        System.out.println(ans);
    }


}
