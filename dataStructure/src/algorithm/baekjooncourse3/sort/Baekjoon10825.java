package algorithm.baekjooncourse3.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon10825 {


    public static void main(String[] args) {
        sc.init();
        int n = sc.nextInt();

        PriorityQueue<Student> priorityQueue = new PriorityQueue<Student>(100000, new Comparator<Student>() {
            @Override
            public int compare(Student a, Student b) {
                if (a.kr == b.kr) {
                    if (a.eng == b.eng) {
                        if (a.math == b.math) {
                            return a.name.compareTo(b.name);
                        }
                        return Integer.compare(b.math, a.math);
                    }

                    return Integer.compare(a.eng, b.eng);
                }

                return  Integer.compare(b.kr, a.kr);
            }
        });

        while (0 < n--) {
            priorityQueue.add(new Student(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }

        while(!priorityQueue.isEmpty()) {
            Student st = priorityQueue.poll();
            System.out.println(st.name);
        }
    }

    static class sc {
        private static  BufferedReader br;
        private static StringTokenizer st;

        public static void init() {
            br = new BufferedReader(new InputStreamReader(System.in));
            st = new StringTokenizer("");
        }

        public static String next() {
            if (!st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public static int nextInt() {
            return Integer.parseInt(next());
        }
    }

    public static class Student {
        String name;
        int kr;
        int eng;
        int math;

        public Student(String name, int kr, int eng, int math) {
            this.name = name;
            this.kr = kr;
            this.eng = eng;
            this.math = math;
        }
    }
}
