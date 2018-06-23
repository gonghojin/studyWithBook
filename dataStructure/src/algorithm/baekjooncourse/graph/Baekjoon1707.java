package algorithm.baekjooncourse.graph;

import java.util.ArrayList;
import java.util.Scanner;

// https://www.acmicpc.net/problem/1707
// DFS 활용
public class Baekjoon1707 {
    private static void dfs(ArrayList<Integer>[] a, int[] color, int x, int c) {
        color[x] = c;
        for (int y : a[x]) {
            if (color[y] == 0) {
                dfs(a, color, y, 3 - c); // 1 + 2 = 3, c + (3 - c) = 3
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // 테스트 케이스 개수

        while (t-- > 0) {
            int n = sc.nextInt(); // 정점 개수
            int m = sc.nextInt(); // 간선 개수

            ArrayList<Integer>[] a = (ArrayList<Integer>[]) new ArrayList[n+1];
            for (int i = 1; i <= n; i++) {
                a[i] = new ArrayList<Integer>();
            }
            for (int i = 0; i < m; i++) { // 간선 연결
                int u = sc.nextInt();
                int v = sc.nextInt();

                a[u].add(v);
                a[v].add(u);
            }

            int[] color = new int[n+1]; // 1은 왼쪽 2는 오른쪽
            boolean ok = true;
            for (int i = 1; i <= n; i++) {
                if (color[i] == 0) { // 지나가지 않았다면
                    dfs(a, color, i, 1);
                }
            }

            for (int i = 1; i <= n; i++) {
                for(int x : a[i]) {
                    if (color[i] == color[x]) {
                        ok = false;
                    }
                }
            }

            if (ok) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }


}
