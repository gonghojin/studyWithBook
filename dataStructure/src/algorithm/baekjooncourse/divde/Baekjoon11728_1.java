package algorithm.baekjooncourse.divde;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon11728_1 {

    public static void main(String[] args) {
        sc.init();
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }
/*

        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        while (i < n || j < m) {
            if (m <= j || (i < n && a[i] <= b[j])) {
                sb.append(a[i++] + " ");
            } else {
                sb.append(b[j++] + " ");
            }
        }
        System.out.println(sb);

*/
        int[] c = new int[n + m];
        {
            int i = 0;
            int j = 0;
            int k = 0;
            while (i < n || j < m) {
                if (j >= m || (i < n && a[i] <= b[j])) {
                    c[k++] = a[i++];
                } else {
                    c[k++] = b[j++];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n + m; i++) {
            sb.append(c[i] + " ");
        }
        System.out.println(sb);
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
