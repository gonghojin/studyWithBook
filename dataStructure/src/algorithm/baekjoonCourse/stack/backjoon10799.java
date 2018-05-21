package algorithm.baekjoonCourse.stack;

import java.util.Scanner;
import java.util.Stack;

public class backjoon10799 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine().trim(); // 입력 레이저 + 쇠막대기
        int n = a.length();
        Stack<Integer> stack = new Stack<Integer>();
        int count = 0; // 쇠막대기 개수
        for (int i = 0; i < n; i++) {
            if (a.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.peek() + 1 == i) { // stack 안에 있는 인덱스 + 1 == i 라면 레이저를 뜻함
                    stack.pop(); // 레이저의 '('를 뺌
                    count += stack.size();
                } else { // 쇠막대기 끝을 나타내는 ')'
                    stack.pop();
                    count++; // 쇠막대기 끝이니 한토막 추가
                }
            }

        }

        System.out.println(count);
    }
}
