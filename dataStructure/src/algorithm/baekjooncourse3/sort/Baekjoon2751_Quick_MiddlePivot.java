package algorithm.baekjooncourse3.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2751_Quick_MiddlePivot {

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

    public static void main(String[] args) {

        sc.init();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        quickSort(arr, 0, n - 1);

        StringBuilder sb = new StringBuilder();
        for (int x : arr) {
            sb.append(x + "\n");
        }
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
