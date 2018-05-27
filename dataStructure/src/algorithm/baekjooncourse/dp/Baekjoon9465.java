package algorithm.baekjooncourse.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/9465
public class Baekjoon9465 {

    public static void main(String[] args) throws IOException {
        // BufferdReader가 구현과정까지 번거롭지만 입출력 값이 많은 때는 Scanner보다 월등히 빠름
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Integer.valueOf(String) vs parseInt(String) - valueOf = 객체(Integer) return , parseInt - 기본값(int) return
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스
        while (t-- > 0) {
            int num = Integer.parseInt(br.readLine());
            long[][] arr = new long[num+1][2];

            // 첫번째 행 점수 받기
            {
                String[] line = br.readLine().split(" ");
                for (int i = 1; i <= num; i++) {
                    arr[i][0] = Long.parseLong(line[i-1]);
                }
            }
            // 두번째 행 점수 받기
            {
                String[] line = br.readLine().split(" ");
                for (int i = 1; i <= num; i++) {
                    arr[i][1] = Long.parseLong(line[i-1]);
                }
            }

            long[][] d = new long[num+1][3];
            for (int i = 1; i <= num; i++) {
                d[i][0] = Math.max(d[i-1][0], Math.max(d[i-1][1], d[i-1][2]));
                d[i][1] = Math.max(d[i-1][0], d[i-1][2]) + arr[i][0]; // n열 1째 자리의 점수 == arr[i][0]
                d[i][2] = Math.max(d[i-1][0], d[i-1][1]) + arr[i][1]; // n열 2째 자리의 점수 == arr[i][1]
            }

            long result = 0;
            result = Math.max(d[num][0], Math.max(d[num][1], d[num][2]));
            System.out.println(result);
        }
    }
}
