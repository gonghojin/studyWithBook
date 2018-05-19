package onetime.recursive;

public class Factorial {
    static int factoria(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factoria(n -1);
        }
    }
    public static void main(String[] args) {
        System.out.printf("1! = %d \n", factoria(1));
        System.out.printf("2! = %d \n", factoria(2));
        System.out.printf("3! = %d \n", factoria(3));
        System.out.printf("4! = %d \n", factoria(4));
        System.out.printf("9! = %d \n", factoria(9));
    }
}
