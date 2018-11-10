package algorithm.baekjooncourse.greedy;

import java.util.Scanner;

// http://mizzo-dev.tistory.com/entry/baekjoon1080
public class Baekjoon1080_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        char[][] a = new char[n][m];
        boolean[][] check = new boolean[n][m]; // false == 짝수 , true == 홀수;


        for (int i = 0; i < n; i++) {
            a[i] = sc.next().toCharArray();
        }

        // b행렬의 값을 입력받는 동시에, a와 비교
        // 동일할 경우 : 짝수번 뒤집힘, 다를 경우 : 홀수번 뒤집힘
        int diff = 0;
        for (int i = 0; i < n; i++) {
            char[] inputs = sc.next().toCharArray();
            for (int k = 0; k < m; k++) {
                if (inputs[k] != a[i][k]) {
                    check[i][k] = true; // 홀수번
                    diff++;
                }
            }
        }

        if (diff == 0) {
            System.out.println(0);
        } else {
            System.out.println(getAns(check));
        }
    }

    static int getAns(boolean[][] check) {
        int n = check.length;
        int m = check[0].length;

        // 차이가 있는데 뒤집을 조건이 되지 않음, 따라서 -1
        if (n < 3 || m < 3)
            return -1;

        int count = 0;
        for (int i = 0; i <= n - 3; i++) {
            for (int j = 0; j <= m - 3; j++) {
                // 마지막 3개가 다 다를 경우 -1
                if (i == n - 3 && !(check[i][j] == check[i + 1][j] && check[i][j] == check[i + 2][j])) {
                    return -1;
                }
                if (j == m - 3 && !(check[i][j] == check[i][j + 1] && check[i][j] == check[i][j + 2])) {

                    return -1;
                }

                // 가능한 경우 홀수 일때 3x3을 모두 뒤집는다.
                if (check[i][j]) {
                    reverse(check, i, j);
                    count++;
                }
            }
        }

        boolean flag = check[n - 3][m - 3];
        for (int i = n - 1; n - 3 < i; i--) {
            for (int j = m - 1; n - 3 < j; j--) {
                if (flag != check[i][j]) {
                    return -1;
                }
            }
        }

        return count;
    }

    static void reverse(boolean[][] check, int x, int y) {
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++)
                check[i][j] = !check[i][j];
        }
    }
}
