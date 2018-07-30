package algorithm.baekjooncourse2.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// Comparable interface 이용 : http://brenden.tistory.com/26
// Comparator interface 이용 : http://zoonvivor.tistory.com/59
// Comparable, Comparator 비교 정리 : http://cwondev.tistory.com/15
public class Baekjoon10825 {
    static class Student {
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Student> q = new PriorityQueue<Student>(100000, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                if (s1.kr == s2.kr) {
                    if (s1.eng == s2.eng) {
                        if (s1.math == s2.math) {
                            // 국 영 수가 같으면 이름의 사전순서(오름차순)
                            return s1.name.compareTo(s2.name);
                        }
                        return Integer.compare(s2.math, s1.math);
                    }
                    // 오름차순  - 영어점수가 증가하는 순서
                    return Integer.compare(s1.eng, s2.eng);
                }
                // 내림차순 - 국어점수가 감소하는 순서
                /**
                 * 오름차순 정렬은 첫번째 매개변수(s1)가  Integer.compare의 첫번째 인자값으로 들어가지만,
                 * 내림차순 정렬은 반대로 들어가야함
                 * compare 할 때 s1 < s2일 경우 -1이 return 되는데 -1 0 1 기준으로 오름차순이 이루어짐
                 * 따라서 s2 < s1 이 -1 경우, 결국 s1 < s2 일 때는 1을 가르키게 됨(반대가 됨)
                 */
                return Integer.compare(s2.kr, s1.kr);
            }
        });

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            q.add(new Student(st.nextToken()
                    , Integer.parseInt(st.nextToken())
                    , Integer.parseInt(st.nextToken())
                    , Integer.parseInt(st.nextToken())));
        }

        while(!q.isEmpty()) {
            Student s = q.poll();
            System.out.println(s.name);
        }
    }
}
