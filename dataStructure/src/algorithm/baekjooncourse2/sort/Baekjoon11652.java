package algorithm.baekjooncourse2.sort;

import java.io.*;
import java.util.Arrays;

public class Baekjoon11652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int n = Integer.parseInt(br.readLine());
        long[] d = new long[n];
        for (int i = 0; i < n; i++) {
            d[i] = Long.parseLong(br.readLine());
        }

        br.close();

        Arrays.sort(d);
        long ans = d[0];
        int ans_cnt = 1;
        int cnt = 1;
        for (int i = 1; i < n; i++) {
            if (d[i - 1] == d[i]) {
                cnt++;
            } else {
                cnt = 1;
            }
            if (ans_cnt < cnt) {
                ans_cnt = cnt;
                ans = d[i];
            }
        }
        System.out.println(ans);
    }

}
