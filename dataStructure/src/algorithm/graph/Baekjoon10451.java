package algorithm.graph;

import java.util.Scanner;

// https://www.acmicpc.net/problem/10451
public class Baekjoon10451 {
    private static void dfs(int[] a, boolean[] c, int i) {
        if (c[i] == true) {
            return;
        }
        c[i] = true;
        // // 다음 정점은 항상 한 개이기 떄문에 for문 필요없음
        dfs(a, c, a[i]);

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // 테스트 케이스 개수

        while (t-- > 0) {
            int n = sc.nextInt(); // 정점 개수
            int[] a = new int[n+1]; // 정점 // 모든 정점이 항상 간선을 하나 가지기 떄문에 인접행렬은 매우 비효율적, 또한 인접리스트도 필요없음
            boolean[] c = new boolean[n+1];
            for (int i = 1; i <= n; i++) {
                a[i] = sc.nextInt();
            }

            int ans = 0; // 사이클 개수
            for (int i = 1; i <= n; i++) {
                if (c[i] == false) {
                    dfs(a, c, i);
                    ans += 1;
                }
            }
            System.out.println(ans);
        }
    }


}

