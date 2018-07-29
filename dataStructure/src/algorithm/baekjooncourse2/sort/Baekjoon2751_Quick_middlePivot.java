package algorithm.baekjooncourse2.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2751_Quick_middlePivot {
    public static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[(left + right) / 2];
        while (left < right) {
            while ((arr[left] < pivot) && (left < right)) {
                left++;
            }
            while ((pivot < arr[right]) && (left < right)) {
                right--;
            }
            if (left < right) {
                swap(arr, left, right);
            }
        }
        return left;
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int newPivot = partition(arr, left, right);
            quickSort(arr, left, newPivot - 1);
            quickSort(arr, newPivot + 1, right);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine().trim());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine().trim());
        }
        quickSort(arr, 0, n -1);

        for (int i = 0; i < n; i++) {
            sb.append(arr[i] + "\n");
        }
        System.out.println(sb);
    }
}
