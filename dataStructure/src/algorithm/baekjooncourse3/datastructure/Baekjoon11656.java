package algorithm.baekjooncourse3.datastructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Baekjoon11656 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int sL = s.length();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < sL; i++) {
            list.add(s.substring(i));
        }
        Collections.sort(list);
        for (String ans : list) {
            System.out.println(ans);
        }
    }
}
