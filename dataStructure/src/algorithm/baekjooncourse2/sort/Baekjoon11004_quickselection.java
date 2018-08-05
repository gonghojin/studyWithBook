package algorithm.baekjooncourse2.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 그래도 시간초과 로직 이상 일단 보류
 */

// •quick selection의 시간복잡도는  으로, merge/quick보다 빠르다.
// http://hackability.kr/entry/Quick-Selection%EC%9D%84-%EC%9D%B4%EC%9A%A9%ED%95%9C-On-%EC%84%A0%ED%83%9D-%EB%B0%A9%EB%B2%95
public class Baekjoon11004_quickselection {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();
        System.out.println(quickSelect(arr,0, arr.length -1, k -1));
    }

    /**
     * @param k : 찾고자 하는 수의 인덱스
     */
    public static int quickSelect(int[] arr, int start, int end, int k) {
       if (start <= end) {
           int pivot = partition(arr, start, end);
           if (pivot == k) {
               return arr[k];
           } else if (k < pivot) {
               return quickSelect(arr, start, pivot - 1, k); // pivot 기준 왼쪽만 탐색
           } else if (pivot < k) {
               return quickSelect(arr, pivot + 1, end, k); // pivot 기준 오른쪽 탐색
           }
       }
        return Integer.MIN_VALUE;
    }

    public static int partition(int[] arr, int start, int end) {
        int pivot = arr[(start + end) / 2];
       // swap(arr, end, pivot); // 피벗은 배열의 마지막 원소로 한다.
        while (start < end) {
            while ((arr[start] < pivot) && (start < end)) {
                start++;
            }
            while((pivot < arr[end]) && (start < end)) {
                end--;
            }
            if (start < end) {
                swap(arr, start, end);
            }
        }
        return start;
     /*   int i = start - 1;
        for (int j = start; j < end; j++) {
            if (arr[j] < arr[i]) {

            }
        }*/
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
