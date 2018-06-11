package algorithm.baekjooncourse.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/2751
// 병합 정렬 해보기
public class Baekjoon2751_mergeSort {

    static int a[];
    static int b[];//결과

    public static void merge(int start, int end) {
        int mid = (start + end) / 2;
        int i = start;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= end) {
            if (a[i] <= a[j]) {
                b[k++] = a[i++];
            } else {
                b[k++] = a[j++];
            }
        }
        while (i <= mid) {
            b[k++] = a[i++];
        }
        while (j <= end) {
            b[k++] = a[j++];
        }
        for (int w = start; w <= end; w++) {
            a[w] = b[w-start];
        }
    }
    public static void sort(int start, int end) {
        if (start == end) {
            return;
        }
        int mid = (start + end) / 2;
        sort(start, mid);
        sort(mid + 1, end);
        merge(start, end);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine().trim());

        a = new int[n];
        b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine().trim());
        }

        sort(0, n - 1);
        for (int i = 0; i < n; i++) {
            sb.append(a[i] + "\n");
        }
        System.out.println(sb.toString());
    }
}
