package algorithm.baekjooncourse2.datastructure;

import java.util.Scanner;
import java.util.Stack;

public class Baekjoon10799 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine().trim();
        int n = line.length();
        Stack<Integer> stack = new Stack<Integer>();
        int dap = 0;
        for (int i = 0; i < n; i++) {
            if (line.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.peek() + 1 == i) {
                    stack.pop();
                    dap += stack.size();
                } else {
                    stack.pop();
                    dap++;
                }
            }
        }
        System.out.println(dap);
    }
}
