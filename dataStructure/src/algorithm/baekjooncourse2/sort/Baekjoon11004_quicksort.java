package algorithm.baekjooncourse2.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 퀵, merge 정렬로는 시간초과가 된다 시간 복잡도가 nlogn보다 빠른 정렬이 필요
 * 여기서는 Scanner를 사용했지만, quicksort에서 BufferedReader를 해봤지만 그마저도 불가
 * 다른 방법 필요
 */

public class Baekjoon11004_quicksort {
    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        ArrayList<Integer> array = new ArrayList<Integer>();

        st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < n; idx++) {
            array.add(Integer.parseInt(st.nextToken()));
        }
        br.close();

        quickSort(array, 0, array.size() - 1);
        System.out.println(array.get(k -1));

    }

    public static void quickSort(ArrayList<Integer> array, int left, int right) {
        if (left < right) {
            int newPrivot = partition(array, left, right);
            quickSort(array, left, newPrivot - 1);
            quickSort(array, newPrivot + 1, right);
        }
    }

    public static int partition(ArrayList<Integer> array, int left, int right) {
        int pivot = array.get((left + right) / 2);
        while (left < right) {
            while ((array.get(left) < pivot) && (left < right)) {
                left++;
            }
            while ((pivot < array.get(right)) && (left < right)) {
                right--;
            }
            if (left < right) {
                Collections.swap(array, left, right);
            }
        }
        return left;
    }


}
