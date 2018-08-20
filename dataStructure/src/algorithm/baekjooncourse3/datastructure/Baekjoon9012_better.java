package algorithm.baekjooncourse3.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon9012_better {
    public static String valid(String s) {
        s = s.trim();
        int cnt = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                cnt += 1;
            } else {
                cnt -= 1;
            }
            if (cnt < 0) {
                return "NO";
            }
        }
        if (cnt == 0) {
            return "YES";
        } else {
            return "NO";
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            System.out.println(valid(br.readLine()));
        }
        br.close();
    }
}
