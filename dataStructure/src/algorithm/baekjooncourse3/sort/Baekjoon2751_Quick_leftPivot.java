package algorithm.baekjooncourse3.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2751_Quick_leftPivot {

    private static void swap(int[] arr, int low, int high) {
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }

    private static void quickSort(int[] arr, int left, int right) {
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



    public static void main(String[] args) {
        sc.init();

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0 ; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        quickSort(arr, 0, n - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++)
            sb.append(arr[i] + "\n");

        System.out.println(sb);
    }



    static class sc {

        private static BufferedReader br;
        private static StringTokenizer st;

        static void init() {
            br = new BufferedReader(new InputStreamReader(System.in));
            st = new StringTokenizer("");
        }

        private static String next() {
            while (!st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        static int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
