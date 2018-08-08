package algorithm.baekjooncourse2.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon11724 {
    public static ArrayList<Integer>[] a;
    public static boolean[] check;

    public static void bfs(int x) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(x);
        check[x] = true;
        while (!q.isEmpty()) {
            int n = q.remove();
            for (int y : a[n]) {
                if (check[y] == false) {
                    check[y] = true;
                    q.add(y);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        a = (ArrayList<Integer>[]) new ArrayList[n + 1];
        check = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            a[u].add(v);
            a[v].add(u);
        }
        br.close();
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (check[i] == false) {
                bfs(i);
                ans++;
            }
        }
        System.out.println(ans);
    }
}
