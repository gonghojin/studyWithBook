package algorithm.baekjooncourse3.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon11004_quickselection {

   /* 내 퀵선택정렬은 시간초과.. 밑에 방법은 성공하네 (

    static int n;
    static int k;
    static int[] arr;
    static int ans = 0;

    public static void main(String[] args) {
        sc.init();

        n = sc.nextInt();
        k = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        quickSelectionSort(0, arr.length - 1);
        System.out.println(ans);
    }

    static void quickSelectionSort(int low, int high) {
        if (high < low) {
            return;
        }

        int middlePivot = arr[(low + high) / 2];
        int left = low;
        int right = high;

        while (left < right) {
            while ((left < right) && (arr[left] < middlePivot)) {
                left++;
            }

            while ((left < right) && (middlePivot < arr[right])) {
                right--;
            }

            if (left < right) {
                swap(left, right);
            }
        }

        if (k - 1 < left) {
            quickSelectionSort(low, left - 1);
        } else if (left < k -1 ) {
            quickSelectionSort(left + 1, high);
        } else {
            ans = arr[left];
        }

    }

    private static void swap(int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    static class sc {
        private static BufferedReader br;
        private static StringTokenizer st;

        public static void init() {
            br = new BufferedReader(new InputStreamReader(System.in));
            st = new StringTokenizer("");
        }

        private static String next() {
            if (!st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return st.nextToken();
        }

        public static int nextInt() {
            return Integer.parseInt(next());
        }

        public static long nextLong() {
            return Long.parseLong(next());
        }
    }

    */

   // 츌처 : http://6a68.tistory.com/12

        static int N;
        static int K;
        static int[] ar;
        static int answer = 0;

        public static void main(String[] args) throws Exception {
            // TODO Auto-generated method stub
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            ar = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                ar[i] = Integer.parseInt(st.nextToken());
            }
            quickSort(0, ar.length - 1);
            System.out.println(answer);
        }

        public static void quickSort(int low, int high) {
            if (low < high) {
                long pivot = ar[high];
                int left = low - 1;
                int right = high;

                while (true) {
                    while (ar[++left] < pivot);
                    while (right > low && ar[--right] > pivot);

                    if (left >= right) break;
                    swap(left, right);
                }

                swap(left, high);

                if (left > K - 1) {
                    quickSort(low, left - 1);
                } else if (left < K - 1) {
                    quickSort(left + 1, high);
                } else {
                    answer = ar[left];
                }
            } else if (low == high && low == K - 1) {
                answer = ar[low];
            }
        }

        public static void swap(int left, int right) {
            int tmp = ar[left];
            ar[left] = ar[right];
            ar[right] = tmp;
        }

}
