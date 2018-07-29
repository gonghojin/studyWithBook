package algorithm.baekjooncourse2.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2751_mergesort {

    public static int[] result;

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int fIdx = left;
        int rIdx = mid + 1;
        int sIdx = left;
        while (fIdx <= mid && rIdx <= right) {
            if (arr[fIdx] <= arr[rIdx]) {
                result[sIdx++] = arr[fIdx++];
            } else {
                result[sIdx++] = arr[rIdx++];
            }
        }
        if (mid < fIdx) {
            for (int i = rIdx; i <= right; i++) {
                result[sIdx++] = arr[i];
            }
        } else {
            for (int i = fIdx; i <= mid; i++) {
                result[sIdx++] = arr[i];
            }
        }
        for (int i = left; i <= right; i++) {
            arr[i] = result[i];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());
        result = new int[n];
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(arr, 0, n - 1);

        for (int i = 0; i < n; i++) {
            sb.append(result[i] + "\n");
        }
        System.out.println(sb);
    }
}
