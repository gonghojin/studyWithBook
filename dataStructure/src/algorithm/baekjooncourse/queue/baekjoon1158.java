package algorithm.baekjooncourse.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//https://www.acmicpc.net/problem/1158
public class baekjoon1158 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        Queue<Integer> queue = new LinkedList<Integer>();

        for (int i = 1; i <= n; i++){
            queue.offer(i); // 값 넣어주기
        }

        for (int i = 0; i < n - 1; i++) { //  총 7명일 경우 마지막 남은 1명일 때는 필요없음
            for (int j = 0; j < m -1; j++) { // 3번째 사람을 제외할 경우 2번째까지는 제외하면 안됨
                queue.offer(queue.poll());
            }
            sb.append(queue.poll() + ", ");// 3번째 사람은 제외
        }

        sb.append(queue.poll() + ">");
        System.out.println(sb);
    }
}
