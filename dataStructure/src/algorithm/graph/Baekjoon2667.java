package algorithm.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// https://www.acmicpc.net/problem/2667
// bfs 활용

public class Baekjoon2667 {

    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {-1, 1, 0, 0};

    private static void bfs(int[][] a, int[][] group, int x, int y, int cnt, int n) {
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(x, y));
        group[x][y] = cnt;
        while (!q.isEmpty()) {
            Pair p = q.remove();
            x = p.x;
            y = p.y;
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                    if (a[nx][ny] == 1 && group[nx][ny] == 0) {
                        q.add(new Pair(nx, ny));
                        group[nx][ny] = cnt;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 지도 크기
        sc.nextLine();
        int[][] a = new int[n][n]; // 단지 배열
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < n; j++) {
                // 어떤 칸과 연결되어있는 칸이 항상 상하좌우 4칸 중 하나이기 때문에
                // 모든 칸마다 4칸을 검사하면 되기 때문에 인접행렬이나 리스트 필요없음
                a[i][j] = s.charAt(j) - '0';
            }
        }

        int cnt = 0; // 단지 개수 및 단지 구별 값
        int[][] group = new int[n][n];
        // group 배열 == 단지 구별
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 1 && group[i][j] == 0) {
                    bfs(a, group, i, j, ++cnt, n);
                }
            }
        }

        int[] ans = new int[cnt];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (group[i][j] != 0) {
                    ans[group[i][j] - 1] += 1;
                }
            }
        }

        Arrays.sort(ans);
        System.out.println(cnt);
        for (int i = 0; i < cnt; i++) {
            System.out.println(ans[i]);
        }
    }

}

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}