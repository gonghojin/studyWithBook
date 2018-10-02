package algorithm.baekjooncourse3.sort;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon10989 {

    public static void main(String[] args) throws IOException {
        sc.init();
        int n = sc.nextInt();
        int[] arr = new int[10001];

        while (0 < n--) {
            int idx = sc.nextInt();
            arr[idx]++;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i <= 10000; i++) {
            for (int j = 0; j < arr[i]; j++) {
                bw.write(i + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
   /*
        안 좋은 방법
    public static void main(String[] args) {
        sc.init();
        int n = sc.nextInt();
        int[] arr = new int[100001];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        StringBuffer sb = new StringBuffer();
        for (int x : arr) {
            sb.append(x + "\n");
        }
        System.out.println(sb);
    }
*/

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