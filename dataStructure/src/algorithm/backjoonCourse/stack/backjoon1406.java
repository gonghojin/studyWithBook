package algorithm.backjoonCourse.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// https://www.acmicpc.net/problem/1406
public class backjoon1406 {
    public static void main(String[] args) throws IOException {
        /**
         *  bufferdReader와 Scanner의 활용차이:
         *  기능면에서는 Scanner의 사용이 편리하다.
         *  그러나!! Scanner의 버퍼사이즈는 1024char, BufferedReader의 버퍼사이즈는 8192char이기 때문에
         *  많은 입력이 있다면 BufferdReader가 성능(속도빠름) 앞승!!
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        Stack<Character> left = new Stack<Character>(); // 커서의 왼쪽 문자
        Stack<Character> right = new Stack<Character>(); // 커서의 오른쪽 문자

        for (int i = 0; i < line.length(); i++) {
            left.push(line.charAt(i)); // 초기는 커서가 맨 오른쪽
        }

        int cmdCount = Integer.parseInt(br.readLine()); // 명령어 개수
        while (cmdCount-- > 0) {
            String[] cmdLine = br.readLine().split(" "); // 명령어 한 줄
            char cmd = cmdLine[0].charAt(0); // 실질적인 명령어
            if (cmd == 'L') {
                if (!left.empty()) {
                    right.push(left.pop()); // 왼쪽 stack 값을 오른쪽으로 이동 == 커서 오른쪽에 넣기
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
                char pChar = cmdLine[1].charAt(0);
                left.push(pChar);
            }
        }
        while (!left.empty()) {
            right.push(left.pop()); // 출력순서 잡기 : 스택 구조 이해
        }
        StringBuilder sb = new StringBuilder();
        while (!right.empty()) {
            sb.append(right.pop());
        }

        System.out.println(sb);
    }

}

