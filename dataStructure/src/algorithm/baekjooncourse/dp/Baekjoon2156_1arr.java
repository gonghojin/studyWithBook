package algorithm.baekjooncourse.dp;

import java.util.Scanner;

// https://www.acmicpc.net/problem/2156
// 1차원 배열로 풀어보기
public class Baekjoon2156_1arr {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num+1]; // 포도주 양
        for (int i = 1; i <= num; i++) {
            arr[i] = sc.nextInt();
        }

        int[] d = new int[num+1]; // 포도주의 최대 양

        // 예외를 만들어야 할 범위는 값을 직접 넣는 게 효율
        d[1] = arr[1];
        if (num >= 2) {
            d[2] = arr[1] + arr[2]; // 3잔 연속 제한에 걸리지만 않으면 당연히 먹는 게 최대양
        }

        for (int i = 3; i <= num; i++) {
            d[i] = d[i-1]; // 0 연속
            d[i] = Math.max(d[i], d[i-2] + arr[i]); // 0 연속과 1 연속(i번째 잔을 먹고 i-1번째 잔은 먹지 x)일 때 최대값 대입
            d[i] = Math.max(d[i], d[i-3] + arr[i-1] + arr[i]); // 0 ~ 1 연속 중 큰 값과 2연속 값 비교
        }

        int  result = d[1];
        for (int i = 2; i <= num; i++) {
            result = Math.max(result, d[i]);
        }
        System.out.println(result);
    }

}
