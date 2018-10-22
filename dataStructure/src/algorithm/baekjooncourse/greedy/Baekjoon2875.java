package algorithm.baekjooncourse.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon2875 {

    public static void main(String[] args) {
        sc.init();
        int n = sc.nextInt(); // 여자
        int m = sc.nextInt(); // 남자
        int k = sc.nextInt(); // 인턴

        int ans = 0;
        while (2 <= n && 1 <= m && k + 3 <= n + m) {
            n -= 2;
            m -= 1;
            ans += 1;
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