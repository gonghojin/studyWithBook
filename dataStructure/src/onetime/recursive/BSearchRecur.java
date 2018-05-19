package onetime.recursive;

public class BSearchRecur {
    static int bSearchRecur(int ar[], int first, int last, int target) {
        int mid;

        if ( first > last) { return -1; } // 탐색 실패를 의미

        mid = (first + last) / 2; // 탐색 대상을 중앙에서 찾기

        if (ar[mid] == target) {
            return mid; // 탐색된 타켓의 인덱스 값 반환
        } else if (target < ar[mid]) {
            return bSearchRecur(ar, first, mid -1, target);
        } else {
            return bSearchRecur(ar, mid + 1, last, target);
        }
    }
    public static void main(String[] args) {
        int [] arr = {1, 3, 5, 7, 9};
        int idx;

        idx = bSearchRecur(arr, 0, arr.length -1, 7);
        if (idx == -1) {
            System.out.println("탐색 실패");
        } else {
            System.out.printf("타켓 저장 인덱스 : %d \n", idx);
        }
        
    }
}
