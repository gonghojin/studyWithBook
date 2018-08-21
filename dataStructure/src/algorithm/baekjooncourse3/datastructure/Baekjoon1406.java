package algorithm.baekjooncourse3.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine().trim();
        int sLength = s.length();
        int t = Integer.parseInt(br.readLine());


        Stack<Character> left = new Stack<Character>();
        Stack<Character> right = new Stack<Character>();
        for (int i = 0; i < sLength; i++) {
            left.push(s.charAt(i));
        }
        while (t-- > 0) {
           String[] cmdArr = br.readLine().trim().split(" ");
           char cmd = cmdArr[0].charAt(0);
           if (cmd == 'L') {
               if (!left.isEmpty()) {
                   right.push(left.pop());
               }
           } else if (cmd == 'D') {
               if (!right.isEmpty()) {
                   left.push(right.pop());
               }
           } else if (cmd == 'B') {
               if (!left.isEmpty()) {
                   left.pop();
               }
           } else if (cmd == 'P') {
               left.push(cmdArr[1].charAt(0));
           }
        }
        br.close();

        StringBuffer sb = new StringBuffer();
        while (!left.isEmpty()) {
            right.push(left.pop());
        }
        while (!right.isEmpty()) {
            sb.append(right.pop());
        }
        System.out.println(sb);
    }
}
