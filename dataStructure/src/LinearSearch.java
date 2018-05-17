public class LinearSearch {
    public static int LSearch(int [] ar, int len, int target) { // 순차탐색 알고리즘 적용 함수
        int i;
        for (i = 0; i < len; i++) {
            if(ar[i] == target) { return i; } // 찾은 대상의 인덱스 값
        }

        return -1; // 찾지 못했음을 의미;
    }

    public static void main(String[] args) {
        int [] arr = {3, 5, 2, 4, 9};
        int idx;

        idx = LSearch(arr, arr.length, 4);

        if (idx == -1) {
            System.out.println("탐색 실패 \n");
        } else {
            System.out.printf("타켓 저장 인덱스 : %d \n", idx);
        }
    }

}
