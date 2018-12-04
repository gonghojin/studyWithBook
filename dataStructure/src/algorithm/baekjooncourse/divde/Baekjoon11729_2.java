package algorithm.baekjooncourse.divde;

import java.util.Scanner;

// 출처 : http://brenden.tistory.com/31
public class Baekjoon11729_2 {
    public static int answer = 0;
    public static StringBuilder sb = new StringBuilder();

    public static void solve(int num, int from, int by, int to) {
        ++answer;
        if (num == 1) {
            sb.append(from + " " + to + "\n");
        } else {
            // num - 1 개를 A에서 B로 이동
            solve(num - 1, from, to, by);

            // 1 개를 A에서 C로 이동
            sb.append(from + " " + to + "\n");

            // num - 1 개를 B에서 C로 이동
            solve(num-1, by, from, to);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        solve(n, 1, 2, 3);
        sb.insert(0, answer + "\n");
        System.out.println(sb);
    }
}
