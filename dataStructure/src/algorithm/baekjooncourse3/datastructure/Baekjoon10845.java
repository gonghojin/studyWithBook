package algorithm.baekjooncourse3.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon10845 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        MyQueue q = new MyQueue();
        while (n-- > 0) {
            String[] cmdArr = br.readLine().trim().split(" ");
            String  cmd = cmdArr[0];
            if (cmd.equals("push")) {
                q.push(Integer.parseInt(cmdArr[1]));
            } else if (cmd.equals("pop")) {
                System.out.println(q.pop());
            } else if (cmd.equals("size")) {
                System.out.println(q.size());
            } else if (cmd.equals("front")) {
                System.out.println(q.front());
            } else if (cmd.equals("back")) {
                System.out.println(q.back());
            } else if (cmd.equals("empty")) {
                System.out.println(q.empty());
            }
        }
        br.close();
    }
}

class MyQueue {
    private int begin;
    private int end;
    private int[] data;

    public MyQueue() {
        begin = 0;
        end = 0;
        data = new int[10000];
    }

    public void push(int x) {
        data[end] = x;
        end += 1;
    }

    public int pop() {
        if (empty() == 1) {
            return -1;
        }
        return data[begin++];
    }

    public int front() {
        if (empty() == 1) {
            return -1;
        }
        return data[begin];
    }

    public int back() {
        if (empty() == 1) {
            return -1;
        }
        return data[end-1];
    }

    public int size() {
        return end - begin;
    }

    public int empty() {
        if (begin == end) {
            return 1;
        } else {
            return 0;
        }
    }
}
