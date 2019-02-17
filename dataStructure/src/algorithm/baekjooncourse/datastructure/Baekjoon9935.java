package algorithm.baekjooncourse.datastructure;

import java.util.Scanner;
import java.util.Stack;

class Pair {
    int first, second;
    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class Baekjoon9935 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String firLine = sc.nextLine();
        String secLine = sc.nextLine();

        int firLengh = firLine.length();
        int secLengh = secLine.length();

        boolean[] erased = new boolean[firLengh];
        if (secLengh == 1) {
            for (int i = 0; i < firLengh; i++) {
                if (firLine.charAt(i) == secLine.charAt(0)) {
                    erased[i] = true;
                }
            }
        } else {
            Stack<Pair> stack = new Stack<>();
            for (int i = 0; i < firLengh; i++) {
                if (firLine.charAt(i) == secLine.charAt(0)) { // 예제 문제의 문자 중 'CC44'의 가운데 c4가 폭발하고 그 후 사이드 c4처리가 진행될 수 있음
                    stack.push(new Pair(i, 0));
                } else {
                    if (!stack.empty()) {
                        Pair p = stack.peek();
                        if (firLine.charAt(i) == secLine.charAt(p.second + 1)) {
                            stack.push(new Pair(i, p.second + 1));
                            if (p.second + 1 == secLengh - 1) { // 문자열 폭발 발생 조건 부합
                                for (int k = 0; k < secLengh; k++) {
                                    Pair top = stack.pop();
                                    erased[top.first] = true;
                                }
                            }
                        } else {
                            while (!stack.empty()) {
                                stack.pop();
                            }
                        }
                    }
                }
            }
        }

        boolean printed = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < firLengh; i++) {
            if (erased[i]) {
                continue;
            }
            sb.append(firLine.charAt(i));
            printed = true;
        }

        if (printed) {
            System.out.println(sb);
        } else {
            System.out.println("FRULA");
        }
    }

}
