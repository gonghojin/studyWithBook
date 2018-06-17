package algorithm.graph;

import java.util.Scanner;

// https://www.acmicpc.net/problem/9466
// 재귀함수 사용
public class Baekjoon9466_recursive {
    public static int[] a, d, s;

    private static int dfs(int x, int cnt, int step) {
        if (d[x] != 0) {
            if (step != s[x]) { // 같은 사이클의 범위를 step으로 표현
                return 0; // 같지 않다는 것은 사이클을 형성 못했다는 뜻.
            }
            return cnt - d[x]; // 같은 사이클이니 d[x] 빼줘야 첫번쨰 시작점이 2번 안들어감
        }                       // d[x]는 출발점이니 항상 1 = cnt
        d[x] = cnt;
        s[x] = step;

        return dfs(a[x], cnt + 1, step);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            a = new int[n+1]; // 입력 배열
            d = new int[n+1]; // 시작 정점부터 몇 번 째 방문 자리인지
            s = new int[n+1]; // 시작 정점으로 같은 사이클인지 구분

            for (int i = 1; i <= n; i++) {
                a[i] = sc.nextInt(); // 정점
                d[i] = 0;
                s[i] = 0;
            }
            int ans = 0;
            for (int i = 1; i <= n; i++) {
                if (d[i] == 0) { // 지나가지 않았다면
                    ans += dfs(i, 1, i);
                }
            }
            System.out.println(n - ans);
        }
    }


}
