package algorithm.baekjooncourse3.dp;

        import java.util.Scanner;

public class Baekjoon1463_bottomup {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int[] d = new int[x+1];
        d[1] = 0;
        for (int i = 2; i <= x; i++) {
            d[i] = d[i-1] + 1;
            if (i % 3 == 0) {
                int temp = d[i/3] + 1;
                if (temp < d[i]) {
                    d[i] = temp;
                }
            }
            if (i % 2 == 0) {
                int temp = d[i/2] + 1;
                if (temp < d[i]) {
                    d[i] = temp;
                }
            }
        }
        System.out.println(d[x]);

    }
}
