package algorithm.baekjooncourse2.sort;

import java.io.*;

public class Baekjoon10989 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] count = new int[10001];
        int idx;

        for (int i = 0; i < n; i++) {
            idx = Integer.parseInt(br.readLine());
            count[idx]++;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i <= 10000; i++) {
            for (int j = 0; j < count[i]; j++) {
                bw.write((i + "\n"));
            }
        }
        bw.flush();
    }
}

