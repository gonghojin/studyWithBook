package algorithm.baekjooncourse3.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();
        br.close();
        int sLength = s.length();
        Stack<Integer> stack = new Stack<Integer>();
        int count = 0;
        for (int i = 0; i < sLength; i++) {
            char point = s.charAt(i);
            if (point == '(') {
                stack.push(i);
            } else if (point == ')') {
                /*if (s.charAt(i-1) == '(') {
                    stack.pop();
                    count += stack.size();

                   better than this
                 */
                if (stack.peek() + 1 == i) {
                    stack.pop();
                    count += stack.size();
                } else {
                    count += 1;
                    stack.pop();
                }
            }
        }
        System.out.println(count);
    }
}