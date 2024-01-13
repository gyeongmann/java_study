package step2;

import java.util.Scanner;

public class N2525 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        B += C;

        if (B >= 60) {
            A += B / 60;
            B %= 60;
            A %= 24;
        }

        System.out.println(A + " " + B);
    }
}
