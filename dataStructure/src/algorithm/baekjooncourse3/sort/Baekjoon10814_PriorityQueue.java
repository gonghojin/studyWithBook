package algorithm.baekjooncourse3.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon10814_PriorityQueue {

    public static void main(String[] args) {
        sc.init();
        int n = sc.nextInt();

        PriorityQueue<Member> priorityQueue = new PriorityQueue<>(100000, new Comparator<Member>() {
            @Override
            public int compare(Member a, Member b) {
                if (a.age < b.age) {
                    return -1;
                } else if (b.age < a.age) {
                    return 1;
                } else {
                    return a.num - b.num;
                }
            }
        });

        for (int i = 0; i < n; i++) {
            priorityQueue.add(new Member(sc.nextInt(), sc.next(), i));
        }

        while (!priorityQueue.isEmpty()) {
            Member member = priorityQueue.poll();
            System.out.println(member.age + " " + member.name);
        }
    }

    static class Member {
        int age;
        String name;
        int num;

        public Member(int age, String name, int num) {
            this.age = age;
            this.name = name;
            this.num = num;
        }
    }

    static class sc {

        private static BufferedReader br;
        private static StringTokenizer st;

        static void init() {
            br = new BufferedReader(new InputStreamReader(System.in));
            st = new StringTokenizer("");
        }

        static String next() {
            while (!st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return st.nextToken();
        }

        static int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
