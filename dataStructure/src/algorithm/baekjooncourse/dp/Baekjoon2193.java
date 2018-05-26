package algorithm.baekjooncourse.dp;

import java.util.Scanner;

// https://www.acmicpc.net/problem/2193/
public class Baekjoon2193 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        long[][] arr = new long[91][2]; // N자리는 1부터 90까지( 즉 0 인덱스 x)

        arr[1][0] = 0; // 1자리일 때 0으로 시작 x
        arr[1][1] = 1;
        for (int i = 2; i <= num; i++) {
            arr[i][0] = arr[i-1][0] + arr[i-1][1];
            arr[i][1] = arr[i-1][0];
        }

        System.out.println(arr[num][0] + arr[num][1]);
    }
}
