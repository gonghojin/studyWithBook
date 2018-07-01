package algorithm.baekjooncourse2.datastructure.deque;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Baekjoon10866 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
        while (n-- > 0) {
            String[] cmdArr = sc.nextLine().split(" ");
            String cmd = cmdArr[0];
            if (cmd.equals("push_front")) {
                int cmdInput = Integer.parseInt(cmdArr[1]);
                deque.offerFirst(cmdInput);
            } else if (cmd.equals("push_back")) {
                int cmdInput = Integer.parseInt(cmdArr[1]);
                deque.offerLast(cmdInput);
            } else if (cmd.equals("pop_front")) {
                if (deque.isEmpty()) {
                    System.out.println("-1");
                } else {
                    System.out.println(deque.pollFirst());
                }
            } else if (cmd.equals("pop_back")) {
                if (deque.isEmpty()) {
                    System.out.println("-1");
                } else {
                    System.out.println(deque.pollLast());
                }
            } else if (cmd.equals("size")) {
                System.out.println(deque.size());
            } else if (cmd.equals("empty")) {
                if (deque.isEmpty()) {
                    System.out.println("1");
                } else {
                    System.out.println("0");
                }
            } else if (cmd.equals("front")) {
                if (deque.isEmpty()) {
                    System.out.println("-1");
                } else {
                    System.out.println(deque.peekFirst());
                }
            } else if (cmd.equals("back")) {
                if (deque.isEmpty()) {
                    System.out.println("-1");
                } else {
                    System.out.println(deque.peekLast());
                }
            }
        }
    }
}
