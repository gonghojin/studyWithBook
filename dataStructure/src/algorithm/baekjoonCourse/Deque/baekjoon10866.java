package algorithm.baekjoonCourse.Deque;

import java.util.ArrayDeque;
import java.util.Scanner;

// https://www.acmicpc.net/problem/10866
public class baekjoon10866 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cmdCount = sc.nextInt();
        sc.nextLine();
        ArrayDeque<Integer> queue = new ArrayDeque<Integer>();

        for (int i = 0; i < cmdCount; i++) {
            String cmdLine = sc.nextLine(); // 명령어 한줄
            String[] cmdArr = cmdLine.split(" ");
            String cmd =  cmdArr[0]; // 명렁어
            if (cmd.equals("push_front")) { // 덱 앞에 삽입
                int cmdNum = Integer.parseInt(cmdArr[1]);
                queue.offerFirst(cmdNum);
            } else if (cmd.equals("push_back")) { // 덱 마지막에 삽입
                int cmdNum = Integer.parseInt(cmdArr[1]);
                queue.offerLast(cmdNum);
            } else if (cmd.equals("pop_front")) {
                if (queue.isEmpty()) {
                    System.out.println("-1");
                } else {
                    System.out.println(queue.pollFirst()); // 첫번째 값 리턴 + 제거
                }
            } else if (cmd.equals("pop_back")) {
                if (queue.isEmpty()) {
                    System.out.println("-1");
                } else {
                    System.out.println(queue.pollLast()); // 마지막 값 리턴 + 제거
                }
            } else if (cmd.equals("size")) {
                System.out.println(queue.size());
            } else if (cmd.equals("empty")) {
                if (queue.isEmpty()) {
                    System.out.println("1");
                } else {
                    System.out.println("0");
                }
            } else if (cmd.equals("front")) {
                if (queue.isEmpty()) {
                    System.out.println("-1");
                } else {
                    System.out.println(queue.peekFirst());
                }
            } else if (cmd.equals("back")) {
                if (queue.isEmpty()) {
                    System.out.println("-1");
                } else {
                    System.out.println(queue.peekLast());
                }
            }
        }
    }
}
