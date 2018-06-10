package algorithm.baekjooncourse.sort;

import java.io.*;

// https://www.acmicpc.net/problem/2751
// 퀵 정렬 해보기
public class Baekjoon2751_quickSort {

    private static void QuickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = arr[right]; // 피벗은 이론상은 범위내 어떤 수가 되도 상관없지만, 배열의 양끝 또는 중간값이 구현에 편리하고 속도도 좋다고 한다.
        int l = left;
        int r = right - 1;

        while (l <= r) { // 교차하기 전까지 진행
            //피벗보다 큰 값을 찾는 과정
            while (l <= r && arr[l] < pivot) {
                l++;
            }
            //피벗보다 작은 값을 찾는 과정
            while (l <= r && arr[r] > pivot) {
                r--;
            }

            if (l <= r) { // 교차되지 않는 상태라면
                Swap(arr, l, r);
            }
        }
        Swap(arr, l, right);
        QuickSort(arr, left, l - 1);
        QuickSort(arr, l + 1, right);
    }

    private static void Swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine().trim()); // 공백을 제거하여 오류발생 사전예방
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine().trim());
        }

        QuickSort(arr, 0, n - 1);

        for (int i = 0; i < n; i++) {
            sb.append(arr[i] + "\n");
        }
        System.out.println(sb);
    }


}
