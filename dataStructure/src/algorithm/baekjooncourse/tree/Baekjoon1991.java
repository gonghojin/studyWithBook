package algorithm.baekjooncourse.tree;

import java.util.Scanner;

// https://www.acmicpc.net/problem/1991
public class Baekjoon1991 {
    public static void preorder(int[][] a, int x) {
        if (x == -1) { // '.'라면
            return;
        }
        System.out.print((char) (x + 'A'));
        preorder(a, a[x][0]);
        preorder(a, a[x][1]);
    }

    public static void inorder(int[][] a, int x) {
        if (x == -1) {
            return;
        }
        inorder(a, a[x][0]);
        System.out.print((char) (x + 'A'));
        inorder(a, a[x][1]);
    }

    public static void postorder(int[][] a, int x) {
        if (x == -1) {
            return;
        }
        postorder(a, a[x][0]);
        postorder(a, a[x][1]);
        System.out.print((char) (x + 'A'));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[][] a = new int[26][2]; // 2진트리 노트 개수 26
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            int x = line.charAt(0) - 'A';
            char l = line.charAt(2);
            char r = line.charAt(4);

            if (l == '.') {
                a[x][0] = -1;
            } else {
                a[x][0] = l - 'A';
            }
            if (r == '.') {
                a[x][1] = -1;
            } else {
                a[x][1] = r - 'A';
            }
        }

        preorder(a, 0);
        System.out.println();
        inorder(a, 0);
        System.out.println();
        postorder(a, 0);
        System.out.println();

    }
}
