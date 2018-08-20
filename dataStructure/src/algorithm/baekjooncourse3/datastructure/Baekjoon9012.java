package algorithm.baekjooncourse3.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon9012 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            Stack<Character> stack = new Stack<Character>();
            String s = br.readLine();
            int sLength = s.length();
            for (int i = 0; i < sLength; i++) {
                char ans = s.charAt(i);
                if (ans == '(') {
                    stack.push(ans);
                } else if (ans == ')') {
                    if (stack.isEmpty()) {
                        System.out.println("NO");
                        break;
                    } else {
                        stack.pop();
                    }
                }
                if (i == (sLength -1)) {
                    if (stack.isEmpty()) {
                        System.out.println("YES");
                    } else {
                        System.out.println("NO");
                    }
                }
            }

        }
        br.close();
    }
}
