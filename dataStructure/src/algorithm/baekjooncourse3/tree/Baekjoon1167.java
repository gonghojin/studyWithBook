package algorithm.baekjooncourse3.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Baekjoon1167_Pair {
    public int v;
    public int l;

    public Baekjoon1167_Pair(int v, int l) {
        this.v = v;
        this.l = l;
    }
}

public class Baekjoon1167 {
    static ArrayList<Baekjoon1167_Pair>[] a;
    public static void main(String[] args) {
        sc.init();
        int n = sc.nextInt();
        a = (ArrayList<Baekjoon1167_Pair>[]) new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            a[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            int vn = sc.nextInt();
            while (true) {
                int v = sc.nextInt();
                if (v == -1) {
                    break;
                }
                int l = sc.nextInt();
                a[vn].add(new Baekjoon1167_Pair(v, l));
            }

        }

        int[] distPerV = bfs(1, n);
        int start = 1;
        for (int i = 2; i <= n; i++) {
            if (distPerV[start] < distPerV[i]) {
                start = i;
            }
        }
        distPerV = bfs(start, n);
        int ans = distPerV[1];
        for (int i = 2; i <= n; i++) {
            if (ans < distPerV[i]) {
                ans = distPerV[i];
            }
        }
        System.out.println(ans);
    }

    public static int[] bfs(int start, int n) {
        int[] dist = new int[n + 1];
        boolean[] check = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        check[start] = true;

        while (!q.isEmpty()) {
            int x = q.poll();
            for (Baekjoon1167_Pair p : a[x]) {
                int v = p.v;
                int l = p.l;

                if (check[v] == false) {
                    q.add(v);
                    check[v] = true;
                    dist[v] = dist[x] + l;
                }
            }
        }

        return dist;
    }

    static class sc {
        static BufferedReader br;
        static StringTokenizer st;

        static void init() {
            br = new BufferedReader(new InputStreamReader(System.in));
            st = new StringTokenizer("");
        }

        static String next() {
            if (!st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return st.nextToken();
        }

        static int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
