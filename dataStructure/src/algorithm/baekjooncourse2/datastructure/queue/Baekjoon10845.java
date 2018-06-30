package algorithm.baekjooncourse2.datastructure.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<Integer>();
        while (n-- > 0) {
           String cmdLine = br.readLine();
           String[] cmdArr = cmdLine.split(" ");
           String cmd = cmdArr[0];
           if (cmd.equals("push")) {
               int pushNum = Integer.parseInt(cmdArr[1]);
               q.offer(pushNum);
           } else if (cmd.equals("pop")) {
               if (q.isEmpty()) {
                   System.out.println("-1");
               }
               System.out.println(q.poll());
           } else if (cmd.equals("size")) {
               System.out.println(q.size());
           } else if (cmd.equals("empty")) {
               if (q.isEmpty()) {
                   System.out.println("1");
               } else {
                   System.out.println("0");
               }
           } else if (cmd.equals("front")) {
               if (q.isEmpty()) {
                   System.out.println("-1");
               } else {
                   System.out.println(q.peek());
               }
           } else if (cmd.equals("back")) {
                if (q.isEmpty()) {
                    System.out.println("-1");
                } else {
                    // Queue 비존재
                }
           }
        }
    }
}
