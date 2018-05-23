package algorithm.baekjooncourse.dp;

import java.util.Scanner;

// https://www.acmicpc.net/problem/11726
public class Baekjoon11726 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] d = new int[1001]; // 1번 인덱스부터 시작
        d[0] = 1; // 이치상은 당연히 없는 타일은 1이 아니지만, 없지만 1이라고 놓고 계산하면 알고리즘의 원리 이해가 쉽다
        d[1] = 1;
        for (int i = 2; i <= num; i++) {
            d[i] = d[i -1] + d[i -2];
            d[i] %= 10007;
        }
        System.out.println(d[num]);
    }
}
    /**
     *  DP문제의 특징을 간파하자!
     *  작은 문제의 합은 큰 문제로 도출된다.
     *  작게 보고 풀면 문제를 풀 수 있다.
     *  1. Overlapping Subproblem
     *  2. Optimal Substructure
     *
     *
     * **/
