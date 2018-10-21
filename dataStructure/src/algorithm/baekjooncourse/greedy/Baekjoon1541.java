package algorithm.baekjooncourse.greedy;

import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;

public class Baekjoon1541 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] lineArr = line.split("\\-");

        int ans = 0;
        for (int i = 0; i < lineArr.length; i++) {
            int tempSum = 0;

            String[] lineArr2 = lineArr[i].split("\\+");
            for (String x : lineArr2) {
                tempSum += Integer.parseInt(x);
            }

            if (i == 0) {
                tempSum *= -1;
            }
            ans -= tempSum;
        }

        System.out.println(ans);
    }
}
