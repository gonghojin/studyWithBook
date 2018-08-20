package algorithm.baekjooncourse3.datastructure;

import java.util.Scanner;
import java.util.Stack;

public class Baekjoon10828 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Stack<Integer> stack = new Stack<Integer>();
        while (n-- > 0) {
            String[] line = sc.nextLine().split(" ");
            String cmd = line[0];
            if (cmd.equals("push")) {
                stack.push(Integer.parseInt(line[1]));
            } else if (cmd.equals("pop")) {
                if (stack.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(stack.pop());
                }
            } else if (cmd.equals("size")) {
                System.out.println(stack.size());
            } else if (cmd.equals("empty")) {
                if (stack.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if (cmd.equals("top")) {
                if (stack.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(stack.peek());
                }
            }
        }
    }
}
