package algorithm.baekjooncourse.bfs;

import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon11723 {

    public static void main(String[] args) throws IOException {
        sc.init();

        int m = sc.nextInt();
        int num = 0;
        int bitmask = 0;

        String cmd;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (m-- > 0) {


            cmd = sc.nextString();
            num = sc.nextInt();

            switch (cmd) {

                case "add":
                    bitmask |= 1 << num;
                    break;

                case "remove":
                    bitmask &= ~(1 << num);
                    break;

                case "check":
                    bw.write(((bitmask & (1 << num)) >> num) + "\n");
                    break;

                case "toggle":
                    bitmask ^= (1 << num);
                    break;

                case "all":
                    bitmask |= (1 << 21) - 1;
                    break;

                case "empty":
                    bitmask = 0;
                    break;
            }
        }

        bw.flush();

        bw.close();


    }

    static class sc {
        static BufferedReader br;
        static StringTokenizer st;

        static void init() {
            br = new BufferedReader(new InputStreamReader(System.in));
            st = new StringTokenizer("");
        }

        static String nextString() {
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
            return Integer.parseInt(st.nextToken());
        }
    }
}
