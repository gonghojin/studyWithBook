package algorithm.baekjooncourse2.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Baekjoon11004_merge {
    public static void mergeSort(List<Integer> list, int first, int last) {
        if (first < last) {
            int mid = (first + last) / 2;
            mergeSort(list, first, mid);
            mergeSort(list, mid + 1, last);
            merge(list, first, mid, last);
        }
    }
    public static void merge(List<Integer> list, int first, int mid, int last) {
        if (first < last) {
            int left = first;
            int right = mid + 1;
            List<Integer> temp = new ArrayList<Integer>();
            while (left <= mid && right <= last) {
                if (list.get(left) < list.get(right)) {
                    temp.add(list.get(left));
                    left++;
                } else if (list.get(right) < list.get(left)) {
                    temp.add(list.get(right));
                    right++;
                } else {
                    temp.add(list.get(left));
                    left++;
                    right++;
                }
            }
            while (left <= mid) {
                temp.add(list.get(left));
                left++;
            }
            while (right <= last) {
                temp.add(list.get(right));
                right++;
            }
            list = temp;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        List<Integer> list = new ArrayList<Integer>();
        while (n-- > 0) {
            list.add(sc.nextInt());
        }
        mergeSort(list, 0, list.size() - 1);
        System.out.println(list.get(k));
    }
}
