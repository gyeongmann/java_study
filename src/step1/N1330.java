package step1;

import java.util.Scanner;

public class N1330 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();

        System.out.println(compare(A, B));
    }

    static String compare(int A, int B) {
        if (A > B) return ">";
        else if (A < B) return "<";
        return "==";
    }
}
