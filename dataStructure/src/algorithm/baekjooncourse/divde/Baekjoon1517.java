package algorithm.baekjooncourse.divde;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// ***
public class Baekjoon1517 {

    public static long solve(int[] a, int start, int end) {
        if (start == end) {
            return 0;
        }

        int mid = (start + end) / 2;
        int[] b = new int[end - start + 1];
        long ans = solve(a, start, mid) + solve(a, mid + 1, end);
        {
            int i = start;
            int j = mid + 1;
            int k = 0;
            while (i <= mid || j <= end) {
                if (i <= mid && (end < j || a[i] <= a[j])) {
                    b[k++] = a[i++];
                } else {
                    ans +=  (long) (mid - i + 1);
                    b[k++] = a[j++];
                }
            }
        }

        for (int i = start; i <= end; i++) {
            a[i] = b[i - start];
        }

        return ans;
    }

    public static void main(String[] args) {
        sc.init();
        int n = sc.nextInt();
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = sc.nextInt();
        }
        long ans = solve(d, 0, n -1);
        System.out.println(ans);
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
