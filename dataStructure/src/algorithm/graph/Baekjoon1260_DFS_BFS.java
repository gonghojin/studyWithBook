package algorithm.graph;

import java.util.*;

// https://www.acmicpc.net/problem/1260
// 인접리스트 활용
public class Baekjoon1260_DFS_BFS {
    public static ArrayList<Integer>[] a;
    public static boolean[] c;// 지나간 정점인지 체크

    // dfs는 스택 원리의 자료구조 따라서 재귀함수 사용
    private static void dfs(int x) {
        if (c[x]) {
            return;
        }
        c[x] = true; // 지나간 정점
        System.out.print(x + " ");
        for (int y : a[x]) {
            if (c[y] == false) {
                dfs(y);
            }
        }
    }

    // bfs는 큐
    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<Integer>(); // 큐는 인터페이스다.
        q.add(start);
        c[start] = true;

        while (!q.isEmpty()) {
            int x = q.remove(); // bfs는  큐, 따라서 지나갈 때 정점이 지나갈 때 바로 제거
            System.out.print(x + " ");

            for (int y : a[x]) {
                if (c[y] == false) {
                    c[y] = true;
                    q.add(y);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 정점
        int m = sc.nextInt(); // 간선
        int start = sc.nextInt(); // 시작 정점
        a = (ArrayList<Integer>[]) new ArrayList[n+1];

        for (int i = 1; i <= n; i++) { // 문제조건 : 정점은 1부터 시작
            a[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) { // 정점 u와 연결된 정점
            int u = sc.nextInt();
            int v = sc.nextInt();
            //문제 조건 : 양방향 간선
            a[u].add(v);
            a[v].add(u);
        }
        for (int i = 1; i<= n; i++) {
            Collections.sort(a[i]); // 문제조건 : 방문가능한 정점이 여러 개인 경우 , 작은 정점부터
        }

        // 깊이우선탐색(dfs)
        c = new boolean[n+1];
        dfs(start);
        System.out.println();
        // 너비우선탐색(bfs)
        c = new boolean[n+1];
        bfs(start);
        System.out.println();
    }




}
