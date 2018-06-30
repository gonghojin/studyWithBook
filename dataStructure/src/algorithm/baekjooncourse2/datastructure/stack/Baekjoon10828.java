package algorithm.baekjooncourse2.datastructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/submit/10828/7186894
public class Baekjoon10828 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayStack arrayStack = new ArrayStack();
        while (n-- > 0) {
            String[] arrLine = br.readLine().split(" ");
            if (arrLine.length == 1) {
                String command = arrLine[0];
                if (command.equals("empty")) {
                    arrayStack.empty();
                } else if (command.equals("pop")) {
                    arrayStack.pop();
                } else if (command.equals("size")) {
                    arrayStack.size();
                } else if (command.equals("top")) {
                    arrayStack.top();
                }
            } else {
                arrayStack.push(Integer.parseInt(arrLine[1]));
            }
        }
    }
}

class ArrayStack {
    private int[] stack;
    private int top;
    private final int MAXSZIE = 10000;

    public ArrayStack() {
        this.stack = new int[MAXSZIE];
        this.top = -1;
    }

    public void push(int value) {
        if (top == MAXSZIE - 1) {
            throw new ArrayIndexOutOfBoundsException("오버스텍");
        }
        stack[++top] = value;
    }

    public void pop() {
        if (top < 0) {
            System.out.println(-1);
            return;
        } else {
            System.out.println(stack[top--]);
        }
    }

    public boolean empty() {
        if (top < 0) { // 비어있으면
            System.out.println(1);
            return true;
        } else {
            System.out.println(0);
            return false;
        }
    }
    public void size() {
        System.out.println(top + 1);
    }

    public void top() {
        if (top < 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(stack[top]);
    }
}