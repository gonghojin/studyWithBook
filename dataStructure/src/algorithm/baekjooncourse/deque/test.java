public class test {
    public static void main(String[] args) {
       /* Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] A = new int[n];
        int count = 0;
        int [] pbNum = new int[3];
        //int pbNum = 0; //문제발생 수
        int pbExt = 0; // 문제 존재
        int pbMax = 0; // max값
        for(int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        for(int i = 1; i < n; i++) {
            if (A[i] < A[i-1]) { // IF 1

                //pbNum = A[i-1];
                pbNum[0] = A[i-2];
                pbNum[1] = A[i-1];// 문제 발생 포인트
                pbNum[2] = A[i];
                pbExt = 1;
            }

            if (pbExt == 1) { // If 2
                if (pbNum[1] <= A[i]) {
                    if ((pbMax > pbNum[2]) || (pbMax <pbNum[0])) {
                        return false;
                    }
                } else if (pbMax < A[i]) { // 문제 발생 포인트 이후 MAX값
                    pbMax = A[i];

                }


            }


        }
*/      Integer a = null;

        if(a == null) {
            a = 3;
            System.out.println("Fsdfdsfd");
        }

        System.out.println(a);


    }
}


// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public boolean solution(int[] A) {
        int n = A.length;
        int count = 0;
        int [] pbNum = new int[3];
        //int pbNum = 0; //문제발생 수
        int pbExt = 0; // 문제 존재
        int pbMax = 0; // max값

        for(int i = 1; i < n; i++) {
            if (A[i] < A[i-1]) { // IF 1

                //pbNum = A[i-1];
                pbNum[0] = A[i-2];
                pbNum[1] = A[i-1];// 문제 발생 포인트
                pbNum[2] = A[i];
                pbExt = 1;
            }

            if (pbExt == 1) { // If 2
                if (pbNum[1] <= A[i]) {
                    if ((pbMax > pbNum[2]) || (pbMax <pbNum[0])) {
                        return false;
                    }
                } else if (pbMax < A[i]) { // 문제 발생 포인트 이후 MAX값
                    pbMax = A[i];

                }

            }

        }
        if (pbExt == 1) {
            if ((pbMax > pbNum[2]) || (pbMax <pbNum[0])) {
                return false;
            }
        }
        return true;
    }

}


////////
// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public String solution(String S) {
        // write your code in Java SE 8
        //AB , BA => AA = > A
        // BC CB => CC => C
        //결과 A, C만 남음
        String rmS = S.replace("B", "");  //b제거

        int n = rmS.length(); // 글자 사이즈
        String out = "";

        int state = 0; // 첫번쨰 값 A

        out += rmS.charAt(0);// 0번째 무조건 +
        if (out.equals("C")) {
            state = 1;
        }

        for (int i = 1; i < n; i++) {
            char ch = rmS.charAt(i); // 문자 저장

            switch(ch) {
                case 'A' :
                    if (state == 0) {
                        break;
                    } else {
                        out += 'A';
                        state = 0;
                        break;
                    }
                case 'C' :
                    if (state == 1) {
                        break;
                    } else {
                        out += 'C';
                        state = 1;
                        break;
                    }
            }
        }


        return out;

    }

}
//////////
// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8

        int max = 0;
        Integer numA = null,numB = null;
        int n = A.length;//사이즈
        int lNow = 0;
        int lSame = 1;
        for (int i = 0; i < n; i++) {
            if(numA == null) {
                numA = A[i];
            } else if (numB == null) {
                if (numA != A[i]) {
                    numB = A[i];
                }
            }
            //numA = A[i];
            if ((numA == A[i]) || (numB == A[i])) {
                lNow++;
            } else {
                if (lNow > max) {
                    max = lNow;
                    lNow = lSame;
                    System.out.println(lSame);
                }
                numA = numB;
                numB = A[i];

            }
            if (i > 0 && A[i] == A[i-1]) {
                lSame++;
            } else {
                lSame = 1;
            }
        }

        return max;
    }


}