package algorithm.baekjooncourse3.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon10828_self {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MyStatc stack = new MyStatc();

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String s = br.readLine();
            String[] cmdArr = s.split(" ");
            String cmd = cmdArr[0];
            if (cmd.equals("push")) {
                stack.push(cmdArr[1]);
            } else if (cmd.equals("pop")) {
                stack.pop();
            } else if (cmd.equals("size")) {
                stack.size();
            } else if (cmd.equals("empty")) {
                stack.empty();
            } else if (cmd.equals("top")) {
                stack.top();
            }
        }

        br.close();
    }


}

class MyStatc {
    int topIndex;
    int[] data;

    public MyStatc() {
        topIndex = -1;
        data = new int[10000];
    }

    public void push(String x) {
        data[++topIndex] = Integer.parseInt(x);
    }

    public void pop() {
        if (topIndex < 0) {
            System.out.println(-1);
        } else {
            System.out.println(data[topIndex--]);
        }
    }

    public void size() {
        System.out.println(topIndex < 0 ? 0 : topIndex + 1);
    }

    public void empty() {
        if (topIndex < 0) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    public void top() {
        if (topIndex < 0) {
            System.out.println(-1);
        } else {
            System.out.println(data[topIndex]);
        }
    }
}