package algorithm.baekjooncourse3.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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

        if (fIdx <= mid) {
            for (int i = fIdx; i <= mid; i++) {
                result[sIdx++] = arr[i];
            }
        } else {
            for (int i = rIdx; i <= right; i++) {
                result[sIdx++] = arr[i];
            }
        }

        for (int i = left; i <= right; i++) {
            arr[i] = result[i];
        }
    }

    public static void main(String[] args) {

        sc.init();

        int n = sc.nextInt();
        int[] arr = new int[n];
        result = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        mergeSort(arr, 0, n -1);

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sb.append(result[i] + "\n");
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

        static String readLine() {
            try {
                br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        static String next() {
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

