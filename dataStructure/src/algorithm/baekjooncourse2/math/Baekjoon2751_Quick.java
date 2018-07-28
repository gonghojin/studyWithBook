package algorithm.baekjooncourse2.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2751_Quick {

    private static void swap(int[] arr, int low, int right) {
        int temp = arr[low];
        arr[low] = arr[right];
        arr[right] = temp;
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (right <= left) {
            return;
        }
        int pivot = arr[left];
        int low = left + 1;
        int high = right;

        while (low <= high) {
            while (low <= right && arr[low] <= pivot) {
                low++;
            }
            while (left + 1 <= high && pivot <= arr[high]) {
                high--;
            }
            if (low < high) {
                swap(arr, low, high);
            }
        }
        swap(arr, left, high);
        quickSort(arr, left, high - 1);
        quickSort(arr, high + 1, right);
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine().trim());
        int arr[] = new int[N];

        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(br.readLine().trim());

        quickSort(arr, 0, N - 1);

        for (int i = 0; i < N; i++)
            sb.append(arr[i] + "\n");

        System.out.println(sb);

    }
}
