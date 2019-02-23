package algorithm.baekjooncourse.datastructure;

import java.util.Scanner;
import java.util.Stack;

public class Baekjoon3015_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        long ans = 0;
        Stack<Integer> stack  = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int h = arr[i];
            int count = 1;

            while (!stack.empty()) {
                if (stack.peek() <= arr[i]) {
                    ans += countStack.peek();
                    if (stack.peek() == arr[i]) {
                        count += countStack.peek();
                    }
                    stack.pop();
                    countStack.pop();
                } else {
                    break;
                }

            }
            if (!stack.empty()) {
                ans += 1L;
            }
            stack.push(h);
            countStack.push(count);
        }

        System.out.println(ans);
    }
}
