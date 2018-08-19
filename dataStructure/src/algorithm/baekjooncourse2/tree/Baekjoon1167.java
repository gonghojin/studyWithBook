package algorithm.baekjooncourse2.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 트리의 지름 개념 설명 : http://mygumi.tistory.com/226
class Edge {
    int to;
    int cost;

    public Edge(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
}
public class Baekjoon1167 {

    static class sc {
        private static BufferedReader br;
        private static StringTokenizer st;

        static void init() {
            br = new BufferedReader(new InputStreamReader(System.in));
            st = new StringTokenizer("");
        }

        private static String readLine() {
            try {
                return br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        private static String next() {
            while (!st.hasMoreTokens()) {
                st = new StringTokenizer(readLine());
            }
            return st.nextToken();
        }

        public static int nextInt() {
            return Integer.parseInt(next());
        }
    }

    public static int[] bfs (int n, List<Edge>[] a, int start) {
        boolean[] check = new boolean[n+1];
        int[] dist = new int[n+1];
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);
        check[start] = true;
        while (!q.isEmpty()) {
            int x = q.remove();
            for (Edge e : a[x]) {
                int y = e.to;
                int cost = e.cost;
                if (check[y] == false) {
                    q.add(y);
                    check[y] = true;
                    dist[y] = dist[x] + cost;
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        sc.init();
        int n = sc.nextInt();
        List<Edge>[] a = (ArrayList<Edge>[]) new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            a[i] = new ArrayList<Edge>();
        }
        for (int i = 1; i <= n; i++) {
            int x = sc.nextInt();
            while (true) {
                int y = sc.nextInt();
                if (y == -1) {
                    break;
                }
                int z = sc.nextInt();
                a[x].add(new Edge(y, z));
            }
        }
        int[] dist = bfs(n, a, 1);
        int start = 1;
        for (int i = 2; i <= n; i++) {
            if (dist[i] > dist[start]) {
                start = i;
            }
        }
        dist = bfs(n, a, start);
        int ans = dist[1];
        for (int i = 2; i <= n; i++) {
            if (ans < dist[i]) {
                ans = dist[i];
            }
        }
        System.out.println(ans);
    }
}
