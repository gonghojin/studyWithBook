package algorithm.baekjooncourse.divde;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon10815_1 {
    public static void main(String[] args) {
        sc.init();
        int n = sc.nextInt();
        int[] arrN = new int[n];
        for (int i = 0; i < arrN.length; i++) {
            arrN[i] = sc.nextInt();
        }

        Arrays.sort(arrN);

        int m = sc.nextInt();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int searchValue = sc.nextInt();
            boolean res = binary_search(arrN, searchValue);
            if (res) {
                ans.append("1 ");
            } else {
                ans.append("0 ");
            }
        }
        System.out.println(ans);

    }

    public static boolean binary_search(int[] arrN, int searchValue) {
        int arrNSize = arrN.length;
        int start = 0;
        int end = arrNSize - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arrN[mid] == searchValue) {
                return true;
            } else if (arrN[mid] < searchValue) {
                start = mid + 1;
            } else if (searchValue < arrN[mid]) {
                end = mid - 1;
            }
        }
        return false;
    }
/* TODO 이 방법보다 위 방법이 훨씬 빠름
    public static void binary_search(int[] arrN, int searchValue) {
        int arrNSize = arrN.length;
        int start = 0;
        int end = arrNSize - 1;        while (start <= end) {
            int mid = (start + end) / 2;
            if (arrN[mid] == searchValue) {
                System.out.print("1 ");
                return;
            } else if (arrN[mid] < searchValue) {
                start = mid + 1;
            } else if (searchValue < arrN[mid]) {
                end = mid - 1;
            }
        }
        System.out.print("0 ");
        return;
    }
    */
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
