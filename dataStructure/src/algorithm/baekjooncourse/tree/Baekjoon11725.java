package algorithm.baekjooncourse.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// https://www.acmicpc.net/problem/11725
public class Baekjoon11725 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer>[] a = (ArrayList<Integer>[]) new ArrayList[n+1];
        for (int i = 1; i <= n; i++) { // 노드의 개수
            a[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < n - 1; i++) { // 간선
            int u = sc.nextInt();
            int v = sc.nextInt();
            a[u].add(v);
            a[v].add(u);
        }
        boolean[] check = new boolean[n+1]; // 1번 인덱스부터
        int[] parent = new int[n+1]; // 시작
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(1);
        check[1] = true;
        while (!q.isEmpty()) {
            int x = q.remove();
            for (int y : a[x]) {
                if (check[y] == false) {
                    check[y] = true;
                    parent[y] = x;
                    q.add(y);
                }
            }
        }
        for (int i = 2; i <= n; i++) { //2번째 노드부터
            System.out.println(parent[i]);
        }
    }
}
