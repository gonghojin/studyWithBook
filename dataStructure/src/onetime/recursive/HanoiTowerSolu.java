package onetime.recursive;

public class HanoiTowerSolu {

    static void hanoiTowerMove(int num, char from, char by, char to) {
        if (num == 1) { // 이동할 원반의 수가 1개라면
            System.out.printf("원반1을 %c에서 %c로 이동 \n", from, to);
        } else {
            hanoiTowerMove(num -1, from, to, by);
            System.out.printf("원반%d를 %c에서 %c로 이동 \n", num, from, to);
            hanoiTowerMove(num -1, by, from, to);
        }
    }
    public static void main(String[] args) {
        // 막대 A의 원반 3개를 막대 B를 경유하여 막대 C로 옮기기
        hanoiTowerMove(3, 'A', 'B', 'C');

    }
}
