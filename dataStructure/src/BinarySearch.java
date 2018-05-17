public class BinarySearch {
    public static int BSearch(int[] ar, int len, int target) {
        int first = 0; // 탐색 대상의 시작 인덱스 값
        int last = len -1;
        int mid;

        while (first <= last) {
            mid = (first + last) / 2; // 탐색 대상의 중앙 찾기

            if (ar[mid] == target) {
                return mid; // 탐색 완료
            } else { // 타겟이 아니라면 탐색 대상을 반으로 줄인다.
                if (ar[mid] > target) {
                    last = mid - 1;
                } else {
                    first = mid + 1;
                }
            }

        }

        return -1;
    }
    public static void main(String[] args) {
       int [] arr = {1, 3, 5, 7, 9};
       int idx;

       idx = BSearch(arr, arr.length, 7);
       if (idx == -1) {
           System.out.println("탐색 실패 \n");
       } else {
           System.out.printf("타켓 저장 인덱스 : %d \n", idx);
       }
    }
}
