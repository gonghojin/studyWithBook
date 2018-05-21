package algorithm.baekjoonCourse.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// https://www.acmicpc.net/problem/10845
public class baekjoon10845 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cmdCount = sc.nextInt();
        sc.nextLine(); // nextInt() 뒤에는 \n이 붙기 때문에 빼줘야함
        Queue<Integer> queue = new LinkedList<Integer>();

        for (int i = 0; i < cmdCount; i++) {
            String cmdLine = sc.nextLine(); // 명령어 한줄
            String[] cmdArr = cmdLine.split(" "); // 명령어 배열
            String cmd = cmdArr[0]; // 명령어
            if (cmd.equals("push")) {
                int cmdNum = Integer.parseInt(cmdArr[1]); // 해당 명령어 값
                queue.offer(cmdNum); //offer() : insert 실패시 return false
                                    //add() : throw IllegalStateException
                                    //출처 : https://softwareengineering.stackexchange.com/questions/190267/what-is-the-difference-of-the-add-and-offer-methods-of-javas-priorityqueue

            } else if (cmd.equals("pop:")) {
                if (queue.isEmpty()) {
                    System.out.println("-1");
                } else {
                    System.out.println(queue.poll()); // 값을 리턴 + 제거
                }
            } else if (cmd.equals("front")) {
                if (queue.isEmpty()) {
                    System.out.println("-1");
                } else {
                    System.out.println(queue.peek()); // 값을 리턴만
                }
            } else if (cmd.equals("back")) {
                if (queue.isEmpty()) {
                    System.out.println("-1");
                } else {
                    // Queue에 없음. 따라서 back이 있을 경우 배열로 만들어야 할듯..
                }
            } else if (cmd.equals("size")) {
                System.out.println(queue.size());
            } else if (cmd.equals("empty")) {
                if (queue.isEmpty()) {
                    System.out.println("1");
                } else {
                    System.out.println("0");
                }
            }
        }

    }
}
