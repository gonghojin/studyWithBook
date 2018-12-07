package algorithm.baekjooncourse.divde;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://blog.naver.com/PostView.nhn?blogId=phj8498&logNo=221330141350
public class Baekjoon2263 {

    static int inOrder[];
    static int postOrder[];

    static void order(int in_start, int in_end, int post_start, int post_end) {
        if (in_start > in_end || post_start > post_end) {
            return;
        }

        int root = postOrder[post_end];
        System.out.print(root + " ");

        order(in_start, inOrder[root] - 1, post_start, post_start + inOrder[root] - in_start - 1);
        order(inOrder[root] + 1, in_end, post_start + inOrder[root] - in_start, post_end - 1);
    }

    public static void main(String[] args) {
        sc.init();

        int n = sc.nextInt();
        inOrder = new int[n + 1];
        postOrder = new int[n];

        for (int i = 0; i < n; i++) {
            int d = sc.nextInt();
            inOrder[d] = i;
        }
        for (int i = 0; i < n; i++) {
            postOrder[i] = sc.nextInt();
        }

        order(0, n -1, 0, n - 1);
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
