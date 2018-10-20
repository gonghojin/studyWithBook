package algorithm.baekjooncourse.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon11047_nonrepeat {
    public static void main(String[] args) {
        sc.init();
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] coinArr = new int[n];
        for (int i = n - 1; 0 <= i; i--) {
            coinArr[i] = sc.nextInt();
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += k / coinArr[i];
            k %= coinArr[i];
        }
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
