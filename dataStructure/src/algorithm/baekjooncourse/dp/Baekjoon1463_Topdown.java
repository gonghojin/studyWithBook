package algorithm.baekjooncourse.dp;


import java.util.Scanner;
// https://gist.github.com/Baekjoon/7b675fe68d3c2abfef40
// 이해 안됨... 나중에 다시 분석(재귀함수)
public class Baekjoon1463_Topdown {
    public static int[] d;
    public static int go(int num) {
        if (num == 1) { // 1이 들어올 경우
            return 0;
        }
        if (d[num] > 0) {
            return d[num];
        }
        d[num] = go(num -1) + 1;
        if (num % 2 == 0) {
            int temp = go(num / 2) + 1;
            if (d[num] > temp) {
                d[num] = temp;
            }
        }
        if (num % 3 == 0) {
            int temp = go(num / 3) + 1;
            if (d[num] > temp) {
                d[num] = temp;
            }
        }

        return d[num];
    }
    public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     int num = sc.nextInt();
     d = new int[num + 1];
     System.out.println(go(num));
    }
}
