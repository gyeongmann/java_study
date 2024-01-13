package step2;

import java.util.Scanner;

public class N14681 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();

        if (x > 0) {
            if (y > 0) {
                System.out.println(1);
            }
            if (y < 0) {
                System.out.println(4);
            }
        }

        if (x < 0) {
            if (y > 0) {
                System.out.println(2);
            }
            if (y < 0) {
                System.out.println(3);
            }
        }
    }
}
