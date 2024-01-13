package step1;

import java.util.Scanner;

public class N2753 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int year = sc.nextInt();

        System.out.println(calculateYear(year));
    }

    static int calculateYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 != 0 || year % 400 == 0) {
                return 1;
            }
        }
        return 0;
    }
}
