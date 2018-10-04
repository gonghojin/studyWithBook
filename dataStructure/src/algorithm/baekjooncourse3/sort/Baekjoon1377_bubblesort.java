package algorithm.baekjooncourse3.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Baekjoon1377_bubblesort {

    public static void main(String[] args) {
        sc.init();
        int n = sc.nextInt();
        ArrayList<Pair> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Pair(i, sc.nextInt()));
        }

        Collections.sort(list, new Comparator<Pair>() {
            @Override
            public int compare(Pair a, Pair b) {
                if (a.value < b.value) {
                    return -1;
                } else if (a.value == b.value) {
                    return  0;
                } else {
                    return 1;
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

    public static class Pair {
        int index;
        int value;

        public Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    static class sc {

        private static BufferedReader br;
        private static StringTokenizer st;

        public static void init() {
            br = new BufferedReader(new InputStreamReader(System.in));
            st = new StringTokenizer("");
        }

        public static String next() {
            if (!st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public static int nextInt() {
            return Integer.parseInt(next());
        }

    }
}
