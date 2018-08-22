package algorithm.baekjooncourse3.datastructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon1158 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }
        StringBuffer sb = new StringBuffer();
        sb.append("<");

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m -1; i++) {
                q.add(q.remove());
            }
            sb.append(q.poll() + ", ");
        }
        sb.append(q.remove() + ">");
        System.out.println(sb);
    }
}
