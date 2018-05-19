package onetime.recursive;

public class FibonacciFunc {

    static int fibo(int n) {
        if (n == 1) {
            return 0;
        } else if(n == 2) {
            return 1;
        } else {
            return fibo(n -1) + fibo(n -2);
        }
    }
    public static void main(String[] args) {
        int i;
        for (i = 1; i < 15; i++) {
            System.out.printf("%d ", fibo(i));

        }
    }
}
