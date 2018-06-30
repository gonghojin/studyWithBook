package algorithm.baekjooncourse2.datastructure.stack;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjonn1406 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        Stack<Character> left = new Stack<Character>();
        Stack<Character> right = new Stack<Character>();
        for (int i = 0; i < line.length(); i++) {
            left.push(line.charAt(i));
        }

        int cmdCount = Integer.parseInt(br.readLine());
        while (cmdCount-- > 0) {
            String[] cmdArr = br.readLine().split(" ");
            char cmd = cmdArr[0].charAt(0);
            if (cmd == 'L') {
                if (!left.empty()) {
                    right.push(left.pop());
                }
            } else if (cmd == 'D') {
                if (!right.empty()) {
                    left.push(right.pop());
                }
            } else if (cmd == 'B') {
                if (!left.empty()) {
                    left.pop();
                }
            } else if (cmd == 'P') {
                char input = cmdArr[1].charAt(0);
                left.push(input);
            }
        }
        while (!left.empty()) {
            right.push(left.pop());
        }
        StringBuilder sb = new StringBuilder();
        while (!right.empty()) {
            sb.append(right.pop());
        }
        System.out.println(sb);
    }
}
