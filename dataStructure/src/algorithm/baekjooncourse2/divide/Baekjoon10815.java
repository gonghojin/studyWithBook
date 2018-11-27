package algorithm.baekjooncourse2.divide;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon10815 {
    public static void main(String[] args) {
        SC.init();
        int n = SC.nextInt();
        int[] nr = new int[n];
        for (int i = 0; i < n; i++) {
            nr[i] = SC.nextInt();
        }
        Arrays.sort(nr);

        int m = SC.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            boolean ck = binary_seasrch(nr, SC.nextInt());
            if (ck) {
                sb.append("1 ");
            } else {
                sb.append("0 ");
            }
        }
        System.out.println(sb);
    }

    public static boolean binary_seasrch(int[] nr, int searchValue) {
        int nrLength = nr.length;
        int start = 0;
        int end = nrLength - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nr[mid] == searchValue) {
                return true;
            } else if (searchValue < nr[mid] ) {
                end = mid - 1;
            } else if (nr[mid] < searchValue) {
                start = mid + 1;
            }
        }

        return false;
    }
    static class SC {
        public static BufferedReader br;
        public static StringTokenizer st;

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
