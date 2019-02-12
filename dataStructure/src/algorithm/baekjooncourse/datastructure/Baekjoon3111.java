package algorithm.baekjooncourse.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon3111 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int lineLength = line.length();

        StringBuilder sb = new StringBuilder(br.readLine());

        boolean isLeft = true;
        while (true) {
            if (isLeft) {
                int position = sb.indexOf(line);
                if (-1 < position) {
                    sb.delete(position, position + lineLength);
                    isLeft = false;
                } else {
                    break;
                }
            } else {
                int position = sb.lastIndexOf(line);
                if (-1 < position) {
                    sb.delete(position, position + lineLength);
                    isLeft = true;
                } else {

                    break;
                }
            }
        }

        System.out.println(sb);
    }

    /* public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String conditionLine = sc.nextLine();
        String line = sc.nextLine();
        int conditionLineLength = conditionLine.length();
        int lineLength = line.length();

        Stack<Character> oriStack = new Stack<Character>();
        int sameCount = 0;
        int firstSearch = 0;
        for (int i = 0 ; i < lineLength; i++) {
            if ((conditionLine.charAt(sameCount) == line.charAt(i)) && (firstSearch == 0 || lineLength - conditionLineLength <= i)) {
                sameCount++;
            } else {
                sameCount = 0;
            }

            oriStack.push(line.charAt(i));
            if (sameCount == conditionLineLength *//*&& (firstSearch == 0 || i == lineLength - 1)*//*) {
                for (int j = 0; j < conditionLineLength; j++) {
                    oriStack.pop();
                }
                sameCount = 0;
                firstSearch = 1;
            }
        }

        int oriStackSize = oriStack.size();
        Stack<Character> newStack = new Stack<>();
        for (int i = 0; i < oriStackSize; i++) {
            newStack.push(oriStack.pop());
        }
        for (int i = 0; i < oriStackSize; i++) {
            System.out.print(newStack.pop());
        }
        System.out.println();
    }*/
}
