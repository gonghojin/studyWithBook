package algorithm.baekjooncourse.dp;

import java.util.Scanner;

// https://gist.github.com/Baekjoon/0813d3bc5db11b9bb72d
public class Baekjoon1463_bottmup {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] d = new int[n + 1]; // 1번째 인덱스부터 사용하기 위함
        d[1] = 0; // 1은 연산 횟수 0

        for (int i = 2; i <= n; i++) {
            d[i] = d[i -1] + 1;
            if (i % 2 ==0 && d[i] > d[i / 2] + 1) {
                d[i] = d[i / 2] + 1;
            }
            if (i % 3 == 0 && d[i] > d[i / 3] + 1) {
                d[i] = d[i/3] + 1;
            }
        }

        System.out.println(d[n]);
    }
}

/**
 *  다이나믹 프로그래밍(dp)는 두가지 속성을 만족해야 문제를 풀 수 있다.
 *  1. Overlapping Subproblem : 겹치는 부문 문제, 큰 문제와 작은 문제를 같은 방법으로 풀이 가능
 *                              따라서 문제를 작은 문제로 쪼갤 수 있고, 작은문제의 연산은 곧 큰 문제의 도출로 이어짐
 *  2. Optimal Substructure- 최적의 하위조건(??)
 *
 *  따라서 큰 문제를 풀기 위해서 작은 문제를 풀고 그 값을 저장해논다(memorization 기록화)
 *  그렇기 때문에 위 2가지 특징을 이해하면 13번째줄 for문의 내용이 이해될 것
 *
 *
 *
 *
 * **/