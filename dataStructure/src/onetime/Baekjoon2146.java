package onetime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2146 {

    public static void preorder(int[][] node, int x) {
        if (x == -1) {
            return;
        }
        System.out.print((char) (x + 'A'));
        preorder(node, node[x][0]);
        preorder(node, node[x][1]);
    }

    public static void inorder(int[][] node, int x) {
        if (x == -1) {
            return;
        }
        inorder(node, node[x][0]);
        System.out.print((char) (x + 'A'));
        inorder(node, node[x][1]);
    }

    public static void postorder(int[][] node, int x) {
        if (x == -1) {
            return;
        }
        postorder(node, node[x][0]);
        postorder(node, node[x][1]);
        System.out.print((char) (x + 'A'));
    }

    public static void main(String[] args) {
        sc.init();
        int n = sc.nextInt();
        int[][] node = new int[26][2];
        for (int i = 0; i < n; i++) {
            int parent = sc.next().charAt(0) - 'A';
            char childA = sc.next().charAt(0);
            char childB = sc.next().charAt(0);

            if (childA == '.') {
                node[parent][0] = -1;
            } else {
                node[parent][0] = childA - 'A';
            }
            if (childB == '.') {
                node[parent][1] = -1;
            } else {
                node[parent][1] = childB - 'A';

            }
        }

        preorder(node, 0);
        System.out.println();
        inorder(node, 0);
        System.out.println();
        postorder(node, 0);
        System.out.println();
    }

    static class sc {
        private static BufferedReader br;
        private static StringTokenizer st;

        private static void init() {
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

        private static int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
