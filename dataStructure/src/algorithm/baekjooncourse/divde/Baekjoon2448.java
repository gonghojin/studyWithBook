package algorithm.baekjooncourse.divde;

import java.util.Scanner;

// http://n1tjrgns.tistory.com/70
public class Baekjoon2448 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] d = new String[n];
        d[0] = "  *  ";
        d[1] = " * * ";
        d[2] = "*****";

        // Math.log는 자연로그이기 때문에, 밑을 정해서 로그를 만드는 방법은 = Math.log(수) / Math.log(밑)
        int m = (int) (Math.log(n/3) / Math.log(2));
        int height = 3;
        String sp =  "   ";
        for (int i = 0 ; i < m; i++) {
            for (int j = 0; j < height; j++) {
                d[height + j] = d[j] + " " + d[j];
                for (int k = 0; k < height / 3; k++) {
                    d[j] = sp + d[j] + sp;
                }
            }
            height = height + height;
        }

        for (String x : d) {
            System.out.println(x);
        }
    }
}
