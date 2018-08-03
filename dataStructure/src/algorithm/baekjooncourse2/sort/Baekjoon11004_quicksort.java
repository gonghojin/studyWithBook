package algorithm.baekjooncourse2.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Baekjoon11004_quicksort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        ArrayList<Integer> array = new ArrayList<Integer>();

        for (int idx = 0; idx < N; idx++) {
            array.add(sc.nextInt());
        }
        quickSort(array, 0, array.size() - 1);
        System.out.println(array.get(K));

    }

    public static void quickSort(ArrayList<Integer> array, int left, int right) {
        if (left < right) {
            int pivotLoc = partition(array, left, right);
            quickSort(array, left, pivotLoc - 1);
            quickSort(array, pivotLoc + 1, right);
        }
    }

    public static int partition(ArrayList<Integer> array, int left, int right) {
        int pivot = array.get(right);
        int i = left - 1;
        for (int j = left; j <= right - 1; j++) {
            if (array.get(j) < pivot) {
                i++;
                Collections.swap(array, i, j);
            }
        }
        Collections.swap(array, i + 1, right);
        return i + 1;
    }


}
