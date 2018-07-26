package algorithm.baekjooncourse2.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2751_Quick {
    public static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    public static int partion(int arr[], int left, int right) {
        // 피벗 위치 가장 왼쪽
        int pivot = arr[left];
        int low = left + 1;
        int high = right;

        while (low <= high) {

            // 피벗보다 큰 값을 찾는 과정
            while (arr[low] <= pivot && low < right) {
                low++;
            }

            // 피벗보다 작은 값
            while (pivot <= arr[high] && (left + 1) <= high) {
                high--;
            }

            if (low <= high) {
                swap(arr, low, high);
            }
        }
        swap(arr, left, high);
        return high;
    }
    public static void quickSort(int[] arr,int left, int right) {
        if (left <= right) {
            int pivot = partion(arr, left, right);
            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot + 1, right);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine().trim());
        }
        quickSort(arr, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }
}
