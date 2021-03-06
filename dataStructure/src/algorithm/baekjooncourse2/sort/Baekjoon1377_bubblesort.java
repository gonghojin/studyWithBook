package algorithm.baekjooncourse2.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Baekjoon1377_bubblesort {

    public static class Pair {
        int index;
        int value;

        public Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    private void solve() {
        int n = sc.nextInt();
        ArrayList<Pair> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Pair(i, sc.nextInt()));
        }

        Collections.sort(list, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.value < o2.value) {
                    return -1;
                } else if (o2.value < o1.value) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (ans < list.get(i).index - i) {
                ans = list.get(i).index - i;
            }
        }
        System.out.println(ans + 1);
    }

    static class sc {
        private static BufferedReader br;
        private static StringTokenizer st;

        static void init() {
            br = new BufferedReader(new InputStreamReader(System.in));
            st = new StringTokenizer("");
        }

        static String readLine() {
            try {
                br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        static String next() {
            while (!st.hasMoreTokens()) {
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

    public static void main(String[] args) {
        sc.init();
        new Baekjoon1377_bubblesort().solve();
    }
}