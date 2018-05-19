public class BSWorstOpCount {
    public static int BSearch(int[] ar, int len, int target) {
        int first = 0; // 탐색 대상의 시작 인덱스 값
        int last = len - 1;
        int mid;
        int opCount = 0; // 비교연산의 횟수를 기록

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
            opCount += 1;
        }
        System.out.printf("비교연산횟수 : %d \n" , opCount); // 탐색실패 시 연산횟수 출력
        return -1;
    }

    public static void main(String[] args) {
        int [] arr1 = new int[500]; // 0으로 초기화
        int [] arr2 = new int[5000]; // 0으로 초기화
        int [] arr3 = new int[50000]; // 0으로 초기화
        int idx;

        // 배열 arr1을 대상으로, 저장되는 않은 정수 1을 찾으라고 명령 why? 시간복잡도 == 최악의 경우 따라서, 탐색실패 유발
        idx = BSearch(arr1, arr1.length, 1);
        if (idx == -1) {
            System.out.println("탐색 실패 \n");
        } else {
            System.out.printf("타켓 저장 인덱스 : %d \n", idx);
        }

        // 배열 arr2을 대상으로, 저장되는 않은 정수 2을 찾으라고 명령 why? 시간복잡도 == 최악의 경우 따라서, 탐색실패 유발
        idx = BSearch(arr2, arr2.length, 2);
        if (idx == -1) {
            System.out.println("탐색 실패 \n");
        } else {
            System.out.printf("타켓 저장 인덱스 : %d \n", idx);
        }

        // 배열 arr3을 대상으로, 저장되는 않은 정수 3을 찾으라고 명령 why? 시간복잡도 == 최악의 경우 따라서, 탐색실패 유발
        idx = BSearch(arr3, arr3.length, 2);
        if (idx == -1) {
            System.out.println("탐색 실패 \n");
        } else {
            System.out.printf("타켓 저장 인덱스 : %d \n", idx);
        }
    }

}
