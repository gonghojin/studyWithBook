package algorithm.baekjooncourse2.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon10814_priorityQueue {

    static class Member {
        int age;
        int uid;
        String name;

        Member(int age, int uid, String name) {
            this.age = age;
            this.name = name;
            this.uid = uid;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Member> q = new PriorityQueue<Member>(100000, new Comparator<Member>() {
            @Override
            public int compare(Member m1, Member m2) {
                if (m1.age < m2.age) {
                    return -1;
                } else if (m1.age > m2.age) {
                    return 1;
                } else {
                    return m1.uid - m2.uid;
                }

            }
        });

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            // 인덱스 값이 필요없는 문자열을 읽을 때는 StringTokenizer를 사용하는 게 속도면에서 가장 빠름
            // http://mygumi.tistory.com/78
            StringTokenizer st = new StringTokenizer(br.readLine());
            q.add(new Member(Integer.parseInt(st.nextToken()), i, st.nextToken()));
        }

        while (!q.isEmpty()) {
            Member m = q.poll();
            System.out.println(m.age + " " + m.name);
        }
    }
}
