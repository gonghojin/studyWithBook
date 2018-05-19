package onetime.recursive;

public class RecursiveFunc {
    static void Recursive(int num) {
        if (num <= 0) { // 재귀함수 탈출 조건
            return; // 재귀함수 탈출
        }

        System.out.printf("Recursive call! %d \n", num);
        Recursive(--num);
    }
    public static void main(String[] args) {
        Recursive(3);

    }
}
