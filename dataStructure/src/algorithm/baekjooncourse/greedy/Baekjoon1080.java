package algorithm.baekjooncourse.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon1080 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        int[][] matrixA = new int[n][m];
        int[][] matrixB = new int[n][m];
        String temp;
        for (int i = 0; i < n; i++) {
            temp = scanner.nextLine();
            for (int j = 0; j < m; j++) {
                matrixA[i][j] = Integer.parseInt(String.valueOf(temp.charAt(j)));
            }
        }
        for (int i = 0; i < n; i++) {
            temp = scanner.nextLine();
            for (int j = 0; j < m; j++) {
                matrixB[i][j] = Integer.parseInt(String.valueOf(temp.charAt(j)));
            }
        }

        int count = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m - 2; j++) {
                if (matrixA[i][j] != matrixB[i][j]) {
                    reverseMatrix(matrixA, i, j);
                    count++;
                }
            }
        }
        System.out.println(Arrays.deepEquals(matrixA, matrixB) ? count : -1);
    }

    private static void reverseMatrix(int[][] matrix, int i, int j) {
        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
                matrix[i + k][j + l] = matrix[i + k][j + l] == 0 ? 1 : 0;
            }
        }
    }


}
